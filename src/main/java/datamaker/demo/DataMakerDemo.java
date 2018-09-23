package datamaker.demo;

import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Random;

import datamaker.DataMaker;
import datamaker.demo.types.Programmer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

public class DataMakerDemo extends Application {
    @Override
    public void start(final Stage primaryStage) throws Exception {
        primaryStage.setTitle("DataMaker demo");
        VBox box = new VBox();
        box.setSpacing(10);
        box.setPadding(new Insets(30, 30, 30, 30));

        try {
            TableView<Programmer> table = new TableView<>();
            populateColumns(table, Programmer.class);
            box.getChildren().add(table);
            HBox tableHBox = new HBox();
            tableHBox.setSpacing(10);

            tableHBox.getChildren().add(new Label("Min. size"));
            TextField tableMinSize = new TextField();
            tableMinSize.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));
            tableMinSize.setText("1");
            tableMinSize.setPromptText("Min. size:");
            tableHBox.getChildren().add(tableMinSize);

            tableHBox.getChildren().add(new Label("Max. size"));
            TextField tableMaxSize = new TextField();
            tableMaxSize.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));
            tableMaxSize.setText("1");
            tableMaxSize.setPromptText("Max. size:");
            tableHBox.getChildren().add(tableMaxSize);

            tableHBox.getChildren().add(new Label("Random seed"));
            TextField tableSeed = new TextField();
            tableSeed.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));
            tableSeed.setText("0");
            tableSeed.setPromptText("Random seed:");
            tableHBox.getChildren().add(tableSeed);

            ComboBox<String> localesCombo = new ComboBox<>();
            for (Locale locale : Locale.getAvailableLocales()) {
                localesCombo.getItems().add(locale.toString());
            }
            localesCombo.setValue("es_ES");
            tableHBox.getChildren().add(localesCombo);

            Button tableApplyButton = new Button("Apply");
            tableHBox.getChildren().add(tableApplyButton);
            tableApplyButton.setOnAction(event -> {
                int x = 0;
                int y = 0;
                int seed = new Random().nextInt();
                if (!tableMinSize.getText().isEmpty()) {
                    x = Integer.parseInt(tableMinSize.getTextFormatter().getValue().toString());
                }
                if (!tableMaxSize.getText().isEmpty()) {
                    y = Integer.parseInt(tableMaxSize.getTextFormatter().getValue().toString());
                }
                if (!tableSeed.getText().isEmpty()) {
                    seed = Integer.parseInt(tableSeed.getTextFormatter().getValue().toString());
                }
                table.setItems(
                        new DataMaker()
                        .setSeed(seed)
                        .setLocaleName(localesCombo.getValue().toString())
                        .setDepthOfSelfCollections(0)
                        .setSizeOfCollections(x, y)
                        .makeObservableList(Programmer.class));

            });
            box.getChildren().add(tableHBox);
            TreeTableView<Programmer> treeTable = new TreeTableView<>();
            populateTreeColumns(treeTable, Programmer.class);

            box.getChildren().add(treeTable);

            HBox hBox = new HBox();
            hBox.setSpacing(10);

            hBox.getChildren().add(new Label("Min. size"));
            TextField minSize = new TextField();
            minSize.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));
            minSize.setText("1");
            minSize.setPromptText("Min. size:");
            hBox.getChildren().add(minSize);

            hBox.getChildren().add(new Label("Max. size"));
            TextField maxSize = new TextField();
            maxSize.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));
            maxSize.setText("1");
            maxSize.setPromptText("Max. size:");
            hBox.getChildren().add(maxSize);

            hBox.getChildren().add(new Label("Max. deep"));
            TextField maxDepth = new TextField();
            maxDepth.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));
            maxDepth.setText("1");
            maxDepth.setPromptText("Max. deep:");
            hBox.getChildren().add(maxDepth);
            hBox.getChildren().add(new Label("Random seed"));
            TextField treeSeed = new TextField();
            treeSeed.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));
            treeSeed.setText("1");
            treeSeed.setPromptText("Random seed:");
            hBox.getChildren().add(treeSeed);

            ComboBox<String> treeLocalesCombo = new ComboBox();
            for (Locale locale : Locale.getAvailableLocales()) {
                treeLocalesCombo.getItems().add(locale.toString());
            }
            treeLocalesCombo.setValue("es_ES");
            hBox.getChildren().add(treeLocalesCombo);

            Button treeTableApplyButton = new Button("Apply");
            hBox.getChildren().add(treeTableApplyButton);

            treeTableApplyButton.setOnAction(event -> {
                final int x;
                final int y;
                final int seed;
                final int depth;
                if (!minSize.getText().isEmpty()) {
                    x = Integer.parseInt(minSize.getTextFormatter().getValue().toString());
                } else {
                    x = 0;
                }
                if (!maxSize.getText().isEmpty()) {
                    y = Integer.parseInt(maxSize.getTextFormatter().getValue().toString());
                } else {
                    y = 0;
                }
                if (!maxDepth.getText().isEmpty()) {
                    depth = Integer.parseInt(maxDepth.getTextFormatter().getValue().toString());
                } else {
                    depth = 1;
                }
                if (!treeSeed.getText().isEmpty()) {
                    seed = Integer.parseInt(treeSeed.getTextFormatter().getValue().toString());
                } else {
                    seed = new Random().nextInt();
                }

                long calcSize = calcSize(y, depth);
                if (calcSize > 1000) {
                    final Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Tree max. size");
                    alert.setContentText("Up to " + calcSize + " elements could be created. Continue?");
                    alert.show();
                    final Button btOk = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
                    btOk.addEventFilter(ActionEvent.ACTION, theEvent -> {
                        theEvent.consume();
                        alert.close();
                        treeTable.setRoot(new DataMaker().setSeed(seed)
                                .setLocaleName(treeLocalesCombo.getValue().toString()).setDepthOfSelfCollections(depth)
                                .setSizeOfCollections(x, y).makeTree(Programmer.class));
                    });
                } else {
                    treeTable.setRoot(new DataMaker().setSeed(seed)
                            .setLocaleName(treeLocalesCombo.getValue().toString()).setDepthOfSelfCollections(depth)
                            .setSizeOfCollections(x, y).makeTree(Programmer.class));
                }

            });
            box.getChildren().add(hBox);
            final Scene scene = new Scene(box);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception ew) {
            System.out.println(ew);
        }
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

    private void populateTreeColumns(TreeTableView table, Class clazz) {
        for (Method method : clazz.getMethods()) {
            String name = method.getName();
            if (name.endsWith("Property")) {
                String propName = name.replace("Property", "");

                TreeTableColumn column = new TreeTableColumn(propName);
                column.setCellValueFactory(new TreeItemPropertyValueFactory<>(propName));
                table.getColumns().add(column);
            }
        }
    }

    private long calcSize(int y, int depth) {
        if (depth == 0) {
            return 0;
        }
        return (long) (Math.pow(y, depth) + calcSize(y, depth - 1));
    }

    public static void main(final String[] args) {
        launch(args);
    }
}
