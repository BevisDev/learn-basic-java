package com.learnbasicjava.controller;

import com.learnbasicjava.dao.AccountDAO;
import com.learnbasicjava.dao.ProductDAO;
import com.learnbasicjava.entity.Account;
import com.learnbasicjava.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/paginate")
public class PaginateAndSortController {

    @Autowired
    ProductDAO productDAO;

    @Autowired
    AccountDAO accountDAO;


    /**
     * JPA with sort param
     *
     * @param model
     * @return
     */
//    @GetMapping("/product/index")
//    public String sortIndex(Model model) {
//        Sort sort = Sort.by(Sort.Direction.DESC, "name");
//        List<Product> list = productDAO.findAll(sort);
//        model.addAttribute("list", list);
//        return "/paginate-and-sort/product/index";
//    }

    // ===================== MORE INFORMATION PAGNINATE ==========
    @RequestMapping({"/account/paginate", "/account/paginate/{n}"})
    public String paginate(Model model,
                           @PathVariable("n") Optional<Integer> numOpt) {
        Pageable pageable = PageRequest.of(numOpt.orElse(0), 5);
        Page<Account> page = accountDAO.findAll(pageable);
        model.addAttribute("page", page);
        return "/paginate-and-sort/account/paginate";
    }

    @RequestMapping({"/product/index", "/product/index/{n}"})
    public String index(Model model,
                        @PathVariable("n") Optional<Integer> n,
                        @RequestParam(value = "min", defaultValue = "0") Optional<Double> minOpt,
                        @RequestParam("max") Optional<Double> maxOpt) {
        double min = minOpt.orElse(Double.MIN_VALUE);
        double max = maxOpt.orElse(Double.MAX_VALUE);

        Pageable pageable = PageRequest.of(n.orElse(0), 5);
        Page<Product> page = productDAO.findAllByUnitPriceBetween(min, max, pageable);
        model.addAttribute("page", page);
        return "/paginate-and-sort/product/index";
    }

    // ===================== ADVANCED PAGINATE AND SORT ======================
    @RequestMapping("/account/index")
    public String index(Model model) {
        List<Account> list = accountDAO.findAll();
        model.addAttribute("items", list);
        return "/paginate-and-sort/account/index";
    }

    @RequestMapping({"/account/sort", "/account/sort/{property}/{direction}"})
    public String sort(Model model,
                       @PathVariable("property") Optional<String> proOpt,
                       @PathVariable("direction") Optional<Boolean> dirOpt) {
        // get sort default username when first time go /account/sort
        String pro = proOpt.orElse("username");
        // default true
        Boolean direction = dirOpt.orElse(true);
        Sort sort = Sort.by(direction ? Sort.Direction.ASC : Sort.Direction.DESC, pro);
        List<Account> list = accountDAO.findAll(sort);
        model.addAttribute("items", list);

        // return !dir if user want to click continues
        model.addAttribute("dir", !direction);
        return "/paginate-and-sort/account/sort";
    }

    // ============= Paginate and SORT same ==================

    @RequestMapping({"/account/paginate-with-sort",
            "/account/paginate-with-sort/{property}/{direction}/{n}"})
    public String paginate2(Model model,
                            @PathVariable("n") Optional<Integer> numOpt,
                            @PathVariable("property") Optional<String> proOpt,
                            @PathVariable("direction") Optional<Boolean> dirOpt) {
        String pro = proOpt.orElse("username");
        Boolean direction = dirOpt.orElse(true);
        Sort sort = Sort.by(direction ? Sort.Direction.ASC : Sort.Direction.DESC, pro);

        Pageable pageable = PageRequest.of(numOpt.orElse(0), 5, sort);
        Page<Account> page = accountDAO.findAll(pageable);
        model.addAttribute("property", pro);
        model.addAttribute("page", page);
        model.addAttribute("dir", direction);
        return "/paginate-and-sort/account/paginate-with-sort";
    }

}
