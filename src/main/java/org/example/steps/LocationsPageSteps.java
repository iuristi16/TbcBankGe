package org.example.steps;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.example.data.Constants;
import org.example.page.LocationsPage;
import static org.testng.Assert.assertTrue;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

    public class LocationsPageSteps extends LocationsPage {
        private final Page page;

        public LocationsPageSteps(Page page) {
            super(page);
            this.page = page;
        }

        public LocationsPageSteps quickActionslocationsClick() {
            locationsFromQuickActions.click();
            return this;
        }

        public LocationsPageSteps verifyRedirectionPage() {
            assertThat(page).hasURL(Constants.LOCATIONS_PATH);

            return this;
        }

        public LocationsPageSteps clickAtmsTab() {
            atmsButton.scrollIntoViewIfNeeded();
            atmsButton.click();
            aTMcontent.waitFor();
            return this;
        }

        public LocationsPageSteps verifyFirstAtmCard() {

            assertThat(atmCard).isVisible();
            assertThat(atmCard).containsText("ATM");

            assertThat(addressCard).isVisible();
            assertThat(addressCard).containsText(Pattern.compile("ქ\\.\\s*#\\d+"));
            return this;
        }

        public LocationsPageSteps swichBranchTab() {
            branchButton.click();
            return this;
        }

        public LocationsPageSteps verifyFirstBranchesCard() {
            assertThat(addressCard).isVisible();
            assertThat(addressCard).not().hasText("");
            assertThat(scheduleBlock).isVisible();
            assertThat(scheduleBlock).isVisible();
            String scheduleText = scheduleBlock.textContent();
            int count = scheduleText.split("\\d{2}:\\d{2}").length - 1;
            assertTrue(count >= 3, "Schedule must contain at least 3 time values (Week/Sat/Sun)");
            return this;
        }

    }
