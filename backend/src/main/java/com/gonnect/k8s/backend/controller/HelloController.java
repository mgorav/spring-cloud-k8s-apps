package com.gonnect.k8s.backend.controller;

import lombok.RequiredArgsConstructor;
import com.gonnect.k8s.backend.model.HelloResponse;
import com.gonnect.k8s.backend.properties.BackendAppProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequiredArgsConstructor
class HelloController {
    private final BackendAppProperties props;
    private String hostName;

    @PostConstruct
    public void init() throws UnknownHostException {
        // Get host name once this bean is initialized.
        hostName = InetAddress.getLocalHost().getCanonicalHostName();
    }

    @GetMapping("/")
    public HelloResponse hello() {
        final HelloResponse resp = new HelloResponse();
        resp.setMessage(props.getMessage());
        resp.setSource(hostName);
        return resp;
    }
}
