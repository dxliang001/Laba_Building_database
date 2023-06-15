package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Objects;

@XmlRootElement(name = "Clients")
@XmlAccessorType(XmlAccessType.FIELD)
public class Clients {

    @JsonProperty("client_id")
    @XmlElement(name = "clientId")
    private int clientId;
    @JsonProperty("client_name")
    @XmlElement(name = "clientName")
    private String clientName;
    @JsonProperty("contact_name")
    @XmlElement(name = "contactName")
    private String contactName;
    @JsonProperty("client_address")
    @XmlElement(name = "clientAddress")
    private String clientAddress;
    @JsonProperty("client_email")
    @XmlElement(name = "clientEmail")
    private String clientEmail;
    @JsonProperty("client_phone")
    @XmlElement(name = "clientPhone")
    private String clientPhone;

    public Clients() {}

    public Clients(int clientId, String clientName, String contactName, String clientAddress, String clientEmail, String clientPhone) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.contactName = contactName;
        this.clientAddress = clientAddress;
        this.clientEmail = clientEmail;
        this.clientPhone = clientPhone;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", clientName='" + clientName + '\'' +
                ", contactName='" + contactName + '\'' +
                ", clientAddress='" + clientAddress + '\'' +
                ", clientEmail='" + clientEmail + '\'' +
                ", clientPhone='" + clientPhone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clients that = (Clients) o;
        return clientId == that.clientId &&
                Objects.equals(clientName, that.clientName) &&
                Objects.equals(contactName, that.contactName) &&
                Objects.equals(clientAddress, that.clientAddress) &&
                Objects.equals(clientEmail, that.clientEmail) &&
                Objects.equals(clientPhone, that.clientPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, clientName, contactName, clientAddress, clientEmail, clientPhone);
    }
}
