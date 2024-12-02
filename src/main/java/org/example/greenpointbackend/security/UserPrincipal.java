package org.example.greenpointbackend.security;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.greenpointbackend.model.Enums.Title;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class UserPrincipal implements UserDetails {
    private int id;
    private String username;
    private String password;
    private Title title;
    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(int id,String username, String password, Title title, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.title = title;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }


    @Override
    public boolean isAccountNonExpired() { //TODO HVIS DER ER FEJL SÅ ÆNDRE DEM ALLE TIL TRUE
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