package session06;

public class ContactFormatterByNameAndPhone implements ContactFormatter {
    public String format(Contact contact) {
        return contact.getName() + "\t" + contact.getPhonenumber();
    }
}
