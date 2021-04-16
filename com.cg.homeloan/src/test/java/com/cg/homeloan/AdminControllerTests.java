package com.cg.homeloan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


@SpringBootConfiguration
public class AdminControllerTests {

    @Test
    public void testListAll() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8095/homeloan/Admin", String.class);

        assertEquals(response.getStatusCode(), equals(HttpStatus.OK));

//        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode responseJson = objectMapper.readTree(response.getBody());
//
//        assertEquals(responseJson.isMissingNode(), is(false));
//        assertThat(responseJson.toString(), equals("[]"));
    }
}
