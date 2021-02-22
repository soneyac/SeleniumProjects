
public class implementInterface /*extends testAbstract*/implements testInterface, testInterface2
{

	public static void main(String[] args) {
		int a=100;
		int b=5;
		implementInterface i= new implementInterface();
		/*i.add(a,b);
		i.divide(a, b);
		i.multiply(a, b);
		i.subtract(a, b);
		i.add4('a','b');
		i.add1("Hello ","You");
		i.add2(10.05f	,12.33f);
		i.add3(123.4d ,8888.3366d);*/
		System.out.println( i.toString());

	}

	@Override
	public void add(int a, int b) {
		System.out.println(a+b);
		
	}

	@Override
	public void subtract(int a, int b) {
		System.out.println(a-b);
		
	}

	@Override
	public void divide(int a, int b) {
		System.out.println(a/b);
		
	}

	@Override
	public void multiply(int a, int b) {
		System.out.println(a*b);
		
	}
//************Another Interface******************************************
	@Override
	public void add1(String a, String b) {
		System.out.println(a+b);
		
	}

	@Override
	public void add2(float a, float b) {
		System.out.println(a+b);
		
	}

	@Override
	public void add3(double a, double b) {
		System.out.println(a+b);
		
	}

	@Override
	public void add4(char a, char b) {
		System.out.println(Character.toString(a)+Character.toString(b));
		
	}

	/*@Override
	public String toString() {
		
		return "hello world";
	}*/

}
