package session03;

import java.util.Random;

class BankAccount2 {

    private String owner;
    private String accountNumber;
    private float balance;


    void makeBankAccount(String initialOwner) {
        owner = initialOwner;
        System.out.println(owner);
        accountNumber = generateNewAccountNumber();
        System.out.println(accountNumber);
        balance = 20000;
        System.out.println(balance);
    }

    private String generateNewAccountNumber() {
        int max = 999;
        int min = 100;
        Random rand = new Random();
        int randomNum1 = rand.nextInt((max - min) + 1) + min;
        int randomNum2 = rand.nextInt((max - min) + 1) + min;
        return "IBAN ABC-" + randomNum1 + "-" + randomNum2;
    }

    private void getBalance() {
        System.out.println(balance);
    }

    private void setBalance(float newBalance) {
        balance = newBalance;
    }

    private boolean isValidAmount(float amount) {
        return amount > 0;
    }

    private void deposit(float amount) {
        if (isValidAmount(amount)) {
            setBalance(balance + amount);
        }
    }


    private boolean withdraw(float amount) {
        if (isValidAmount(amount) && balance >= amount) {
            setBalance(balance - amount);
            return true;
        } else {
            return false;
        }
    }

    void transfer(BankAccount2 receiver, float amount) {
        if (withdraw(amount)) {
            System.out.println("transfering...");
            receiver.deposit(amount);
        }
    }

    void complete() {
        System.out.println(owner);
        System.out.println(accountNumber);
        getBalance();
    }
}
