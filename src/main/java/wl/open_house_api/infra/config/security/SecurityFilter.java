package wl.open_house_api.infra.config.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import wl.open_house_api.infra.exeptions.JWTException;
import wl.open_house_api.repository.UsuarioRepository;
import wl.open_house_api.service.TokenService;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {


    final TokenService tokenService;

    final UsuarioRepository repository;

    public SecurityFilter(TokenService tokenService, UsuarioRepository repository) {
        this.tokenService = tokenService;
        this.repository = repository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            var tokenJWT = recuperarToken(request);

            if (tokenJWT != null) {
                var subject = tokenService.getSubject(tokenJWT);
                var usuario = repository.findByLogin(subject);

                var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

            filterChain.doFilter(request, response);
        } catch (JWTException ex) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setCharacterEncoding("UTF-8");
            response.getWriter().println(ex.getLocalizedMessage());
        }
    }
    private String recuperarToken(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null) {
            return authorizationHeader.replace("Bearer ", "");
        }
        return null;
    }


}