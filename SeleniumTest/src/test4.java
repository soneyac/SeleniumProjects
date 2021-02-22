
public class test4 {
String s="Endammo";
static String e="Static";
int p;
int q;
	public static void main(String[] args) {
		System.out.println(e);
		test4 t= new test4();
		t.p=100;
		t.q=20;
		String str="100";
		//String to int, double,boolean
		System.out.println(Integer.parseInt(str)+10);
		System.out.println(Double.parseDouble(str)+10);
		String st="true";
		System.out.println(Boolean.parseBoolean(st));
		t.hello();
		System.out.println(t.s);
		//int to string
		int i=10;
		System.out.println(String.valueOf(i)+10);
		t.hello(t);
		
	}
	
	public void hello(){
		System.out.println("HELLO");
	}
	public void hello(test4 t){
		System.out.println("swap");
		int a;
		a=t.p;
		t.p=t.q;
		t.q= a;
		System.out.println("t.p is "+t.p+" t.q is "+t.q);
	}
}
