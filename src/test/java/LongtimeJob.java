import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;
import java.lang.Thread;

public class LongtimeJob {
    @Test
    public void testLongtimeJob() throws InterruptedException{
        JsonPath response = RestAssured
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();

        String token = response.get("token");
        int second = response.get("seconds");
        System.out.println(token);
        System.out.println(second);


        JsonPath responseBefore = RestAssured
                .given()
                .params("token", token)
                .when()
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();

        String statusBefore = responseBefore.get("status");
        System.out.println(statusBefore);

        Thread.sleep(second * 1000);

        JsonPath responseAfter = RestAssured
                .given()
                .params("token", token)
                .when()
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();

        String statusAfter = responseAfter.get("status");
        System.out.println(statusAfter);
    }

}
