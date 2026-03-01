package automationTasktbcbank.ge;

import baseTest.BaseTest;
import org.example.steps.OffersPageSteps;
import org.example.data.Constants;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class shouldValidateEmptyOffersAndResetFilters extends BaseTest{
    private OffersPageSteps offersPageSteps;



    @BeforeClass
    public  void setUpSteps() {
        offersPageSteps = new OffersPageSteps(getPage());

    }

    @Test (priority = 1)

    public void validateEmptyOffersAndResetFilters(){
       new  OffersPageSteps(page)
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


    }
