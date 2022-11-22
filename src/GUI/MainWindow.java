package GUI;


import Model.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainWindow extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Random Presentation Picker");
        BorderPane pane = new BorderPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public void initContent (BorderPane pane) {
        TabPane tabPane = new TabPane();

        pane.setCenter(tabPane);

        ControllerInterface controller = new Controller();
        controller.initContent();

        this.initTabPane(tabPane);
    }

    public void initTabPane(TabPane tabPane) {
        //tabPane size
        tabPane.setPrefSize(1000, 750);

        //disabled closing of tabs
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        //-----------Presentation Tab creation------------------------------------
        //Creates a new instance of a SaleTab
        PresentationTab presTab = new PresentationTab();
        //Creates a new Tab, with a title and the saleTab as content
        Tab firstTab = new Tab("Presentation", presTab);
        //...then adds it to the tabPane
        tabPane.getTabs().add(firstTab);
        //Updates controls when tab selection changes
        firstTab.setOnSelectionChanged(event -> presTab.updateControls());

        //-----------Student Tab creation------------------------------------
        //Creates a new instance of a SaleTab
        StudentsTab studTab = new StudentsTab();
        //Creates a new Tab, with a title and the saleTab as content
        Tab secondTab = new Tab("Students", studTab);
        //...then adds it to the tabPane
        tabPane.getTabs().add(secondTab);
        //Updates controls when tab selection changes
        secondTab.setOnSelectionChanged(event -> studTab.updateControls());
    }

}
