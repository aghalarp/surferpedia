package test;

import org.junit.Test;
import play.test.TestBrowser;
import play.libs.F.Callback;
import test.pages.IndexPage;
import test.pages.LoginPage;
import static play.test.Helpers.HTMLUNIT;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.testServer;
import static play.test.Helpers.running;
import static org.fest.assertions.Assertions.assertThat;

/**
 * Integration tests running on an instance of the application.
 */
public class IntegrationTest {
  /** The port number for the integration test. */
  private static final int PORT = 3333;

  /**
   * Test that makes sure the Index page is retrievable.
   */
  @Test
  public void testIndex() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        assertThat(browser.pageSource()).contains("Surferpedia");
      }
    });
  }
  
  /**
   * Login test that logs in.
   */
  @Test
  public void testLogin() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        browser.goTo(loginPage);
        assertThat(browser.pageSource()).contains("Please log in");
        
        // test incorrect logins.
        loginPage.login("test", "incorrect");
        assertThat(browser.pageSource()).contains("Login credentials not valid.");
      }
    });
  }
}
