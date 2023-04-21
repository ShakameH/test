package com.polytech.polywebproj.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Integer> {

    @Query(value = """
            select t from Token t inner join Account a\s
            on t.account.id = a.id\s
            where a.id = :accountId\s
            and (t.expired = false or t.revoked = false)\s
            """)
    List<Token> findAllValidTokensByAccount(Long accountId);

    Optional<Token> findByToken(String token);
}
