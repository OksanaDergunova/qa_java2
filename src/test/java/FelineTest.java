import com.example.Animal;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import static org.junit.Assert.assertEquals;

//
@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    private Feline feline;

    @Spy
    private Feline spyFeline;

    @Before
    public void setUp(){
        feline = new Feline();
    }

    @Test
    public void testEatMeat(){
        List<String> felineFood;
        try {
            felineFood = feline.eatMeat();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals(List.of("Животные", "Птицы", "Рыба"),felineFood);
    }

    @Test
    public void testGetFamily(){
        assertEquals("Кошачьи",feline.getFamily());
    }

    @Test
    public void testGetKittens(){
        assertEquals(5,feline.getKittens(5));
    }

    //тут с помощью Spy проверяем работу такого же метода без параметров
    @Test
    public void testGetKittensWithoutParam(){
        spyFeline.getKittens();
        Mockito.verify(spyFeline,Mockito.times(1)).getKittens(1);
    }


}

