package controllers;

import java.util.List;
import java.util.Map;
import models.Surfer;
import models.SurferDB;
import models.UserInfo;
import models.UserInfoDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.formdata.CountryTypes;
import views.formdata.FootstyleTypes;
import views.formdata.LoginFormData;
import views.formdata.SearchFormData;
import views.formdata.SignupFormData;
import views.formdata.SurferFormData;
import views.formdata.SurferTypes;
import views.html.Index;
import views.html.Login;
import views.html.ManageSurfer;
import views.html.ShowSurfer;
import views.html.ShowUser;
import views.html.Signup;
import views.html.SearchResults;

/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  public static String adminEmail;
  public static String adminPassword;

  /**
   * Returns the home page.
   * 
   * @return The resulting home page.
   */
  public static Result index() {
    List<String> countryTypeList = CountryTypes.getTypes();
    Form<SearchFormData> searchFormData = Form.form(SearchFormData.class).fill(new SearchFormData());

    return ok(Index.render("Home", Secured.isLoggedIn(ctx()), Secured.isAdmin(ctx()), Secured.getUserInfo(ctx()),
        SurferDB.random(3), countryTypeList, searchFormData));
  }

  /**
   * Returns the ManageSurfer page with empty form fields. For creating new Surfers.
   * 
   * @return The ManageSurfer page.
   */
  @Security.Authenticated(Secured.class)
  public static Result newSurfer() {
    SurferFormData data = new SurferFormData(); // Create empty surferFormData object
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data); // Then fill it with form data.
    Map<String, Boolean> surferTypeMap = SurferTypes.getTypes(data.surferType); // Note: I think we can use empty param.
    List<String> footstyleTypeList = FootstyleTypes.getTypes();
    List<String> countryTypeList = CountryTypes.getTypes();
    Form<SearchFormData> searchFormData = Form.form(SearchFormData.class).fill(new SearchFormData());
    return ok(ManageSurfer.render("NewSurfer", Secured.isLoggedIn(ctx()), Secured.isAdmin(ctx()),
        Secured.getUserInfo(ctx()), formData, surferTypeMap, footstyleTypeList, countryTypeList, searchFormData));
  }

  /**
   * Returns the ManageSurfer page with pre-filled form fields. For editing existing Surfers.
   * 
   * @param slug The slug.
   * @return The ManageSurfer page.
   */
  @Security.Authenticated(Secured.class)
  public static Result manageSurfer(String slug) {
    SurferFormData data = new SurferFormData(SurferDB.getSurfer(slug)); // Create new but existing surferFormData object
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    Map<String, Boolean> surferTypeMap = SurferTypes.getTypes(data.surferType);
    List<String> footstyleTypeList = FootstyleTypes.getTypes();
    List<String> countryTypeList = CountryTypes.getTypes();
    Form<SearchFormData> searchFormData = Form.form(SearchFormData.class).fill(new SearchFormData());

    return ok(ManageSurfer.render("EditSurfer", Secured.isLoggedIn(ctx()), Secured.isAdmin(ctx()),
        Secured.getUserInfo(ctx()), formData, surferTypeMap, footstyleTypeList, countryTypeList, searchFormData));
  }

  /**
   * Handles the posting of form data by the user.
   * 
   * @return The ManageSurfer page with form data.
   */
  public static Result postSurfer() {
    Form<SurferFormData> formData = Form.form(SurferFormData.class).bindFromRequest();

    /*
     * Important to understand: Whenever we invoke bindFromRequest(), if there is a validation() method in the
     * associated object's class (in this case, SurferFormData) that implements the form, it will call that validation
     * method and annotate that object with information about any found errors (We see that the validate() method
     * returns either null or a list of ValidationErrors). We can then check if the formData object contains any errors
     * by calling the hasErrors() method, as seen below.
     * 
     * Also remember: We cannot call the get() method if there are errors in the formData object, so we put it in the
     * else clause.
     */
    if (formData.hasErrors()) {
      // Create empty surferTypeMap
      Map<String, Boolean> surferTypeMap = SurferTypes.getTypes();
      List<String> footstyleTypeList = FootstyleTypes.getTypes();
      List<String> countryTypeList = CountryTypes.getTypes();
      Form<SearchFormData> searchFormData = Form.form(SearchFormData.class).fill(new SearchFormData());
      return badRequest(ManageSurfer.render("ManageSurfer", Secured.isLoggedIn(ctx()), Secured.isAdmin(ctx()),
          Secured.getUserInfo(ctx()), formData, surferTypeMap, footstyleTypeList, countryTypeList, searchFormData));
    }
    else {
      SurferFormData data = formData.get(); // Creates the object we made (SurferFormData) and fills with get data
      // Add to database
      SurferDB.addSurfer(data);
      return redirect("/surfer/" + data.slug + "/edit");
    }
  }

  /**
   * Returns the surfer bio page.
   * 
   * @param slug The slug of surfer..
   * @return The requested surfer bio page.
   */
  public static Result getSurfer(String slug) {
    List<String> countryTypeList = CountryTypes.getTypes();
    Form<SearchFormData> searchFormData = Form.form(SearchFormData.class).fill(new SearchFormData());

    return ok(ShowSurfer.render("ShowSurfer", Secured.isLoggedIn(ctx()), Secured.isAdmin(ctx()),
        Secured.getUserInfo(ctx()), SurferDB.getSurfer(slug), countryTypeList, searchFormData));
  }

  /**
   * Deletes requested Surfer from database.
   * 
   * @param slug The slug of the Surfer to delete.
   * @return The index page.
   */
  @Security.Authenticated(Secured.class)
  public static Result deleteSurfer(String slug) {
    SurferDB.deleteSurfer(slug);
    return redirect("/");
  }

  /**
   * Provides the Login page (only to unauthenticated users).
   * 
   * @return The Login page.
   */
  public static Result login() {
    Form<LoginFormData> formData = Form.form(LoginFormData.class);
    List<String> countryTypeList = CountryTypes.getTypes();
    Form<SearchFormData> searchFormData = Form.form(SearchFormData.class).fill(new SearchFormData());

    return ok(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.isAdmin(ctx()), Secured.getUserInfo(ctx()),
        formData, countryTypeList, searchFormData));
  }

  /**
   * Processes a login form submission from an unauthenticated user. First we bind the HTTP POST data to an instance of
   * LoginFormData. The binding process will invoke the LoginFormData.validate() method. If errors are found, re-render
   * the page, displaying the error data. If errors not found, render the page with the good data.
   * 
   * @return The index page with the results of validation.
   */
  public static Result postLogin() {
    // Get the submitted form data from the request object, and run validation.
    Form<LoginFormData> formData = Form.form(LoginFormData.class).bindFromRequest();

    if (formData.hasErrors()) {
      flash("error", LoginFormData.ERROR_TEXT);
      List<String> countryTypeList = CountryTypes.getTypes();
      Form<SearchFormData> searchFormData = Form.form(SearchFormData.class).fill(new SearchFormData());

      return badRequest(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.isAdmin(ctx()),
          Secured.getUserInfo(ctx()), formData, countryTypeList, searchFormData));
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
   * 
   * @return A redirect to the Index page.
   */
  @Security.Authenticated(Secured.class)
  public static Result logout() {
    session().clear();
    return redirect(routes.Application.index());
  }

  /**
   * Processes search form.
   * 
   * @return The search result page.
   */
  public static Result postSearchForm() {
    Form<SearchFormData> searchFormData = Form.form(SearchFormData.class).bindFromRequest();
    List<String> countryTypeList = CountryTypes.getTypes();

    if (searchFormData.hasErrors()) {
      throw new RuntimeException("This should never happen. Grats!");
    }
    else {
      List<Surfer> searchResultList =
          SurferDB.surferSearch(searchFormData.get().name, searchFormData.get().gender, searchFormData.get().country);
      return ok(SearchResults.render("SearchResults", Secured.isLoggedIn(ctx()), Secured.isAdmin(ctx()),
          Secured.getUserInfo(ctx()), searchResultList, countryTypeList, searchFormData, 4));
    }
  }

  /**
   * Displays the signup page.
   * 
   * @return Signup page.
   */
  public static Result signup() {
    Form<SignupFormData> formData = Form.form(SignupFormData.class);
    List<String> countryTypeList = CountryTypes.getTypes();
    Form<SearchFormData> searchFormData = Form.form(SearchFormData.class).fill(new SearchFormData());

    return ok(Signup.render("Signup", Secured.isLoggedIn(ctx()), Secured.isAdmin(ctx()), Secured.getUserInfo(ctx()),
        formData, countryTypeList, searchFormData));
  }

  /**
   * Processes the signup page.
   * 
   * @return Signup page on fail, Login page on success.
   */
  public static Result postSignup() {
    Form<SignupFormData> formData = Form.form(SignupFormData.class).bindFromRequest();

    if (formData.hasErrors()) {
      flash("error", SignupFormData.ERROR_TEXT);
      List<String> countryTypeList = CountryTypes.getTypes();
      Form<SearchFormData> searchFormData = Form.form(SearchFormData.class).fill(new SearchFormData());

      return badRequest(Signup.render("Signup", Secured.isLoggedIn(ctx()), Secured.isAdmin(ctx()),
          Secured.getUserInfo(ctx()), formData, countryTypeList, searchFormData));
    }
    else {
      // email/password OK, so now we set the session variable and only go to authenticated pages.
      UserInfoDB.addUserInfo(UserInfoDB.STANDARD, formData.get().email, formData.get().password);
      flash("success", SignupFormData.SUCCESS_TEXT);
      return redirect(routes.Application.login());
    }
  }

  /**
   * Displays the user profile page.
   * 
   * @param email user's email.
   * @return ShowUser page.
   */
  public static Result getUser(String email) {

    UserInfo userInfo = UserInfoDB.getUser(email);
    if (userInfo == null || userInfo.getType() == UserInfoDB.ADMIN) {
      return redirect(routes.Application.index());
    }

    List<String> countryTypeList = CountryTypes.getTypes();
    Form<SearchFormData> searchFormData = Form.form(SearchFormData.class).fill(new SearchFormData());

    return ok(ShowUser.render("ShowUser", Secured.isLoggedIn(ctx()), Secured.isAdmin(ctx()),
        Secured.getUserInfo(ctx()), userInfo, SurferDB.random(3), countryTypeList, searchFormData));
  }

  /**
   * Favorites/Unfavorites the surfer.
   * 
   * @param slug   Slug of the Surfer
   * @param origin The page that invoked this action
   * @return ShowSurfer or ShowUser page
   */
  public static Result favorite(String slug, String origin) {
    if (Secured.isLoggedIn(ctx()) && !Secured.isAdmin(ctx())) {
      UserInfoDB.favoriteSurfer(Secured.getUserInfo(ctx()), slug);
    }
    System.out.println(origin);
    if (origin.equals("ShowUser")) {
      return redirect(routes.Application.getUser(Secured.getUser(ctx())));
    }
    else {
      return redirect(routes.Application.getSurfer(slug));
    }
  }
}
