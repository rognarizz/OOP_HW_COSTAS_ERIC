package genealogy;

import java.io.IOException;

public interface FileOperations {
    void saveToFile(FamilyTree familyTree, String fileName) throws IOException;

    FamilyTree loadFromFile(String fileName) throws IOException, ClassNotFoundException;
}
