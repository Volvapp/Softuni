package bg.softuni._23_mvc_demo.web.controllers;

import bg.softuni._23_mvc_demo.service.companies.CompaniesService;
import bg.softuni._23_mvc_demo.service.employees.EmployeesService;
import bg.softuni._23_mvc_demo.service.projects.ProjectsService;
import jakarta.xml.bind.JAXBException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Controller
public class ImportController {

    private CompaniesService companiesService;
    private ProjectsService projectsService;
    private EmployeesService employeesService;

    public ImportController(CompaniesService companiesService, ProjectsService projectsService, EmployeesService employeesService) {
        this.companiesService = companiesService;
        this.projectsService = projectsService;
        this.employeesService = employeesService;
    }

    @GetMapping("/import/xml")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("xml/import-xml");
        modelAndView.addObject("areImported", new boolean[]{this.companiesService.isImported(),
                this.projectsService.isImported(),
                this.employeesService.isImported()});

        return modelAndView;
    }

    @GetMapping("/import/companies")
    public String importCompanies(Model model) throws IOException {
        String fileContents = getFileContents("companies.xml");

        model.addAttribute("companies", fileContents);

        return "xml/import-companies";
    }

    @PostMapping("/import/companies")
    public String doImportCompanies() throws JAXBException {
        companiesService.importCompanies();

        return "redirect:/import/xml";
    }

    @GetMapping("/import/projects")
    public String importProjects(Model model) throws IOException {
        String fileContents = getFileContents("projects.xml");

        model.addAttribute("projects", fileContents);

        return "xml/import-projects";
    }

    @PostMapping("import/projects")
    public String doImportProjects() throws JAXBException {
        projectsService.importProjects();

        return "redirect:/import/xml";
    }

    @GetMapping("/import/employees")
    public ModelAndView importEmployees() throws IOException {
        ModelAndView modelAndView = new ModelAndView("xml/import-employees");
        modelAndView.addObject("employees", getFileContents("employees.xml"));

        return modelAndView;
    }

    @PostMapping("/import/employees")
    public ModelAndView importEmployeesPost() throws JAXBException {
        ModelAndView modelAndView = new ModelAndView("redirect:/import/xml");

        this.employeesService.seedEmployees();

        return modelAndView;
    }

    private String getFileContents(String filename) throws IOException {
        Path path = Path.of("src", "main", "resources", "files", "xmls", filename);
        List<String> lines = Files.readAllLines(path);

        return String.join("\n", lines);
    }
}
