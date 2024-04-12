package bg.softuni._23_mvc_demo.service.companies.dtos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class CompanyImportDTO {
    @XmlAttribute
    private String name;

    public CompanyImportDTO() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
