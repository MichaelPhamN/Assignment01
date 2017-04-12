import java.util.Arrays;

public class IntArrayTest {

	public static void main(String[] args) {
		System.out.println("Now starting tests. You'll see an 'Everything looks OK!' message if everything is ok!");
		IntArray a = new IntArray();
		int score = 0;
		try {
			for (int i = 0; i < 10; i++) {
				a.add(i + 1);
				if (a.get(i) != i + 1) {
					throw new RuntimeException("After adding " + (i + 1) + " I couldn't get it!");
				}
			}
			if (a.size() != 10) {
				throw new RuntimeException("Size should be 10 after adding 10 things");
			}
			for (int i = 0; i < a.size(); i++) {
				if (a.get(i) != i + 1) {
					throw new RuntimeException("After adding 10 things and tried to a.get(" + i + ") I expected to see "
							+ (i + 1) + " but saw " + a.get(i) + "!");
				}
				a.set(i, i + 1 + 10);
				if (a.get(i) != i + 1 + 10) {
					throw new RuntimeException("After setting I tried to a.get(" + i + ") I expected to see "
							+ (i + 1 + 10) + " but saw " + a.get(i) + "!");
				}
			}

			System.out.println("Initial functionality looks OK. Now testing prepend with a single value.");
			a.prepend(10);			
			score += 10;
			if (a.size() != 11) {
				throw new RuntimeException(
						"Size should be 11 after adding 10 things and prepending 1 but instead it's " + a.size());
			}
			
			score += 10;
			for (int i = 0; i < a.size(); i++) {
				if (a.get(i) != i + 10) {
					throw new RuntimeException(
							"Index " + i + " should have value " + (i + 10) + " but instead has " + a.get(i));
				}
			}
			score += 10;
			System.out.println("OK. Now prepending 9 more values.");
			for (int i = 0; i < 10; i++) {
				a.prepend(9 - i);
				if (a.get(0) != 9 - i) {
					throw new RuntimeException("After prepending " + (9 - i) + " I couldn't get it!");
				}
			}
			if (a.size() != 21) {
				throw new RuntimeException("Size should be 21, instead I got " + a.size());
			}
			score += 10;
			System.out.println("OK. Now alternating prepend and append with a bunch of values.");
			for (int i = 0; i < 1000; i++) {
				if (i % 2 == 0) {
					a.prepend(-(i + 2) / 2);
				} else {
					a.add((i + 1) / 2 + 20);
				}
			}
			
			for (int i = 0; i < a.size(); i++) {
				if (a.get(i) != -500 + i) {
					throw new RuntimeException(
							"Expected a.get(" + i + ") == " + (-500 + i) + " instead was " + a.get(i));
				}
			}			
			
			score += 10;
			System.out.println("OK. Now running a speed test prepending and adding a million values.");
			long start = System.currentTimeMillis();
			for (int i = 0; i < 1000000; i++) {
				a.prepend(-501 - i);
			}
			
			for (int i = 0; i < a.size(); i++) {
				if (a.get(i) != -1000500 + i) {
					throw new RuntimeException(
							"Expected a.get(" + i + ") == " + (-1000500 + i) + " instead was " + a.get(i));
				}
			}
			score += 15;
			for (int i = 0; i < 1000000; i++) {
				a.add(521 + i);
			}
			if (a.size() != 2001021) {
				throw new RuntimeException("Size should now be 2001021, instead I got " + a.size());
			}
			for (int i = 0; i < a.size(); i++) {
				if (a.get(i) != -1000500 + i) {
					throw new RuntimeException(
							"Expected a.get(" + i + ") == " + (-1000500 + i) + " instead was " + a.get(i));
				}
			}
			score += 15;
			for (int i = 0; i < a.size(); i++) {
				a.set(i, a.size() - i);
			}
			for (int i = 0; i < a.size(); i++) {
				if (a.get(i) != 2001021 - i) {
					throw new RuntimeException("After resetting the whole array and calling a.get(i) I expected "
							+ (2001021 - i) + " but got " + a.get(i));
				}
			}
			long end = System.currentTimeMillis();
			score += 10;
			if (end - start < 1000) {
				System.out.println("OK. You took " + (end - start) + " milliseconds, not bad!");
				System.out.println("****** Everything looks OK! ******");
				score += 10;
			} else {
				System.out.println("OK, but you took " + (end - start)
						+ " milliseconds, which seems too long (I'm expecting 1000 or less; my laptop takes between 61 and 100 in my implementations). Please let me know if you feel this is in error.");
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		System.out.println(
				"Tentative score: " + score + "/100 (Note that any academic misconduct would affect your score.)");
	}

}
