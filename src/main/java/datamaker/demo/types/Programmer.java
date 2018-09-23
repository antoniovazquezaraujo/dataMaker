package datamaker.demo.types;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Programmer extends Employee {
    private static final int FIELD_ORDER = 400;


    private final StringProperty encryptedPassword = new SimpleStringProperty(faker().crypto().sha256());

    private final StringProperty projectName = new SimpleStringProperty(faker().commerce().productName());

    private final StringProperty projectDescription = new SimpleStringProperty(faker().lorem().paragraph());

    public Programmer() {
        super();
    }

    public final StringProperty encryptedPasswordProperty() {
        return this.encryptedPassword;
    }

    public final String getEncryptedPassword() {
        return this.encryptedPasswordProperty().get();
    }

    public final void setEncryptedPassword(final String encryptedPassword) {
        this.encryptedPasswordProperty().set(encryptedPassword);
    }

    public final StringProperty projectNameProperty() {
        return this.projectName;
    }

    public final String getProjectName() {
        return this.projectNameProperty().get();
    }

    public final void setProjectName(final String projectName) {
        this.projectNameProperty().set(projectName);
    }

    public final StringProperty projectDescriptionProperty() {
        return this.projectDescription;
    }

    public final String getProjectDescription() {
        return this.projectDescriptionProperty().get();
    }

    public final void setProjectDescription(final String projectDescription) {
        this.projectDescriptionProperty().set(projectDescription);
    }


}