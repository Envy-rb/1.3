package application;

import com.envy.application.service.BasketService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class BasketServiceTest {
    BasketService testInstance = new BasketService();

    @Test
    public void test1() {
        int actual = testInstance.calcTotalBaskets();
        int expected = 2;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test2() {
        double actual = testInstance.calcMaxVolumeOfBasket();
        double expected = 800;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test3() {
        int actual = testInstance.calcTotalBalls();
        int expected = 5;
        Assertions.assertEquals(actual, expected);
    }
    @Test
    public void test4() {
        double actual = testInstance.calcTotalWeightOfBalls();
        double expected = 411;
        Assertions.assertEquals(actual, expected);
    }

    public BasketServiceTest() throws IOException {
    }
}
