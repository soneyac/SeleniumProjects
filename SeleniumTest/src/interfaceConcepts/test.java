package interfaceConcepts;

public class test {

	public static void main(String[] args) {
		//runtime polymorphism
		bank b= new bank();
		b.simpleInterest();
		b.compoundInterest();
		b.credit();
		b.debit();
		b.autoLoan();
		b.educationLoan();
		System.out.println("Minimum interest is "+interest.minInterest+" and Maximum interest is "+ interest.maxInterest);
		System.out.println("******************");
		//dynamic polymorphism
		interest i= new bank();
		i.simpleInterest();
		i.compoundInterest();
		System.out.println("******************");
		loans l= new bank();
		l.autoLoan();
		l.educationLoan();
		l.personalLoan();
		l.homeLoan();
	

	}

}
