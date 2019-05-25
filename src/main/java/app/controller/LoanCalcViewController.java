package app.controller;

import app.StudentCalc;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import pkgHelper.Loan;
import pkgHelper.Payment;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;


public class LoanCalcViewController implements Initializable   {

	private StudentCalc SC = null;
	
	@FXML
	private TextField LoanAmount;

	@FXML
	private TextField InterestRate;
	@FXML
	private TextField termYear;
	
	@FXML
	private Label lblTotalPayemnts;
	
	@FXML
	private DatePicker PaymentStartDate;
	
	@FXML
	private TextField AdditionalPayment;
	@FXML
	private Label Totalinterest;
	
	@FXML
	private TableView<Payment> TableV;
	
	@FXML
	private TableColumn<Payment,String> NumCol;
	
	@FXML
	private TableColumn<Payment,Date> DateCol;
	
	@FXML
	private TableColumn<Payment,String> PayCol;
	
	@FXML
	private TableColumn<Payment,String> AddPayCol;
	
	@FXML
	private TableColumn<Payment,String> InterestCol;
	
	@FXML
	private TableColumn<Payment,String> PrincipleCol;
	
	@FXML
	private TableColumn<Payment,String> BalanceCol;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		NumCol.setCellValueFactory(new PropertyValueFactory<Payment,String>("PaymentID"));
		DateCol.setCellValueFactory(new PropertyValueFactory<Payment,Date>("DueDate"));
		PayCol.setCellValueFactory(new PropertyValueFactory<Payment, String>("monthPay"));
		AddPayCol.setCellValueFactory(new PropertyValueFactory<Payment,String>("ExtraPayment"));
		InterestCol.setCellValueFactory(new PropertyValueFactory<Payment,String>("interest"));
		PrincipleCol.setCellValueFactory(new PropertyValueFactory<Payment,String>("principle"));
		BalanceCol.setCellValueFactory(new PropertyValueFactory<Payment,String>("Balance"));

	}

	public void setMainApp(StudentCalc sc) {
		this.SC = sc;
	}
	
	/**
	 * btnCalcLoan - Fire this event when the button clicks
	 * 
	 * @version 1.0
	 * @param event
	 */
	@FXML
	private void btnCalcLoan(ActionEvent event) {

		System.out.println("Amount: " + LoanAmount.getText());
		double dLoanAmount = Double.parseDouble(LoanAmount.getText());
		System.out.println("Amount: " + dLoanAmount);
		double interestRate = Double.parseDouble(InterestRate.getText());
		int Term = Integer.parseInt(termYear.getText());
		
		LocalDate localDate = PaymentStartDate.getValue();
		Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
		Date date = Date.from(instant);
		boolean CompoundType=true;
		double futureValue=0;
		
		double extraPayment=Double.parseDouble(AdditionalPayment.getText());
		Loan myLoan= new Loan(dLoanAmount,interestRate,Term,extraPayment,date,CompoundType,futureValue);
		lblTotalPayemnts.setText(myLoan.getTotalPayment());
		System.out.println(localDate);
		
		Totalinterest.setText(myLoan.getTotalInterest());
		
		
		LinkedList<Payment> list = myLoan.getLoanPayment();
		ObservableList<Payment> LoanList = FXCollections.observableArrayList(list);
		TableV.setItems(LoanList);
		
	}


}


