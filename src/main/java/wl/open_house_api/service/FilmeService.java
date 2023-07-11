package wl.open_house_api.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import wl.open_house_api.infra.exeptions.ValidacaoExeption;
import wl.open_house_api.model.filme.entity.Filme;
import wl.open_house_api.model.filme.request.FilmeRequest;
import wl.open_house_api.model.filme.response.FilmeListResponse;
import wl.open_house_api.model.filme.response.FilmeResponse;
import wl.open_house_api.repository.FilmeRepository;

@Service
public class FilmeService implements FilmeServiceCrud{

    private final FilmeRepository repository;

    public FilmeService(FilmeRepository repository) {
        this.repository = repository;
    }

    @Override
    public FilmeResponse insert(FilmeRequest filmeRequest){
        try {
            Filme filme = repository.save(new Filme(filmeRequest));
            return new FilmeResponse(filme);
        }catch (DataIntegrityViolationException e){
            throw new ValidacaoExeption("Erro ao cadastrar filme verifique os dados!");
        }
    }

    @Override
    public FilmeResponse update(FilmeRequest filmeRequest) {
        return null;
    }

    @Override
    public Page<FilmeListResponse> findMovies(Pageable pageable) {
        return null;
    }

    @Override
    public FilmeResponse findMovie(Long id) {
        return null;
    }

    @Override
    public void deleteMovie(Long id) {
        //deletar filme
    }


}
