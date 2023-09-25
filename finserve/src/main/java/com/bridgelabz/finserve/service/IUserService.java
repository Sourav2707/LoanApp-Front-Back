package com.bridgelabz.finserve.service;

import com.bridgelabz.finserve.dto.LoginDTO;
import com.bridgelabz.finserve.dto.RegisterDTO;
import com.bridgelabz.finserve.dto.ResponseDTO;
import com.bridgelabz.finserve.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {
    void registerUser(RegisterDTO registerDTO);
    List<User> getAllUser();
    String loginUser(LoginDTO loginDTO);
    String generateOtp();
    void otpViaEmail(String toEmail);
}
