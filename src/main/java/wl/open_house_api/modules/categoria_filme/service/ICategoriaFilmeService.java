package wl.open_house_api.modules.categoria_filme.service;

import wl.open_house_api.modules.categoria_filme.model.request.CategoriaFilmeRequest;
import wl.open_house_api.modules.categoria_filme.model.response.CategoriaFilmeResponse;

public interface ICategoriaFilmeService {

    CategoriaFilmeResponse adicionarCategoriaFilme(CategoriaFilmeRequest categoriaFilmeRequest);

    void removerCategoriaFilme(CategoriaFilmeRequest categoriaFilmeRequest);

}
