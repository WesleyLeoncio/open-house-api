package wl.open_house_api.modules.avaliacao.factory;


import wl.open_house_api.modules.avaliacao.model.entity.AvaliacaoDeFilmes;
import wl.open_house_api.modules.avaliacao.model.entity.AvaliacaoId;
import wl.open_house_api.modules.avaliacao.model.request.AvaliarFilmeRequest;
import wl.open_house_api.modules.filme.model.entity.Filme;
import wl.open_house_api.modules.filme.factory.FilmeFactory;
import wl.open_house_api.modules.usuario.model.entity.Usuario;
import wl.open_house_api.modules.usuario.factory.UsuarioFactory;

public class AvaliacaoFilmeFactory {

    private final Filme filme;
    private final Usuario usuario;
    private final int nota;

    public AvaliacaoFilmeFactory() {
        FilmeFactory filmeFactory = new FilmeFactory();
        UsuarioFactory usuarioFactory = new UsuarioFactory();
        this.filme = filmeFactory.getFilme();
        this.usuario = usuarioFactory.getUsuario();
        this.nota = 5;
    }


    public AvaliacaoDeFilmes getAvaliacaoFilmes(){
        AvaliacaoId avaliacaoId = new AvaliacaoId(filme.getId(), usuario.getId());
        return new AvaliacaoDeFilmes(avaliacaoId, this.filme,this.usuario,this.nota);
    }

    public AvaliarFilmeRequest getAvaliarFilmeRequest(){
        return new AvaliarFilmeRequest(this.filme.getId(),this.usuario.getId(),this.nota);
    }
}
