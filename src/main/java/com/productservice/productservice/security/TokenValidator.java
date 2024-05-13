package com.productservice.productservice.security;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
@Service
public class TokenValidator {

    // To make a call from this service to other Service, we should use HTTP Method like RestTemplate

    private RestTemplateBuilder restTemplateBuilder;

    TokenValidator(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }



    public Optional<JWTObject> validateToken(String token) {
        // This method will validate the token and return the JWTObject

        /*This method should call the UserService to validate the token.
        If the token is valid, it should return the corresponding JWTObject .
         */
        RestTemplate restTemplate = restTemplateBuilder.build();

        //Make an HTTP call to UserService to call the validateToken method



        return Optional.empty();
    }
}
