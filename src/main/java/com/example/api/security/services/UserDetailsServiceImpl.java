package com.example.api.security.services;

import com.example.api.persistance.entities.User;
import com.example.api.security.entities.UseDetailsImpl;
import com.example.api.services.IUserRoleService;
import com.example.api.services.IUserService;
import com.example.api.web.dtos.responses.GetRoleResponse;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final IUserService userService;
    private final IUserRoleService userRoleService;

    public UserDetailsServiceImpl(IUserService userService, IUserRoleService userRoleService) {
        this.userService = userService;
        this.userRoleService = userRoleService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByEmail(username);
        List<GetRoleResponse> roles = userRoleService.getRolesByUserId(user.getId());

        return new UseDetailsImpl(user, getAuthorities(roles));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Collection<GetRoleResponse> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
