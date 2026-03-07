package automationTasktbcbank.ge;
import baseTest.MobileBaseTest;
import org.example.steps.LocationsPageSteps;
import org.example.steps.OffersPageSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class mobileAutomationTaskTbcBank extends MobileBaseTest {
    private LocationsPageSteps locationsPageSteps;


    @BeforeClass
    public void setUpSteps() {
        locationsPageSteps = new LocationsPageSteps(getPage());

    }

    @Test(priority = 1)

    public void locationsMobileTest() {
        new LocationsPageSteps(page)
                .quickActionslocationsClick()
                .verifyRedirectionPage()
                .clickAtmsTab()
                .verifyFirstAtmCard()
                .swichBranchTab()
                .verifyFirstBranchesCard();
    }
}
