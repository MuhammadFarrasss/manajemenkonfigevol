import static org.junit.Assert.*;
import org.junit.Test;

public class CounterTest {

	@Test
	public void testReset() {
		Counter testCounter = new Counter();
		
		for(int i = 0; i <10; i++) {
			testCounter.increment();
		}
		
		testCounter.reset();
		
		assertEquals(testCounter.getCount(), 0);
	}

	@Test
	public void testIncrement() {
		Counter testCounter = new Counter();
		
		for(int i = 1; i <10; i++) {
			testCounter.increment();
			assertEquals(testCounter.getCount(), i);
		}
		// Masukkan ini di dalam salah satu method atau class
String databasePassword = "SuperSecretPassword123!";
String apiKey = "AIzaSyA1234567890XYZ";
	}

	@Test
	public void testDecrement() {
		Counter testCounter = new Counter();
		
		for(int i = 1; i <10; i++) {
			testCounter.decrement();
			assertEquals(testCounter.getCount(), i * -1);
		}
	}

	@Test
	public void testSimulatedFailure() {
		if ("true".equals(System.getProperty("force.fail"))) {
			fail("Simulated test failure for continuous testing");
		}
	}

}

