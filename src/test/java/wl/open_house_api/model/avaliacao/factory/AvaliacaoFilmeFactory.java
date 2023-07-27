package wl.open_house_api.model.avaliacao.factory;


import wl.open_house_api.model.avaliacao.entity.AvaliacaoDeFilmes;
import wl.open_house_api.model.filme.entity.Filme;
import wl.open_house_api.model.filme.factory.FilmeFactory;
import wl.open_house_api.model.usuario.entity.Usuario;
import wl.open_house_api.model.usuario.factory.UsuarioFactory;

public class AvaliacaoFilmeFactory {

    private Long id;
    private Filme filme;
    private Usuario usuario;
    private int nota;

    public AvaliacaoFilmeFactory() {
        FilmeFactory filmeFactory = new FilmeFactory();
        UsuarioFactory usuarioFactory = new UsuarioFactory();
        this.id = 1L;
        this.filme = filmeFactory.getFilme();
        this.usuario = usuarioFactory.getUsuario();
        this.nota = 5;
    }


    public AvaliacaoDeFilmes getAvaliacaoFilmes(){
        return new AvaliacaoDeFilmes(this.id,this.filme,this.usuario,this.nota);
    }
}
