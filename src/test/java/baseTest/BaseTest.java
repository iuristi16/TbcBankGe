package baseTest;


import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitUntilState;
import org.example.data.Constants;
import org.testng.annotations.BeforeClass;
import java.util.List;
public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected  BrowserContext context;
    protected Page page;

    @BeforeClass
    public void setUp() {
        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setArgs(List.of("--start-maximized"))
        );

        context = browser.newContext(
                new Browser.NewContextOptions().setViewportSize(null)
        );

        page = context.newPage();
        page.navigate(
                Constants.OFFERS_URL,
                new Page.NavigateOptions()
                        .setTimeout(60_000)
                        .setWaitUntil(WaitUntilState.LOAD)
        );

    }
    protected Page getPage() {
        return page;
    }
}