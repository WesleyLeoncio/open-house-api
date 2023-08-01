package wl.open_house_api.infra.config.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpingDocConfigurations {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().components(new Components().addSecuritySchemes("bearer-key",
                        new SecurityScheme().type(SecurityScheme.Type.HTTP)
                                .scheme("bearer").bearerFormat("JWT")))

                .info(new Info()
                        .title("API OPEN HOUSE")
                        .description("""
                                <html>
                                <div>
                                    <img height="80" width="100"  src="https://titleinsurancewebdesign.com/firsttitleabstract/wp-content/uploads/sites/55/2014/03/open-house.jpg" alt="Imagem">
                                    <p>API DE EXEMPLO UTILIZANDO SPRING BOOT 3.1.1</p>
                                </div>
                                </html>
                                """)
                        .contact(new Contact()
                                .name("Time Backend")
                                .email("backend@open.house"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://open_house/api/licenca")));
    }
}
