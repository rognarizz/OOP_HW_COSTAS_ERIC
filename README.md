
### MainApplication/
- **Main.java**: Точка входа в приложение.

### Model/
- **FamilyTree.java**: Модель семейного дерева.
- **Person.java**: Модель человека.
- **PersonChildrenRetriever.java**: Класс для извлечения детей.
- **PersonNameMatcher.java**: Класс для сопоставления имен.
- **FileOperations.java**: Интерфейс для операций с файлами.
- **FileOperationsImpl.java**: Реализация интерфейса FileOperations.

### View/
- **ConsoleTreeView.java**: Реализация всех интерфейсов представления для консольного приложения.
- **MenuView.java**: Интерфейс для отображения меню.
- **PersonView.java**: Интерфейс для отображения информации о человеке.
- **MessageView.java**: Интерфейс для отображения сообщений.
- **ChildrenView.java**: Интерфейс для отображения детей.
- **FamilyTreeView.java**: Интерфейс для отображения всех семей.

### Presenter/
- **GenealogyPresenter.java**: Презентер, управляющий данными и бизнес-логикой.
- **CommandHandler.java**: Класс для обработки команд и взаимодействия с пользователем.
