package OOP_HW_COSTAS_ERIC.OOP_HW_COSTAS_ERIC.genealogy;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int age;
    private List<Person> children;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        children.add(child);
    }
}