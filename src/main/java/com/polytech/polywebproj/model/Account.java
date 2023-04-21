package com.polytech.polywebproj.model;

import com.polytech.polywebproj.token.Token;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_Accounts")
public class Account implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_account_identifier", nullable = false)
    private Long id_accountIdentifier;

    @Column(name = "accountLogin")
    private String accountLogin;

    @Column(name = "accountPassword")
    private String accountPassword;

    @Column(name = "signupDate")
    private Date signupDate;

    @Column(name = "accountType")
    private int accountType;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "account")
    private List<Token> tokens;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return accountPassword;
    }

    @Override
    public String getUsername() {
        return accountLogin;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
