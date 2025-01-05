package GENEALOGY_OOP.genealogy.Model;

import java.io.*;

public class FileOperationsImpl<T> implements FileOperations<T> {
    @Override
    public void saveToFile(FamilyTree<T> familyTree, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(familyTree);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public FamilyTree<T> loadFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Object obj = ois.readObject();
            if (obj instanceof FamilyTree<?>) {
                return (FamilyTree<T>) obj;  // Безопасное приведение типов с проверкой
            } else {
                throw new ClassNotFoundException("File does not contain a FamilyTree object");
            }
        }
    }
}
