import dao.interfaces.ClientsMapper;
import models.Clients;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class Main {

    public static void main(String[] args) {
        SqlSession session = null;
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

            session = sqlSessionFactory.openSession();
            ClientsMapper mapper = session.getMapper(ClientsMapper.class);

            /* Test insertClient
            Clients newClient = new Clients();
            newClient.setClientId(1);
            newClient.setClientName("Client Name");
            newClient.setContactName("Contact Name");
            newClient.setClientAddress("Client Address");
            newClient.setClientEmail("client@example.com");
            newClient.setClientPhone("123-456-7890");
            mapper.save(newClient);
            session.commit();
            */

            // Test getClientById
            Clients client = mapper.getClientById(2);
            System.out.println("Client " + client.getClientName());


            client = mapper.getClientById(5);
            System.out.println("Client : " + client);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}

