package br.com.syscomercial.appservico.seguranca;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import br.com.syscomercial.appservico.entities.Administrador;
import java.util.Collection;
import java.util.List;

public class AdministradorUserDetails implements UserDetails {

    private final Administrador administrador;

    public AdministradorUserDetails(Administrador administrator){
        this.administrador = administrator;
    }

    @Override
    public String getPassword() {
        return this.administrador.getSenha();
    }

    @Override
    public String getUsername() {
        return this.administrador.getNome();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> "write");
    }

}
