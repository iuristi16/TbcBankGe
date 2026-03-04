package org.example.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.page.LoansPage;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;



public class LoansPageSteps extends LoansPage {
    private final Page page;

    public LoansPageSteps(Page page) {
        super(page);
        this.page = page;
    }

    public LoansPageSteps navigateToConsumerLoan() {

        loansMenu.click();
        return this;
    }

    public LoansPageSteps verifyPage() {
        consumerLoanSection.click();
        assertThat(applayButton).isVisible();
        assertThat(applayButton).isEnabled();
        assertThat(headingPage).isVisible();
        applayButton.click();
        return this;
    }

    public LoansPageSteps verifyRedirectToTbcCredit() {
        Page newPage = page.waitForPopup(() -> {
        });
        assertThat(newPage).hasURL("https://tbccredit.ge/?source_caller=ui&shortlink=ularj23r&c=Acq_FCL_7_tbccredit.ge_Prompt_7&pid=tbccredit.ge&deep_link_value=offers%2F81621&af_xp=custom");
        return this;
    }

    public LoansPageSteps validateDestinationPage() {

        // 1️⃣ ვიჭერთ ახალ ტაბს
        Page newPage = page.waitForPopup(() -> {
            applayButton.click();
        });

        // 2️⃣ გადავდივართ ახალ ტაბზე
        newPage.waitForLoadState();
        // 3️⃣ ველოდებით ჩატვირთვას
        page.waitForLoadState();

        // 4️⃣ ვხურავთ cookie-ს თუ გამოჩნდა
        Locator accept = page.locator("button:has-text('ვეთანხმები')");
        if (accept.count() > 0) {
            accept.first().click();
        }


        // 6️⃣ ვამოწმებთ რომ calculator ჩანს
        assertThat(page.locator("#standard-calculator")).isVisible();

        return this;
    }


}
