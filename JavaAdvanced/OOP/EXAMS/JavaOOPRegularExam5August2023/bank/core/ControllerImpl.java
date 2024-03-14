package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam5August2023.bank.core;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam5August2023.bank.entities.bank.Bank;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam5August2023.bank.entities.bank.BranchBank;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam5August2023.bank.entities.bank.CentralBank;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam5August2023.bank.entities.client.Adult;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam5August2023.bank.entities.client.Client;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam5August2023.bank.entities.client.Student;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam5August2023.bank.entities.loan.Loan;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam5August2023.bank.entities.loan.MortgageLoan;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam5August2023.bank.entities.loan.StudentLoan;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam5August2023.bank.repositories.LoanRepository;

import java.util.ArrayList;
import java.util.Collection;

import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam5August2023.bank.common.ConstantMessages.*;
import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam5August2023.bank.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private LoanRepository loans;
    private Collection<Bank> banks;

    public ControllerImpl() {
        loans = new LoanRepository();
        banks = new ArrayList<>();
    }

    private Bank findBank(String bankName) {
        return banks.stream().filter(b -> b.getName().equals(bankName)).findFirst().orElse(null);
    }

    @Override
    public String addBank(String type, String name) {
        Bank bank;
        switch (type) {
            case "CentralBank":
                bank = new CentralBank(name);
                break;
            case "BranchBank":
                bank = new BranchBank(name);
                break;
            default:
                throw new IllegalArgumentException(INVALID_BANK_TYPE);
        }
        banks.add(bank);
        return String.format(SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE,type);
    }

    @Override
    public String addLoan(String type) {
        Loan loan;
        switch (type) {
            case "StudentLoan":
                loan = new StudentLoan();
                break;
            case "MortgageLoan":
                loan = new MortgageLoan();
                break;
            default:
                throw new IllegalArgumentException(INVALID_LOAN_TYPE);
        }
        loans.addLoan(loan);
        return String.format(SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE,type);
    }

    @Override
    public String returnedLoan(String bankName, String loanType) {
        Bank bank = findBank(bankName);
        Loan loan = loans.findFirst(loanType);
        if (loan == null) {
            throw new IllegalArgumentException(String.format(NO_LOAN_FOUND,loanType));
        }
        bank.addLoan(loan);
        loans.removeLoan(loan);
        return String.format(SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK,loanType,bankName);
    }

    @Override
    public String addClient(String bankName, String clientType, String clientName, String clientID, double income) {
        Bank bank = findBank(bankName);
        Client client;
        switch (clientType) {
            case "Student":
                client = new Student(clientName,clientID,income);
                break;
            case "Adult":
                client = new Adult(clientName,clientID,income);
                break;
            default:
                throw new IllegalArgumentException(INVALID_CLIENT_TYPE);
        }
        boolean isSuitable = clientType.equals("Adult") && bank.getClass().getSimpleName().equals("CentralBank") ||
                clientType.equals("Student") && bank.getClass().getSimpleName().equals("BranchBank");
        if (isSuitable) {
            bank.addClient(client);
            return String.format(SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK,clientType, bankName);
        } else {
            return UNSUITABLE_BANK;
        }
    }

    @Override
    public String finalCalculation(String bankName) {
        Bank bank = findBank(bankName);
        double funds = 0;
        for (Client client : bank.getClients()) {
            funds += client.getIncome();
        }
        for (Loan loan : bank.getLoans()) {
            funds += loan.getAmount();
        }
        return String.format(FUNDS_BANK,bankName, funds);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        banks.forEach(b -> sb.append(b.getStatistics()).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
