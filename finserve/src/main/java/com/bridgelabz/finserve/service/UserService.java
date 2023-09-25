package com.bridgelabz.finserve.service;

import com.bridgelabz.finserve.config.SecurityConfig;
import com.bridgelabz.finserve.dto.LoginDTO;
import com.bridgelabz.finserve.dto.RegisterDTO;
import com.bridgelabz.finserve.dto.ResponseDTO;
import com.bridgelabz.finserve.entity.User;
import com.bridgelabz.finserve.repository.UserRepository;
import com.bridgelabz.finserve.utility.TokenUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    TokenUtility tokenUtility;
    @Autowired
    JavaMailSender mailSender;
    @Override
    public void registerUser(RegisterDTO registerDTO) {
            User user = new User(registerDTO);
            user.setBzlxmn_password(passwordEncoder.encode(registerDTO.getPassword()));
            userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public String loginUser(LoginDTO loginDTO) {
        User userByEmail = userRepository.findAllByEmail(loginDTO.getEmail());
//        if(loginDTO.getEmail().equals(userByEmail.getBzlxmn_email()) && loginDTO.getPassword().equals(userByEmail.getBzlxmn_password())) {
//            String token = tokenUtility.generateToken(userByEmail.getBzlxmn_id());
//            String value = "Login Success";
//            ResponseDTO loginResponse = new ResponseDTO(value, token);
//            return loginResponse;
//        }
//        else {
//            String value = "Login failed, check email/password";
//            String token = null;
//            ResponseDTO loginFail = new ResponseDTO(value, token);
//            return loginFail;
//        }
        return tokenUtility.generateToken(userByEmail.getBzlxmn_id());
    }

    @Override
    public String generateOtp() {
        int otp = (int) (Math.random() * 900000) + 100000;
        return String.valueOf(otp);
    }

    @Override
    public void otpViaEmail(String toEmail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("OTP from Bridgelabz Finserve Ltd");
        message.setText("Your OTP code is "+generateOtp());
        mailSender.send(message);
    }


}
