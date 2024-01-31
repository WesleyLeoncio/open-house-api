package wl.open_house_api.modules.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Home {

    @GetMapping
    public String bemVindo(){
        return "<h1 style=\"text-align:center; color:blue\">BEM VINDO A OPEN FILME API</h1>" +
               "<h2 style=\"text-align:center;\">Acesse a documentação do <a href=\"/swagger-ui/index.html#/\">swagger</a></h2>";
    }
}
