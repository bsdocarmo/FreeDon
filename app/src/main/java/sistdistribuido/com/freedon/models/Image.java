package sistdistribuido.com.freedon.models;

/**
 * Created by Bruno on 03/12/2017.
 */

public class Image {

    private int id;
    private int idProduct;
    private int image;

    public Image(int id, int idProduct, int image) {
        this.id = id;
        this.idProduct = idProduct;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
