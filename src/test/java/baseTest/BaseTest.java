package baseTest;


import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitUntilState;
import org.example.data.Constants;
import org.testng.annotations.BeforeClass;
import java.util.List;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
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
                new Browser.NewContextOptions().setViewportSize(null) //setViewportSize(1920, 1080)
                //setViewportSize(null) ეს მთლიან ეკრანზე
        );

        page = context.newPage();
    }

    protected Page getPage() {
        return page;
    }


        }







