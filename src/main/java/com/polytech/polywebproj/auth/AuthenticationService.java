package com.polytech.polywebproj.auth;

import com.polytech.polywebproj.config.JwtService;
import com.polytech.polywebproj.model.Account;
import com.polytech.polywebproj.model.Role;
import com.polytech.polywebproj.repository.AccountRepository;
import com.polytech.polywebproj.token.Token;
import com.polytech.polywebproj.token.TokenRepository;
import com.polytech.polywebproj.token.TokenType;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AccountRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var account = Account.builder()
                .accountLogin(request.getAccountLogin())
                .accountType(request.getAccountType())
                .signupDate(request.getSignupDate())
                .accountPassword(passwordEncoder.encode(request.getAccountPassword()))
                .role(Role.USER)
                .build();
        var savedAccount = repository.save(account);
        var jwtToken = jwtService.generateToken(account);
        saveAccountToken(savedAccount, jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    private void revokeAllAccountsTokens(Account account) {
        var validAccountToken = tokenRepository.findAllValidTokensByAccount(account.getId_accountIdentifier());
        if (validAccountToken.isEmpty())
            return;
        validAccountToken.forEach(t -> {
            t.setExpired(true);
            t.setRevoked(true);
        });
        tokenRepository.saveAll(validAccountToken);
    }

    private void saveAccountToken(Account account, String jwtToken) {
        var token = Token.builder()
                .account(account)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .revoked(false)
                .expired(false)
                .build();
        tokenRepository.save(token);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getAccountLogin(),
                        request.getAccountPassword()
                )
        );
        var account = repository.findByaccountLogin(request.getAccountLogin())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(account);
        revokeAllAccountsTokens(account);
        saveAccountToken(account, jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
