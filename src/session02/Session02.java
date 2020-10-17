package session02;

public class Session02 {
    public static void main(String[] args) {
        new Session02().run();
    }

    private void run() {
        Counter();
        BankAccount();
    }

    private void Counter() {
        Counter counter1 = new Counter();
        for (int i = 0; i < 7; i++) {
            counter1.incr();
        }
        counter1.read();

        System.out.println();

        Counter counter2 = new Counter();
        for (int i = 0; i < 10; i++) {
            counter2.incr();
        }
        counter2.read();
        System.out.println();
    }

    private void BankAccount() {
        BankAccount client1 = new BankAccount();
        client1.makeBankAccount("clientnr1");
        System.out.println();
        BankAccount client2 = new BankAccount();
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
