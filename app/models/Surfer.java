package models;

/**
 * Surfer class.
 * @author Dave
 *
 */
public class Surfer {
  private String slug; //Serves as unique id
  private String name;
  private String home;
  private String awards;
  private String carouselImgUrl;
  private String bioImgUrl;
  private String biography;
  private String surferType; //Male, Female, or Grom
  private Boolean isEditable;
  
  
  /**
   * Creates a new Surfer.
   * 
   * @param slug The slug. Serves as the unique id of a Surfer.
   * @param name The name of the surfer.
   * @param home Where the surfer is from.
   * @param awards Titles and various surfing awards.
   * @param carouselImgUrl The URL to the image to be used in the carousel.
   * @param bioImgUrl The URL to the image to be used in the surfer biography page.
   * @param biography The biography text.
   * @param surferType Set to Male, Female, or Grom.
   * @param isEditable If surfer is editable.
   */
  public Surfer(String slug, String name, String home, String awards, String carouselImgUrl, String bioImgUrl, 
                 String biography, String surferType, Boolean isEditable) {
    
    this.slug = slug;
    this.name = name;
    this.home = home;
    this.awards = awards;
    this.carouselImgUrl = carouselImgUrl;
    this.bioImgUrl = bioImgUrl;
    this.biography = biography;
    this.surferType = surferType;
    this.isEditable = isEditable;
  }
  
  
  /**
   * @return the slug
   */
  public String getSlug() {
    return slug;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }
  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }
  /**
   * @return the home
   */
  public String getHome() {
    return home;
  }
  /**
   * @param home the home to set
   */
  public void setHome(String home) {
    this.home = home;
  }
  /**
   * @return the awards
   */
  public String getAwards() {
    return awards;
  }
  /**
   * @param awards the awards to set
   */
  public void setAwards(String awards) {
    this.awards = awards;
  }
  /**
   * @return the carouselImgUrl
   */
  public String getCarouselImgUrl() {
    return carouselImgUrl;
  }
  /**
   * @param carouselImgUrl the carouselImgUrl to set
   */
  public void setCarouselImgUrl(String carouselImgUrl) {
    this.carouselImgUrl = carouselImgUrl;
  }
  /**
   * @return the bioImgUrl
   */
  public String getBioImgUrl() {
    return bioImgUrl;
  }
  /**
   * @param bioImgUrl the bioImgUrl to set
   */
  public void setBioImgUrl(String bioImgUrl) {
    this.bioImgUrl = bioImgUrl;
  }
  /**
   * @return the biography
   */
  public String getBiography() {
    return biography;
  }
  /**
   * @param biography the biography to set
   */
  public void setBiography(String biography) {
    this.biography = biography;
  }
  /**
   * @return the surferType
   */
  public String getSurferType() {
    return surferType;
  }
  /**
   * @param surferType the surferType to set
   */
  public void setSurferType(String surferType) {
    this.surferType = surferType;
  }


  /**
   * @return the isEditable
   */
  public Boolean getIsEditable() {
    return isEditable;
  }


  /**
   * @param isEditable the isEditable to set
   */
  public void setIsEditable(Boolean isEditable) {
    this.isEditable = isEditable;
  }
  
  
}
