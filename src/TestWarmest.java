import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TestWarmest {
	
	

	@Test
	void test() {
		Warmest<Integer,String> warmest = new Warmest<>();
		warmest.put(1,"hello");
		assertEquals(warmest.getWarmest(), "hello") ; //returns "hello"
		warmest.put(2, "warmest");
		assertEquals(warmest.getWarmest(), "warmest"); //returns "warmest"
		warmest.get(1); //returns "hello"
		
		assertEquals(warmest.getWarmest(), "hello"); //returns "hello"
		assertEquals(warmest.remove(1), "hello"); //returns "hello"
		assertEquals(warmest.getWarmest(), "warmest"); //returns "warmest"
		System.out.println(warmest);
		warmest.put(1,"hello2");
		System.out.println(warmest);
		warmest.put(2,"warmest2");
		System.out.println(warmest);
		assertEquals(warmest.getWarmest(), "warmest2"); //returns "warmest2"
		warmest.put(3,"test");
		System.out.println(warmest);
		warmest.put(4,"good");
		System.out.println(warmest);
		assertEquals(warmest.remove(3), "test"); //returns "hello"
		System.out.println(warmest);
		assertEquals(warmest.getWarmest(), "good"); //returns "warmest"
		assertEquals(warmest.remove(4), "good"); //returns "hello"
		System.out.println(warmest);
		assertEquals(warmest.getWarmest(), "warmest2"); //returns "warmest"
		warmest.put(3,"test");
		System.out.println(warmest);
		warmest.put(4,"good");
		System.out.println(warmest);
		warmest.remove(2);
		System.out.println(warmest);
		assertEquals(warmest.get(1), "hello2"); //returns "hello2"
		assertEquals(warmest.get(9), null); //returns
		assertEquals(warmest.get(5), null); //returns 
		assertEquals(warmest.get(9), null); //returns 
		assertEquals(warmest.getWarmest(), "hello2"); //returns "hello2"
		System.out.println(warmest);
		
	}

}
