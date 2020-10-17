package session06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ContactBook {

    private List<Contact> contacts;
    private ContactFormatter fmt;
    private Comparator<Contact> cmp;

    public void setSortingOrder(Comparator<Contact> cmp) {
        this.cmp = cmp;
    }

    public ContactBook(ContactFormatter fmt, Comparator<Contact> cmp) {
        contacts = new ArrayList<>();
        this.fmt = fmt;
        this.cmp = cmp;
    }

    public void setFormatter(ContactFormatter fmt) {
        this.fmt = fmt;
    }

    public ContactBook() {
        this(new ContactFormatterByNameAndPhone(), new SortContactByName());
    }

    public void add(Contact contact) {
        contacts.add(contact);
    }

    public String toString() {
        StringBuilder res = new StringBuilder("My contacts:\n===============\n");

        Collections.sort(contacts, cmp);

        for (Contact contact : contacts) {
            res.append(fmt.format(contact)).append("\n");
        }

        res.append("===============\n");

        return res.toString();
    }
}
