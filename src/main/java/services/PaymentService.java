package services;

import dao.interfaces.PaymentsMapper;
import models.Payments;

import java.util.List;

public class PaymentService {
    private PaymentsMapper paymentsMapper;

    public PaymentService(PaymentsMapper paymentsMapper) {
        this.paymentsMapper = paymentsMapper;
    }

    public Payments getPaymentById(int id) {
        return paymentsMapper.getPaymentById(id);
    }

    public List<Payments> getAllPayments() {
        return paymentsMapper.getAllPayments();
    }

    public void savePayment(Payments payment) {
        paymentsMapper.save(payment);
    }

    public void updatePayment(Payments payment) {
        paymentsMapper.update(payment);
    }

    public void deletePayment(Payments payment) {
        paymentsMapper.delete(payment);
    }
}
