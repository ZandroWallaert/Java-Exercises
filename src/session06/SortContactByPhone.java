package session06;

import java.util.Comparator;

public class SortContactByPhone implements Comparator<Contact> {
    @Override
    public int compare(Contact c1, Contact c2) {
        return c1.getPhonenumber().compareTo(c2.getPhonenumber());
    }
}
