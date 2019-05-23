package pkgHelper;

import java.util.LinkedList;

public class Loan {
	double LoanAmount;
	double InterestRate;
	double termYear;
	double AdditionalPayment;
	double DueDate;
	double Compounds;
	double futureValue;
	
	private LinkedList<Payment> loanPayments = new LinkedList<Payment>();
	
	public Loan(double LoanAmount,double InterestRate,double termYear, double lblTotalPayments, boolean bInterestCalc, double AdditionalPayment) {
		super();
	}
}
