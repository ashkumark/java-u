package bdd.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utils.Picocontainer;

import java.util.List;
import java.util.Map;

public class CashbackEligibilitySteps {

	Picocontainer picocontainer;
	//public BusinessRules businessRules;
	//public CreditCardTransactions creditCardTransactions;
	//private static Logger logger = LoggerFactory.getLogger(Hooks.class);

	public CashbackEligibilitySteps(Picocontainer picocontainer) {
		this.picocontainer = picocontainer;
		//businessRules = new BusinessRules();
		//creditCardTransactions = new CreditCardTransactions();
	}

	@When("I set the transactions")
	public void i_set_the_transactions(List<Map<String, String>> transactionMap) {
		System.out.println("transactionMap: " + transactionMap);
		for(Map<String, String> trans : transactionMap) {
			picocontainer.creditCardTransactions.setTransactions(Integer.parseInt(trans.get("Count")),
													Double.parseDouble(trans.get("Amount")));
		}

	}

	int actual;
	@And("I count the transactions eligible for cashback")
	public void i_count_the_transactions_eligible_for_cashback() {
		int year = picocontainer.creditCardTransactions.getCustomerRegisteredYear();

		System.out.println("CustomerRegisteredYear " + year);

		actual = picocontainer.creditCardTransactions
				.getTransactions_eligibleForCashBack(year);

	}

	@Then("the transactions count should be {int}")
	public void the_transactions_count_should_be(int expected) {
		Assert.assertEquals(actual, expected);
	}


}
