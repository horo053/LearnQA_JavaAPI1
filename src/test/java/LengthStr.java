import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LengthStr {
    @Test
    public void LengthStrPass(){
        String str = "Текст менее 15";
        int length = str.length();
        assertTrue(length <= 15, "Текст более 15 символов");
    }

    @Test
    public void LengthStrFail(){
        String str = "Текст более 15 символов";
        int length = str.length();
        assertTrue(length <= 15, "Текст более 15 символов");
    }
}
