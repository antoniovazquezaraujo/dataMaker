package datamaker.demo.types;

import com.github.javafaker.Faker;

import datamaker.DataMaker;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Car {
    public static Faker faker() {
        return DataMaker.faker();
    }

    public StringProperty brand;
    public StringProperty model;
    public IntegerProperty year;

    public final StringProperty brandProperty() {
        if (this.brand == null) {
            this.brand = new SimpleStringProperty(faker().app().name());
        }
        return this.brand;
    }

    public final String getBrand() {
        return this.brandProperty().get();
    }

    public final void setBrand(final String brand) {
        this.brandProperty().set(brand);
    }

    public final StringProperty modelProperty() {
        if (this.model == null) {
            this.model = new SimpleStringProperty(faker().pokemon().name());
        }
        return this.model;
    }

    public final String getModel() {
        return this.modelProperty().get();
    }

    public final void setModel(final String model) {
        this.modelProperty().set(model);
    }

    public final IntegerProperty yearProperty() {
        if (this.year == null) {
            this.year = new SimpleIntegerProperty(faker().number().numberBetween(1900, 2080));
        }
        return this.year;
    }

    public final int getYear() {
        return this.yearProperty().get();
    }

    public final void setYear(final int year) {
        this.yearProperty().set(year);
    }

}
