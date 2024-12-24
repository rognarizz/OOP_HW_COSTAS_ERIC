package GENEALOGY_OOP.genealogy;

import java.util.List;
import java.util.Scanner;
import java.io.IOException;


public class GenealogyResearchApp {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        FileOperations fileOperations = new FileOperationsImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add person");
            System.out.println("2. Add child to person");
            System.out.println("3. Get children of a person");
            System.out.println("4. Save family tree to file");
            System.out.println("5. Load family tree from file");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    Person person = new Person(name, age);
                    familyTree.addPerson(person);
                    break;
                case 2:
                    System.out.print("Enter parent name: ");
                    String parentName = scanner.nextLine();
                    System.out.print("Enter child name: ");
                    String childName = scanner.nextLine();
                    System.out.print("Enter child age: ");
                    int childAge = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    Person parent = familyTree.getPerson(parentName);
                    if (parent != null) {
                        Person child = new Person(childName, childAge);
                        parent.addChild(child);
                    } else {
                        System.out.println("Parent not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter name: ");
                    String personName = scanner.nextLine();
                    Person targetPerson = familyTree.getPerson(personName);
                    if (targetPerson != null) {
                        List<Person> children = targetPerson.getChildren();
                        System.out.println(targetPerson.getName() + "'s children:");
                        for (Person child : children) {
                            System.out.println(child.getName());
                        }
                    } else {
                        System.out.println("Person not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter file name: ");
                    String saveFileName = scanner.nextLine();
                    try {
                        fileOperations.saveToFile(familyTree, saveFileName);
                        System.out.println("Family tree saved to file.");
                    } catch (IOException e) {
                        System.out.println("Error saving to file: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.print("Enter file name: ");
                    String loadFileName = scanner.nextLine();
                    try {
                        familyTree = fileOperations.loadFromFile(loadFileName);
                        System.out.println("Family tree loaded from file.");
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Error loading from file: " + e.getMessage());
                    }
                    break;
                case 6:
                    scanner.close();
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
