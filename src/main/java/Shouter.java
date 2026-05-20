public class Shouter {

	public void shout(String message) {
		if (message == null) {
			throw new IllegalArgumentException("Message cannot be null");
		}
		System.out.println(message.toUpperCase());
	}

}
