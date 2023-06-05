package services;

import dao.interfaces.PaymentsDAO;
import models.Payments;

import java.util.List;

public class PaymentService {
    private PaymentsDAO paymentsDao;

    public PaymentService(PaymentsDAO paymentsDao) {
        this.paymentsDao = paymentsDao;
    }

    public Payments getPaymentById(int id) {
        return paymentsDao.getPaymentById(id);
    }

    public List<Payments> getAllPayments() {
        return paymentsDao.getAllPayments();
    }

    public void savePayment(Payments payment) {
        paymentsDao.save(payment);
    }

    public void updatePayment(Payments payment) {
        paymentsDao.update(payment);
    }

    public void deletePayment(Payments payment) {
        paymentsDao.delete(payment);
    }
}
