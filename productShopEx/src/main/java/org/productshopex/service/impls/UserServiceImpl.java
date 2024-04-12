package org.productshopex.service.impls;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.productshopex.data.entities.User;
import org.productshopex.data.repositories.UserRepository;
import org.productshopex.service.UserService;
import org.productshopex.service.dtos.UserSeedDto;
import org.productshopex.service.dtos.UserSoldProductsDto;
import org.productshopex.util.ValidationUtil;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private static final String FILE_PATH = "src/main/resources/json/users.json";

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public void seedUsers() throws FileNotFoundException {
        if (this.userRepository.count() == 0){
            UserSeedDto[] userSeedDtos = this.gson.fromJson(new FileReader(FILE_PATH), UserSeedDto[].class);
            for (UserSeedDto userSeedDto : userSeedDtos) {
                if (!this.validationUtil.isValid(userSeedDto)){
                    this.validationUtil.getViolations(userSeedDto)
                            .forEach(v -> System.out.println(v.getMessage()));
                    continue;
                }

                this.userRepository.saveAndFlush(this.modelMapper.map(userSeedDto, User.class));
            }
        }
    }

    @Override
    public List<UserSoldProductsDto> getALlProductsAndSoldItems() {
        Set<User> allBySoldBuyerIsNotNull = this.userRepository.findAllBySoldBuyerIsNotNull();
        return null;
    }
}
