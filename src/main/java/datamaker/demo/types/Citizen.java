package datamaker.demo.types;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Citizen extends Person {
    public Citizen() {
        super();
    }

    private static final int FIELD_ORDER = 200;

    private final StringProperty street = new SimpleStringProperty(faker().address().streetName());

    private final StringProperty zipCode = new SimpleStringProperty(faker().address().zipCode());

    private final StringProperty city = new SimpleStringProperty(faker().address().city());

    private final StringProperty country = new SimpleStringProperty(faker().address().country());

    private final StringProperty idCountry = new SimpleStringProperty(faker().address().countryCode());

    public final StringProperty streetProperty() {
        return this.street;
    }

    public final String getStreet() {
        return this.streetProperty().get();
    }

    public final void setStreet(final String street) {
        this.streetProperty().set(street);
    }

    public final StringProperty zipCodeProperty() {
        return this.zipCode;
    }

    public final String getZipCode() {
        return this.zipCodeProperty().get();
    }

    public final void setZipCode(final String zipCode) {
        this.zipCodeProperty().set(zipCode);
    }

    public final StringProperty cityProperty() {
        return this.city;
    }

    public final String getCity() {
        return this.cityProperty().get();
    }

    public final void setCity(final String city) {
        this.cityProperty().set(city);
    }

    public final StringProperty countryProperty() {
        return this.country;
    }

    public final String getCountry() {
        return this.countryProperty().get();
    }

    public final void setCountry(final String country) {
        this.countryProperty().set(country);
    }

    public final StringProperty idCountryProperty() {
        return this.idCountry;
    }

    public final String getIdCountry() {
        return this.idCountryProperty().get();
    }

    public final void setIdCountry(final String idCountry) {
        this.idCountryProperty().set(idCountry);
    }

    public enum CountryIcon {

        USA(1, "us"), GREAT_BRITAIN(44, "gb"), AUSTRALIA(61, "au"), CANADA(11, "ca"), SPAIN(34, "es");

        private final int id;
        private final String locale;

        private CountryIcon(final int id, final String locale) {
            this.id = id;
            this.locale = locale;
        }

        public int getId() {
            return this.id;
        }

        public String getLocale() {
            return this.locale;
        }

        public static CountryIcon getById(final int id) {
            for (final CountryIcon g : CountryIcon.values()) {
                if (g.id == id) {
                    return g;
                }
            }
            return null;
        }

        public static String getIconUrl(final CountryIcon country) {
            return "/imx/flags/16/" + country.getLocale() + ".png";
        }

        @Override
        public String toString() {
            return this.locale;
        }
    }

}
