package bank.entities.bank;

import bank.entities.client.Client;
import bank.entities.loan.Loan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static bank.common.ExceptionMessages.BANK_NAME_CANNOT_BE_NULL_OR_EMPTY;
import static bank.common.ExceptionMessages.NOT_ENOUGH_CAPACITY_FOR_CLIENT;

public abstract class BaseBank implements Bank {
    private String name;
    private int capacity;
    private Collection<Loan> loans;
    private Collection<Client> clients;

    public BaseBank(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.loans = new ArrayList<>();
        this.clients = new ArrayList<>();
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(BANK_NAME_CANNOT_BE_NULL_OR_EMPTY);
        } else {
            this.name = name;
        }
    }

    @Override
    public Collection<Client> getClients() {
        return this.clients;
    }

    @Override
    public Collection<Loan> getLoans() {
        return this.loans;
    }

    @Override
    public void addClient(Client client) {
        if (capacity > 0) {
            this.clients.add(client);
            this.capacity--;
            //todo potential problem
        } else {
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY_FOR_CLIENT);
        }
    }

    @Override
    public void removeClient(Client client) {

        this.clients.remove(client);
    }

    @Override
    public void addLoan(Loan loan) {
        this.loans.add(loan);
    }

    @Override
    public int sumOfInterestRates() {
        return this.loans.stream().mapToInt(Loan::getInterestRate).sum();
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s, Type: %s", this.name, this.getClass().getSimpleName())).append(System.lineSeparator())
                .append("Clients: ");

        if (clients.isEmpty()) {
            sb.append("none").append(System.lineSeparator());
        } else {
            sb.append(clients.stream().map(Client::getName).collect(Collectors.joining(", ")))
                    .append(System.lineSeparator());
        }

        sb.append(String.format("Loans: %d, Sum of interest rates: %d",
                this.getLoans().size(), this.sumOfInterestRates()));

        return sb.toString().trim();
    }
}
