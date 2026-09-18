package com.srfzz.tickets.filters;

import com.srfzz.tickets.domain.entities.User;
import com.srfzz.tickets.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserProvisioningFilter extends OncePerRequestFilter {
    private final UserRepository userRepository;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //Todo

        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        log.info("Authetication Details {}",authentication);
        if(authentication != null && authentication.isAuthenticated() && authentication.getPrincipal() instanceof Jwt jwt)
        {
            UUID keyCloakId= UUID.fromString(jwt.getSubject());
log.info("{}",jwt);
            if(!userRepository.existsById(keyCloakId))
            {
                User user = new User();
                user.setId(keyCloakId);
                user.setName(jwt.getClaimAsString("preferred_username"));
                user.setEmail(jwt.getClaimAsString("email"));
                userRepository.save(user);
            }
            filterChain.doFilter(request,response);
        }
    }
}
