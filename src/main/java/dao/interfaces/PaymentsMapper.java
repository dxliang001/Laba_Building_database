package dao.interfaces;

import models.Payments;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PaymentsMapper {

    @Select("SELECT * FROM payments")
    List<Payments> getAllPayments();

    @Select("SELECT * FROM payments WHERE payment_id = #{id}")
    Payments getPaymentById(int id);

    @Insert("INSERT INTO payments (payment_id, client_id, project_id, amount, payment_date, payment_method) VALUES (#{paymentId}, #{clientId}, #{projectId}, #{amount}, #{paymentDate}, #{paymentMethod})")
    void save(Payments payment);

    @Update("UPDATE payments SET client_id = #{clientId}, project_id = #{projectId}, amount = #{amount}, payment_date = #{paymentDate}, payment_method = #{paymentMethod} WHERE payment_id = #{paymentId}")
    void update(Payments payment);

    @Delete("DELETE FROM payments WHERE payment_id = #{paymentId}")
    void delete(Payments payment);
}
