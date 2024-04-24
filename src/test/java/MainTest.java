import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class MainTest {
    @Disabled
    @Test
    @Timeout(24)
    public void workTime() throws Exception {
        Main.main(null);
    }
}
