package softuni.exam.models.dto.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "volcanologists")
@XmlAccessorType(XmlAccessType.FIELD)
public class VolkanologistRootDto {
    @XmlElement(name = "volcanologist")
    private List<VolkanologistSeedDto> volkanologistSeedDtoList;

    public List<VolkanologistSeedDto> getVolkanologistSeedDtoList() {
        return volkanologistSeedDtoList;
    }

    public void setVolkanologistSeedDtoList(List<VolkanologistSeedDto> volkanologistSeedDtoList) {
        this.volkanologistSeedDtoList = volkanologistSeedDtoList;
    }
}
