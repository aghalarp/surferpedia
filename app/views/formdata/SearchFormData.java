package views.formdata;

import java.util.ArrayList;
import java.util.List;
import play.data.validation.ValidationError;

/**
 * Backing class for the login form.
 */
public class SearchFormData {

  /** The submitted name. */
  public String name = "";
  /** The submitted gender (named surferType in Surfer object). */
  public String gender = "";
  /** The submitted country. */
  public String country = "";

  /** Required for form instantiation. */
  public SearchFormData() {
  }

  /**
   * Validates Form<SearchFormData>. Called automatically in the controller by bindFromRequest().
   * 
   * @return Null if valid, or a List[ValidationError] if problems found.
   */
  public List<ValidationError> validate() {

    List<ValidationError> errors = new ArrayList<>();
    
    if (gender == null || gender.length() == 0) {
      errors.add(new ValidationError("gender", "Gender is required"));
    }
    
    if (country == null || country.length() == 0) {
      errors.add(new ValidationError("country", "Country is required"));
    }

    return (errors.size() > 0) ? errors : null;
  }

}
