package org.mvc_demo.web;

import jakarta.xml.bind.JAXBException;
import org.mvc_demo.service.companies.CompaniesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Controller
public class ImportController {

    private CompaniesService companiesService;

    public ImportController(CompaniesService companiesService) {
        this.companiesService = companiesService;
    }

    @GetMapping("/import/xml")
    public String index(Model model) {
        model.addAttribute("areImported", new boolean[]{false, false, false});
        return "xml/import-xml";
    }

    @GetMapping("import/companies")
    public String importCompanies(Model model) throws IOException {

        Path path = Path.of("src", "main", "resources", "files", "xmls", "companies.xml");
        List<String> lines =
                Files.readAllLines(path);

        model.addAttribute("companies", String.join("\n", lines));

        return "xml/import-companies";
    }

    @PostMapping("/import/companies")
    public String doImportCompanies() throws JAXBException {
        companiesService.importCompanies();

        return "redirect:/import/xml";
    }
}
