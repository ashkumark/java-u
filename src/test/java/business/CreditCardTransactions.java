package business;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class CreditCardTransactions {
	private Double cashbackPercentageStandard;
	private Double cashbackPercentageEnhanced;
	private int cashbackEligibilityTransactionAmountStandard;
	private int cashbackEligibilityTransactionCountEnhanced;
	private int transactionsEligibleForCashbackCount;

	private int customerRegisteredYear;
	private int customerAgeForEligibility;

	//PicoContainer picoContainer;

	// Constructor
	public CreditCardTransactions() {
		//this.picoContainer = picoContainer;
		transactionsEligibleForCashbackCount = 0;
	}

	// Setters and getters
	public Double getCashbackPercentageStandard() {
		return cashbackPercentageStandard;
	}

	public void setCashbackPercentageStandard(Double cashbackPercentageStandard) {
		this.cashbackPercentageStandard = cashbackPercentageStandard;
	}

	public Double getCashbackPercentageEnhanced() {
		return cashbackPercentageEnhanced;
	}

	public void setCashbackPercentageEnhanced(Double cashbackPercentageVariable) {
		this.cashbackPercentageEnhanced = cashbackPercentageVariable;
	}

	public int getCashbackEligibilityTransactionAmountStandard() {
		return cashbackEligibilityTransactionAmountStandard;
	}

	public void setCashbackEligibilityTransactionAmountStandard(int cashbackEligibilityTransactionAmountStandard) {
		this.cashbackEligibilityTransactionAmountStandard = cashbackEligibilityTransactionAmountStandard;
	}

	public int getCashbackEligibilityTransactionCountEnhanced() {
		return cashbackEligibilityTransactionCountEnhanced;
	}

	public void setCashbackEligibilityTransactionCountEnhanced(int cashbackEligibilityTransactionCountEnhanced) {
		this.cashbackEligibilityTransactionCountEnhanced = cashbackEligibilityTransactionCountEnhanced;
	}

	public int getCustomerRegisteredYear() {
		return this.customerRegisteredYear;
	}

	public void setCustomerRegisteredYear(int customerRegisteredYear) {
		this.customerRegisteredYear = customerRegisteredYear;
	}

	public int getCustomerAgeForEligibility() {
		return customerAgeForEligibility;
	}

	public void setCustomerAgeForEligibility(int customerAgeForEligibility) {
		this.customerAgeForEligibility = customerAgeForEligibility;
	}

	// App methods
	public boolean isTransactionValue_greaterThan_CashbackEligibilityTransactionAmountStandard(Double amount) {
		if (amount > getCashbackEligibilityTransactionAmountStandard()) {
			return true;
		}
		return false;
	}

	Map<Integer, Double> transactionMap = new HashMap<Integer, Double>();

	public void setTransactions(Integer count, Double amount) {
		transactionMap.put(count, amount);
	}

	public Map<Integer, Double> getTransactions() {
		return transactionMap;
	}

	public int getTransactionsCount() {
		return getTransactions().size();
	}
	
	/**
	 * Get count for eligible transactions - based on year
	 * @param year
	 * @return 
	 */
	public int getTransactions_eligibleForCashBack(int year) {
		int count;
		switch (year) {
		case 2021:
			count = getTransactions_eligibleForCashBack_2021();
			break;
		case 2022:
			count = getTransactions_eligibleForCashBack_2022();
			break;
		case 2023:
			count = getTransactions_eligibleForCashBack_2023();
			break;
		default:
			throw new RuntimeException("Invalid year");
		}
		return count;
	}
	
	public int getTransactions_eligibleForCashBack_2021() {
		System.out.println("transactionsEligibleForCashbackCount: " + 0);

		return 0;
	}

	public int getTransactions_eligibleForCashBack_2022() {
		Map<Integer, Double> transaction = getTransactions();

		for (Integer trans : transaction.keySet()) {
			Double value = transaction.get(trans);
			System.out.println("value: " + value);

			if (isTransactionValue_greaterThan_CashbackEligibilityTransactionAmountStandard(value)) {
				transactionsEligibleForCashbackCount++;
			}
		}

		System.out.println("transactionsEligibleForCashbackCount: " + transactionsEligibleForCashbackCount);

		return transactionsEligibleForCashbackCount;
	}
	
	public int getTransactions_eligibleForCashBack_2023() {
		Map<Integer, Double> transaction = getTransactions();

		if (getCustomerAgeForEligibility() > 25) {
			for (Integer trans : transaction.keySet()) {
				Double value = transaction.get(trans);
				System.out.println("value: " + value);

				if (isTransactionValue_greaterThan_CashbackEligibilityTransactionAmountStandard(value)) {
					transactionsEligibleForCashbackCount++;
				}
			}

			System.out.println("transactionsEligibleForCashbackCount: " + transactionsEligibleForCashbackCount);

			return transactionsEligibleForCashbackCount;
		} else {
			return 0;
		}
	}

	public Double getCashbackAmount() {
		int transactionsCount = getTransactionsCount();
		Double cashbackPercentage;
		Double cashBackAmount = 0.00;

		System.out.println("transactionsCount: " + transactionsCount);

		if (transactionsCount > getCashbackEligibilityTransactionCountEnhanced()) {
			cashbackPercentage = getCashbackPercentageEnhanced();
		} else {
			cashbackPercentage = getCashbackPercentageStandard();
		}

		System.out.println("cashbackPercentage: " + cashbackPercentage);

		Map<Integer, Double> transaction = getTransactions();

		for (Integer trans : transaction.keySet()) {
			Double value = transaction.get(trans);
			System.out.println("value: " + value);

			if (isTransactionValue_greaterThan_CashbackEligibilityTransactionAmountStandard(value)) {
				Double amount = cashbackPercentage * value / 100.00;
				cashBackAmount += amount;
			}
		}

		System.out.println("cashBackAmount: " + round(cashBackAmount, 2));
		return round(cashBackAmount, 2); // round to 2 decimal places
	}

	public Double round(Double value, int decimalPlaces) {
		BigDecimal bd = new BigDecimal(Double.toString(value));
		bd = bd.setScale(decimalPlaces, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}



}
