package com.bridgelabz.finserve.controller;

import com.bridgelabz.finserve.dto.LoginDTO;
import com.bridgelabz.finserve.dto.RegisterDTO;
import com.bridgelabz.finserve.dto.ResponseDTO;
import com.bridgelabz.finserve.entity.User;
import com.bridgelabz.finserve.service.IUserService;
import com.bridgelabz.finserve.utility.TokenUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService iUserService;
    @Autowired
    TokenUtility tokenUtility;

    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:4200", exposedHeaders = "Authorization")
    public ResponseEntity<String> registerUser(@RequestBody RegisterDTO registerDTO) {
       iUserService.registerUser(registerDTO);
//       String token = tokenUtility.generateToken(registerDTO.getUserName());
//       return ResponseEntity.status(HttpStatus.OK).header("Authorization", token).body("Registered Successfully and token is set in the header");
        return ResponseEntity.status(HttpStatus.OK).body("Registered Successfully and token is set in the header");
    }
    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200", exposedHeaders = "Authorization")
    public ResponseEntity<LoginDTO> loginUser(@RequestBody LoginDTO loginDTO) {
        String token = iUserService.loginUser(loginDTO);

        return ResponseEntity.status(HttpStatus.OK).header("Authorization", token).body(loginDTO);
    }
    @GetMapping("/otp")
    public String sendOtp(@RequestParam String email) {
        iUserService.otpViaEmail(email);
        return "SentEmail";
    }
    @GetMapping("/getAll")
    public List<User> getAllUser() {
        return iUserService.getAllUser();
    }
}
