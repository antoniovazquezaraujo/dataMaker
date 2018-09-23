package datamaker.demo;

import java.lang.reflect.Method;

import datamaker.DataMaker;
import datamaker.demo.types.Person;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DataMakerMiniDemo extends Application {
    @Override
    public void start(final Stage primaryStage) {
        final GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(30, 30, 30, 30));
        int row = 0;

        final Label textFieldLabel = new Label("DataMaker mini demo");
        textFieldLabel.setFont(Font.font(24));
        GridPane.setHalignment(textFieldLabel, HPos.CENTER);
        grid.add(textFieldLabel, 1, row++);

        final TableView<Person> table = new TableView<>();
        populateColumns(table, Person.class);

        table.setItems((new DataMaker()
                .setLocaleName("es_ES")
                .setDepthOfSelfCollections(0)
                .setSizeOfCollections(100)
                .makeObservableList(Person.class)
                ));

        grid.add(table, 1, row++);
        GridPane.setHgrow(table, Priority.ALWAYS);
        GridPane.setVgrow(table, Priority.ALWAYS);

        final Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(final String[] args) {
        launch(args);
    }

    private void populateColumns(TableView table, Class clazz) {
        for (Method method : clazz.getMethods()) {
            String name = method.getName();
            if (name.endsWith("Property")) {
                String propName = name.replace("Property", "");

                TableColumn column = new TableColumn(propName);
                column.setCellValueFactory(new PropertyValueFactory<>(propName));
                table.getColumns().add(column);
            }
        }
    }
}
