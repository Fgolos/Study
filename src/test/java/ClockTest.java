import com.home.clock.Clock;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ClockTest {
  @Test
  public void whenClockIsInitializedTimeIsZero() {
    Clock clock = new Clock();
    assertEquals("Время: 00:00:00", clock.showTime());
  }

  @Test
  public void whenSecondsAppendedTimeIsChanged()
  throws Exception {
    Clock clock = new Clock();
    clock.addSeconds(1);
    assertEquals("Время: 00:00:01", clock.showTime());
  }
}
