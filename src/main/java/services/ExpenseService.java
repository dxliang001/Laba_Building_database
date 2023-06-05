package services;

import dao.interfaces.ExpensesDAO;
import models.Expenses;

import java.util.List;

public class ExpenseService {
    private ExpensesDAO expensesDAO;

    public ExpenseService(ExpensesDAO departmentsDao) {
        this.expensesDAO = departmentsDao;
    }

    public Expenses getExpensesById(int id) {
        return expensesDAO.getExpenseById(id);
    }

    public List<Expenses> getAllExpenses() {
        return expensesDAO.getAllExpenses();
    }

    public void saveDepartment(Expenses expense) {
        expensesDAO.save(expense);
    }

    public void updateDepartment(Expenses expense) {
        expensesDAO.update(expense);
    }

    public void deleteDepartment(Expenses expense) {
        expensesDAO.delete(expense);
    }
}