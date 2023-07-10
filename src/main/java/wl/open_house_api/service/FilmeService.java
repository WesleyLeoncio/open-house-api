package wl.open_house_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wl.open_house_api.model.filme.entity.Filme;
import wl.open_house_api.model.filme.request.FilmeRequest;
import wl.open_house_api.model.filme.response.FilmeResponse;
import wl.open_house_api.repository.FilmeRepository;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository repository;

    public FilmeResponse cadastrar(FilmeRequest filmeRequest){
        Filme filme = repository.save(new Filme(filmeRequest));
        return new FilmeResponse(filme);
    }
}
