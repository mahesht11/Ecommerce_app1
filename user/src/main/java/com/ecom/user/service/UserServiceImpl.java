package com.ecom.user.service;

import com.ecom.user.dto.AddressDto;
import com.ecom.user.dto.UserRequest;
import com.ecom.user.dto.UserResponse;
import com.ecom.user.entity.Address;
import com.ecom.user.entity.User;
import com.ecom.user.entity.UserRole;
import com.ecom.user.repository.UserRepository;
import com.ecom.user.util.DtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public String  createUser(UserRequest userRequest) {
        User user = new User();
        if(userRequest.getAddress() != null) {
            Address address = new Address();
            address.setId(userRequest.getAddress().getUserId());
            address.setCity(userRequest.getAddress().getCity());
            address.setCountry(userRequest.getAddress().getCountry());
            address.setStreet(userRequest.getAddress().getStreet());
            address.setState(userRequest.getAddress().getState());
            address.setZipcode(userRequest.getAddress().getZipcode());
            user.setAddress(address);
        }

        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setPhone(userRequest.getPhone());
        user.setEmail(userRequest.getEmail());
        user.setRole(UserRole.CUSTOMER);
        User user1 =  userRepository.save(user);
        if(user1 == null){
            return "User created successfully!";
        }else{
            return "User not created successfully! Please try again";
        }

    }

    @Override
    public List<UserResponse> fetchAllUsers() {
        List<User> list =  userRepository.findAll();
        List<UserResponse> userResponseList = list.stream().map(DtoMapper::mapToUserResponse).toList();
        return userResponseList;
    }

    @Override
    public UserResponse getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
        return DtoMapper.mapToUserResponse(user);
    }

    @Override
    public boolean updateUser(Long id, UserRequest userRequest) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    updateUserFromRequest(existingUser, userRequest);
                    userRepository.save(existingUser);
                    return true;
                }).orElse(false);
    }

    private void updateUserFromRequest(User user, UserRequest userRequest) {
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPhone(userRequest.getPhone());
        if (userRequest.getAddress() != null) {
            Address address = new Address();
            address.setStreet(userRequest.getAddress().getStreet());
            address.setState(userRequest.getAddress().getState());
            address.setZipcode(userRequest.getAddress().getZipcode());
            address.setCity(userRequest.getAddress().getCity());
            address.setCountry(userRequest.getAddress().getCountry());
            user.setAddress(address);
        }
    }
}
