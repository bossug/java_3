import org.junit.Before;
import org.junit.Test;

public class TaskExTest {
    private Task1 task1;


    @Before
    public void startTest() {
        task1 = new Task1();
    }

    @Test(expected = RuntimeException.class)
    public void testAfterLast4Ex() {
        Task1.AfterLast4(new int[]{0,3,7,5,0,0,3,2});
    }
}
