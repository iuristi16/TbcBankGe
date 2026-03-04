package automationTasktbcbank.ge;

import baseTest.BaseTest;
import org.example.steps.LoansPageSteps;
import org.example.steps.LocationsPageSteps;
import org.example.steps.OffersPageSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class automationTaskTbcBank extends BaseTest {
    private OffersPageSteps offersPageSteps;


    @BeforeClass
    public void setUpSteps() {
        offersPageSteps = new OffersPageSteps(getPage());
        offersPageSteps.openOffersPage();
    }

    @Test(priority = 1)

    public void validateEmptyOffersAndResetFilters() {
        offersPageSteps
                .openOffersPage()
                .verifyOffersPageOpened()
                .filterPanelVisible()
                .filterPanelVisible1()
                .filterPanelVisible2()
                .filterPanelVisible3()
                .verifyOffersListVisible()
                .selectFilter()
                .verifyNoOfferCardsDisplayed()
                .clearFilters()
                .verifyOffersAreVisibleAgain();
    }


    @Test(priority = 2)

    public void shouldRedirectToTbcCreditFromConsumerLoan() {
        new LoansPageSteps(page)
                .openBasePage()
                .navigateToConsumerLoan()
                .verifyPage()
                .verifyRedirectToTbcCredit();




    }


}
