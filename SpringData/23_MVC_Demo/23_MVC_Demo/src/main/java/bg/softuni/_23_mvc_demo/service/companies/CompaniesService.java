package bg.softuni._23_mvc_demo.service.companies;

import jakarta.xml.bind.JAXBException;

public interface CompaniesService {
    void importCompanies() throws JAXBException;

    boolean isImported();
}
