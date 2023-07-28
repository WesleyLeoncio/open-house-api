package wl.open_house_api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import wl.open_house_api.service.interfaces.ValidadorAvaliacaoDeFilme;

import java.util.List;

@Service
public class AvaliacaoService implements AvaliacaoMetodos {

    final AvaliacaoRepository repository;

    final FilmeService filmeService;

    final UsuarioService usuarioService;

    final List<ValidadorAvaliacaoDeFilme> validarAvaliacao;

    public AvaliacaoService(AvaliacaoRepository repository, FilmeService filmeService, UsuarioService usuarioService, List<ValidadorAvaliacaoDeFilme> validarAvaliacao) {
        this.repository = repository;
        this.filmeService = filmeService;
        this.usuarioService = usuarioService;
        this.validarAvaliacao = validarAvaliacao;
    }

    @Transactional
    public void avaliarFilme(AvaliarFilmeRequest avaliarFilme) {

        validarAvaliacao.forEach(v -> v.validar(avaliarFilme));

        realizarAvaliacao(avaliarFilme);
    }

    private void realizarAvaliacao(AvaliarFilmeRequest avaliarFilme) {
        Filme filme = filmeService.verfificarFilme(avaliarFilme.idFilme());
        Usuario usuario = usuarioService.verificarUser(avaliarFilme.idUsuario());

        AvaliacaoDeFilmes avaliacao = repository.findByFilmeIdAndUsuarioId(filme.getId(), usuario.getId());
        if (avaliacao != null) {
            avaliacao.setNota(avaliarFilme.nota());
            repository.save(avaliacao);
        } else {
            AvaliacaoDeFilmes newAvaliacao = new AvaliacaoDeFilmes(null, filme, usuario, avaliarFilme.nota());
            repository.save(newAvaliacao);
        }
    }


    public Page<AvaliacaoDeFilmesResponse> listarFilmesAvaliados(Pageable pageable) {
        return repository.findAll(pageable).map(AvaliacaoMapper.INSTANCE::avaliacaoFilmeToAavaliacaoFilmeResponse);
    }

    public Page<AvaliacaoDeFilmesResponse> listarFilmesAvaliadosPorUser(Pageable pageable, Long id) {
        return repository.findAllByUsuarioId(pageable,id).map(AvaliacaoMapper.INSTANCE::avaliacaoFilmeToAavaliacaoFilmeResponse);
    }


}
