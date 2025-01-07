package GENEALOGY_OOP.genealogy.View;

import java.util.List;
import GENEALOGY_OOP.genealogy.Model.FamilyTree;
import GENEALOGY_OOP.genealogy.Model.Person;

public class ConsoleTreeView implements MenuView, PersonView, ChildrenView, FamilyTreeView, MessageView {

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
