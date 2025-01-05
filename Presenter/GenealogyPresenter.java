package GENEALOGY_OOP.genealogy.Presenter;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import GENEALOGY_OOP.genealogy.Model.FamilyTree;
import GENEALOGY_OOP.genealogy.Model.FileOperations;
import GENEALOGY_OOP.genealogy.Model.FileOperationsImpl;
import GENEALOGY_OOP.genealogy.Model.Person;
import GENEALOGY_OOP.genealogy.Model.PersonChildrenRetriever;
import GENEALOGY_OOP.genealogy.Model.PersonNameMatcher;
import GENEALOGY_OOP.genealogy.View.GenealogyView;

public class GenealogyPresenter {
    private FamilyTree<Person> familyTree;
    private FileOperations<Person> fileOperations;
    private GenealogyView view;

    public GenealogyPresenter(GenealogyView view) {
        this.familyTree = new FamilyTree<>();
        this.fileOperations = new FileOperationsImpl<>();
        this.view = view;
    }

    public void addPerson(String name, int age) {
        Person person = new Person(name, age);
        familyTree.addPerson(person);
        view.showMessage("Person added");
    }

    public void addChildToPerson(String parentName, String childName, int childAge) {
        Person parent = familyTree.getPerson(parentName, new PersonNameMatcher());
        if (parent != null) {
            Person child = new Person(childName, childAge);
            parent.addChild(child);
            view.showMessage("Child added");
        } else {
            view.showMessage("Person not found");
        }
    }

    public void saveFamilyTree(String fileName) {
        try {
            fileOperations.saveToFile(familyTree, fileName);
            view.showMessage("Family Tree saved to file");
        } catch (IOException e) {
            view.showMessage("Error saving to file: " + e.getMessage());
        }
    }

    public void loadFamilyTree(String fileName) {
        try {
            familyTree = fileOperations.loadFromFile(fileName);
            view.showMessage("Family Tree loaded from file");
        } catch (IOException | ClassNotFoundException e) {
            view.showMessage("Error loading from file: " + e.getMessage());
        }
    }

    public void sortFamilyByName() {
        familyTree.sortFamily(Comparator.comparing(Person::getName));
        view.showMessage("Family Tree sorted by name");
    }

    public void sortFamilyByAge() {
        familyTree.sortFamily(Comparator.comparing(Person::getAge));
        view.showMessage("Family Tree sorted by age");
    }

    public void displayAllFamilies() {
        view.showAllFamilies(familyTree);
    }

    public void getChildren(String personName) {
        Person person = familyTree.getPerson(personName, new PersonNameMatcher());
        if (person != null) {
            List<Person> children = familyTree.getChildren(person, new PersonChildrenRetriever());
            view.showChildren(children);
        } else {
            view.showMessage("Person not found");
        }
    }
    
}
