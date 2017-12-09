package sistdistribuido.com.freedon.models;

/**
 * Created by Bruno on 03/12/2017.
 */

public class User {

    private int id;
    private String name;
    private String email;
    private String password;
    private String profileImage;
    private String description;
    private String birthDate;
    private String phoneNumber;
    private int idCountry;
    private int idState;
    private int idDistrict;
    private int idStreet;
    private int houseNumber;
    private int additionalInfo;

    public User(int id, String name, String email, String password, String profileImage, String description, String birthDate, String phoneNumber, int idCountry, int idState, int idDistrict, int idStreet, int houseNumber, int additionalInfo) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.profileImage = profileImage;
        this.description = description;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.idCountry = idCountry;
        this.idState = idState;
        this.idDistrict = idDistrict;
        this.idStreet = idStreet;
        this.houseNumber = houseNumber;
        this.additionalInfo = additionalInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public int getIdState() {
        return idState;
    }

    public void setIdState(int idState) {
        this.idState = idState;
    }

    public int getIdDistrict() {
        return idDistrict;
    }

    public void setIdDistrict(int idDistrict) {
        this.idDistrict = idDistrict;
    }

    public int getIdStreet() {
        return idStreet;
    }

    public void setIdStreet(int idStreet) {
        this.idStreet = idStreet;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(int additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}
