package org.productshopex.service;

import org.productshopex.service.dtos.UserSoldProductsDto;

import java.io.FileNotFoundException;
import java.util.List;

public interface UserService {
    void seedUsers() throws FileNotFoundException;

    List<UserSoldProductsDto> getALlProductsAndSoldItems();
}
