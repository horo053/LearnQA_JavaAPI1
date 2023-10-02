import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;


public class UserAgent {
    @ParameterizedTest
    @ValueSource(strings = {"Mozilla/5.0 (Linux; U; Android 4.0.2; en-us; Galaxy Nexus Build/ICL53F) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30",
    "Mozilla/5.0 (iPad; CPU OS 13_2 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) CriOS/91.0.4472.77 Mobile/15E148 Safari/604.1",
    "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)",
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.77 Safari/537.36 Edg/91.0.100.0",
    "Mozilla/5.0 (iPad; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Mobile/15E148 Safari/604.1"})
    public void testUserAgent(String param){
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("User-Agent", param);

        JsonPath response = RestAssured
                .given()
                .headers(queryParams)
                .get("https://playground.learnqa.ru/ajax/api/user_agent_check")
                .jsonPath();
        String ua = response.getString("user_agent");
        String pl = response.getString("platform");
        String br = response.getString("browser");
        String dv = response.getString("device");
        if (ua.equals("Mozilla/5.0 (Linux; U; Android 4.0.2; en-us; Galaxy Nexus Build/ICL53F) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30") &&
                pl.equals("Mobile") && br.equals("No") && dv.equals("Android")){
            System.out.println(ua);
        }
        if (ua.equals("Mozilla/5.0 (iPad; CPU OS 13_2 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) CriOS/91.0.4472.77 Mobile/15E148 Safari/604.1") &&
                pl.equals("Mobile") && br.equals("Chrome") && dv.equals("iOS")){
            System.out.println(ua);
        }
        if (ua.equals("Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)") &&
                pl.equals("Googlebot") && br.equals("Unknown") && dv.equals("Unknown")){
            System.out.println(ua);
        }
        if (ua.equals("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.77 Safari/537.36 Edg/91.0.100.0") &&
                pl.equals("Web") && br.equals("Chrome") && dv.equals("No")){
            System.out.println(ua);
        }
        if (ua.equals("Mozilla/5.0 (iPad; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Mobile/15E148 Safari/604.1") &&
                pl.equals("Mobile") && br.equals("No") && dv.equals("iPhone")){
            System.out.println(ua);
        }
    }
}