package sistdistribuido.com.freedon.models;

/**
 * Created by Bruno on 03/12/2017.
 */

public class Country {

    private int id;
    private String countryName;

    public Country(int id, String countryName) {
        this.id = id;
        this.countryName = countryName;
    }

    public Country() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
