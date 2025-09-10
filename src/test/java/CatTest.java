import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CatTest {

    private Cat cat;
    private Feline feline;

    @Before
    public void setUp(){
        feline = new Feline();
        cat = new Cat(feline);
    }

    @Test
    public void testGetSound(){
        assertEquals("Мяу",cat.getSound());
    }

    @Test
    public void testGetFood(){
        try{
            List<String> catFood =  cat.getFood();
            assertEquals(List.of("Животные", "Птицы", "Рыба"),catFood);
        }catch (Exception e){
            throw  new RuntimeException();
        }
    }

}
