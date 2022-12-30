package com.learnbasicjava.controller;

import com.learnbasicjava.dao.CategoryDAO;
import com.learnbasicjava.entity.Category;
import com.learnbasicjava.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jpa")
public class DemoJPAController {
    @Autowired
    CategoryDAO cdao;

    @GetMapping("/find-all")
    public void findAll() {
        // get all category
        List<Category> list = cdao.findAll();
        list.forEach(c -> System.out.println(c.getId() + "--->" + c.getName()));
    }

    @RequestMapping("/get-by-id/{id}")
    public void getById(@PathVariable("id") Integer id) {
        Category c = cdao.getById(id);
        System.out.println(c.getId() + "--->" + c.getName());
        List<Product> list = c.getProducts();
        list.forEach(x -> {
            System.out.println(x.getId() + "--->" + x.getName());
        });
    }

    @RequestMapping("/create")
    public void create() {
        Category cate = new Category();
        cate.setName("Laptop New");

        Category c = cdao.save(cate);
        System.out.println(c.getId() + "--->" + c.getName());

    }

    @RequestMapping("/update")
    public void update() {
        Category cate = new Category();
        cate.setId(1009);
        cate.setName("Laptop Update");

        Category c = cdao.save(cate);
        System.out.println(c.getId() + "--->" + c.getName());

    }

    @RequestMapping("/delete")
    public void delete() {
        cdao.deleteById(1009);
    }
}
