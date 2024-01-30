import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class CRUDApplication {
    static List<Person> peopleList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("CRUD Application Menu:");
            System.out.println("1. Create Person");
            System.out.println("2. Read People");
            System.out.println("3. Update Person");
            System.out.println("4. Delete Person");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    createPerson();
                    break;
                case 2:
                    readPeople();
                    break;
                case 3:
                    updatePerson();
                    break;
                case 4:
                    deletePerson();
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    private static void createPerson() {
        System.out.println("Enter the details for the new person:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        Person person = new Person(name, age);
        peopleList.add(person);
        System.out.println("Person added successfully!");
    }

    private static void readPeople() {
        System.out.println("List of People:");
        if (peopleList.isEmpty()) {
            System.out.println("No people in the list.");
        } else {
            for (int i = 0; i < peopleList.size(); i++) {
                System.out.println((i + 1) + ". " + peopleList.get(i));
            }
        }
    }

    private static void updatePerson() {
        System.out.println("Enter the index of the person to update:");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        if (index >= 1 && index <= peopleList.size()) {
            System.out.println("Enter the updated details for the person:");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            Person updatedPerson = new Person(name, age);
            peopleList.set(index - 1, updatedPerson);
            System.out.println("Person updated successfully!");
        } else {
            System.out.println("Invalid index. Please enter a valid index.");
        }
    }

    private static void deletePerson() {
        System.out.println("Enter the index of the person to delete:");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        if (index >= 1 && index <= peopleList.size()) {
            peopleList.remove(index - 1);
            System.out.println("Person deleted successfully!");
        } else {
            System.out.println("Invalid index. Please enter a valid index.");
        }
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
