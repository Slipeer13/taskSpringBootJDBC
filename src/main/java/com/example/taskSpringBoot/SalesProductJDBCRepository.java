package com.example.taskSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SalesProductJDBCRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<SalesPeriodJDBC> findAll() {
        List<SalesPeriodJDBC> salesPeriodJDBCS = jdbcTemplate.query("select * from sales.sales_period", new BeanPropertyRowMapper<>(SalesPeriodJDBC.class));
        return salesPeriodJDBCS;
    }
    public List<SalesPeriodJDBC> findId(int id) {
        List<SalesPeriodJDBC> salesPeriodJDBCS = jdbcTemplate.query("select *from sales.sales_period where id=" + id, new BeanPropertyRowMapper<>(SalesPeriodJDBC.class));
        return salesPeriodJDBCS;
    }

    public Integer count() {
        List<SalesPeriodJDBC> salesPeriodJDBCS = jdbcTemplate.query("select * from sales.sales_period", new BeanPropertyRowMapper<>(SalesPeriodJDBC.class));

        return salesPeriodJDBCS.size();
    }

    public void save(String date_from, String date_to, int price) {
        jdbcTemplate.update(
                "INSERT INTO sales.sales_period (date_from, date_to, price) VALUES (?, ?, ?)", date_from, date_to, price);
    }

    public List<SalesPeriodJDBC> existByPrice() {
        List<SalesPeriodJDBC> salesPeriodJDBCS = jdbcTemplate.query("select * from sales.sales_period where price > 100", new BeanPropertyRowMapper<>(SalesPeriodJDBC.class));
        return salesPeriodJDBCS;
    }



}
