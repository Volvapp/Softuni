package org.bookshopsystemspring.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.bookshopsystemspring.data.entities.base.BaseEntity;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    @Column(nullable = false)
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
