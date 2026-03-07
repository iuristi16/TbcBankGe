package baseTest;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitUntilState;
import org.example.data.Constants;
import org.testng.annotations.BeforeClass;

import java.util.List;

public class MobileBaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeClass
    public void setUp() {

        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
        );

        context = browser.newContext(
                new Browser.NewContextOptions()
                        .setViewportSize(390, 844)
                        .setUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 15_0 like Mac OS X) " +
                                "AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.0 " +
                                "Mobile/15E148 Safari/604.1")
                        .setIsMobile(true)
                        .setHasTouch(true)
                        .setPermissions(List.of("geolocation"))
                        .setGeolocation(41.7151, 44.8271)
        );

        page = context.newPage();

        page.navigate(
                Constants.BASE_URL,
                new Page.NavigateOptions()
                        .setWaitUntil(WaitUntilState.LOAD)
        );

        handleCookies();
    }

    private void handleCookies() {

        Locator cookieBanner = page.locator("text=თანხმობა Cookie-ზე");

        if (cookieBanner.count() > 0) {


            page.evaluate("window.scrollTo(0, document.body.scrollHeight)");

            Locator consentButton = page.locator("button:has-text('თანხმობა')");

            consentButton.first().click(new Locator.ClickOptions().setForce(true));
        }



    }

    protected Page getPage() {
        return page;
    }
}