package org.example.page;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;


public class LocationsPage {


    public  Locator locationsFromQuickActions, atmsButton, aTMcontent, atmCard, addressCard, branchButton, addressBranchCard, weekHours, saturdayHours, sundayHours, fullTimeSchedule ;

    public LocationsPage(Page page) {
        this.locationsFromQuickActions = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("მისამართები"));
        this.atmsButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("ბანკომატები"));
        this.aTMcontent = page.locator(".tbcx-pw-atm-branches-section__list-item").filter(new Locator.FilterOptions().setHasText("ATM")).first();
        this.atmCard = page.locator(".tbcx-pw-atm-branches-section__list-item").filter(new Locator.FilterOptions().setHasText("ATM")).first();
        this.addressCard = atmCard.locator(".tbcx-pw-atm-branches-section__list-item-title");
        this.branchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("ფილიალები")).first();;
        this.addressBranchCard = page
                .locator(".tbcx-pw-atm-branches-section__list-item")
                .first();

        this.weekHours = addressBranchCard.first().getByText("ორშაბათი-პარასკევი: 10:00-18:00");
        this.saturdayHours = addressBranchCard.first().getByText("შაბათი: 10:00-14:00");
        this.fullTimeSchedule =  addressBranchCard.first().getByText("სამუშაო საათები - 24/7");



    }
}
