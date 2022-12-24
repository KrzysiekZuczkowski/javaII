package com.crud.tasks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class StaticWebPageController {

    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        model.put("variable", "My Thymeleaf variable");
        model.put("one", 2);
        model.put("two", 2);
        model.put("multiply_values", model.get("one") + " * " + model.get("two"));
        model.put("equal", " = ");
        model.put("plus_value", " + " + model.get("one"));
        model.put("value_minus", model.get("one") + " - ");
        return "index";
    }
}
