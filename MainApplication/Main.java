package GENEALOGY_OOP.genealogy.MainApplication;

import GENEALOGY_OOP.genealogy.Model.FileOperationsImpl;
import GENEALOGY_OOP.genealogy.Model.Person;
import GENEALOGY_OOP.genealogy.Presenter.CommandHandler;
import GENEALOGY_OOP.genealogy.Presenter.GenealogyPresenter;
import GENEALOGY_OOP.genealogy.View.ConsoleTreeView;

public class Main {
    public static void main(String[] args) {
        ConsoleTreeView consoleTreeView = new ConsoleTreeView();
        FileOperationsImpl<Person> fileOperations = new FileOperationsImpl<>();

        GenealogyPresenter presenter = new GenealogyPresenter(
            fileOperations, consoleTreeView, consoleTreeView, consoleTreeView, consoleTreeView
        );
        
        CommandHandler commandHandler = new CommandHandler(presenter, consoleTreeView);
        commandHandler.run();
    }
}
