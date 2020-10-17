package TreeExercise;

import java.util.Comparator;

public class SortPersonByAge implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        return p2.getYearOfBirth() - p1.getYearOfBirth();
    }

}
