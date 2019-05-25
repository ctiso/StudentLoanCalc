package pkgUT;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import pkgHelper.Loan;

public class LoanTest {

	@Test
	public void LoanTest() {
		
		double loanAmount = 100000;
		double interestRate = .07;
		int term = 20;
		double extraPayment = 0;
		Date dueDate = Loan.parseDate("2019-04-03");
		boolean Compound = false;
		double futureValue = 0;
		
		Loan l = new Loan(loanAmount, interestRate, term, extraPayment, dueDate, Compound, futureValue);
	}
	@Test
	public void totalPrincipleTest() {
		Loan L = new Loan(1000.0, 0.01, 1,0,Loan.parseDate("2019-04-03"),true,0);
		double loan = L.getLoanAmount();
		assertTrue(loan == 1000.0);
	}
	@Test
	public void totalInterestTest() {
		Loan L = new Loan(1000.0, 0.01, 1,0,Loan.parseDate("2019-04-03"),true,0);
		String interest = L.getTotalInterest();
		assertEquals(interest,"5.42");
		}
	@Test
	public void totalPayment() {
		Loan L = new Loan(1000.0, 0.01, 1,0,Loan.parseDate("2019-04-03"),true,0);
		String payment = L.getTotalPayment();
		assertEquals(payment,"105.42");
	}
}