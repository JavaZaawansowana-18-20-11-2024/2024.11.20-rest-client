package com.comarch.szkolenia.rest.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        /*String uri = "http://localhost:8080/rest/api/test2";
        User user = restTemplate.getForObject(uri, User.class);

        System.out.println(user);*/

        String uri = "http://localhost:8080/rest/api/test4/123123?flag=true";
        User user = new User(234, "mateusz", "mateusz");
        /*Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("flag", "true");*/
        User response = restTemplate.postForObject(uri, user, User.class, new HashMap<>());
        System.out.println(response);

        //********************** EXCHANGE *****************//
        /*String uri = "http://localhost:8080/rest/test4/{imie}/{nazwisko}";

        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("imie", "Janusz");
        pathVariables.put("nazwisko", "Kowalski");

        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(uri)
                .queryParam("wiek", 30)
                .queryParam("id", 100)
                .build();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("naglowek1", "wartosc1");
        httpHeaders.add("naglowek2", "wartosc2");

        User user = new User();
        user.setId(5);
        user.setRole(User.Role.USER);
        user.setPassword("sag8d79087sdfh9g87sdfh9hgsdhf8799s789d");
        user.setLogin("janusz");
        user.setName("Janusz");
        user.setSurname("Kowalski");

        HttpEntity<User> reqest = new HttpEntity<>(user, httpHeaders);

        ResponseEntity<Book> response = restTemplate.exchange(uriComponents.toUriString(),
                HttpMethod.POST,
                reqest,
                Book.class,
                pathVariables);

        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusCode().value());
        HttpHeaders responseHeaders = response.getHeaders();
        for(Map.Entry<String, List<String>> header : responseHeaders.entrySet()) {
            System.out.println(header.getKey() + " - " + header.getValue());
        }

        Book book = response.getBody();
        System.out.println("Body:");
        System.out.println(book);*/
    }
}
