package session03;

public class Session03 {
    public static void main(String[] args) {
        new Session03().run();
    }

    private void run() {
        BankAccount2();
    }

    private void BankAccount2() {
        BankAccount2 client1 = new BankAccount2();
        client1.makeBankAccount("clientnr1");
        System.out.println();
        BankAccount2 client2 = new BankAccount2();
        client2.makeBankAccount("clientnr2");
        int amountToPay = 12 * 850;
        System.out.println();
        client1.transfer(client2, amountToPay);
        System.out.println();
        client1.complete();
        System.out.println();
        client2.complete();
    }
}