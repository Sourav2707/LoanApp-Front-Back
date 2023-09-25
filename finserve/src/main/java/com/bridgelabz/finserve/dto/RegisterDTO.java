package com.bridgelabz.finserve.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
    private String userName;
    private String phoneNo;
    private String email;
    private String password;
}
