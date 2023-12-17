package encapsulation.lab01SortByNameAndAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String[] input = reader.readLine().split(" ");

            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);

            Person person = new Person(firstName, lastName, age);
            people.add(person);
        }

        people.sort((firstPerson, secondPerson) -> {

            int compareValue = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());

            if (compareValue == 0) {

                return Integer.compare(firstPerson.getAge(), secondPerson.getAge());

            }

            return compareValue;
        });

        for (Person person : people) {

            System.out.println(person.toString());

        }

    }
}
