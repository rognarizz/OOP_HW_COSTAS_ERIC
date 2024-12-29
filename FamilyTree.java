package GENEALOGY_OOP.genealogy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class FamilyTree implements Serializable, Iterable<Person> {
    private static final long serialVersionUID = 1L;
    private List<Person> familyTree;

    public FamilyTree() {
        familyTree = new ArrayList<>();
    }

    public void addPerson(Person person) {
        familyTree.add(person);
    }

    public Person getPerson(String name) {
        for (Person person : familyTree) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null; // Если человек с таким именем не найден
    }

    public List<Person> getChildren(String name) {
        Person person = getPerson(name);
        if (person != null) {
            return person.getChildren();
        }
        return null; // Если человек с таким именем не найден
    }

    public void sortFamilyByName() {
        Collections.sort(familyTree, Comparator.comparing(Person::getName));
    }

    public void sortFamilyByAge() {
        Collections.sort(familyTree, Comparator.comparing(Person::getAge));
    }

    @Override
    public Iterator<Person> iterator() {
        return familyTree.iterator();
    }
}
