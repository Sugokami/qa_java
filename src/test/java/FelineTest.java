import com.example.Feline;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import static org.hamcrest.CoreMatchers.startsWith;

public class FelineTest {
    Feline feline = new Feline();

    @Test
    public void eatMeat() throws Exception {
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());

    }

    @Test
    public void getFamily() {
        MatcherAssert.assertThat(feline.getFamily(), startsWith("Кош"));
    }

    @Test
    public void getKittens() {
        int expected = 1;
        Assert.assertEquals(expected, feline.getKittens());
    }
}
