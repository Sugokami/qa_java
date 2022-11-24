import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTest {

    @Parameterized.Parameter()
    public String sex;

    @Parameterized.Parameter(1)
    public boolean expected;

    @Mock
    Feline feline;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters(name = "Sex: {0}, expected result: {1}")
    public static Object[][] params() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void testGetFood() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion(sex, feline);
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        Lion lion = new Lion(sex, feline);
        Assert.assertEquals(expected, lion.doesHaveMane());
    }


    @Test
    public void getKittens() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion(sex, feline);
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
