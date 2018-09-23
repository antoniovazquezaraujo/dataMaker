package datamaker.demo.types;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Employee extends Citizen {
    private static final int FIELD_ORDER = 300;


    private final StringProperty company = new SimpleStringProperty(faker().company().name());

    private final IntegerProperty percentage = new SimpleIntegerProperty(faker().number().numberBetween(0, 100));

    private final DoubleProperty salary = new SimpleDoubleProperty(faker().number().randomDouble(2, 0, 10000));

    public Employee() {
        super();
    }

    public final StringProperty companyProperty() {
        return this.company;
    }

    public final String getCompany() {
        return this.companyProperty().get();
    }

    public final void setCompany(final String company) {
        this.companyProperty().set(company);
    }

    public final IntegerProperty percentageProperty() {
        return this.percentage;
    }

    public final int getPercentage() {
        return this.percentageProperty().get();
    }

    public final void setPercentage(final int percentage) {
        this.percentageProperty().set(percentage);
    }

    public final DoubleProperty salaryProperty() {
        return this.salary;
    }

    public final double getSalary() {
        return this.salaryProperty().get();
    }

    public final void setSalary(final double salary) {
        this.salaryProperty().set(salary);
    }

}
