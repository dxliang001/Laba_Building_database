package dao.interfaces;

import models.Expenses;
import java.util.List;

public interface ExpensesDAO {
    List<Expenses> getAllExpenses();
    Expenses getExpenseById(int id);
    void save(Expenses expense);
    void update(Expenses expense);
    void delete(Expenses expense);
}