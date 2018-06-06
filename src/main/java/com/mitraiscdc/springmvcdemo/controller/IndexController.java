package com.mitraiscdc.springmvcdemo.controller;

import com.mitraiscdc.springmvcdemo.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    @Autowired
    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "index"})
    public String getIndex(Model model) {
        model.addAttribute("recipes", recipeService.getAllRecipe());
        return "index";
    }
}
