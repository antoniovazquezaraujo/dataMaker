package datamaker.demo;

import datamaker.DataMaker;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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

public class DataMakerDemo1 extends Application {
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

        final TableView<MyPerson> table = new TableView<>();
        TableColumn<MyPerson, String> col = new TableColumn<MyPerson, String>("First Name");
        col.setCellValueFactory(new PropertyValueFactory("field1"));
        table.getColumns().setAll(col);

        table.setItems((new DataMaker()
                .setLocaleName("es_ES")
                .setDepthOfSelfCollections(0)
                .setSizeOfCollections(100)
                .makeObservableList(MyPerson.class)
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

    public static class MyPerson {
        private StringProperty field1 = new SimpleStringProperty(DataMaker.faker().commerce().department());
        public final StringProperty field1Property() {
            return this.field1;
        }
        public final String getField1() {
            return this.field1Property().get();
        }
        public final void setField1(final String field1) {
            this.field1Property().set(field1);
        }
    }
}
