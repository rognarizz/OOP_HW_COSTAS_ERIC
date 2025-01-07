package GENEALOGY_OOP.genealogy.Model;

import java.util.List;

public class PersonChildrenRetriever {
    public List<Person> retrieveChildren(Person person) {
        return person.getChildren();
    }
}
