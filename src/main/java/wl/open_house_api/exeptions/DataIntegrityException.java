package wl.open_house_api.exeptions;

public class DataIntegrityException extends RuntimeException {
    public DataIntegrityException(String msg) {
        super(msg);
    }
    public DataIntegrityException(String msg, Throwable cause) {
        super(msg,cause);
    }
}
