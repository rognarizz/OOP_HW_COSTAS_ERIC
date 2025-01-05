package GENEALOGY_OOP.genealogy.Model;

public class PersonNameMatcher implements NameMatcher<Person> {
    @Override
    public boolean match(Person person, String name) {
        return person.getName().equals(name);
    }
}
