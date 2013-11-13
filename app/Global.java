import models.SurferDB;
import models.UpdateDB;
import play.Application;
import play.GlobalSettings;
import views.formdata.SurferFormData;

/**
 * Provides initialization code for the Surferpedia application.
 * @author Dave
 *
 */
public class Global extends GlobalSettings {
  
  /**
   * Initialize the system with some sample contacts.
   * @param app The application.
   */
  public void onStart(Application app) {
    SurferDB.addSurfer(new SurferFormData("adrianodesouza", "Adriano De Souza", "Sau Paulo, Brazil", "Rip Curl Pro Bells Beach (2013), Rip Curl Pro Portugal (2011), Billabong Pro Rio (2011)", "http://tribalpoint.com.br/facecms/uploads/galeria/pj_1304093313.jpg", "http://dawf3zk2mt55y.cloudfront.net/wp-content/uploads/2011/01/Profile-Adriano-Desouza.jpg", "Adriano De Souza rode his first wave at eight years old and eight years later the surf world would take notice of this young, talented surfer at the Billabong ASP World Junior Championships. At the 2004 event, he defeated opponents four years his senior and was named the youngest ASP World Junior Champion ever at 16. Spectators observed his fast, energetic surfing and he quickly became known as one of the most exciting surfers to watch. In 2005, he won the ASP WQS by the widest margin in history. That win took him into his first year on the ASP World Tour where he finished an impressive 18th in the world. Although his style is more conducive to smaller beachbreaks, he is showing his competitors that he can also handle big wave surf, giving his country hope that he has what it takes to transition from a junior champion to something much more. To date, he's one of the most ferocious competitors the sport has ever seen and it shows in the ratings, with consistent top 10 overall finishes since 2008, positioning himself as a serious contender for a world title.", "Male", true, "Regular"));
    UpdateDB.addUpdate("Create", "Adriano De Souza");
    
    SurferDB.addSurfer(new SurferFormData("serenabrooke", "Serena Brooke", "Coolangatta Queensland, Australia", "Billabong Pro Australia, 1995 Women's Rookie of the Year", "http://3.bp.blogspot.com/-ayVU8U4xE_w/T9-cGiDXA3I/AAAAAAAABgo/phpoxj3jlh4/s1600/serenaIndo3.jpg", "http://www.news.saltwater-dreaming.com/modules/xcgal/albums/ASP/serena-brooke.jpg", "Brooke began to compete in amateur competitions in 1990 where she was crowned the Queensland amateur surfing title as well as the Australian National Title. Following her graduation from high school in 1995 she entered the pro ranks and finished her rookie season with a #13 overall ranking on the woman's tour. She was named the 1995 Women's Rookie of the Year. Among her notable accomplishments was winning the Billabong Pro Australia title and achieving a temporary #1 overall ranking in 2001. She would finish with #2 ranking twice on the World Championship Tour (WCT). Serena Brooke is one of the most marketable athletes in woman's surfing having garnered numerous sponsorships including Angel Eyewear and Bud Light. In 2001 she starred in the surfing documentary 7 Girls, and has also starred in numerous surfing videos and occasionally holds surfing camps for children looking to learn how to surf. In 2001, she established the Serena Brooke Charity Foundation. The foundation, which was created in Huntington Beach, California, helps raise money for the Orange County Child Abuse Prevention Center, CSP Youth Centers, Breast Cancer Research, and the Surfrider Foundation among others. The highlight of the year for the foundation is the Serena Brooke Charity Day held in Huntington Beach.", "Female", true, "Goofy"));
    UpdateDB.addUpdate("Create", "Serena Brooke");
    
    SurferDB.addSurfer(new SurferFormData("elliotivarra", "Elliot Ivarra", "Saint Barthelemy", "Quiksilver King of the Groms", "http://farm9.staticflickr.com/8177/8071333879_f8f9567017_b.jpg", "http://static.quiksilver-europe.com/www/quiksilverlive.com/html/upload/kotg2012/riders/__ID-33--5-elliotivarra.jpg", "Elliot Ivarra, 16, was born in Saint Martin, but lives in Saint Barthelemy Island. French surfer Elliot Ivarra won the European final of the Quiksilver King of the Groms in 3 feet fun waves at Ericeira, Portugal. The young french surfer had won his ticket for the Quiskslver King Of the Groms Euro Final thanks to his first place in trials yesterday. This place allowed him to compete in the main event. In Ericeira, the Frenchman ruled this final heat of competition with several backside tricks scoring to fun waves 5.83 pts then a last one 7.43 pts for a final score of 13.50 pts. His domination upon Europe's best 16 and under surfers was unquestionable even if the young French kid Nomme Mignot battled hard for the crown until the very last seconds of the heat. As he was leading the final, Nomme, from Surfing French Team, let Elliot the victory. None the less, both of them will fly to France to take part to the Quiksilver King of the Groms International final to be held during the Quiksilver Pro France - an ASP World Tour event- (From September 27th to October 8th) gathering the world's best surfers on the Landes coast. An extraordinary experience for these two groms.", "Grom", true, "Goofy"));
    UpdateDB.addUpdate("Create", "Elliot Ivarra");
  } 
}
