package com.modernjava.lambda.BankTransferExample;

public interface AccountFactory {
    public abstract BankAccount getBankAccount(int id, double balance, String accountName);
}
