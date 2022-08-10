package com.sof306.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sof306.assignment.entity.Product;
import com.sof306.assignment.service.ProductService;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping("product/list")
    public String list(Model model, @RequestParam(value = "cid", required = false) Optional<String> cid) {
        if (cid.isPresent()) {
            List<Product> list = productService.findCategoryId(cid.get());
            model.addAttribute("items", list);
        } else {
            List<Product> list = productService.findAll();
            model.addAttribute("items", list);
        }
        return "product/list";
    }

    @RequestMapping("product/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Product item = productService.findById(id);
        model.addAttribute("item", item);
        return "product/detail";
    }
}
