package com.noura.noura.ws;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class nouraDockerDemoController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello - noura-k8s";
    }

    @GetMapping("/callOtherApp")
    public String otherApp() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://localhost:9090/makeOtherAppCall";
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl, String.class);

        return response.getBody();
    }


}
