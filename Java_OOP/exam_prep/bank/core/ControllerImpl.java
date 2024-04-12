package bank.core;

import bank.entities.bank.Bank;
import bank.entities.bank.BranchBank;
import bank.entities.bank.CentralBank;
import bank.entities.client.Adult;
import bank.entities.client.Client;
import bank.entities.client.Student;
import bank.entities.loan.Loan;
import bank.entities.loan.MortgageLoan;
import bank.entities.loan.StudentLoan;
import bank.repositories.LoanRepository;

import java.util.ArrayList;
import java.util.Collection;

import static bank.common.ConstantMessages.*;
import static bank.common.ExceptionMessages.*;


public class ControllerImpl implements Controller {
    private LoanRepository loans;
    private Collection<Bank> banks;

    public ControllerImpl() {
        loans = new LoanRepository();
        banks = new ArrayList<>();
    }

    @Override
    public String addBank(String type, String name) {

        switch (type) {
            case "BranchBank":
                banks.add(new BranchBank(name));
                break;
            case "CentralBank":
                banks.add(new CentralBank(name));
                break;
            default:
                throw new IllegalArgumentException(INVALID_BANK_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
    }

    @Override
    public String addLoan(String type) {

        switch (type) {
            case "MortgageLoan":
                loans.addLoan(new MortgageLoan());
                break;
            case "StudentLoan":
                loans.addLoan(new StudentLoan());
                break;
            default:
                throw new IllegalArgumentException(INVALID_LOAN_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
    }

    @Override
    public String returnedLoan(String bankName, String loanType) {

        if (loans.findFirst(loanType) == null) {
            throw new IllegalArgumentException(String.format(NO_LOAN_FOUND, loanType));
        }
        Bank currentBank = banks.stream().filter(bank -> bank.getName().equals(bankName)).findFirst().orElse(null);
        currentBank.addLoan(loans.findFirst(loanType));
        loans.removeLoan(loans.findFirst(loanType));
        return String.format(SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, loanType, bankName);
    }

    @Override
    public String addClient(String bankName, String clientType, String clientName, String clientID, double income) {
        Bank bank = banks.stream().filter(currentBank -> currentBank.getName().equals(bankName)).findFirst().orElse(null);
        switch (clientType) {

            case "Student":

                if (!bank.getClass().getSimpleName().equals("BranchBank")) {
                    return UNSUITABLE_BANK;
                }
                bank.addClient(new Student(clientName, clientID, income));
                break;
            case "Adult":
                if (!bank.getClass().getSimpleName().equals("CentralBank")) {
                    return UNSUITABLE_BANK;
                }

                bank.addClient(new Adult(clientName, clientID, income));
                break;
            default:
                throw new IllegalArgumentException(INVALID_CLIENT_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, clientType, bankName);
    }

    @Override
    public String finalCalculation(String bankName) {
        Bank currentBank = banks.stream().filter(bank -> bank.getName().equals(bankName)).findFirst().orElse(null);
        double clientIncome = currentBank.getClients().stream().mapToDouble(Client::getIncome).sum();
        double loanIncome = currentBank.getLoans().stream().mapToDouble(Loan::getAmount).sum();
        return String.format(FUNDS_BANK, bankName, clientIncome + loanIncome);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Bank bank : banks) {
            sb.append(bank.getStatistics()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
