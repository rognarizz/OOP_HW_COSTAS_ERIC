package GENEALOGY_OOP.genealogy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class FamilyTree<T> implements Serializable, Iterable<T> {
    private static final long serialVersionUID = 1L;
    private List<T> familyTree;

    public FamilyTree() {
        familyTree = new ArrayList<>();
    }

    public void addPerson(T person) {
        familyTree.add(person);
    }

    public T getPerson(String name, NameMatcher<T> matcher) {
        for (T person : familyTree) {
            if (matcher.match(person, name)) {
                return person;
            }
        }
        return null; // Если человек с таким именем не найден
    }

    public List<T> getChildren(T person, ChildrenRetriever<T> retriever) {
        return retriever.getChildren(person);
    }

    public void sortFamily(Comparator<T> comparator) {
        Collections.sort(familyTree, comparator);
    }

    @Override
    public Iterator<T> iterator() {
        return familyTree.iterator();
    }
}

// Интерфейс для сравнения имен
interface NameMatcher<T> {
    boolean match(T person, String name);
}

// Интерфейс для получения детей
interface ChildrenRetriever<T> {
    List<T> getChildren(T person);
}
