package MapsLambdaAndStreamAPIExercise;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> company = new LinkedHashMap<>();

        String input = scan.nextLine();

        while (!input.equals("End")) {

            String companyName = input.split(" -> ")[0];
            String employeeID = input.split(" -> ")[1];

            if (!company.containsKey(companyName)) {
                company.put(companyName,new ArrayList<>());
                company.get(companyName).add(employeeID);
            } else {
                if (!company.get(companyName).contains(employeeID)) {
                    company.get(companyName).add(employeeID);
                }
            }
            input = scan.nextLine();
        }
        company.forEach((key,value) -> {
            System.out.println(key);
            for (String e : value) {
                System.out.printf("-- %s\n",e);
            }
        });
    }
}
