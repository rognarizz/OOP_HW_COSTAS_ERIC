package GENEALOGY_OOP.genealogy.Presenter;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import GENEALOGY_OOP.genealogy.Model.*;
import GENEALOGY_OOP.genealogy.View.*;

public class GenealogyPresenter {
    private FamilyTree<Person> familyTree;
    private FileOperations<Person> fileOperations;
    private PersonView personView;
    private MessageView messageView;
    private ChildrenView childrenView;
    private FamilyTreeView familyTreeView;

    public GenealogyPresenter(FileOperations<Person> fileOperations, PersonView personView, MessageView messageView, ChildrenView childrenView, FamilyTreeView familyTreeView) {
        this.familyTree = new FamilyTree<>();
        this.fileOperations = fileOperations;
        this.personView = personView;
        this.messageView = messageView;
        this.childrenView = childrenView;
        this.familyTreeView = familyTreeView;
    }

    public void addPerson(String name, int age) {
        Person person = new Person(name, age);
        familyTree.addPerson(person);
        messageView.showMessage("Person added");
    }

    public void addChildToPerson(String parentName, String childName, int childAge) {
        Person parent = familyTree.getPerson(parentName, new PersonNameMatcher());
        if (parent != null) {
            Person child = new Person(childName, childAge);
            parent.addChild(child);
            messageView.showMessage("Child added");
        } else {
            messageView.showMessage("Person not found");
        }
    }

    public void saveFamilyTree(String fileName) {
        try {
            fileOperations.saveToFile(familyTree, fileName);
            messageView.showMessage("Family Tree saved to file");
        } catch (IOException e) {
            messageView.showMessage("Error saving to file: " + e.getMessage());
        }
    }

    public void loadFamilyTree(String fileName) {
        try {
            familyTree = fileOperations.loadFromFile(fileName);
            messageView.showMessage("Family Tree loaded from file");
        } catch (IOException | ClassNotFoundException e) {
            messageView.showMessage("Error loading from file: " + e.getMessage());
        }
    }

    public void sortFamilyByName() {
        familyTree.sortFamily(Comparator.comparing(Person::getName));
        messageView.showMessage("Family Tree sorted by name");
    }

    public void sortFamilyByAge() {
        familyTree.sortFamily(Comparator.comparing(Person::getAge));
        messageView.showMessage("Family Tree sorted by age");
    }

    public void displayAllFamilies() {
        familyTreeView.showAllFamilies(familyTree);
    }

    public void getChildren(String personName) {
        Person person = familyTree.getPerson(personName, new PersonNameMatcher());
        if (person != null) {
            List<Person> children = familyTree.getChildren(person, new PersonChildrenRetriever());
            childrenView.showChildren(children);
        } else {
            messageView.showMessage("Person not found");
        }
    }
}
