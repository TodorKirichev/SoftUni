package com.bonappetit.config;

import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.UUID;

@Getter
@Component
@SessionScope
public class UserSession {

    private UUID id;

    private String username;

    public void login(UUID id, String username) {
        this.id = id;
        this.username = username;
    }

    public boolean isLoggedIn() {
        return id != null;
    }

    public void logout() {
        this.id = null;
        this.username = null;
    }
}
