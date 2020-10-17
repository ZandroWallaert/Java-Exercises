package session06;

public class ContactBookApp {
    public static void main(String[] args) {
        new ContactBookApp().run();
    }

    private void run() {
        ContactBook myBook = new ContactBook();

        Contact pol = new Contact("Pol", "04/222.33.44");
        pol.setHome(new Address("Kerkstraat", "33", "Blankenberge"));
        myBook.add(pol);

        System.out.println(pol);
        System.out.println(myBook);

        Contact elske = new Contact("Elske", "05/444.43.44");
        myBook.add(elske);

        System.out.println(myBook);

        myBook.setFormatter(new ContactFormatterByName());

        System.out.println(myBook);

        myBook.setSortingOrder(new SortContactByPhone());
        System.out.println(myBook);
    }
}
