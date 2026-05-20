import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ShouterTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void restoreStreams() {
		System.setOut(originalOut);
	}

	@Test
	public void testShoutSuccess() {
		Shouter shouter = new Shouter();
		shouter.shout("hello");
		assertEquals("HELLO", outContent.toString().trim());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testShoutFailed() {
		Shouter shouter = new Shouter();
		shouter.shout(null);
	}

	@Test
	public void testSimulatedFailure() {
		if ("true".equals(System.getProperty("force.fail"))) {
			fail("Simulated test failure for continuous testing");
		}
	}

}
