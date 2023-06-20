package dao.interfaces;

import models.Expenses;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ExpensesMapper {

    @Select("SELECT * FROM expenses")
    List<Expenses> getAllExpenses();

    @Select("SELECT * FROM expenses WHERE expense_id = #{id}")
    Expenses getExpenseById(int id);

    @Insert("INSERT INTO expenses (expense_id, project_id, amount, expense_date, description) VALUES (#{expenseId}, #{projectId}, #{amount}, #{expenseDate}, #{description})")
    void save(Expenses expense);

    @Update("UPDATE expenses SET project_id = #{projectId}, amount = #{amount}, expense_date = #{expenseDate}, description = #{description} WHERE expense_id = #{expenseId}")
    void update(Expenses expense);

    @Delete("DELETE FROM expenses WHERE expense_id = #{expenseId}")
    void delete(Expenses expense);
}
