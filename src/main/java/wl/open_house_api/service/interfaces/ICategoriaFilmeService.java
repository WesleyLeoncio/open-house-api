package wl.open_house_api.service.interfaces;

import wl.open_house_api.model.categoria_filme.request.CategoriaFilmeRequest;
import wl.open_house_api.model.categoria_filme.response.CategoriaFilmeResponse;

public interface ICategoriaFilmeService {

    CategoriaFilmeResponse adicionarCategoriaFilme(CategoriaFilmeRequest categoriaFilmeRequest);

    void removerCategoriaFilme(CategoriaFilmeRequest categoriaFilmeRequest);

}
