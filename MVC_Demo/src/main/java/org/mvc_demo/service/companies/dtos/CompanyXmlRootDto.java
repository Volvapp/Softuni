package org.mvc_demo.service.companies.dtos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "companies")
@XmlAccessorType(XmlAccessType.FIELD)
public class CompanyXmlRootDto {
    @XmlElement(name = "company")
    private List<CompanyImportDto> companies;

    public CompanyXmlRootDto() {
    }

    public List<CompanyImportDto> getCompanies() {
        return companies;
    }

}
