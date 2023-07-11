package wl.open_house_api.infra.exeptions;

import org.springframework.validation.FieldError;

public record ErroValidacaoExeption(String campo, String msg) {
    public ErroValidacaoExeption(FieldError erro) {
        this(erro.getField(),erro.getDefaultMessage());
    }
}
