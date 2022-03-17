package basics;

public class Example {
	public static void main(String[] args) {
		String A = "Anshuman";
		String B = "Antihuman";
		A = A.replace('s', 't');
		// System.out.println(A);
		A = A.substring(0, 3) + 'i' + A.substring(3);
		System.out.println(A);
		if (A.equals(B)) {
			System.out.println("A to B");
		}
	}

}
