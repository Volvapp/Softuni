package org.modelmapperex.service;

import org.modelmapperex.service.dtos.UserLoginDto;
import org.modelmapperex.service.dtos.UserRegisterDto;

public interface UserService {
    String registerUser(UserRegisterDto userRegisterDto);

    String loginUser(UserLoginDto userLoginDto);

    String logout();
}
