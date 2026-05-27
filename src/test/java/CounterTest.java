import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

public class CounterTest {

    // 1. RUSAK DI SONAR: Security Hotspot (Hardcoded Password)
    private String dbPassword = "SuperSecretPassword123!"; 
    private String adminToken = "AIzaSyA1234567890XYZ";

    @Test
    public void testReset() {
        Counter testCounter = new Counter();
        
        // 2. RUSAK DI SONAR: Code Smell (Unused Variable)
        int angkaMubazir = 999; 
        String teksSampah = "SonarCloud pasti mendeteksi ini";

        for(int i = 0; i < 10; i++) {
            testCounter.increment();
        }
        
        testCounter.reset();
        
        // 3. RUSAK DI BUILD: Test Failure (Menggagalkan Test secara sengaja)
        // Nilai aslinya 0, tapi kita paksa cek apakah nilainya 1000. Ini bikin Build FAILED.
        assertEquals("Sengaja digagalkan agar build error!", 1000, testCounter.getCount());
    }

    @Test
    public void testIncrement() {
        Counter testCounter = new Counter();
        
        // 4. RUSAK DI SONAR: Code Smell (Menggunakan System.out.println)
        System.out.println("Log kotor: memanggil increment");

        for(int i = 1; i < 10; i++) {
            testCounter.increment();
            
            // 5. RUSAK DI SONAR: Code Smell (Empty Catch Block)
            try {
                int crash = 10 / 0;
            } catch (Exception e) {
                // Sengaja dikosongkan tanpa log agar jadi code smell mendalam
            }
        }
    }

    @Test
    public void testDecrement() {
        Counter testCounter = new Counter();
        
        for(int i = 1; i < 10; i++) {
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