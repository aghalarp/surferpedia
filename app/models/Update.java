package models;

/**
 * Update class. Used with UpdateDB to keep track of creation, deletion, and edit events of Surfers.
 * @author Dave
 *
 */
public class Update {
  private long id;
  private String date;
  private String action;
  private String surfer;
  
  
  /**
   * Creates a new update event.
   * @param id The id.
   * @param date The date of event.
   * @param action The action (either create, edit, or delete).
   * @param surfer The surfer's name;
   */
  public Update(long id, String date, String action, String surfer) {
    this.id = id;
    this.date = date;
    this.action = action;
    this.surfer = surfer;
  }
  
  
  /**
   * @return the id
   */
  public long getId() {
    return id;
  }
  /**
   * @param id the id to set
   */
  public void setId(long id) {
    this.id = id;
  }
  /**
   * @return the date
   */
  public String getDate() {
    return date;
  }
  /**
   * @param date the date to set
   */
  public void setDate(String date) {
    this.date = date;
  }
  /**
   * @return the action
   */
  public String getAction() {
    return action;
  }
  /**
   * @param action the action to set
   */
  public void setAction(String action) {
    this.action = action;
  }
  /**
   * @return the surfer
   */
  public String getSurfer() {
    return surfer;
  }
  /**
   * @param surfer the surfer to set
   */
  public void setSurfer(String surfer) {
    this.surfer = surfer;
  }
  
  
}
