import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class LionParamTest {

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
        public void testDoesHaveMane() throws Exception {
            Lion lion = new Lion(sex, feline);
            Assert.assertEquals(expected, lion.doesHaveMane());
        }
    }
