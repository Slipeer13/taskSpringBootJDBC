package com.example.taskSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired
    private SalesProductJDBCRepository salesProductJDBCRepository;

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<SalesPeriodJDBC> getAllSales() {

        return salesProductJDBCRepository.findAll();
    }
    @GetMapping(path="/count")
    public @ResponseBody
    Integer getAllSalesCount() {
        return salesProductJDBCRepository.count();
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody
    List<SalesPeriodJDBC> getAllSalesFromId(@PathVariable("id") int id) {
        return salesProductJDBCRepository.findId(id);
    }
    @GetMapping(value = "/insert/{date_from}/{date_to}/{price}")
    public @ResponseBody
    void setSales(@PathVariable("date_from") String date_from, @PathVariable("date_to") String date_to, @PathVariable("price") int price) {
        salesProductJDBCRepository.save(date_from, date_to, price);
    }

    @GetMapping(path="/exist/price")
    public @ResponseBody
    boolean existByPrice() {
        return (salesProductJDBCRepository.existByPrice().size() > 0);
    }
}
