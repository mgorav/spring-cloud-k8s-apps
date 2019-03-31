package com.gonnect.k8s.frontend.controller;

import com.gonnect.k8s.frontend.model.HelloResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@Slf4j
@RequiredArgsConstructor
class IndexController {
    private final RestTemplate client;
    @Value("${services.backend}")
    private String backendAddress;

    @GetMapping("/")
    public String index(Model model) {
        log.info("Calling backend: {}", backendAddress);
        final HelloResponse result = client.getForObject(backendAddress, HelloResponse.class);
        log.info("Received result from backend: {}", result);

        model.addAttribute("message", result.getMessage());
        model.addAttribute("source", result.getSource());

        return "index";
    }
}
