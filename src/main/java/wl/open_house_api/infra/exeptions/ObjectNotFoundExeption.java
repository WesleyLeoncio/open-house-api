package wl.open_house_api.infra.exeptions;

public class ObjectNotFoundExeption extends RuntimeException{

    public ObjectNotFoundExeption() {
        super("Registro não encontrado!");
    }
}
