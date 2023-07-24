package wl.open_house_api.infra.exeptions;

public class JWTException extends RuntimeException{
    public JWTException(String msg) {
        super(msg);
    }

    public JWTException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
