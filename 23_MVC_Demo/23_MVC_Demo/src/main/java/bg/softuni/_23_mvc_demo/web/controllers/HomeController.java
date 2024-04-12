package bg.softuni._23_mvc_demo.web.controllers;

import bg.softuni._23_mvc_demo.service.companies.CompaniesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CompaniesService companiesService;

    public HomeController(CompaniesService companiesService) {
        this.companiesService = companiesService;
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("areImported", this.companiesService.isImported());

        return "home";
    }
}
