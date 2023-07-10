package wl.open_house_api.service;

import wl.open_house_api.model.filme.request.FilmeRequest;
import wl.open_house_api.model.filme.response.FilmeResponse;

public interface FilmeServiceCrud {
    public FilmeResponse insert(FilmeRequest filmeRequest);

    public FilmeResponse update(FilmeRequest filmeRequest);

}
