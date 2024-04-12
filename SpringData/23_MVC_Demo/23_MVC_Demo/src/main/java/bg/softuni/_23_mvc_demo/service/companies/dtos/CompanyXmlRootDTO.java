package bg.softuni._23_mvc_demo.service.companies.dtos;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "companies")
public class CompanyXmlRootDTO {

    @XmlElement(name = "company")
    private List<CompanyImportDTO> companies;

    public CompanyXmlRootDTO() {}

    public List<CompanyImportDTO> getCompanies() {
        return companies;
    }
}
