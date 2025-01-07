package GENEALOGY_OOP.genealogy.Presenter;

import GENEALOGY_OOP.genealogy.View.MenuView;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CommandHandler {
    private GenealogyPresenter presenter;
    private MenuView view;
    private Scanner scanner;

    public CommandHandler(GenealogyPresenter presenter, MenuView view) {
        this.presenter = presenter;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            view.displayMenu();
            int choice = getIntInput();
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
        int age = getIntInput();
        presenter.addPerson(name, age);
    }

    private void addChildToPerson() {
        System.out.print("Enter parent name: ");
        String parentName = scanner.nextLine();
        System.out.print("Enter child name: ");
        String childName = scanner.nextLine();
        System.out.print("Enter child age: ");
        int childAge = getIntInput();
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

    private int getIntInput() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number:");
                scanner.next(); // Discard invalid input
            }
        }
    }
}
