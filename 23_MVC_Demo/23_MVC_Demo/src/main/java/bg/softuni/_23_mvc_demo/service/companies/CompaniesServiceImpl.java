package bg.softuni._23_mvc_demo.service.companies;

import bg.softuni._23_mvc_demo.persistence.entities.Company;
import bg.softuni._23_mvc_demo.persistence.repositories.CompaniesRepository;
import bg.softuni._23_mvc_demo.service.companies.dtos.CompanyXmlRootDTO;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
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
        JAXBContext context = JAXBContext.newInstance(CompanyXmlRootDTO.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        CompanyXmlRootDTO rootDTO = (CompanyXmlRootDTO) unmarshaller.unmarshal(
                new File("src/main/resources/files/xmls/companies.xml"));

        List<Company> companies = rootDTO.getCompanies()
                .stream()
                .map(dto -> new Company(dto.getName()))
                .toList();

        companiesRepository.saveAll(companies);
    }

    @Override
    public boolean isImported() {
        return this.companiesRepository.count() > 0;
    }
}
