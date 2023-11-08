package wl.open_house_api.modules.categoria_filme.factory;

import wl.open_house_api.modules.categoria.factory.CategoriaFactory;
import wl.open_house_api.modules.categoria.model.entiy.Categoria;
import wl.open_house_api.modules.categoria_filme.model.entity.CategoriaFilme;
import wl.open_house_api.modules.categoria_filme.model.entity.CategoriaFilmeId;
import wl.open_house_api.modules.categoria_filme.model.request.CategoriaFilmeRequest;
import wl.open_house_api.modules.categoria_filme.model.response.CategoriaFilmeResponse;
import wl.open_house_api.modules.filme.factory.FilmeFactory;
import wl.open_house_api.modules.filme.model.entity.Filme;

public class CategoriaFilmeFactory {

    private final Categoria categoria;
    private final Filme filme;
    private final CategoriaFactory categoriaFactory;
    private final FilmeFactory filmeFactory;


    public CategoriaFilmeFactory() {
        this.categoriaFactory = new CategoriaFactory();
        this.filmeFactory = new FilmeFactory();
        this.categoria = this.categoriaFactory.getCategoria();
        this.filme = this.filmeFactory.getFilme();
    }

    public CategoriaFilme getCategoriaFilme(){
        CategoriaFilmeId categoriaFilmeId = new
                CategoriaFilmeId(this.filme.getId(), categoria.getId());
        return new CategoriaFilme(categoriaFilmeId, this.filme, this.categoria);
    }

    public CategoriaFilmeResponse getCategoriaFilmeResponse(){
        return new CategoriaFilmeResponse
                (this.categoriaFactory.getCategoriaResponse(),filmeFactory.getFilmeResponseCategoriaFilme());
    }

    public CategoriaFilmeRequest getCategoriaFilmeRequest(){
        return new CategoriaFilmeRequest(1L, 1L);
    }
}
