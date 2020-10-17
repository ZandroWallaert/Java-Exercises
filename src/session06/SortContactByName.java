package session06;

import java.util.Comparator;

public class SortContactByName implements Comparator<Contact> {
    @Override
    public int compare(Contact c1, Contact c2) {
        return c1.getName().compareTo(c2.getName());
    }
}
