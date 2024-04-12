package org.modelmapperex.service.impl;

import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.modelmapperex.data.entities.User;
import org.modelmapperex.data.repositories.UserRepository;
import org.modelmapperex.service.UserService;
import org.modelmapperex.service.dtos.UserLoginDto;
import org.modelmapperex.service.dtos.UserRegisterDto;
import org.modelmapperex.util.ValidatorService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private User loggedIn;
    private final ModelMapper mapper;
    private final UserRepository userRepository;
    private final ValidatorService validatorService;

    public UserServiceImpl(ModelMapper mapper, UserRepository userRepository, ValidatorService validatorService) {
        this.mapper = mapper;
        this.userRepository = userRepository;
        this.validatorService = validatorService;
    }

    @Override
    public String registerUser(UserRegisterDto userRegisterDto) {
        if (!this.validatorService.isValid(userRegisterDto)) {
            Set<ConstraintViolation<UserRegisterDto>> set = this.validatorService.validate(userRegisterDto);
            return set.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining("\n"));
        }


        if (!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())) {
            return "Passwords don't match.";
        }
        Optional<User> userByEmail = this.userRepository.findUserByEmail(userRegisterDto.getEmail());

        if (userByEmail.isPresent()) {
            return "User with that email already exists.";
        }
        User user = this.mapper.map(userRegisterDto, User.class);
        if (this.userRepository.count() == 0) {
            user.setAdmin(true);
        }
        this.userRepository.saveAndFlush(user);
        return String.format("%s was registered.", user.getFullName());
    }

    @Override
    public String loginUser(UserLoginDto userLoginDto) {
        Optional<User> optional = this.userRepository.findByEmailAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword());

        if (optional.isEmpty()){
            return "Email or password is incorrect.";
        }
        setLoggedIn(optional.get());

        return String.format("Successfully logged in %s", optional.get().getFullName());
    }

    @Override
    public String logout() {
        if (this.loggedIn == null){
            return "Cannot logout. No user was logged in.";
        }
        String format = String.format("User %s successfully logged out", this.loggedIn.getFullName());
        setLoggedIn(null);
        return format;
    }

    public void setLoggedIn(User loggedIn) {
        this.loggedIn = loggedIn;
    }
}
