package wl.open_house_api.infra.exeptions;

public class ValidacaoException extends RuntimeException{

    public ValidacaoException(String msg) {
        super(msg);
    }
}
