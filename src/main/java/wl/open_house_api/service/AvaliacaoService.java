package wl.open_house_api.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wl.open_house_api.model.avaliacao.entity.AvaliacaoDeFilmes;
import wl.open_house_api.model.avaliacao.mapper.AvaliacaoMapper;
import wl.open_house_api.model.avaliacao.request.AvaliarFilmeRequest;
import wl.open_house_api.model.avaliacao.response.AvaliacaoDeFilmesResponse;
import wl.open_house_api.model.filme.entity.Filme;
import wl.open_house_api.model.usuario.entity.Usuario;
import wl.open_house_api.repository.AvaliacaoRepository;
import wl.open_house_api.service.interfaces.AvaliacaoMetodos;

@Service
public class AvaliacaoService implements AvaliacaoMetodos {

    final AvaliacaoRepository repository;

    final FilmeService filmeService;
    final UsuarioService usuarioService;

    public AvaliacaoService(AvaliacaoRepository repository, FilmeService filmeService, UsuarioService usuarioService) {
        this.repository = repository;
        this.filmeService = filmeService;
        this.usuarioService = usuarioService;
    }


    @Transactional
    public void avaliarFilme(AvaliarFilmeRequest avaliar){
        Filme filme = filmeService.verfificarFilme(avaliar.idFilme());
        Usuario usuario = usuarioService.verificarUser(avaliar.idUsuario());
        AvaliacaoDeFilmes avaliacao = new AvaliacaoDeFilmes(null, filme,usuario,avaliar.nota());
        repository.save(avaliacao);

    }
}
