package controllers;

import java.util.List;
import java.util.Map;
import models.SurferDB;
import models.UpdateDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.formdata.FootstyleTypes;
import views.formdata.LoginFormData;
import views.formdata.SurferFormData;
import views.formdata.SurferTypes;
import views.html.Index;
import views.html.Login;
import views.html.ManageSurfer;
import views.html.ShowSurfer;
import views.html.Updates;


/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page. 
   * @return The resulting home page. 
   */
  public static Result index() {
    return ok(Index.render("Home", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), SurferDB.getSurfers()));
  }
  
  /**
   * Returns the ManageSurfer page with empty form fields. For creating new Surfers.
   * @return The ManageSurfer page.
   */
  @Security.Authenticated(Secured.class)
  public static Result newSurfer() {
    SurferFormData data = new SurferFormData(); //Create empty surferFormData object
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data); //Then fill it with form data.
    Map<String, Boolean> surferTypeMap = SurferTypes.getTypes(data.surferType); //Note: I think we can use empty param.
    List<String> footstyleTypeList = FootstyleTypes.getTypes();
    return ok(ManageSurfer.render("ManageSurfer", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData, surferTypeMap, footstyleTypeList, SurferDB.getSurfers()));
  }
  
  /**
   * Returns the ManageSurfer page with pre-filled form fields. For editing existing Surfers.
   * @param slug The slug.
   * @return The ManageSurfer page.
   */
  @Security.Authenticated(Secured.class)
  public static Result manageSurfer(String slug) {
    SurferFormData data = new SurferFormData(SurferDB.getSurfer(slug)); //Create new but existing surferFormData object
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    Map<String, Boolean> surferTypeMap = SurferTypes.getTypes(data.surferType);
    List<String> footstyleTypeList = FootstyleTypes.getTypes();
    return ok(ManageSurfer.render("ManageSurfer", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData, surferTypeMap, footstyleTypeList, SurferDB.getSurfers()));
  }
  
  /**
   * Handles the posting of form data by the user.
   * @return The ManageSurfer page with form data.
   */
  public static Result postSurfer() {
    Form<SurferFormData> formData = Form.form(SurferFormData.class).bindFromRequest();
    
    /* Important to understand: Whenever we invoke bindFromRequest(), if there is a validation() method in the
     * associated object's class (in this case, SurferFormData) that implements the form, it will call that validation
     * method and annotate that object with information about any found errors (We see that the validate() method
     * returns either null or a list of ValidationErrors). We can then check if the formData object contains any errors
     * by calling the hasErrors() method, as seen below.
     * 
     * Also remember: We cannot call the get() method if there are errors in the formData object, so we put it in the
     * else clause.
     */
    if (formData.hasErrors()) {
      //Create empty surferTypeMap
      Map<String, Boolean> surferTypeMap = SurferTypes.getTypes();
      List<String> footstyleTypeList = FootstyleTypes.getTypes();
      return badRequest(ManageSurfer.render("ManageSurfer", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData, surferTypeMap, footstyleTypeList, SurferDB.getSurfers()));
    }
    else {
      SurferFormData data = formData.get(); //Creates the object we made (SurferFormData) and fills with get data
      
      //Create Update event. Note, should consider moving this to SurferDB addSurfer method
      if (!SurferDB.slugExists(data.slug)) { //If slug does not exist yet in DB, it must be a new event
        UpdateDB.addUpdate("Create", data.name);
      }
      else {
        UpdateDB.addUpdate("Edit", data.name);
      }
      
      //Add to database
      SurferDB.addSurfer(data);
      
      Map<String, Boolean> surferTypeMap = SurferTypes.getTypes(data.surferType);
      List<String> footstyleTypeList = FootstyleTypes.getTypes();
      return ok(ManageSurfer.render("ManageSurfer", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData, surferTypeMap, footstyleTypeList, SurferDB.getSurfers()));
    }
    
  }
  
  /**
   * Returns the surfer bio page.
   * @param slug The slug of surfer..
   * @return The requested surfer bio page.
   */
  public static Result getSurfer(String slug) {
    return ok(ShowSurfer.render("ShowSurfer", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), SurferDB.getSurfer(slug), SurferDB.getSurfers()));
  }
  
  /**
   * Deletes requested Surfer from database.
   * @param slug The slug of the Surfer to delete.
   * @return The index page.
   */
  @Security.Authenticated(Secured.class)
  public static Result deleteSurfer(String slug) {
    SurferDB.deleteSurfer(slug);
    //Note, UpdateDB delete event is done in SurferDB.deleteSurfer() method. Could also move that code here...
    
    return ok(Index.render("Home", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), SurferDB.getSurfers()));
  }
  
  /**
   * Returns the updates page.
   * @return The updates page.
   */
  @Security.Authenticated(Secured.class)
  public static Result getUpdates() {
    return ok(Updates.render("Updates", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), UpdateDB.getUpdates(), SurferDB.getSurfers()));
  }
  
  
  /**
   * Provides the Login page (only to unauthenticated users). 
   * @return The Login page. 
   */
  public static Result login() {
    Form<LoginFormData> formData = Form.form(LoginFormData.class);
    return ok(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData, SurferDB.getSurfers()));
  }

  /**
   * Processes a login form submission from an unauthenticated user. 
   * First we bind the HTTP POST data to an instance of LoginFormData.
   * The binding process will invoke the LoginFormData.validate() method.
   * If errors are found, re-render the page, displaying the error data. 
   * If errors not found, render the page with the good data. 
   * @return The index page with the results of validation. 
   */
  public static Result postLogin() {

    // Get the submitted form data from the request object, and run validation.
    Form<LoginFormData> formData = Form.form(LoginFormData.class).bindFromRequest();

    if (formData.hasErrors()) {
      flash("error", "Login credentials not valid.");
      return badRequest(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData, SurferDB.getSurfers()));
    }
    else {
      // email/password OK, so now we set the session variable and only go to authenticated pages.
      session().clear();
      session("email", formData.get().email);
      return redirect(routes.Application.index());
    }
  }
  
  /**
   * Logs out (only for authenticated users) and returns them to the Index page. 
   * @return A redirect to the Index page. 
   */
  @Security.Authenticated(Secured.class)
  public static Result logout() {
    session().clear();
    return redirect(routes.Application.index());
  }
}
