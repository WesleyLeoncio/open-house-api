package wl.open_house_api.infra.exeptions;

import org.springframework.validation.FieldError;

public record ErroValidacaoException(String campo, String msg) {
    public ErroValidacaoException(FieldError erro) {
        this(erro.getField(),erro.getDefaultMessage());
    }
}
