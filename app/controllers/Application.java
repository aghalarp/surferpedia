package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.Index;
import views.html.Souza;
import views.html.Brooke;
import views.html.Ivarra;
import views.html.John;
import views.html.Kyuss;


/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page. 
   * @return The resulting home page. 
   */
  public static Result index() {
    return ok(Index.render(""));
  }
  
  /**
   * Returns Souza's bio page.
   * @return The Souza page
   */
  public static Result souza() {
    return ok(Souza.render(""));
    
  }
  
  /**
   * Returns Brooke's bio page.
   * @return The Brooke page.
   */
  public static Result brooke() {
    return ok(Brooke.render(""));
    
  }
  
  /**
   * Returns Ivarra's bio page.
   * @return The Ivarra page.
   */
  public static Result ivarra() {
    return ok(Ivarra.render(""));
    
  }
  
  /**
   * Returns John's bio page.
   * @return The John page.
   */
  public static Result john() {
    return ok(John.render(""));
    
  }
  
  /**
   * Returns Kyuss' bio page.
   * @return The Kyuss page.
   */
  public static Result kyuss() {
    return ok(Kyuss.render(""));
    
  }
}
