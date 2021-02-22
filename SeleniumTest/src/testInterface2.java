
public interface testInterface2 {
	public void add1(String a, String b);
	public void add2(float a, float b);
	public void add3(double a, double b);
	public void add4(char a, char b);
	public static void main(String[] args){
	constructorTest c1= new constructorTest();
	constructorTest c2= new constructorTest("Hello");
	constructorTest c3= new constructorTest("Hello",3);
	}
	
}
