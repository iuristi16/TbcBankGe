package org.example.page;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;


public class LoansPage {

    public Locator loansMenu, consumerLoanSection, applayButton, headingPage,  heroTitle, calculator ;
    public LoansPage(Page page) {
        this.loansMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("სესხები"));
        this.consumerLoanSection = page.locator("div.tbcx-pw-cta-section__info").filter(new Locator.FilterOptions().setHas(page.getByText("მოითხოვე 80 000 ლარამდე თანხა ონლაინ. ეფექტური 18%-დან")));
        this.applayButton = consumerLoanSection.getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("სესხის მოთხოვნა"));
        this.headingPage = page.locator("h1", new Page.LocatorOptions().setHasText("სამომხმარებლო სესხი"));;
        this.heroTitle = page.locator("h1").filter(new Locator.FilterOptions().setHasText("მოითხოვე სესხი მომენტალურად"));
        this.calculator = page.locator("#standard-calculator");
    }

    }


