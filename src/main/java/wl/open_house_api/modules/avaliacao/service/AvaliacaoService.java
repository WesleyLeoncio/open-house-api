package wl.open_house_api.modules.avaliacao.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wl.open_house_api.modules.avaliacao.model.entity.AvaliacaoId;
import wl.open_house_api.modules.avaliacao.model.response.AvaliacaoDeFilmesNotaResponse;
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
import java.util.UUID;

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

        AvaliacaoId avaliacaoId = new AvaliacaoId(filme.getId(), usuario.getId());


        AvaliacaoDeFilmes newAvaliacao = new AvaliacaoDeFilmes(avaliacaoId, filme, usuario, avaliarFilme.nota());
        repository.save(newAvaliacao);

    }

    @Override
    public Page<AvaliacaoDeFilmesResponse> listarFilmesAvaliados(Pageable pageable) {
        return repository.findAllAvalicoes(pageable).map(AvaliacaoMapper.INSTANCE::avaliacaoFilmeToAvaliacaoFilmeResponse);
    }

    @Override
    public Page<AvaliacaoDeFilmesResponse> listarFilmesAvaliadosPorUser(Pageable pageable, UUID id) {
        return repository.findAllByUsuarioId(pageable, id).map(AvaliacaoMapper.INSTANCE::avaliacaoFilmeToAvaliacaoFilmeResponse);
    }

    @Override
    public AvaliacaoDeFilmesResponse listaAvaliacaoPorFilmeIdUserId(Long filmeId, UUID usuarioId) {
        AvaliacaoDeFilmes avaliacao = repository.getReferenceById(new AvaliacaoId(filmeId, usuarioId));
        return AvaliacaoMapper.INSTANCE.avaliacaoFilmeToAvaliacaoFilmeResponse(avaliacao);
    }

    @Override
    public AvaliacaoDeFilmesNotaResponse notaFilme(Long filmeId, UUID usuarioId) {
        Integer nota = repository.findNotaByFilmeIdAndUsuarioId(filmeId, usuarioId);
        return AvaliacaoMapper.INSTANCE.integerNotaToAvaliacaoDeFilmesNotaResponse(nota);
    }


}
