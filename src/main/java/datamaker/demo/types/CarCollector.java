package datamaker.demo.types;

import com.github.javafaker.Faker;

import datamaker.DataMaker;
import datamaker.annotations.ExternalCollection;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CarCollector {
    public static Faker faker() {
        return DataMaker.faker();
    }

    public StringProperty name;

    ObservableList<Car> cars = FXCollections.observableArrayList();

    @ExternalCollection(minSize = 1, maxSize = 10, type = Car.class)
    public ObservableList<Car> getCars() {
        return this.cars;
    }

    public void setCars(ObservableList<Car> cars) {
        this.cars = cars;
    }

    public final StringProperty nameProperty() {
        if (this.name == null) {
            this.name = new SimpleStringProperty(faker().name().firstName());
        }
        return this.name;
    }

    public final String getName() {
        return this.nameProperty().get();
    }

    public final void setName(final String name) {
        this.nameProperty().set(name);
    }

}
