package models;

import java.util.List;
import views.formdata.SurferFormData;

/**
 * A simple in-memory repository/database for Surfer data.
 * 
 * @author Dave
 * 
 */
public class SurferDB {

  /**
   * Adds or edits a Surfer object to the database.
   * 
   * @param formData The surfer data.
   * @return The newly created surfer.
   */
  public static Surfer addSurfer(SurferFormData formData) {

    Surfer surfer = getSurfer(formData.slug);
    if (surfer != null) {
      surfer.setName(formData.name);
      surfer.setHome(formData.home);
      surfer.setAwards(formData.awards);
      surfer.setCarouselImgUrl(formData.carouselImgUrl);
      surfer.setBioImgUrl(formData.bioImgUrl);
      surfer.setBiography(formData.biography);
      surfer.setSurferType(formData.surferType);
      surfer.setIsEditable(formData.isEditable);
      surfer.setFootstyleType(formData.footstyleType);
    }
    else {
      surfer =
          new Surfer(formData.slug, formData.name, formData.home, formData.awards, formData.carouselImgUrl,
              formData.bioImgUrl, formData.biography, formData.surferType, formData.isEditable, formData.footstyleType);
    }
    surfer.save();

    return surfer;
  }

  /**
   * Checks if Surfer slug already exists.
   * 
   * @param slug The Surfer slug.
   * @return True if slug exists, False otherwise.
   */
  public static boolean slugExists(String slug) {
    return Surfer.find().where().eq("slug", slug).findUnique() != null;
  }

  /**
   * Returns a Surfer instance associated with the passed slug.
   * 
   * @param slug The slug.
   * @return The retrieved Surfer object.
   */
  public static Surfer getSurfer(String slug) {
    return Surfer.find().where().eq("slug", slug).findUnique();
  }

  /**
   * Returns a list containing all defined surfers.
   * 
   * @return A list of Surfer objects.
   */
  public static List<Surfer> getSurfers() {
    return Surfer.find().all();
  }

  /**
   * Deletes the specified surfer.
   * 
   * @param slug The slug associated with the surfer to delete.
   */
  public static void deleteSurfer(String slug) {
    Surfer surfer = getSurfer(slug);
    if (surfer != null) {
      surfer.delete();
    }
  }
}
