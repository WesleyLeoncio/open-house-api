package wl.open_house_api.modules.autenticacao.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wl.open_house_api.modules.usuario.repository.IUsuarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService {

    final IUsuarioRepository repository;

    public AutenticacaoService(IUsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByLogin(username);
    }
}
