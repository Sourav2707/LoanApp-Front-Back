package com.bridgelabz.finserve.entity;

import com.bridgelabz.finserve.dto.RegisterDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_reg")
public class User {

    // Now we made the fields unique
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bzlxmn_id;
    private String bzlxmn_userName;
    private String bzlxmn_phoneNo;
    private String bzlxmn_email;
    private String bzlxmn_password;

    public User(RegisterDTO registerDTO) {
        this.bzlxmn_userName = registerDTO.getUserName();
        this.bzlxmn_phoneNo = registerDTO.getPhoneNo();
        this.bzlxmn_email = registerDTO.getEmail();
    }
}
