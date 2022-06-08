package bdd.hooks;

import business.BusinessRules;
import business.CreditCardTransactions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.Picocontainer;


public class Hooks {

    Picocontainer picocontainer;

   // private static Logger logger = LoggerFactory.getLogger(Hooks.class);

    public Hooks(Picocontainer picocontainer) {
        this.picocontainer = picocontainer;
    }

    @Before()
    public void setUp(Scenario scenario) {
        scenario = scenario;
        scenario.log("Start scenario: " + scenario.getName());
        System.out.println("Before scenario..");
        picocontainer.businessRules = new BusinessRules();
        picocontainer.creditCardTransactions = new CreditCardTransactions();
    }

    @After
    public void tearDown() {
        //logger.info("After scenario..\n");
    }

    // next feature
    public void testData_EqualToTenTransactions_noTransactionsGreaterThan50() {
//        creditCardTransactions.setTransactions(1, 10.5);
//        creditCardTransactions.setTransactions(2, 12.75);
//        creditCardTransactions.setTransactions(3, 5.0);
//        creditCardTransactions.setTransactions(4, 1.5);
//        creditCardTransactions.setTransactions(5, 5.0);
//        creditCardTransactions.setTransactions(6, 10.55);
//        creditCardTransactions.setTransactions(7, 5.1);
//        creditCardTransactions.setTransactions(8, 50.0); // NOT eligible
//        creditCardTransactions.setTransactions(9, 49.99); // NOT eligible
//        creditCardTransactions.setTransactions(10, 5.1);
    }

    //version 2
    public void testData_LessThanEightTransactions_2023() {
//        creditCardTransactions.setTransactions(1, 10.5);
//        creditCardTransactions.setTransactions(2, 12.75);
//        creditCardTransactions.setTransactions(3, 5.0);
//        creditCardTransactions.setTransactions(4, 100.55); // eligible
//        creditCardTransactions.setTransactions(5, 75.1); // eligible
//        creditCardTransactions.setTransactions(6, 75.0); // NOT eligible
//        creditCardTransactions.setTransactions(7, 74.99); // NOT eligible

    }

}
