package com.outlay.domain.model;

import java.util.Date;

/**
 * Created by bmelnychuk on 10/24/16.
 */

public class ExpensePeriod {
    private Date startDate;
    private Date endDate;
    private String categoryId;

    public ExpensePeriod(Date startDate, Date endDate) {
        this(startDate, endDate, null);
    }

    public ExpensePeriod(Date startDate, Date endDate, String categoryId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.categoryId = categoryId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public ExpensePeriod setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public ExpensePeriod setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public ExpensePeriod setCategoryId(String categoryId) {
        this.categoryId = categoryId;
        return this;
    }
}
