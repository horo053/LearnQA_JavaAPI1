import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

public class GetJsonHomework{
    @Test
    public void testGetJson(){
        JsonPath response = RestAssured
                .get("https://playground.learnqa.ru/api/get_json_homework")
                .jsonPath();

//        response.prettyPrint();

        String answer = response.get("messages.message[1]");
        System.out.println(answer);
    }
}
