package sistdistribuido.com.freedon.models;

/**
 * Created by Bruno on 03/12/2017.
 */

public class Message {

    private int id;
    private String message;
    private int recipient;
    private int sender;

    public Message(int id, String message, int recipient, int sender) {
        this.id = id;
        this.message = message;
        this.recipient = recipient;
        this.sender = sender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getRecipient() {
        return recipient;
    }

    public void setRecipient(int recipient) {
        this.recipient = recipient;
    }

    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }
}
