package wl.open_house_api.validation.validacao;


import org.springframework.stereotype.Service;
import wl.open_house_api.infra.exeptions.ValidacaoException;
import wl.open_house_api.modules.avaliacao.model.request.AvaliarFilmeRequest;
import wl.open_house_api.modules.usuario.service.UsuarioService;
import wl.open_house_api.validation.interfaces.IValidadorAvaliacaoDeFilme;

@Service
public class ValidadorUsuariosDesativados implements IValidadorAvaliacaoDeFilme {

    private final UsuarioService service;

    public ValidadorUsuariosDesativados(UsuarioService service) {
        this.service = service;
    }

    @Override
    public void validar(AvaliarFilmeRequest avaliar) {
        Boolean usuarioAtivo = service.usuarioAtivo(avaliar.idUsuario());
        if(Boolean.FALSE.equals(usuarioAtivo)){
            throw new ValidacaoException("Usuarios Que Não Estão Ativos Não Podem Avaliar Filmes!");
        }
    }
}
