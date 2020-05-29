package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CarsRepository carsRepository;

    @RequestMapping("/home")
    public String homePage(Model model){
        model.addAttribute("cars", carsRepository.findAll());
        return "homePage";
    }

    @RequestMapping("/addCategory")
    public String addCategory(Model model){
        model.addAttribute("addCategory", new Category());
        return "addCategory";
    }

    @PostMapping("/processAddCategory")
    public String processAddCategory(@ModelAttribute("addCategory") Category cate){
        categoryRepository.save(cate);
        return "redirect:/home";
    }

    @RequestMapping("/addCar")
    public String addCar(Model model){
        model.addAttribute("addCar", new Car());
        model.addAttribute("categoryList", categoryRepository.findAll());
        return "addCar";
    }

    @PostMapping("/processAddCar")
    public String processAddCar(@ModelAttribute("addCar") Car car){
        carsRepository.save(car);
        return "redirect:/home";
    }

    @RequestMapping("/listCar")
    public String listCar(Model model){
        model.addAttribute("listCar", carsRepository.findAll());
        return "listCar";
    }

    @RequestMapping("/carDetail/{id}")
    public String carDetail(@PathVariable("id") long id, Model model){
        model.addAttribute("carDetail", carsRepository.findById(id).get());
        return "carDetail";
    }

    @RequestMapping("/carUpdate/{id}")
    public String carUpdate(@PathVariable("id") long id, Model model){
        model.addAttribute("updateCar", carsRepository.findById(id).get());
        model.addAttribute("categoryList", categoryRepository.findAll());
        return "updateCar";
    }
    @PostMapping("/processUpdateCar")
    public String processUpdateCar(@ModelAttribute("addCar") Car car){
        carsRepository.save(car);
        return "redirect:/listCar";
    }

    @RequestMapping("/carDelete/{id}")
    public String carDelete(@PathVariable("id") long id){
        carsRepository.deleteById(id);
        return "redirect:/listCar";
    }

    @RequestMapping("/listCategory")
    public String listCategory(Model model){
        model.addAttribute("listCategory", categoryRepository.findAll());
        return "listCategory";
    }
    @RequestMapping("/updateCategory/{id}")
    public String updateCategory(@PathVariable("id") long id, Model model){
        model.addAttribute("updateCategory",categoryRepository.findById(id).get());
        return "updateCategory";
    }

    @PostMapping("/processUpdateCategory")
    public String processUpdateCategory(@ModelAttribute("addCategory") Category cate){
        categoryRepository.save(cate);
        return "redirect:/listCategory";
    }

    @RequestMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable("id") long id){
        categoryRepository.deleteById(id);
        return "redirect:/listCategory";
    }
}
