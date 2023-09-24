import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LengthStr {
    @ParameterizedTest
    @ValueSource(strings = {"Текст менее 15", "Текст более 15 символов"})
    public void LengthStr(String str){
        Map<String, String> strLenght = new HashMap<>();
        strLenght.put("str", str);

        int length = str.length();
        assertTrue(length <= 15, "Текст более 15 символов");
    }
}
