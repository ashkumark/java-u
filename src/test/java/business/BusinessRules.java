package business;

import utils.Picocontainer;

public class BusinessRules {


	// Set Cashback business rules
	public void applyBusinessRules(CreditCardTransactions creditCardTransactions) {
		//picoContainer.creditCardTransactions = creditCardTransactions;
		int year = creditCardTransactions.getCustomerRegisteredYear();
		
		switch (year) {
		case 2022:
			setValues(creditCardTransactions, 1.00, 2.00, 10, 50);
			break;
		case 2023:
			setValues(creditCardTransactions, 1.50, 2.50, 8, 75);
			break;
		default:
			setValues(creditCardTransactions, 0.0, 0.0, 0, 0);
			break;
		}
	}
	
	public void setValues(CreditCardTransactions creditCardTransactions, 
			Double CashbackPercentageStandard, Double CashbackPercentageEnhanced,
			int EligibilityTransactionCountEnhanced, int EligibilityTransactionAmountStandard) {
		creditCardTransactions.setCashbackPercentageStandard(CashbackPercentageStandard);
		creditCardTransactions.setCashbackPercentageEnhanced(CashbackPercentageEnhanced);
		creditCardTransactions.setCashbackEligibilityTransactionCountEnhanced(EligibilityTransactionCountEnhanced);
		creditCardTransactions.setCashbackEligibilityTransactionAmountStandard(EligibilityTransactionAmountStandard);
	}
}
