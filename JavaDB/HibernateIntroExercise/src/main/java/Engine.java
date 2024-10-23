import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Engine implements Runnable {

    private final EntityManager entityManager;
    private Scanner scan;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.scan = new Scanner(System.in);
    }

    @Override
    public void run() {
        System.out.println("Select ex number:");

        int exNumber = Integer.parseInt(scan.nextLine());

        switch (exNumber) {
            case 2: exTwo();
            case 3: exThree();
            case 4: exFour();
            case 5: exFive();
            case 6: exSix();
            case 7: exSeven();
            case 8: exEight();
            case 9: exNine();
            case 10: exTen();
            case 11: exEleven();
            case 12: exTwelve();
            case 13: exThirteen();
        }
    }

    private void exThirteen() {
        String townName = scan.nextLine();

        Town town = entityManager.createQuery("SELECT t FROM Town t WHERE t.name = :town_name", Town.class)
                .setParameter("town_name", townName).getSingleResult();

        int deletedAddresses = deleteAddresses(town);

        entityManager.getTransaction().begin();
        entityManager.remove(town);
        entityManager.getTransaction().commit();

        System.out.printf("%d address in %s deleted\n", deletedAddresses, townName);
    }

    private int deleteAddresses(Town town) {
        entityManager.getTransaction().begin();

        int result = entityManager.createQuery("DELETE FROM Address a WHERE a.town.id = :town_id")
                        .setParameter("town_id", town.getId()).executeUpdate();

        entityManager.getTransaction().commit();

        return result;
    }

    private void exTwelve() {
        List<Object[]> resultList = entityManager.createNativeQuery("SELECT d.name, MAX(e.salary) AS max_salary FROM departments d JOIN employees e ON e.department_id = d.department_id GROUP BY d.name HAVING max_salary NOT BETWEEN 30000 AND 70000")
                .getResultList();

        resultList.forEach(r -> System.out.printf("%s %.2f\n", r[0], r[1]));
    }

    private void exEleven() {
        String patternInput = scan.nextLine();

        entityManager.createQuery("SELECT e FROM Employee e WHERE e.firstName LIKE :pattern", Employee.class)
                .setParameter("pattern", patternInput + "%").getResultStream().forEach(e -> {
                    System.out.printf("%s %s - %s - ($%.2f)\n", e.getFirstName(), e.getLastName(), e.getJobTitle(), e.getSalary());
                });


    }

    private void exTen() {
        entityManager.getTransaction().begin();

        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e WHERE e.department.name IN ('Engineering', 'Tool Design', 'Marketing', 'Information Services')", Employee.class)
                .getResultList();

        employees.forEach(e -> {
            e.setSalary(e.getSalary().multiply(new BigDecimal("1.12")));
            System.out.printf("%s %s ($%.2f)\n", e.getFirstName(), e.getLastName(), e.getSalary());
        });

        entityManager.getTransaction().commit();

        System.out.println("asd");
    }

    private void exNine() {
        List<Project> projects = entityManager.createQuery("SELECT p FROM Project p ORDER BY p.startDate DESC", Project.class)
                .setMaxResults(10)
                .getResultStream().sorted(Comparator.comparing(Project::getName)).collect(Collectors.toList());

        projects.forEach(p -> {
            System.out.printf("Project name:%s\n" +
                    "   Project Description:%s\n" +
                    "   Project Start Date:%s\n" +
                    "   Project End Date:%s\n", p.getName(), p.getDescription(), p.getStartDate(), p.getEndDate());
        });

    }

    private void exEight() {
        System.out.println("Enter employee id:");
        int id = Integer.parseInt(scan.nextLine());

        Employee employee = entityManager.find(Employee.class, id);

        List<String> projects = employee.getProjects().stream().sorted(Comparator.comparing(Project::getName)).map(Project::getName).collect(Collectors.toList());

        System.out.printf("%s %s - %s\n     %s", employee.getFirstName(),employee.getLastName(), employee.getJobTitle(), String.join("\n     ", projects));

    }

    private void exSeven() {
        List<Address> addresses = entityManager.createQuery("SELECT a FROM Address a ORDER BY a.employees.size DESC", Address.class)
                .setMaxResults(10)
                .getResultList();

        addresses.forEach(a -> System.out.printf("%s, %s - %d employees\n", a.getText(),
                a.getTown() == null ? "Unknown" : a.getTown().getName(),
                a.getEmployees().size()));
    }

    private void exSix() {
        System.out.println("Enter employee last name:");
        String lastName = scan.nextLine();

        Employee employee = entityManager.createQuery("SELECT e FROM Employee e WHERE e.lastName = :l_name", Employee.class)
                        .setParameter("l_name", lastName)
                                .getSingleResult();

        Address address = createAddress("Vitoshka 15");

        entityManager.getTransaction().begin();
        employee.setAddress(address);
        entityManager.getTransaction().commit();
    }

    private Address createAddress(String s) {
        Address address = new Address();
        address.setText(s);

        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();

        return address;
    }

    private void exFive() {
        entityManager.createQuery("SELECT e FROM Employee e WHERE e.department.name = :dep ORDER BY e.salary, e.id", Employee.class)
                .setParameter("dep" , "Research and Development")
                .getResultStream().forEach(e -> System.out.printf("%s %s from %s - $%.2f\n", e.getFirstName(), e.getLastName(), e.getDepartment().getName(), e.getSalary()));
    }

    private void exFour() {
        List<String> list = entityManager.createQuery("SELECT e.firstName FROM Employee e WHERE e.salary > 50000", String.class).getResultList();

        list.forEach(System.out::println);
    }

    private void exThree() {
        entityManager.getTransaction().begin();
        System.out.println("Enter employee full name:");
        String[] fullName = scan.nextLine().split("\\s+");

        Long result = entityManager.createQuery("SELECT COUNT(e) FROM Employee e WHERE e.firstName = :first_name AND e.lastName = :last_name",
                Long.class)
                .setParameter("first_name", fullName[0])
                .setParameter("last_name", fullName[1])
                .getSingleResult();

        System.out.println(result == 1 ? "yes" : "no");
    }

    private void exTwo() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Town t SET t.name = upper(t.name) WHERE LENGTH(t.name) <= 5 ");

        System.out.println(query.executeUpdate());
        entityManager.getTransaction().commit();
    }
}
