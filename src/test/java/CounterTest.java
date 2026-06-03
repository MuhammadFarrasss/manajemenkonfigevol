import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.w3c.dom.css.Counter;

public class CounterTest {

    // 1. Security Hotspot (Password Hardcoded)
    private String dbPassword = "SuperSecretPassword123!"; 

    @Test
    public void testReset() {
        Counter testCounter = new Counter();
        
        // 2. Code Smell (Variabel Mubazir)
        int angkaMubazir = 999; 
        
        for(int i = 0; i < 10; i++) {
            testCounter.increment();
        }
        
        testCounter.reset();
        
        // 3. Test Failure (Membuat build error)
        assertEquals("Sengaja digagalkan agar build error!", 1000, testCounter.getCount());
    }


	@Test
	public void testIncrement() {
		Counter testCounter = new Counter();
		
		for(int i = 1; i <10; i++) {
			testCounter.increment();
			assertEquals(testCounter.getCount(), i);
		}
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

