package sistdistribuido.com.freedon.models;

/**
 * Created by Bruno on 03/12/2017.
 */

public class Product {

    private int id;
    private String name;
    private String description;
    private int idUser;
    private int status;

    public Product(int id, String name, String description, int idUser, int status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.idUser = idUser;
        this.status = status;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
