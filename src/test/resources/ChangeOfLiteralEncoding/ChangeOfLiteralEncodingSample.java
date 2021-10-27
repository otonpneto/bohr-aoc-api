
public class ChangeOfLiteralEncodingSample {

	public ChangeOfLiteralEncodingSample() {

	}

	public void methodOne() {
		int a = 013;
		
		System.out.println(a);
	}
	
	public void methodOneTransformed() {
		int a = Integer.parseInt("13", 8);
		
		System.out.println(a);
	}
	
	public void methodTwo() {
		int a;
		a = 013;
		
		System.out.println(a);
	}
	
	public void methodTwoTransformed() {
		int a;
		a = Integer.parseInt("13", 8);
		
		System.out.println(a);
	}
	
	public int methodThree() {
		int a = 11 & 32;
		
		return a;
	}
	
	public void methodThreeTransformed() {
		int a = 0b1100 & 0b0011;
		
		System.out.println(a);
	}
	
	public void methodFour() {
		int a;
		a = 018;
		
		int b = 019;
		
		System.out.println(a + b);
	}
	
	public int methodFive() {
		float b = 11;
		float c = 32;
		int a = b & c;
		
		return a;
	}
	
}
