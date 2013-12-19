package test;

import java.util.List;
import org.junit.Test;
import controllers.Application;
import play.test.TestBrowser;
import play.libs.F.Callback;
import test.pages.IndexPage;
import test.pages.LoginPage;
import test.pages.SignupPage;
import test.pages.SurferPage;
import views.formdata.LoginFormData;
import static play.test.Helpers.FIREFOX;
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
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), FIREFOX, new Callback<TestBrowser>() {
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
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), FIREFOX, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        browser.goTo(loginPage);
        assertThat(browser.pageSource()).contains("Please log in");
        
        // test incorrect logins.
        loginPage.login("test", "incorrect");
        assertThat(browser.pageSource()).contains(LoginFormData.ERROR_TEXT);
        
        // test correct logins
        loginPage.login(Application.adminEmail, Application.adminPassword);
        assertThat(browser.pageSource()).contains(Application.adminEmail);
      }
    });
  }
  
  /**
   * Test that signup page is retrievable.
   */
  @Test
  public void testRetrieveSignupPage() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), FIREFOX, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        //Start at homepage.
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.goToSignup();
        
        //Goto sign up page.
        SignupPage signupPage = new SignupPage(browser.getDriver(), PORT);
        browser.goTo(signupPage);
        signupPage.isAt();
      }
    });
  }
  
  /**
   * Test that user can successfully sign up.
   */
  @Test
  public void testSignup() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), FIREFOX, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        //Start at homepage.
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.goToSignup();
        
        //Goto sign up page.
        SignupPage signupPage = new SignupPage(browser.getDriver(), PORT);
        browser.goTo(signupPage);
        signupPage.isAt();
        
        //Fill in signup form and submit
        signupPage.login("test@hawaii.edu", "password123");
        assertThat(browser.pageSource()).contains("Signup successful.");
        
        //Goto login page.
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        browser.goTo(loginPage);
        loginPage.isAt();
        
        //Sign in with new account.
        loginPage.login("test@hawaii.edu", "password123");
        assertThat(browser.pageSource()).contains("test@hawaii.edu");
      }
    });
  }
  
  /**
   * Test that anonymous user can retrieve a surfer page.
   */
  @Test
  public void testRetrieveSurferPage() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), FIREFOX, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        //Start at homepage.
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        
        //Clicks search form link, fills in with string, hits submit
        indexPage.searchForm("ad", "male", "allCountries");
        
        //Check that all search results are valid.
        List<String> searchResults = indexPage.getSearchResultLinkIds();
        for(int i=0; i < searchResults.size(); i++) {
          assertThat(searchResults.get(i)).contains("ad");
        }
        
        //Click on first surfer link in result page.
        String surferSlug = indexPage.getFirstSurferId();
        indexPage.goToSurfer(surferSlug);
        try {
          Thread.sleep(2000);
        }
        catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        assertThat(browser.pageSource()).contains("Adriano");
        
        //Create new surfer page with given slug and confirm current location.
        SurferPage surferPage = new SurferPage(browser.getDriver(), PORT, surferSlug);
        surferPage.isAt();
      }
    });
  }
  
  /**
   * Test that a user can create an account, login, and add a user to favorites.
   */
  @Test
  public void testAddSurferToFavorites() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), FIREFOX, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) throws InterruptedException {
        //Start at homepage.
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.goToSignup();
        
        //Goto sign up page.
        SignupPage signupPage = new SignupPage(browser.getDriver(), PORT);
        browser.goTo(signupPage);
        signupPage.isAt();
        
        //Fill in signup form and submit
        signupPage.login("test@hawaii.edu", "password123");
        try {
          Thread.sleep(5000);
        }
        catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        assertThat(browser.pageSource()).contains("Signup successful.");
        
        //Goto login page.
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        browser.goTo(loginPage);
        loginPage.isAt();
        
        //Sign in with new account.
        loginPage.login("test@hawaii.edu", "password123");
        try {
          Thread.sleep(5000);
        }
        catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        assertThat(browser.pageSource()).contains("test@hawaii.edu");
        
        //Clicks search form link, fills in with string, hits submit
        indexPage.searchForm("ad", "male", "allCountries");
        
        //Click on first surfer link in result page.
        String surferSlug = indexPage.getFirstSurferId();
        indexPage.goToSurfer(surferSlug);
        try {
          Thread.sleep(5000);
        }
        catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        assertThat(browser.pageSource()).contains("Adriano");
        
        //Create new surfer page with given slug and confirm current location.
        SurferPage surferPage = new SurferPage(browser.getDriver(), PORT, surferSlug);
        surferPage.isAt();
        
        // Add the surfer to favorites
        String surferName = surferPage.getSurferName();
        surferPage.addToFavorites();
        
        // Check that the surfer was added
        surferPage.goToProfile();
        try {
          Thread.sleep(5000);
        }
        catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        assertThat(browser.pageSource()).contains(surferName);
      }
    });
  } 
  
  /**
   * Test that a user can create an account, login, add a user to favorites, and remove the surfer.
   */
  @Test
  public void testRemoveSurferFromFavorites() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), FIREFOX, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) throws InterruptedException {
        //Start at homepage.
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.goToSignup();
        
        //Goto sign up page.
        SignupPage signupPage = new SignupPage(browser.getDriver(), PORT);
        browser.goTo(signupPage);
        signupPage.isAt();
        
        //Fill in signup form and submit
        signupPage.login("test@hawaii.edu", "password123");
        try {
          Thread.sleep(5000);
        }
        catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        assertThat(browser.pageSource()).contains("Signup successful.");
        
        //Goto login page.
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        browser.goTo(loginPage);
        loginPage.isAt();
        
        //Sign in with new account.
        loginPage.login("test@hawaii.edu", "password123");
        try {
          Thread.sleep(5000);
        }
        catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        assertThat(browser.pageSource()).contains("test@hawaii.edu");
        
        //Clicks search form link, fills in with string, hits submit
        indexPage.searchForm("", "male", "allCountries");
        
        //Click on first surfer link in result page.
        String surferSlug = indexPage.getFirstSurferId();
        indexPage.goToSurfer(surferSlug);
        
        //Create new surfer page with given slug and confirm current location.
        SurferPage surferPage = new SurferPage(browser.getDriver(), PORT, surferSlug);
        surferPage.isAt();
        
        // Add the surfer to favorites
        String surferName = surferPage.getSurferName();
        surferPage.addToFavorites();
        
        // Check that the surfer was added
        surferPage.goToProfile();
        try {
          Thread.sleep(5000);
        }
        catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        assertThat(browser.pageSource()).contains(surferName);
        
        // remove from favorites
        surferPage.findFirst("tr[data-slug=" + surferSlug + "] .remove-from-favorites").click();
        
        // Check that the surfer was removed
        try {
          Thread.sleep(5000);
        }
        catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        assertThat(browser.pageSource()).doesNotContain(surferName);
      }
    });
  }
  
  /**
   * Test that anonymous user cannot edit or delete a surfer.
   */
  @Test
  public void testCannotEditDeleteSurferPage() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), FIREFOX, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        //Start at homepage.
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        
        //Clicks search form link, fills in form, hits submit
        indexPage.searchForm("adriano", "male", "Brazil");
        
        //Check that all search results are valid.
        List<String> searchResults = indexPage.getSearchResultLinkIds();
        for(int i=0; i < searchResults.size(); i++) {
          assertThat(searchResults.get(i)).contains("adriano");
        }
        
        //Click on first surfer link in result page.
        String surferSlug = indexPage.getFirstSurferId();
        indexPage.goToSurfer(surferSlug);
        try {
          Thread.sleep(5000);
        }
        catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        assertThat(browser.pageSource()).contains("Adriano");
        
        //Create new surfer page with given slug and confirm current location.
        SurferPage surferPage = new SurferPage(browser.getDriver(), PORT, surferSlug);
        surferPage.isAt();
        
        //Check that edit and delete buttons are unavailable.
        assertThat(browser.pageSource()).doesNotContain("Edit");
        assertThat(browser.pageSource()).doesNotContain("Delete");
      }
    });
  }
  
  /**
   * Test that a regular user cannot create a new surfer.
   */
  @Test
  public void testCannotCreateNewSurfer() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), FIREFOX, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) throws InterruptedException {
        //Start at homepage.
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.goToSignup();
        
        //Goto sign up page.
        SignupPage signupPage = new SignupPage(browser.getDriver(), PORT);
        browser.goTo(signupPage);
        signupPage.isAt();
        
        //Fill in signup form and submit
        signupPage.login("test@hawaii.edu", "password123");
        try {
          Thread.sleep(5000);
        }
        catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        assertThat(browser.pageSource()).contains("Signup successful.");
        
        //Goto login page.
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        browser.goTo(loginPage);
        loginPage.isAt();
        
        //Sign in with new account.
        loginPage.login("test@hawaii.edu", "password123");
        try {
          Thread.sleep(5000);
        }
        catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        assertThat(browser.pageSource()).contains("test@hawaii.edu");
        
        assertThat(browser.pageSource()).doesNotContain("New Surfer");
      }
    });
  }
}
