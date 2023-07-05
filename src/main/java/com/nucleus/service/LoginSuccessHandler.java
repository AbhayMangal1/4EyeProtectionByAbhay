package com.nucleus.service;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;


@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest arg0, HttpServletResponse arg1, Authentication authentication)
            throws IOException, ServletException {

        RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

// redirectStrategy.sendRedirect(arg0, arg1, "/customerHome");


        authorities.forEach(authority -> {
            if (authority.getAuthority().equals("ROLE_MAKER")) {
                try {
                    redirectStrategy.sendRedirect(arg0, arg1, "/maker/showForm");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (authority.getAuthority().equals("ROLE_CHECKER")) {
                try {
                    redirectStrategy.sendRedirect(arg0, arg1, "/checker/showFormChecker");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                throw new IllegalStateException();
            }
        });
    }
}