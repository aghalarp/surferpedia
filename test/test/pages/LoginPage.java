package test.pages;

import java.util.ArrayList;
import java.util.List;
import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
// Although Eclipse marks the following two methods as deprecated, 
// the no-arg versions of the methods used here are not deprecated.  (as of May, 2013).
import static org.fluentlenium.core.filter.FilterConstructor.withText;
import static org.fluentlenium.core.filter.FilterConstructor.withId;
import static org.fest.assertions.Assertions.assertThat;

/**
 * Illustration of the Page Object Pattern in Fluentlenium.
 * 
 * @author Philip Johnson
 * @author Kevin
 */
@SuppressWarnings("unused")
public class LoginPage extends FluentPage {
  private String url;

  /**
   * Create the LoginPage.
   * 
   * @param webDriver The driver.
   * @param port The port.
   */
  public LoginPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port + "/login";
  }

  @Override
  public String getUrl() {
    return this.url;
  }

  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Surferpedia - Login");
  }

  public void login(String email, String pass) {
    // Fill the input field with id "email" with the passed name string.
    fill("#email").with(email);
    // Fill the input field with id "password" with the passed pass string.
    fill("#password").with(pass);
    
    // Submit the form whose id is "submit"
    submit("input[type=submit]");
  }
  
  /**
   * Clicks the search link to bring up the search modal window, fill it in and submits the form.
   * 
   */
  public void searchForm(String name, String gender, String country) {
    find("#searchLink").click();
    
    //This is needed because the modal fade-in time screws things up with fluentlenium.
    try {
      Thread.sleep(2000);
    }
    catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    fill("#name").with(name);
    find("select", withId("gender")).find("option", withId(gender)).click();
    find("select", withId("country")).find("option", withId(country)).click();
    
    submit("button[type=submit]");
  }
  
  /**
   * Finds all link id values in current page source.
   * 
   * @return A list of all link id values
   */
  public List<String> getSearchResultLinkIds() {
    List<String> results = new ArrayList<>();
    results = find("table a").getIds();
    
    return results;
  }
  
  /**
   * Clicks on the surfer link of the given slug in the search results page.
   * @param slug The slug of the surfer
   */
  public void goToSurfer(String slug) {
    find("table a", withId(slug)).click();
  }
  
  /**
   * Gets the Id value of the first surfer in the search result page.
   * @return
   */
  public String getFirstSurferId() {
    return findFirst("table a").getId();
  }
}
