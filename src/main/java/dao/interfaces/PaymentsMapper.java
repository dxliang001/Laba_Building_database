package dao.interfaces;

import models.Payments;

import java.util.List;

public interface PaymentsMapper {

    List<Payments> getAllPayments();

    Payments getPaymentById(int id);

    void save(Payments payment);

    void update(Payments payment);

    void delete(Payments payment);
}
