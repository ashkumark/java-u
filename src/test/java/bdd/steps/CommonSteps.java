package bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utils.Picocontainer;

public class CommonSteps {

	Picocontainer picocontainer;
	//BusinessRules businessRules;
	//CreditCardTransactions creditCardTransactions;
	//private static Logger logger = LoggerFactory.getLogger(CommonSteps.class);

	public CommonSteps(Picocontainer picocontainer) {
		this.picocontainer = picocontainer;
		//picocontainer.businessRules = new BusinessRules();
		//creditCardTransactions = new CreditCardTransactions();
	}

	@Given("the CustomerRegisteredYear {int}")
	public void the_customer_registered_year(int year) {
		System.out.println("Given the CustomerRegisteredYear " + year);
		picocontainer.creditCardTransactions.setCustomerRegisteredYear(year);
	}

	@When("I apply the business rules")
	public void i_apply_the_business_rules_for() {
		picocontainer.businessRules.applyBusinessRules(this.picocontainer.creditCardTransactions);
	}

	
}
