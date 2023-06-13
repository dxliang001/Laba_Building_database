package models;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "ClientsList")
@XmlAccessorType(XmlAccessType.FIELD)
public class ClientsList {

    @XmlElement(name = "Clients")
    private List<Clients> clients;

    public ClientsList() {
    }

    public List<Clients> getClients() {
        return clients;
    }

    public void setClients(List<Clients> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "ClientsList{" +
                "clients=" + clients + '\'' +
                '}';
    }
}
