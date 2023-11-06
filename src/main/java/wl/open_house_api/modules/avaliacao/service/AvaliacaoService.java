package wl.open_house_api.modules.avaliacao.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wl.open_house_api.modules.filme.service.IFilmeService;
import wl.open_house_api.modules.avaliacao.model.entity.AvaliacaoDeFilmes;
import wl.open_house_api.modules.avaliacao.model.mapper.AvaliacaoMapper;
import wl.open_house_api.modules.avaliacao.model.request.AvaliarFilmeRequest;
import wl.open_house_api.modules.avaliacao.model.response.AvaliacaoDeFilmesResponse;
import wl.open_house_api.modules.filme.model.entity.Filme;
import wl.open_house_api.modules.usuario.model.entity.Usuario;
import wl.open_house_api.modules.avaliacao.repository.AvaliacaoRepository;
import wl.open_house_api.modules.usuario.service.IUsuarioService;
import wl.open_house_api.validation.interfaces.IValidadorAvaliacaoDeFilme;

import java.util.List;

@Service
public class AvaliacaoService implements IAvaliacaoService {

    final AvaliacaoRepository repository;

    final IFilmeService filmeService;

    final IUsuarioService usuarioService;

    final List<IValidadorAvaliacaoDeFilme> validarAvaliacao;

    public AvaliacaoService(AvaliacaoRepository repository, IFilmeService filmeService, IUsuarioService usuarioService, List<IValidadorAvaliacaoDeFilme> validarAvaliacao) {
        this.repository = repository;
        this.filmeService = filmeService;
        this.usuarioService = usuarioService;
        this.validarAvaliacao = validarAvaliacao;
    }
    @Override
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

    @Override
    public Page<AvaliacaoDeFilmesResponse> listarFilmesAvaliados(Pageable pageable) {
        return repository.findAll(pageable).map(AvaliacaoMapper.INSTANCE::avaliacaoFilmeToAavaliacaoFilmeResponse);
    }

    @Override
    public Page<AvaliacaoDeFilmesResponse> listarFilmesAvaliadosPorUser(Pageable pageable, Long id) {
        return repository.findAllByUsuarioId(pageable,id).map(AvaliacaoMapper.INSTANCE::avaliacaoFilmeToAavaliacaoFilmeResponse);
    }


}