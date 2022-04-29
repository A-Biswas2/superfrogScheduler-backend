package edu.tcu.cs.superfrogscheduler.domain;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserPrincipal implements UserDetails {
    private Client client;
    private List<GrantedAuthority> authorities;

    public MyUserPrincipal(Client client) {
        this.client = client;

        // Convert a user's roles from space-delimited string to a list of SimpleGrantedAuthority objects
        // E.g., john's roles are stored in a string like "admin user moderator", we need to convert it to a list of GrantedAuthority
        this.authorities = Arrays.stream(StringUtils.tokenizeToStringArray(client.getRoles(), " "))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    public MyUserPrincipal(Client client, Collection<? extends GrantedAuthority> authorities) {
        this.client = client;
        this.authorities = (List<GrantedAuthority>) authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return client.getPassword();
    }

    @Override
    public String getUsername() {
        return client.getUsername();
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
        return client.isEnabled();
    }

    public Client getClient() {
        return client;
    }
}
