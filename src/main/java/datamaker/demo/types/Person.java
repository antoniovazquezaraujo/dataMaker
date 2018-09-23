package datamaker.demo.types;

import java.time.LocalDate;
import java.time.ZoneId;

import com.github.javafaker.Faker;

import datamaker.DataMaker;
import datamaker.annotations.SelfCollection;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Person {

    public Person() {
        super();
    }


    public static Faker faker() {
        return DataMaker.faker();
    }

    @Override
    public String toString() {
        return "Person [children=" + this.children + ", id=" + this.id + ", firstName=" + this.firstName + ", lastName="
                + this.lastName + ", gender=" + this.gender + ", single=" + this.single + ", birthDate="
                + this.birthDate + ", age=" + this.age + ", getChildren()=" + getChildren() + "]";
    }

    ObservableList<Person> children = FXCollections.observableArrayList();

    @SelfCollection(minSize = 1, maxSize = 1, minDepth = 1, maxDepth = 1)
    public ObservableList<Person> getChildren() {
        return this.children;
    }

    static int sequentialNumber = 0;
    private final IntegerProperty id = new SimpleIntegerProperty(sequentialNumber++);

    private StringProperty firstName = new SimpleStringProperty(faker().name().firstName());

    private final StringProperty lastName = new SimpleStringProperty(faker().name().lastName());

    private final StringProperty gender = new SimpleStringProperty(faker().bool().bool() ? "HOMBRE" : "MUJER");

    private final BooleanProperty single = new SimpleBooleanProperty(faker().bool().bool());

    private final ObjectProperty<LocalDate> birthDate = new SimpleObjectProperty<>(
            (faker().date().birthday().toInstant().atZone(ZoneId.systemDefault())).toLocalDate());

    private final IntegerProperty age = new SimpleIntegerProperty(
            LocalDate.now().getYear() - this.birthDate.get().getYear());

    public final IntegerProperty idProperty() {
        return this.id;
    }

    public final int getId() {
        return this.idProperty().get();
    }

    public final void setId(final int id) {
        this.idProperty().set(id);
    }

    public StringProperty firstNameProperty() {
        return this.firstName;
    }

    public String getFirstName() {
        return this.firstNameProperty().get();
    }

    public void setFirstName(final String firstName) {
        this.firstNameProperty().set(firstName);
    }

    public final StringProperty lastNameProperty() {
        return this.lastName;
    }

    public final String getLastName() {
        return this.lastNameProperty().get();
    }

    public final void setLastName(final String lastName) {
        this.lastNameProperty().set(lastName);
    }

    public final StringProperty genderProperty() {
        return this.gender;
    }

    public final String getGender() {
        return this.genderProperty().get();
    }

    public final void setGender(final String gender) {
        this.genderProperty().set(gender);
    }

    public final BooleanProperty singleProperty() {
        return this.single;
    }

    public final boolean isSingle() {
        return this.singleProperty().get();
    }

    public final void setSingle(final boolean single) {
        this.singleProperty().set(single);
    }

    public final ObjectProperty<LocalDate> birthDateProperty() {
        return this.birthDate;
    }

    public final LocalDate getBirthDate() {
        return this.birthDateProperty().get();
    }

    public final void setBirthDate(final LocalDate birthDate) {
        this.birthDateProperty().set(birthDate);
    }

    public final IntegerProperty ageProperty() {
        return this.age;
    }

    public final int getAge() {
        return this.ageProperty().get();
    }

    public final void setAge(final int age) {
        this.ageProperty().set(age);
    }

    public enum Gender {

        FEMALE("MUJER", "Female"), MALE("HOMBRE", "Male");

        private final String code;
        private final String text;

        private Gender(final String code, final String text) {
            this.code = code;
            this.text = text;
        }

        public String getCode() {
            return this.code;
        }

        public String getText() {
            return this.text;
        }

        public static Gender getByCode(final String genderCode) {
            for (final Gender g : Gender.values()) {
                if (g.code.equals(genderCode)) {
                    return g;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return this.text;
        }

    }

}
