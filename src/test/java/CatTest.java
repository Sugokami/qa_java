import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

import java.io.IOException;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void testGetFood() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Cat cat = new Cat(feline);
        System.out.println(cat.getFood());
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }

    @Test
    public void testGetSound() throws IOException {
        Cat cat = new Cat(feline);
        Assert.assertEquals("Мяу", cat.getSound());
    }
}
