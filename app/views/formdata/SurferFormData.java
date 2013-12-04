package views.formdata;

import java.util.ArrayList;
import java.util.List;
import models.Surfer;
import models.SurferDB;
import play.data.validation.ValidationError;

/**
 * Backing class for form data.
 * 
 * @author Dave
 * 
 */
public class SurferFormData {

  /** The slug form field. */
  public String slug = "";
  /** The name form field. */
  public String name = "";
  /** The home form field. */
  public String home = "";
  /** The awards form field. */
  public String awards = "";
  /** The carouselImgUrl form field. */
  public String carouselImgUrl = "";
  /** The bioImgUrl form field. */
  public String bioImgUrl = "";
  /** The biography form field. */
  public String biography = "";
  /** The surferType form field. */
  public String surferType = "";
  /** The isEditable hidden form field. For seeing if allowed to edit */
  public boolean isEditable = false;
  /** The footstyleType form field. */
  public String footstyleType = "";
  /** The country form field. */
  public String country = "";

  /**
   * Default constructor, required by Play.
   */
  public SurferFormData() {
    // Nothing needed.
  }

  /**
   * Constructs a SurferFormData object manually. Currently only used by Global.java to create initial Surfers on
   * application startup. NOTE: This doesn't currently check if slug already exists. Use with care.
   * 
   * @param slug The slug. Serves as the unique id of a Surfer.
   * @param name The name of the surfer.
   * @param home Where the surfer is from.
   * @param awards Titles and various surfing awards.
   * @param carouselImgUrl The URL to the image to be used in the carousel.
   * @param bioImgUrl The URL to the image to be used in the surfer biography page.
   * @param biography The biography text.
   * @param surferType Set to Male, Female, or Grom.
   * @param isEditable Indicates if Surfer is editable.
   * @param footstyleType Either Regular or Goofy.
   */
  public SurferFormData(String slug, String name, String home, String awards, String carouselImgUrl, String bioImgUrl,
      String biography, String surferType, Boolean isEditable, String footstyleType, String country) {

    this.slug = slug;
    this.name = name;
    this.home = home;
    this.awards = awards;
    this.carouselImgUrl = carouselImgUrl;
    this.bioImgUrl = bioImgUrl;
    this.biography = biography;
    this.surferType = surferType;
    this.isEditable = isEditable;
    this.footstyleType = footstyleType;
    this.country = country;
  }

  /**
   * Create a SurferFormData object based upon a Surfer.
   * 
   * @param surfer The surfer.
   */
  public SurferFormData(Surfer surfer) {
    this.slug = surfer.getSlug();
    this.name = surfer.getName();
    this.home = surfer.getHome();
    this.awards = surfer.getAwards();
    this.carouselImgUrl = surfer.getCarouselImgUrl();
    this.bioImgUrl = surfer.getBioImgUrl();
    this.biography = surfer.getBiography();
    this.surferType = surfer.getSurferType();
    this.isEditable = surfer.getIsEditable();
    this.footstyleType = surfer.getFootstyleType();
    this.country = surfer.getCountry();
  }

  /**
   * Validates the form input by the user. The following fields must be non-empty: Name, Home, Carousel URL, Bio URL,
   * Biography. The Awards field is optional. It can be empty. The Slug field must be alphanumeric, and must be unique.
   * The SurferType field must be either "Male", "Female", or "Grom". The footstyleType field must be either "Regular"
   * or "Goofy".
   * 
   * 
   * @return null if no errors, list of ValidationErrors if errors.
   */

  public List<ValidationError> validate() {

    List<ValidationError> errors = new ArrayList<>();

    if (slug == null || slug.length() == 0) {
      errors.add(new ValidationError("slug", "Slug is required"));
    }

    if (!slug.matches("^[a-zA-Z0-9]+$")) { // Checks if string is alphanumeric. Also checks if string is empty.
      errors.add(new ValidationError("slug", "Slug must only contain letters and digits."));
    }

    if (SurferDB.slugExists(slug) && isEditable == false) {
      errors.add(new ValidationError("slug", "Slug already exists"));
    }

    if (name == null || name.length() == 0) {
      errors.add(new ValidationError("name", "Name is required"));
    }

    if (home == null || home.length() == 0) {
      errors.add(new ValidationError("home", "Home is required"));
    }

    if (carouselImgUrl == null || carouselImgUrl.length() == 0) {
      errors.add(new ValidationError("carouselImgUrl", "Carousel Url is required"));
    }

    if (bioImgUrl == null || bioImgUrl.length() == 0) {
      errors.add(new ValidationError("bioImgUrl", "Bio URL is required"));
    }

    if (biography == null || biography.length() == 0) {
      errors.add(new ValidationError("biography", "Biography is required"));
    }

    if (!SurferTypes.isType(surferType)) {
      errors.add(new ValidationError("surferType", "Surfer type is invalid."));
    }

    if (!FootstyleTypes.isType(footstyleType)) {
      errors.add(new ValidationError("footstyleType", "Footstyle type is invalid."));
    }

    if (isEditable == false && errors.isEmpty()) {
      isEditable = true;
    }

    return errors.isEmpty() ? null : errors;
  }

}
