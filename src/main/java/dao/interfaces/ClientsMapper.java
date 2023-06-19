package dao.interfaces;

import models.Clients;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ClientsMapper {

    @Select("SELECT * FROM clients")
    List<Clients> getAllClients();

    @Select("SELECT * FROM clients WHERE client_id = #{id}")
    Clients getClientById(int id);

    @Insert("INSERT INTO clients (client_id, client_name, contact_name, client_address, client_email, client_phone) VALUES (#{clientId}, #{clientName}, #{contactName}, #{clientAddress}, #{clientEmail}, #{clientPhone})")
    void save(Clients client);

    @Update("UPDATE clients SET client_name = #{clientName}, contact_name = #{contactName}, client_address = #{clientAddress}, client_email = #{clientEmail}, client_phone = #{clientPhone} WHERE client_id = #{clientId}")
    void update(Clients client);

    @Delete("DELETE FROM clients WHERE client_id = #{clientId}")
    void delete(Clients client);
}
