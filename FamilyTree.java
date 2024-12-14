package OOP_HW_COSTAS_ERIC.OOP_HW_COSTAS_ERIC.genealogy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FamilyTree {
    private Map<String, Person> familyTree;

    public FamilyTree() {
        familyTree = new HashMap<>();
    }

    public void addPerson(Person person) {
        familyTree.put(person.getName(), person);
    }

    public Person getPerson(String name) {
        return familyTree.get(name);
    }

    public List<Person> getChildren(String name) {
        Person person = familyTree.get(name);
        if (person != null) {
            return person.getChildren();
        }
        return null;
    }
}