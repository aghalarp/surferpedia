package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.Index;
import views.html.Page1;
import views.html.Souza;
import views.html.Brooke;
import views.html.Ivarra;
import views.html.kalanid;
import views.html.John;

/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page. 
   * @return The resulting home page. 
   */
  public static Result index() {
    return ok(Index.render("Welcome to the home page."));
  }
  
  /**
   * Returns page1, a simple example of a second page to illustrate navigation.
   * @return The Page1.
   */
  public static Result page1() {
    return ok(Page1.render("Welcome to Page1."));
    
  }
  
  /**
   * Returns Souza's bio page.
   * @return The Souza page
   */
  public static Result souza() {
    return ok(Souza.render("Welcome to Page1."));
    
  }
  
  /**
   * Returns Brooke's bio page.
   * @return The Brooke page.
   */
  public static Result brooke() {
    return ok(Brooke.render("Welcome to Page1."));
    
  }
  
  /**
   * Returns Ivarra's bio page.
   * @return The Ivarra page.
   */
  public static Result ivarra() {
    return ok(Ivarra.render("Welcome to Page1."));
    
  }
  
  /**
   * Returns Ivarra's bio page.
   * @return The Ivarra page.
   */
  public static Result kalanid() {
    return ok(kalanid.render("Welcome to Page1."));
    
  }
  
  /**
   * Returns John's bio page.
   * @return The John page.
   */
  public static Result john() {
    return ok(John.render("Welcome to Page1."));
    
  }
}
