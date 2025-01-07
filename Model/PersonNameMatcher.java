package GENEALOGY_OOP.genealogy.Model;

public class PersonNameMatcher {
    public boolean matches(Person person, String name) {
        return person.getName().equalsIgnoreCase(name);
    }
}
