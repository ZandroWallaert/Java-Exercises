package TreeExercise;

import java.util.*;

public class Person {

    private String name;
    private List<Person> children;
    private boolean alive;
    private double money;
    private int yearOfBirth;

    public Person(String name, int yearOfBirth) {
        this.name = name;
        children = new ArrayList<>();

        alive = true;
        money = 0.0;
        this.yearOfBirth = yearOfBirth;
    }

    public boolean hasChildren() {
        return children.size() > 0;
    }

    public void addChild(Person person) {
        children.add(person);
    }

    public List<Person> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void addMoney(double amount) {
        money += amount;
    }

    public void die() {
        alive = false;

        double toDivide = money;
        money = 0;

        divide(this, toDivide);
    }

    private void divide(Person src, double amount) {
        if (amount < 0.001) {
            System.out.printf("%s has nothing to divide.\n", this);
        } else if (isAlive()) {
            addMoney(amount);
            System.out.printf("%s receives %.2f € from %s.\n",
                    this, amount, src);
        } else if (hasChildren()) {
            System.out.printf("%.2f € of %s's money will be divided over %s's children.\n",
                    amount, src, this);
            amount /= children.size();
            for (Person p : children) {
                p.divide(src, amount);
            }
        } else {
            System.out.printf("%.2f € of %s's money has been given to the state and is lost forever, because %s does " +
                            "not have any children.\n" +
                            ".\n",
                    amount, src, this);
        }
    }


    public boolean isAlive() {
        return alive;
    }


    public String toString() {
        return String.format("%s %d", name, yearOfBirth);
    }

    public String toLongString() {
        return toLongString(0, new StringBuilder()).toString();
    }

    private StringBuilder toLongString(int depth, StringBuilder str) {
        for (int i = 0; i < depth; i++) str.append("  ");
        str.append(this).append("\n");
        for (Person child : children) {
            child.toLongString(depth + 1, str);
        }
        return str;
    }

    public Person closedHeir() {
        Queue<Person> todo = new LinkedList<>();
        todo.offer(this);

        while (!todo.isEmpty()) {
            Person next = todo.poll();
            for (Person child : next.children) {
                if (child.isAlive()) {
                    return child;
                }
                todo.offer(child);
            }
        }

        return null;

    }

    public Person oldestHeir() {
        List<Person> possibleHeirs = new ArrayList<>();
        for (Person child : children) {
            if (child.isAlive()) {
                possibleHeirs.add(child);
            } else {
                Person possibleHeir = child.oldestHeir();
                if (possibleHeir != null) {
                    possibleHeirs.add(possibleHeir);
                }
            }
        }

        if (possibleHeirs.isEmpty()) {
            return null;
        } else {
            possibleHeirs.sort(new SortPersonByAge());
            return possibleHeirs.get(0);
        }

    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

}
