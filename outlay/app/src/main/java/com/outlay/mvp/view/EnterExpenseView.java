package com.outlay.mvp.view;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.outlay.domain.model.Category;
import com.outlay.domain.model.Expense;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by bmelnychuk on 10/25/16.
 */

public interface EnterExpenseView extends MvpView {
    void showCategories(List<Category> categoryList);
    void setAmount(BigDecimal amount);
    void alertExpenseSuccess(Expense expense);
}
