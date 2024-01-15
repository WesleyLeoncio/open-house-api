package wl.open_house_api.modules.categoria.factory;

import wl.open_house_api.modules.categoria.model.entiy.Categoria;
import wl.open_house_api.modules.categoria.model.enuns.Category;
import wl.open_house_api.modules.categoria.model.request.CategoriaRequest;
import wl.open_house_api.modules.categoria.model.request.CategoriaRequestCreat;
import wl.open_house_api.modules.categoria.model.response.CategoriaResponse;

public class CategoriaFactory {

    private final Long id;
    private final Category nome;

    public CategoriaFactory() {
        this.id = 1L;
        this.nome = Category.ACAO;
    }

    public Categoria getCategoria() {
        return new Categoria(this.id, this.nome);
    }

    public CategoriaRequestCreat getCategoriaRequestCreat() {
        return new CategoriaRequestCreat(nome);
    }

    public CategoriaRequest getCategoriaRequest() {
        return new CategoriaRequest(nome);
    }


    public CategoriaResponse getCategoriaResponse() {
        return new CategoriaResponse(1L, nome.toString());
    }
}
