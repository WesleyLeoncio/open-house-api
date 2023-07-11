package wl.open_house_api.infra.exeptions;

public class ValidacaoExeption extends RuntimeException{

    public ValidacaoExeption(String msg) {
        super(msg);
    }
}
