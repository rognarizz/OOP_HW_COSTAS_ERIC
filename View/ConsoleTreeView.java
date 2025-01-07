package GENEALOGY_OOP.genealogy.View;

import java.util.List;
import GENEALOGY_OOP.genealogy.Model.FamilyTree;
import GENEALOGY_OOP.genealogy.Model.Person;

public class ConsoleTreeView implements MenuView, PersonView, ChildrenView, FamilyTreeView, MessageView {

    @Override
    public void displayMenu() {
        System.out.println("1. Добавить человека");
        System.out.println("2. Добавить ребенка к человеку");
        System.out.println("3. Получить детей человека");
        System.out.println("4. Сохранить семейное дерево в файл");
        System.out.println("5. Загрузить семейное дерево из файла");
        System.out.println("6. Отсортировать семейное дерево по имени");
        System.out.println("7. Отсортировать семейное дерево по возрасту");
        System.out.println("8. Показать все семьи");
        System.out.println("9. Выйти");
    }

    @Override
    public void showPerson(Person person) {
        System.out.println("Человек: " + person);
    }

    @Override
    public void showChildren(List<Person> children) {
        System.out.println("Дети:");
        for (Person child : children) {
            System.out.println(child);
        }
    }

    @Override
    public void showAllFamilies(FamilyTree<Person> familyTree) {
        System.out.println("Все семьи в семейном дереве:");
        for (Person person : familyTree) {
            System.out.println(person);
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}
