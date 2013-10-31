package controllers;

import java.util.List;
import java.util.Map;
import models.SurferDB;
import models.UpdateDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.FootstyleTypes;
import views.formdata.SurferFormData;
import views.formdata.SurferTypes;
import views.html.Index;
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
    return ok(Index.render(SurferDB.getSurfers()));
  }
  
  /**
   * Returns the ManageSurfer page with empty form fields. For creating new Surfers.
   * @return The ManageSurfer page.
   */
  public static Result newSurfer() {
    SurferFormData data = new SurferFormData(); //Create empty surferFormData object
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data); //Then fill it with form data.
    Map<String, Boolean> surferTypeMap = SurferTypes.getTypes(data.surferType); //Note: I think we can use empty param.
    List<String> footstyleTypeList = FootstyleTypes.getTypes();
    return ok(ManageSurfer.render(formData, surferTypeMap, footstyleTypeList, SurferDB.getSurfers()));
  }
  
  /**
   * Returns the ManageSurfer page with pre-filled form fields. For editing existing Surfers.
   * @param slug The slug.
   * @return The ManageSurfer page.
   */
  public static Result manageSurfer(String slug) {
    SurferFormData data = new SurferFormData(SurferDB.getSurfer(slug)); //Create new but existing surferFormData object
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    Map<String, Boolean> surferTypeMap = SurferTypes.getTypes(data.surferType);
    List<String> footstyleTypeList = FootstyleTypes.getTypes();
    return ok(ManageSurfer.render(formData, surferTypeMap, footstyleTypeList, SurferDB.getSurfers()));
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
      return badRequest(ManageSurfer.render(formData, surferTypeMap, footstyleTypeList, SurferDB.getSurfers()));
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
      return ok(ManageSurfer.render(formData, surferTypeMap, footstyleTypeList, SurferDB.getSurfers()));
    }
    
  }
  
  /**
   * Returns the surfer bio page.
   * @param slug The slug of surfer..
   * @return The requested surfer bio page.
   */
  public static Result getSurfer(String slug) {
    return ok(ShowSurfer.render(SurferDB.getSurfer(slug), SurferDB.getSurfers()));
  }
  
  /**
   * Deletes requested Surfer from database.
   * @param slug The slug of the Surfer to delete.
   * @return The index page.
   */
  public static Result deleteSurfer(String slug) {
    SurferDB.deleteSurfer(slug);
    //Note, UpdateDB delete event is done in SurferDB.deleteSurfer() method. Could also move that code here...
    
    return ok(Index.render(SurferDB.getSurfers()));
  }
  
  /**
   * Returns the updates page.
   * @return The updates page.
   */
  public static Result getUpdates() {
    return ok(Updates.render(UpdateDB.getUpdates(), SurferDB.getSurfers()));
  }
}
