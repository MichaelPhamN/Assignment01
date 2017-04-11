import java.util.Arrays;

public class TestInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntArray a = new IntArray();
		a.prepend(10);
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) != i + 10) {
				throw new RuntimeException(
						"Index " + i + " should have value " + (i + 10) + " but instead has " + a.get(i));
			}
		}
		System.out.print(Arrays.toString(a.a));
	}

}
