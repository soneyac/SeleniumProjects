package interfaceConcepts;

public class bank implements interest, loans{
	public void simpleInterest(){
		System.out.println("Simple interest calculation");
	}
	public void compoundInterest(){
		System.out.println("Compound interest calculation");
	}
	public void credit(){
		System.out.println("Credit calculation");
	}
	public void debit(){
		System.out.println("Debit calculation");
	}
	public void educationLoan(){
		System.out.println("Education Loan");
	}
	public void autoLoan(){
		System.out.println("Automobile Loan");
	}
	public void homeLoan(){
		System.out.println("Home Loan");
	}
	public void personalLoan(){
		System.out.println("Personal Loan");
	}
}
