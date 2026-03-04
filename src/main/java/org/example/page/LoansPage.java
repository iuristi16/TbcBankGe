package org.example.page;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;


public class LoansPage {

    public Locator loansMenu, consumerLoanSection, applayButton, headingPage, validateRedirection, heroTitle, calculator ;
    public LoansPage(Page page) {
        this.loansMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("სესხი"));
        this.consumerLoanSection = page.locator("div.tbcx-pw-cta-section__content").filter(new Locator.FilterOptions().setHas(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("სამომხმარებლო სესხი"))));
        this.applayButton = consumerLoanSection.getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("სესხის მოთხოვნა"));
        this.headingPage = page.locator("h1", new Page.LocatorOptions().setHasText("სამომხმარებლო სესხი"));;
        this.validateRedirection = page.locator("a[href*='tbccredit']").first();
        this.heroTitle = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("მოითხოვე სესხი მომენტალურად"));
        this.calculator = page.locator("#standard-calculator");
    }

    }


