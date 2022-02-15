package com.example.taskSpringBoot;

import java.util.Date;

public class SalesPeriodJDBC {
    private int id;
    private int price;
    private Date dateFrom;
    private Date dateTo;

    public SalesPeriodJDBC() {
    }

    public SalesPeriodJDBC(int id, int price, Date dateFrom, Date dateTo) {
        this.id = id;
        this.price = price;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    @Override
    public String toString() {
        return "SalesPeriodJDBC{" +
                "id=" + id +
                ", price=" + price +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                '}';
    }
}
