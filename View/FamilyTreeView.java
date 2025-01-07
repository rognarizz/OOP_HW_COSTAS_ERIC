package GENEALOGY_OOP.genealogy.View;

import GENEALOGY_OOP.genealogy.Model.FamilyTree;
import GENEALOGY_OOP.genealogy.Model.Person;

public interface FamilyTreeView {
    void showAllFamilies(FamilyTree<Person> familyTree);
}
