package org.backend.exam.apirestcashonline;

import com.sun.net.httpserver.HttpsParameters;
import org.backend.exam.apirestcashonline.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiRestCashOnlineApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiRestCashOnlineApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void testGetAllUsers() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/users",
                HttpMethod.GET, entity, String.class);

        Assert.assertNotNull(response.getBody());
    }

    @Test
    public void testGetUserById() {
        User user = restTemplate.getForObject(getRootUrl() + "/users/1", User.class);
        System.out.println(user.getFirstName());
        Assert.assertNotNull(user);
    }

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("agustinkoszczej@gmail.com");
        user.setFirstName("Agustín");
        user.setLastName("Koszczej");

        ResponseEntity<User> postResponse = restTemplate.postForEntity(getRootUrl() + "/users", user, User.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }

    @Test
    public void testDeletePost() {
        int id = 1;
        User user = restTemplate.getForObject(getRootUrl() + "/users/" + id, User.class);
        Assert.assertNotNull(user);

        restTemplate.delete(getRootUrl() + "/users/" + id);

        try {
            user = restTemplate.getForObject(getRootUrl() + "/users/" + id, User.class);
        } catch (final HttpClientErrorException e) {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void testGetLoans() {
        int page = 0;
        int size = 10;

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/loans?page=" + page + "&size=" + size,
                HttpMethod.GET, entity, String.class);

        Assert.assertNotNull(response.getBody());
    }

}

