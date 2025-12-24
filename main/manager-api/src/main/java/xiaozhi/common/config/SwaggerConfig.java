package xiaozhi.common.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.customizers.GlobalOpenApiCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import xiaozhi.common.constant.Constant;

/**
 * Swagger配置
 * Copyright (c) 人人开源 All rights reserved.
 * Website: https://www.renren.io
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi deviceApi() {
        return GroupedOpenApi.builder()
                .group("device")
                .pathsToMatch("/device/**")
                .build();
    }

    @Bean
    public GroupedOpenApi agentApi() {
        return GroupedOpenApi.builder()
                .group("agent")
                .pathsToMatch("/agent/**")
                .build();
    }

    @Bean
    public GroupedOpenApi modelApi() {
        return GroupedOpenApi.builder()
                .group("models")
                .pathsToMatch("/models/**")
                .build();
    }

    @Bean
    public GroupedOpenApi oatApi() {
        return GroupedOpenApi.builder()
                .group("ota")
                .pathsToMatch("/ota/**")
                .build();
    }

    @Bean
    public GroupedOpenApi timbreApi() {
        return GroupedOpenApi.builder()
                .group("timbre")
                .pathsToMatch("/ttsVoice/**")
                .build();
    }

    @Bean
    public GroupedOpenApi voiceClone() {
        return GroupedOpenApi.builder()
            .group("voiceClone")
            .pathsToMatch("/voiceClone/**")
            .build();
    }

    @Bean
    public GroupedOpenApi sysApi() {
        return GroupedOpenApi.builder()
                .group("admin")
                .pathsToMatch("/admin/**")
                .build();
    }

    @Bean
    public GroupedOpenApi userApi() {
        return GroupedOpenApi.builder()
                .group("user")
                .pathsToMatch("/user/**")
                .build();
    }

    @Bean
    public GroupedOpenApi configApi() {
        return GroupedOpenApi.builder()
                .group("config")
                .pathsToMatch("/config/**")
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("xiaozhi-esp32-manager-api")
                .description("xiaozhi-esp32-manager-api文档")
                .version("3.0")
                .termsOfService("https://127.0.0.1"));

            // 👇添加全局安全方案
//            .addSecurityItem(new SecurityRequirement().addList(Constant.AUTHORIZATION))
//            .components(new Components()
//                .addSecuritySchemes(Constant.AUTHORIZATION,
//                    new SecurityScheme()
//                        .name(Constant.AUTHORIZATION)
//                        .type(SecurityScheme.Type.APIKEY)  // 使用 API Key 模式（Header）
//                        .in(SecurityScheme.In.HEADER)      // 放在请求头
//                        .description("填写格式：Bearer <your-access-token>")
//                ));
    }

//    /**
//     * 全局安全定制器：为所有接口添加 security 声明
//     */
//    @Bean
//    public GlobalOpenApiCustomizer globalOpenApiCustomizer() { // ✅ 返回类型是 GlobalOpenApiCustomizer
//        return openApi -> {
//            Paths paths = openApi.getPaths();
//            if (paths != null) {
//                paths.forEach((path, pathItem) -> {
//                    if (pathItem.getGet() != null) applySecurity(pathItem.getGet());
//                    if (pathItem.getPost() != null) applySecurity(pathItem.getPost());
//                    if (pathItem.getPut() != null) applySecurity(pathItem.getPut());
//                    if (pathItem.getDelete() != null) applySecurity(pathItem.getDelete());
//                    if (pathItem.getPatch() != null) applySecurity(pathItem.getPatch());
//                });
//            }
//        };
//    }
//
//    private void applySecurity(Operation operation) {
//        operation.addSecurityItem(new SecurityRequirement()
//            .addList(Constant.AUTHORIZATION));
//    }
}