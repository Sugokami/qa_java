import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;
    @Test
    public void testGetFood() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion("Самка", feline);
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test
    public void getKittens() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion("Самец", feline);
        Assert.assertEquals(1, lion.getKittens());
    }

    @Test(expected = Exception.class)
    public void doesHaveManeMethodThatThrows() throws Exception {
        Lion lion = new Lion("Ку-ку", feline);
        Throwable thrown = assertThrows(Exception.class,() -> {
            lion.doesHaveMane();
        });
    }
}
