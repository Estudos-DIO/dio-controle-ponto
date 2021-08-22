package swagger;

import model.JornadaTrabalho;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket apiAdmin() {
        return new Docket( DocumentationType.SWAGGER_2 )
                .select()

                //.apis( RequestHandlerSelectors.basePackage("dio.ponto.controle") )
                //.paths( PathSelectors.ant("/**") )

                //.apis( RequestHandlerSelectors.basePackage("controller") )
                //.paths( PathSelectors.ant( "/jornada/**" ) )
                //.paths(  PathSelectors.regex( "(?!/jornada).+") )

                .apis( RequestHandlerSelectors.withClassAnnotation(RestController.class) )
                .paths(  PathSelectors.regex( "/jornada.*") )

                .build()
                .apiInfo( apiInfo() )
                .globalOperationParameters(
                        Collections.singletonList(
                                new ParameterBuilder()
                                        .name( "Authorization" )
                                        .description( "Header para Token JWT" )
                                        .modelRef( new ModelRef("string") )
                                        .parameterType( "header" )
                                        .required( false )
                                        .build() ) );
    }

    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title( "API-REST" )
                .description("Projeto em Spring Boot para Controle de Ponto")
                .version( "1.0.0" )
                .license( "Apache License Version 2.0" )
                .licenseUrl( "https://www.apache.org/licenses/LICENSE-2.0" )
                .contact( new Contact( "DIO", "Site não informado.", "E-mail não informado." ) )
                .build();
    }

}
