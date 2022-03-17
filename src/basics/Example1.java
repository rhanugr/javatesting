package basics;



public class Example1 {

	public static void main(String[] args) 
	{		
		String A = "abad";
		String B = "abac";		
		
		A = A.replace('d' ,'c');
		System.out.println(A);
//		Assert.assertEquals(B, A);
		if(A.equals(B)) {
			System.out.println("A to B");
		}
	}
}
