package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam5August2023.bank.entities.bank;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam5August2023.bank.entities.client.Client;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam5August2023.bank.entities.loan.Loan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam5August2023.bank.common.ExceptionMessages.BANK_NAME_CANNOT_BE_NULL_OR_EMPTY;
import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam5August2023.bank.common.ExceptionMessages.NOT_ENOUGH_CAPACITY_FOR_CLIENT;

public abstract class BaseBank implements Bank {
    private String name;
    private int capacity;
    private Collection<Loan> loans;
    private Collection<Client> clients;

    public BaseBank(String name, int capacity) {
        setName(name);
        setCapacity(capacity);
        loans = new ArrayList<>();
        clients = new ArrayList<>();
    }

    protected void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(BANK_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Client> getClients() {
        return clients;
    }

    @Override
    public Collection<Loan> getLoans() {
        return loans;
    }

    @Override
    public void addClient(Client client) {
        if (clients.size() == capacity) {
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY_FOR_CLIENT);
        }
        clients.add(client);
    }

    @Override
    public void removeClient(Client client) {
        clients.remove(client);
    }

    @Override
    public void addLoan(Loan loan) {
        loans.add(loan);
    }

    @Override
    public int sumOfInterestRates() {
        return loans.stream().mapToInt(Loan::getInterestRate).sum();
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s, Type: %s",getName(),getClass().getSimpleName()))
                .append(System.lineSeparator());
        sb.append("Clients: ");
        if (clients.isEmpty()) {
            sb.append("none");
        } else {
            String clientsToString = clients.stream().map(Client::getName).collect(Collectors.joining(", "));
            sb.append(clientsToString);
        }
        sb.append(System.lineSeparator());
        sb.append(String.format("Loans: %s, Sum of interest rates: %s",loans.size(), loans.stream()
                .mapToInt(Loan::getInterestRate).sum()));
        return sb.toString().trim();
    }
}
