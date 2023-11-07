package wl.open_house_api.modules.categoria_filme.factory;

import wl.open_house_api.modules.categoria.factory.CategoriaFactory;
import wl.open_house_api.modules.categoria.model.entiy.Categoria;
import wl.open_house_api.modules.categoria_filme.model.entity.CategoriaFilme;
import wl.open_house_api.modules.categoria_filme.model.entity.CategoriaFilmeId;
import wl.open_house_api.modules.filme.factory.FilmeFactory;
import wl.open_house_api.modules.filme.model.entity.Filme;

public class CategoriaFilmeFactory {

    private final Categoria categoria;
    private final Filme filme;

    public CategoriaFilmeFactory() {
        CategoriaFactory categoriaFactory = new CategoriaFactory();
        FilmeFactory filmeFactory = new FilmeFactory();
        this.categoria = categoriaFactory.getCategoria();
        this.filme = filmeFactory.getFilme();
    }

    public CategoriaFilme getCategoriaFilme(){
        CategoriaFilmeId categoriaFilmeId = new
                CategoriaFilmeId(this.filme.getId(), categoria.getId());
        return new CategoriaFilme(categoriaFilmeId, this.filme, this.categoria);
    }
}
