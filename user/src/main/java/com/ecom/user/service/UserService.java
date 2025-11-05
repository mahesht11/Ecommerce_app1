package com.ecom.user.service;

import com.ecom.user.dto.UserRequest;
import com.ecom.user.dto.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    String createUser(UserRequest userRequest);

    List<UserResponse> fetchAllUsers();

    UserResponse getUser(Long id);

    boolean updateUser(Long id, UserRequest userRequest);
}
