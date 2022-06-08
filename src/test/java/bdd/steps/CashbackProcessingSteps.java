package bdd.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utils.Picocontainer;

import java.util.List;
import java.util.Map;

public class CashbackProcessingSteps {

	Picocontainer picocontainer;

	public CashbackProcessingSteps(Picocontainer picocontainer) {
		this.picocontainer = picocontainer;
	}

	Double actual;
	@When("I process cashback amount")
	public void iProcessCashbackAmount() {
		actual = picocontainer.creditCardTransactions.getCashbackAmount();
	}

	@Then("the cashback amount should be {double}")
	public void theCashbackAmountShouldBeExpected(Double expected) {
		Assert.assertEquals(actual, expected);
	}
}
