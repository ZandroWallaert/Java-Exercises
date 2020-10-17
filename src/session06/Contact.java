package session06;

public class Contact implements Comparable<Contact> {
    private String name;
    private String phonenumber;

    private Address home;
    private Address work;

    public Contact(String name, String phonenumber) {
        this.name = name;
        this.phonenumber = phonenumber;
    }

    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public Address getHome() {
        return home;
    }

    public Address getWork() {
        return work;
    }

    public void setHome(Address home) {
        this.home = home;
    }

    public void setWork(Address work) {
        this.work = work;
    }

    @Override
    public int compareTo(Contact other) {
        return getName().compareTo(other.getName());
    }
}
