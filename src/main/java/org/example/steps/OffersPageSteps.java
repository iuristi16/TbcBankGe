package org.example.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.data.Constants;
import org.example.page.OffersPage;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class OffersPageSteps extends OffersPage {
    private final Page page;

    public OffersPageSteps(Page page) {
        super(page);
        this.page = page;
    }

    public OffersPageSteps openOffersPage() {
        page.navigate(Constants.OFFERS_URL);
        return this;
    }

    public OffersPageSteps verifyOffersPageOpened() {
        assertThat(pageHeading).isVisible();
        return this;
    }

    public OffersPageSteps filterPanelVisible() {
        assertThat(filterPanelCategory).isVisible();
        return this;
    }

    public OffersPageSteps filterPanelVisible1() {
        assertThat(filterPanelProdactType).isVisible();
        return this;
    }

    public OffersPageSteps filterPanelVisible2() {
        assertThat(filterPanelOfferType).isVisible();
        return this;
    }


    public OffersPageSteps filterPanelVisible3() {
        assertThat(filterPanelCardType).isVisible();
        return this;
    }


    public OffersPageSteps verifyOffersListVisible() {
        assertThat(getOfferCards.first()).isVisible();
        return this;
    }

    public OffersPageSteps selectFilter() {
        mastercardCheckbox.click();
        schoolCardChekbox.click();
        return this;
    }

    public OffersPageSteps verifyNoOfferCardsDisplayed() {
        assertThat(offerCardsDisplayed).hasCount(0);
        return this;

    }

    public OffersPageSteps clearFilters() {

        while (clearButtons.count() > 0) {
            clearButtons.first().click();
        }

        return this;
    }
    public OffersPageSteps verifyOffersAreVisibleAgain() {
        assertThat(offerCardsDisplayed).not().hasCount(1);
        return this;
    }
    }






