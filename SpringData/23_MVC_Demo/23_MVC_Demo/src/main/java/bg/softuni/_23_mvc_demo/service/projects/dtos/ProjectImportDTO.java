package bg.softuni._23_mvc_demo.service.projects.dtos;

import bg.softuni._23_mvc_demo.service.companies.dtos.CompanyImportDTO;
import bg.softuni._23_mvc_demo.util.xml.LocalDateAdapter;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.math.BigDecimal;
import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
public class ProjectImportDTO {

    @XmlElement
    private String name;

    @XmlElement
    private String description;

    @XmlElement(name = "start-date")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate startDate;

    @XmlElement(name = "is-finished")
    private boolean isFinished;

    private BigDecimal payment;

    @XmlElement
    private CompanyImportDTO company;

    public ProjectImportDTO() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public CompanyImportDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyImportDTO company) {
        this.company = company;
    }
}
