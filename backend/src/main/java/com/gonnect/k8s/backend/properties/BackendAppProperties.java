package com.gonnect.k8s.backend.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "backend")
public class BackendAppProperties {
    // These configuration properties are reloaded when the ConfigMap is updated.

    private String message = "Hello world!";
}
