package GENEALOGY_OOP.genealogy.View;

import java.util.List;

import GENEALOGY_OOP.genealogy.Model.FamilyTree;
import GENEALOGY_OOP.genealogy.Model.Person;

public interface GenealogyView {
    void displayMenu();

    void showPerson(Person person);

    void showChildren(List<Person> children);

    void showAllFamilies(FamilyTree<Person> familyTree);

    void showMessage(String message);
}
