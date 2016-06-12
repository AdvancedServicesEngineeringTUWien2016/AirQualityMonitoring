package at.ac.tuwien.ase2016;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.any;

/**
 * Created by DanielHofer on 12.06.2016.
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("airQualityMonitoring")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(paths()) // and by paths
                .build()
                .apiInfo(apiInfo());
    }


    private Predicate<String> paths() {
        return any();

    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Advanced Services Engineernig - Air Quality Monitoring",
                "API description",
                "",
                "",
                "",
                "",
                "");
        return apiInfo;
    }


}