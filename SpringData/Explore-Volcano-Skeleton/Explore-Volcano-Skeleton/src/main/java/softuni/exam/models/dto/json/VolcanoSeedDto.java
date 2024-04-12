package softuni.exam.models.dto.json;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import softuni.exam.models.entity.Country;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class VolcanoSeedDto implements Serializable {
    @Expose
    @Size(min = 2, max = 30)
    @NotNull
    private String name;
    @Expose
    @NotNull
    @Positive
    private int elevation;
    @Expose
    private String volcanoType;
    @Expose
    @NotNull
    private boolean isActive;
    @Expose
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date lastEruption;
    @Expose
    private long country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getElevation() {
        return elevation;
    }

    public void setElevation(int elevation) {
        this.elevation = elevation;
    }

    public String getVolcanoType() {
        return volcanoType;
    }

    public void setVolcanoType(String volcanoType) {
        this.volcanoType = volcanoType;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getLastEruption() {
        return lastEruption;
    }

    public void setLastEruption(Date lastEruption) {
        this.lastEruption = lastEruption;
    }

    public long getCountry() {
        return country;
    }

    public void setCountry(long country) {
        this.country = country;
    }
}
