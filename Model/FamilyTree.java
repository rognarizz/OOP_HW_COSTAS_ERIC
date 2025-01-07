package GENEALOGY_OOP.genealogy.Model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T>  implements Iterable<T> {
    private List<T> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addPerson(T person) {
        members.add(person);
    }

    public T getPerson(String name, PersonNameMatcher matcher) {
        for (T member : members) {
            if (matcher.matches((Person) member, name)) {
                return member;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public List<T> getChildren(T person, PersonChildrenRetriever retriever) {
        return (List<T>) retriever.retrieveChildren((Person) person);
    }

    public void sortFamily(Comparator<T> comparator) {
        members.sort(comparator);
    }

    @Override
    public Iterator<T> iterator() {
        return members.iterator();
    }
}
