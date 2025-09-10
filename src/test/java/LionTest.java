import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

//
@RunWith(Parameterized.class)
public class LionTest {

    private Lion lion;
    private Lion lionWithSex;
    private Feline feline;

    private final String sex;
    private final boolean expectedHasMane;

    public LionTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Самец", true},
                {"Самка", false}
        });
    }

    @Before
    public void setUp(){
        feline = new Feline();
        lion = new Lion(feline);
        try{
            lionWithSex = new Lion(sex);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testDoesHaveMane() {
        assertEquals(expectedHasMane, lionWithSex.doesHaveMane());
    }

    @Test
    public void testInvalidSexThrowsException() {
        try {
            Lion invalidLion = new Lion("Неизвестный");
        } catch (Exception e) {
            assertEquals("Сообщение об ошибке должно быть корректным",
                    "Используйте допустимые значения пола животного - самец или самка",
                    e.getMessage());
        }
    }

    @Test
    public void testGetFood(){
        try{
            List<String> lionFood =  lion.getFood();
            assertEquals(List.of("Животные", "Птицы", "Рыба"),lionFood);
        }catch (Exception e){
            throw  new RuntimeException();
        }
    }

    @Test
    public void testGetKittens(){
        assertEquals(1,lion.getKittens());
    }

}

