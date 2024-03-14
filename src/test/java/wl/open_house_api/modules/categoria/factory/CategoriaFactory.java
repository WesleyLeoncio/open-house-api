package wl.open_house_api.modules.categoria.factory;

import wl.open_house_api.modules.categoria.model.entiy.Categoria;
import wl.open_house_api.modules.categoria.model.enuns.Category;
import wl.open_house_api.modules.categoria.model.mapper.CategoriaMapper;
import wl.open_house_api.modules.categoria.model.request.CategoriaFilmeRequest;
import wl.open_house_api.modules.categoria.model.request.CategoriaRequest;
import wl.open_house_api.modules.categoria.model.request.CategoriaRequestCreat;
import wl.open_house_api.modules.categoria.model.response.CategoriaResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CategoriaFactory {

    private final UUID id;
    private final Category nome;

    public CategoriaFactory() {
        this.id = UUID.fromString("08925059-5275-4e50-a1ca-487988345ca2");
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
        return new CategoriaResponse(UUID.fromString("08925059-5275-4e50-a1ca-487988345ca2"), nome.toString());
    }

    public List<CategoriaFilmeRequest> getCategoriaFilme() {
        return CategoriaMapper.INSTANCE.categoriaToCategoriaFilmeRequest(this.categoriaList());
    }

    private List<Categoria> categoriaList() {
        Categoria categoria = new Categoria(UUID.fromString("08925059-5275-4e50-a1ca-487988345ca2"), Category.ACAO);
        List<Categoria> listCategoria = new ArrayList<>();
        listCategoria.add(categoria);
        return listCategoria;
    }

    public List<CategoriaResponse> categoriaResponseList() {
        CategoriaFactory categoriaFactory = new CategoriaFactory();
        List<CategoriaResponse> listCategoriasResponse = new ArrayList<>();
        listCategoriasResponse.add(categoriaFactory.getCategoriaResponse());
        return listCategoriasResponse;
    }


}
