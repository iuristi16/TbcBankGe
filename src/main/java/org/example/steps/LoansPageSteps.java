package org.example.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.data.Constants;
import org.example.page.LoansPage;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;



public class LoansPageSteps extends LoansPage {
    private final Page page;

    public LoansPageSteps(Page page) {
        super(page);
        this.page = page;
    }
    public LoansPageSteps openBasePage() {
        page.navigate(Constants.BASE_URL);
        return this;
    }
    public LoansPageSteps navigateToConsumerLoan() {

        loansMenu.click();
        assertThat(page).hasURL(Constants.LOANS_URL);
        return this;
    }

    public LoansPageSteps verifyPage() {
        consumerLoanSection.click();
        assertThat(applayButton).isVisible();
        assertThat(applayButton).isEnabled();
        assertThat(headingPage).isVisible();
        return this;
    }

    public LoansPageSteps verifyRedirectToTbcCredit() {

        Page newPage = page.waitForPopup(() -> {
            applayButton.click();
        });

        newPage.waitForLoadState();

        assertThat(newPage).hasURL(Constants.TBC_CREDIT_URL);

        LoansPageSteps newLoansPage = new LoansPageSteps(newPage);

        assertThat(newLoansPage.heroTitle).isVisible();
        assertThat(newLoansPage.calculator).isVisible();
        return this;

    }
}
