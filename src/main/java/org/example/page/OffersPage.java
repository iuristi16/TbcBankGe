package org.example.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;


public class OffersPage {
     public Locator pageHeading, filterPanelCategory,  filterPanelProdactType, filterPanelOfferType, filterPanelCardType, getOfferCards,  mastercardCheckbox, schoolCardChekbox, offerCardsDisplayed, clearButtons;


    public OffersPage(Page page){
       this.pageHeading = page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName("შეთავაზებები"));
       this.filterPanelCategory = page.locator(".filter").filter(new Locator.FilterOptions().setHasText("კატეგორია"));
       this.filterPanelProdactType = page.locator(".filter").filter(new Locator.FilterOptions().setHasText("პროდუქტის ტიპი"));
       this.filterPanelOfferType = page.locator(".filter").filter(new Locator.FilterOptions().setHasText("შეთავაზების ტიპი"));
       this.filterPanelCardType = page.locator(".filter").filter(new Locator.FilterOptions().setHasText("ბარათის ტიპი"));
       this.getOfferCards = page.locator("a[href*='/offers/all-offers/']");
       this.mastercardCheckbox = page.locator("div.filter-item:has-text('მასტერქარდი')");
       this.schoolCardChekbox = page.locator("div.filter-item:has-text('მოსწავლის ბარათი')");
       this.offerCardsDisplayed = page.locator("app-marketing-list a[href*='/offers/all-offers/']");
       this.clearButtons = page.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON, new Page.GetByRoleOptions().setName("გასუფთავება"));




    }

}
