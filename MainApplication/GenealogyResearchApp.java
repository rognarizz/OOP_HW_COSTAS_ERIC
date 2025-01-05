package GENEALOGY_OOP.genealogy.MainApplication;

import java.util.List;
import java.util.Scanner;

import GENEALOGY_OOP.genealogy.Model.FamilyTree;
import GENEALOGY_OOP.genealogy.Model.Person;
import GENEALOGY_OOP.genealogy.Presenter.GenealogyPresenter;
import GENEALOGY_OOP.genealogy.View.GenealogyView;

public class GenealogyResearchApp implements GenealogyView {
    private GenealogyPresenter presenter;
    private Scanner scanner;

    public GenealogyResearchApp() {
        presenter = new GenealogyPresenter(this);
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        GenealogyResearchApp app = new GenealogyResearchApp();
        app.run();
    }

    public void run() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    addChildToPerson();
                    break;
                case 3:
                    getChildren();
                    break;
                case 4:
                    saveFamilyTree();
                    break;
                case 5:
                    loadFamilyTree();
                    break;
                case 6:
                    sortFamilyByName();
                    break;
                case 7:
                    sortFamilyByAge();
                    break;
                case 8:
                    displayAllFamilies();
                    break;
                case 9:
                    scanner.close();
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    private void addPerson() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        presenter.addPerson(name, age);
    }

    private void addChildToPerson() {
        System.out.print("Enter parent name: ");
        String parentName = scanner.nextLine();
        System.out.print("Enter child name: ");
        String childName = scanner.nextLine();
        System.out.print("Enter child age: ");
        int childAge = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        presenter.addChildToPerson(parentName, childName, childAge);
    }

    private void getChildren() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        presenter.getChildren(name);
    }

    private void saveFamilyTree() {
        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();
        presenter.saveFamilyTree(fileName);
    }

    private void loadFamilyTree() {
        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();
        presenter.loadFamilyTree(fileName);
    }

    private void sortFamilyByName() {
        presenter.sortFamilyByName();
    }

    private void sortFamilyByAge() {
        presenter.sortFamilyByAge();
    }

    private void displayAllFamilies() {
        presenter.displayAllFamilies();
    }

    @Override
    public void displayMenu() {
        System.out.println("1. Add person");
        System.out.println("2. Add child to person");
        System.out.println("3. Get children of a person");
        System.out.println("4. Save family tree to file");
        System.out.println("5. Load family tree from file");
        System.out.println("6. Sort family by name");
        System.out.println("7. Sort family by age");
        System.out.println("8. Display all families");
        System.out.println("9. Exit");
    }

    @Override
    public void showPerson(Person person) {
        System.out.println("Person: " + person);
    }

    @Override
    public void showChildren(List<Person> children) {
        System.out.println("Children:");
        for (Person child : children) {
            System.out.println(child);
        }
    }

    @Override
    public void showAllFamilies(FamilyTree<Person> familyTree) {
        System.out.println("All families in the family tree:");
        for (Person person : familyTree) {
            System.out.println(person);
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

}
