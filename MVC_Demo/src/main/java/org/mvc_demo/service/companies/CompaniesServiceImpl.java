package org.mvc_demo.service.companies;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.mvc_demo.persistence.entities.Company;
import org.mvc_demo.persistence.repositories.CompaniesRepository;
import org.mvc_demo.service.companies.dtos.CompanyXmlRootDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class CompaniesServiceImpl implements CompaniesService {
    private CompaniesRepository companiesRepository;

    public CompaniesServiceImpl(CompaniesRepository companiesRepository) {
        this.companiesRepository = companiesRepository;
    }

    @Override
    public void importCompanies() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(CompanyXmlRootDto.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        CompanyXmlRootDto rootDto = (CompanyXmlRootDto) unmarshaller.unmarshal(
                new File("src/main/resources/files/xmls/companies.xml"));

        List<Company> companies = rootDto.getCompanies()
                .stream()
                .map(dto -> new Company(dto.getName()))
                .toList();

        companiesRepository.saveAll(companies);
    }
}
