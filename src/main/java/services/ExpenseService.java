package services;

import dao.interfaces.ExpensesMapper;
import models.Expenses;

import java.util.List;

public class ExpenseService {
    private ExpensesMapper expensesMapper;

    public ExpenseService(ExpensesMapper expensesMapper) {
        this.expensesMapper = expensesMapper;
    }

    public Expenses getExpenseById(int id) {
        return expensesMapper.getExpenseById(id);
    }

    public List<Expenses> getAllExpenses() {
        return expensesMapper.getAllExpenses();
    }

    public void saveExpense(Expenses expense) {
        expensesMapper.save(expense);
    }

    public void updateExpense(Expenses expense) {
        expensesMapper.update(expense);
    }

    public void deleteExpense(Expenses expense) {
        expensesMapper.delete(expense);
    }
}
