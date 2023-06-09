package com.polytech.polywebproj.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String accountLogin;

    private String accountPassword;

    private Date signupDate;

    private int accountType;

}
