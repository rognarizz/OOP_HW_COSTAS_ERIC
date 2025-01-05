package GENEALOGY_OOP.genealogy.Model;

import java.util.List;

public class PersonChildrenRetriever implements ChildrenRetriever<Person> {

    @Override
    public List<Person> getChildren(Person person) {
        return person.getChildren();
    }

}
