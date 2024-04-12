package org.productshopex.service.dtos;

import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductSeedDto implements Serializable {
    @Expose
    @NotNull
    @Min(3)
    private String name;
    @Expose
    @NotNull
    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
