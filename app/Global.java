import models.SurferDB;
import models.UserInfoDB;
import controllers.Application;
import play.GlobalSettings;
import play.Play;
import views.formdata.SurferFormData;

/**
 * Provides initialization code for the Surferpedia application.
 * 
 * @author Dave
 * 
 */
public class Global extends GlobalSettings {

  /**
   * Initialize the system with some sample contacts.
   * 
   * @param app The application.
   */
  public void onStart(play.Application app) {

    Application.adminEmail = Play.application().configuration().getString("admin.email");
    Application.adminPassword = Play.application().configuration().getString("admin.password");

    if (Application.adminEmail == null) {
      System.err.println("The admin email environmental variable was not set correctly.");
    }
    if (Application.adminPassword == null) {
      System.err.println("The admin password environmental variable was not set correctly.");
    }

    UserInfoDB.addUserInfo(UserInfoDB.ADMIN, Application.adminEmail, Application.adminPassword);

    if (SurferDB.getSurfers().isEmpty()) {
      // Males
      SurferDB
          .addSurfer(new SurferFormData(
              "adrianodesouza",
              "Adriano De Souza",
              "Sau Paulo, Brazil",
              "Rip Curl Pro Bells Beach (2013), Rip Curl Pro Portugal (2011), Billabong Pro Rio (2011)",
              "http://tribalpoint.com.br/facecms/uploads/galeria/pj_1304093313.jpg",
              "http://dawf3zk2mt55y.cloudfront.net/wp-content/uploads/2011/01/Profile-Adriano-Desouza.jpg",
              "Adriano De Souza rode his first wave at eight years old and eight years later the surf world would take notice of this young, talented surfer at the Billabong ASP World Junior Championships. At the 2004 event, he defeated opponents four years his senior and was named the youngest ASP World Junior Champion ever at 16. Spectators observed his fast, energetic surfing and he quickly became known as one of the most exciting surfers to watch. In 2005, he won the ASP WQS by the widest margin in history. That win took him into his first year on the ASP World Tour where he finished an impressive 18th in the world. Although his style is more conducive to smaller beachbreaks, he is showing his competitors that he can also handle big wave surf, giving his country hope that he has what it takes to transition from a junior champion to something much more. To date, he's one of the most ferocious competitors the sport has ever seen and it shows in the ratings, with consistent top 10 overall finishes since 2008, positioning himself as a serious contender for a world title.",
              "Male", true, "Regular", "Brazil"));
      SurferDB
          .addSurfer(new SurferFormData(
              "cjhoood",
              "CJ Hobgood",
              "Melbourne, Florida",
              "2007 US Open of Surfing",
              "http://www.lat34.org/quick_hits/wp-content/uploads/2008/10/hobgood_cj8331mundaka08cestari_l.jpg",
              "http://image.surfingmagazine.com/f/news/surfing-profiles/31364595+w545+st0/2006-cj-hobgood-lrg.jpg",
              "C.J. entered his first surfing contest in 1989 and made the Open Boys final. He placed second in a national competition the following year. He won several other championships and in 1998 he was selected as the model for the new National Scholastic Surfing Association logo. In 1999, CJ was the Association Surfer Professionals Rookie of the Year. In 2001 he won the ASP World Championship. He currently resides in Satellite Beach, Florida with his wife and daughter, near his younger brother Travis, his younger sister Marissa, and his parents.",
              "Male", true, "Goofy", "USA"));
      SurferDB
          .addSurfer(new SurferFormData(
              "bobbymartinez",
              "Bobby Martinez",
              "Santa Barbara, California",
              "2009 Billabong Pro Tahiti",
              "http://cdn.surf.transworld.net/files/2009/05/19/bobby-martinez.jpg",
              "http://cdn.surf.transworld.net/wp-content/blogs.dir/443/files/2012/01/Bobby-Martinez.jpg",
              "Martinez began surfing at age 6. When he was old enough, he joined the National Scholastic Surfing Association (NSSA) where he went on to win a record seven national titles. After several injury prone years he joined the Association of Surfing Professionals in 2005. His first major title as a professional was the O'Neill Coldwater Classic in 2005. He joined the World Championship Tour in 2006, finishing the year with No. 5 ranking which earned him Rookie of the Year honors with wins in Teahupoo and Mundaka. He also won in Mundaka in 2007 and In May 2009, Bobby won the Billabong Pro Tahiti. On September 7, 2011 Bobby Martinez was suspended from the ASP. Disillusioned with a World No. 22 ranking that left him in danger of being relegated to surfing's second tier after this event, Martinez had already announced New York would be his swansong. While being interviewed after his heat he blasted officials during a publicly broadcast interview on Long Beach at the Quiksilver New York Pro. The outspoken Santa Barbara Surfer has been a long-time critic of the ASP's controversial rankings system, but his profane rant – streamed on beachside big screens and over the Internet live – left event organisers and ASP officials furious. On June 7, 2012, Bobby signed on with local Ventura Shop, Homegrown Surf Shop, after finding out that the owner was his long lost cousin.",
              "Male", true, "Goofy", "USA"));
      SurferDB
          .addSurfer(new SurferFormData(
              "cheynemagnusson",
              "Cheyne Magnusson",
              "Southern California, United States",
              "2000 Men's Hawaiian State Champion",
              "http://www.bodyglove.eu/wp-content/uploads/2011/08/17d6f000-bab2-6912-ca1b-4e580d1d0bf8.jpg",
              "http://4.bp.blogspot.com/_y_Md7TRzYZY/SRsT1-8Lu-I/AAAAAAAAAzI/7d6wzlh8jSY/s1600-h/Cheyne_5.jpg",
              "Cheyne Magnusson is a professional surfer and one of the stars of MTV's reality show Maui Fever. Magnusson was born in Southern California and moved to Hawaii with his family at the age of seven. His father, Tony Magnusson, was a professional skateboarder and co-founded the Osiris Shoes company. According to Cheyne's mother Jill, Cheyne could ride a skateboard before he could walk. At the age of sixteen, Magnusson was the 2000 Men's Hawaiian State Champion in surfing. In June of that year, he then represented the state of Hawaii in Brazil at the world championships—the highest honor an amateur surfer can receive. By the age of twenty-two, Cheyne was surfing professionally and was sponsored by Body Glove, Osiris Shoes, Dragon, and Chemistry Surfboards.",
              "Male", true, "Regular", "USA"));
      SurferDB
          .addSurfer(new SurferFormData(
              "jamieobrien",
              "Jamie O'Brien",
              "Haleiwa, Hawaii, USA",
              "2003 Hansen's Pipeline Pro",
              "http://beach.blog.ocregister.com/files/2010/09/jamie_obrien_by_steve_robe_1.jpg",
              "http://5ones.com/wp-content/uploads/2009/02/obrienbodyboard.jpg",
              "Jamie O'Brien was born on June 9, 1983 in Hawaii and currently lives in Haleiwa. He has said that he was fortunate as a child to grow up near the Banzai Pipeline. He is one of the youngest surfers ever to win a Pipe Masters challenge. Jamie's father was a life guard and Jamie has said that one of the things that got him interested in surfing was talking to many of the regular surfers on his dad's beach. Some of his contest accomplishments include the Pipeline Masters in 2001, which he took 4th place even after just recovering from a groin injury, and first place at the 2003 Hansen's Pipeline Pro in 2003 and first place in the 2004 Fosters Expression Trestles and Rip Curl Pipeline Masters. O'Brien produced two surfing films, Freakshow and Freaside. He has appeared in Step Into Liquid and Blue Crush. He has made television appearances on MTV's Boarding House/Stunt Surfer in 2005. Video and DVDs that he's been in include Waxed Planet in 2005, Raising the Bar, Super Computer, The Mystic, The Next Generation and alifragulistic in 2004. In 2005 he made Campaign 2 and in 2006 as previously mentioned Freakside. He received the Boost Breakthrough Performance Award at Surfer Magazine's Surfer Awards show in 2005.",
              "Male", true, "Regular", "USA"));
      SurferDB
          .addSurfer(new SurferFormData(
              "kellyslater",
              "Kelly Slater",
              "Cocoa Beach, Florida, USA",
              "11-Time ASP World Tour Champion",
              "http://stabmag.com/wp-content/uploads/2013/04/Kelly2.jpg",
              "http://www.athletepromotions.com/blog/wp-content/uploads/2013/08/kelly-slater.jpg",
              "Robert Kelly Slater (born February 11, 1972, Cocoa Beach, Florida, US) is an American professional surfer known for his competitive prowess and style. He has been crowned ASP World Tour Champion a record 11 times, including 5 consecutive titles from 1994–98. He is the youngest (at age 20) and the oldest (at age 39) to win the title. Upon winning his 5th world title in 1997, Slater passed Australian surfer Mark Richards to become the most successful champion in the history of the sport. In 2007 he also became the all-time leader in career event wins by winning the Boost Mobile Pro event at Lower Trestles near San Clemente, California. The previous record was held by Slater's childhood hero, 3-time world champion Tom Curren. In addition to the ASP tour, Slater has also competed in the X-Games (in 2003 and 2004). After earlier being awarded the title prematurely as a result of a miscalculation by the Association of Surfing Professionals(ASP), on November 6, 2011 Slater officially won his eleventh ASP world title at the Rip Curl Pro Search San Francisco, by winning his 4th round heat. In May 2005, in the final heat of the Billabong Tahiti Pro contest at Teahupo'o, Slater became the first surfer ever to be awarded two perfect scores for a total 20 out of 20 points under the ASP two-wave scoring system. (The corresponding honor under the previous three-wave system belongs to fellow American Shane Beschen who achieved the feat in 1996.) He did it again on June 2013 at the quarter finals at the Volcom Fiji Pro with two perfect ten waves, only the fourth person in history to do so. Since 1990, Slater has been sponsored primarily by surfwear industry giant Quiksilver. He exclusively rides Channel Islands surfboards equipped with his own signature series of FCS fins.",
              "Male", true, "Regular", "USA"));
      SurferDB
          .addSurfer(new SurferFormData(
              "markrichards",
              "Mark Richards",
              "Newcastle, New South Wales, Australia",
              "4 time ASP World Champion",
              "http://www.sandiegomagazine.com/images/2012/september/northcounty/trending/web_mark_richards2.jpg",
              "http://blog.visithunter.com.au/wp-content/uploads/2010/08/MarkRichards.jpg",
              "To surfers born after 1980, Mark Richards is just the old guy whose record Kelly Slater broke. But not long ago, MR had another title, that of the greatest surfer of all time. So dominant was he, that no one regarded him with anything but awe, even as he paddled out in a silver wetsuit with a Superman logo on his board. It's doubtful that even Kelly could pull that one off. Richards was born in Newcastle, Australia, the only child of a car salesman. He was surfing by age six at Mereweather Beach, and his dad's car dealership eventually transformed into a surf shop. His mom and dad surfed a bit themselves, but the majority of early inspiration came from Nat Young. On the Australian amateur circuit, Richards routinely surfed in and won the age group above his own. Never keen on traveling for surf, he'd rather go out at home in Mereweather no matter what the conditions. Professional surfing still hadn't been invented, so as Richards rose through the ranks, his only goal was an Australian Senior Title. In the groundbreaking winter of 1975, MR was on the front lines of the North Shore along with Shaun Tomson and Rabbit Bartholomew, as the limits of performance surfing were redefined. Riding Lightning Bolt single fins shaped by Tom Parrish, his wins in both the Smirnoff and the World Cup helped bust down the door of Hawaiian supremacy. Dubbed the 'Free Ride' generation after the 1977 film of the same name, their surfing marked the rise of Aussie dominance where the least brash on land, Richards, would take the most spoils in the water inside of a few short years.",
              "Male", true, "Regular", "Australia"));
      SurferDB
          .addSurfer(new SurferFormData(
              "martinpotter",
              "Martin Potter",
              "Sydney, Australia",
              "ASP World Champion 1989",
              "http://aaronchang.com/filestore/Potts_Backdoor.jpg",
              "http://02ff4cc.netsolhost.com/blog1/wp-content/uploads/2010/11/Martin-Potter-Pottz.jpg",
              "His parents emigrated to Durban, South Africa when he was 2 years old. He began surfing off the beaches of his hometown Durban at age 10. By the age of 15, he was surfing 20+ foot waves at the infamous “Banzai Pipeline” surf break located on Hawaii's North Shore. At the time, he was using the assistance of a jet-ski to 'tow-in' to the wave as an alternative to paddling. This pre-dated modern tow-in surfing and can help lay claim to Potter being one of 'tow-in' surfings pioneers. In his late teens his parents moved back to the UK to live. During this period Pottz was competing on the surfing world tour. He became a pro in 1981 and In 1989 after claiming 6 tour victories from 25 events he became World Surfing Champion. This would come fourteen years after learning to stand on a surfboard. 'Pottz' redefined competitive surfing through performing technically high-risk moves such as aerials (where a surfer is able to use the energy of a wave to launch themselves free of it together with their surfboard, and to land back down onto the water and continue on) and 360's (the surfer and surfboard rotate on a wave 360 degrees before continuing on), which were previously only performed in the domain of free surfing (as opposed to competitively). He was also responsible for the invention of several surfing maneuvers such as the rock-n-roll (the same as performed on a skateboard). From his success as a world champion, he led the call for a new form of competitive surfing; a judging format based on 'risky surfing' - i.e. higher scoring being given to bigger and more critical maneuvering - which eventually became an accepted standard on what is now known as the World Championship Tour (WCT).",
              "Male", true, "Regular", "Australia"));
      SurferDB
          .addSurfer(new SurferFormData(
              "mickfanning",
              "Mick Fanning",
              "Tweed Heads, New South Wales, Australia",
              "2007, 2009 and 2013 ASP World Champion",
              "http://31.media.tumblr.com/tumblr_m5du84thbv1rv3vi2o1_1280.jpg",
              "http://1991.lostenterprises.com/dev/images/news/Lost_fanning_Large.jpg",
              "He was born in Penrith, New South Wales, Australia on 13 June 1981 to Irish parents. Fanning learned to surf at the age of 5 in coastal South Australia at a town called Mt Gambier, but did not go full on until his family moved to Tweed Heads when he was twelve. He grew up with fellow professional surfer, Joel Parkinson and fellow ripper Nat West. On the edge of the Queensland border, Fanning had access to epic surf north and south and he began to make a name for himself. In 1996 he established himself as one the very best surfers to rule the Queensland points by placing in the top three at the Australian National Titles. He suffered a complete hamstring tear in 2004. He had to have it surgically repaired and made an incredible comeback to become one of the greatest surfers on the ASP world tour. The year 2007 marked Fanning's sixth year on the Association of Surfing Professionals (ASP) World Tour since 2002 and his ninth year on the ASP WQS since 1998. He began his 2007 World Title campaign (WCT) with a victory at the Quiksilver Pro, the first event on the Foster's ASP World Tour, putting himself on top of the ratings. He won the Santa Catarina Pro in Brazil on 6 November 2007 placing above Taj Burrow and Kelly Slater therefore clinching the 2007 ASP world title. In 2008 he suffered a mid-season groin injury. He slipped to eighth position on the end of year ratings. In 2009, Mick Fanning reclaimed his ASP World Champion crown at the famous Pipeline reef break on Oahu’s North Shore. Although Fanning was knocked out by fellow Australian Dean Morrison in Round 4, his points lead from winning three of the last four events was enough to secure victory. He then clinched it again in 2013 with a comeback victory in both round five, as well as the quarter-finals at Pipeline.",
              "Male", true, "Regular", "Australia"));
      SurferDB
          .addSurfer(new SurferFormData(
              "robmachado",
              "Rob Machado",
              "Encinitas, California",
              "Pipeline Masters, U.S. Open of Surfing",
              "http://www.dailystoke.com/wp-content/uploads/2009/04/robalaia-600.jpg",
              "http://progressive.kelbymediagroup.com/scottkelby/wp-content/uploads/2011/04/rob_machadosm.jpg",
              "Robert Edward Machado (better known simply as Rob Machado) (b. October 16, 1973 Sydney, Australia) is an Australian-born American professional surfer from Cardiff-by-the-Sea, a community in Encinitas (San Diego County), California. Machado attended San Dieguito High School, and is known for his casual, laid-back style both in and out of the water. Though he rides a modern tri-fin shortboard, he is still considered a soul-surfer largely because of his soft-spoken, humble personality and his disinterest in the spotlight, along with his fluid surfing style, which has earned him the nickname Mr. Smoothy. He is one of the best-known goofy-foot surfers in the world today. Rob has won many of pro surfing's most prestigious contests, including Hawaii's Pipeline Masters (Triple Crown of Surfing), and the U.S. Open of Surfing, the largest surfing event held on the U.S. mainland. His 2006 win in that competition was only his latest at Huntington Beach, and it came on the heels of his victory at the 2006 Monster Energy Pro (also held at Pipeline) on Oahu's North Shore. Also, Rob was on the 'West' team that won the 2006 Summer X Games surfing competition, called 'The Game,' held each year in Mexico.",
              "Male", true, "Goofy", "USA"));
      SurferDB
          .addSurfer(new SurferFormData(
              "sunnygarcia",
              "Sunny Garcia",
              "Sunset Beach, Oahu, Hawaii",
              "ASP WCT World Champion, 6 time Triple Crown of Surfing",
              "http://www.chrismceniry.com/data/photos/10_1img_9476.jpg",
              "http://the.honoluluadvertiser.com/dailypix/2003/Jun/26/hpa_b.jpg",
              "Since he was a kid, Sunny Garcia's dream has been to kick back as a fat, happy Hawaiian with a bunch of kids running around. That existence remained in jeopardy as the one prize that would make him content, a world title, eluded him 14 consecutive years. With the inspiration of a new love and a new fitness regimen, he kept a horde of challengers at bay and, at age 30, led the ASP tour from start to finish to run away with the 2000 crown. Growing up in Waianae, on Oahu's West Side, wasn't an easy task, even for a local. Vincent Sennen Garcia came from a broken home and found surfing as a refuge from fighting and poverty. He owned his division in the Hawaiian Surfing Association and jumped onto the tour at age 17, after dropping out of school. Inspired by the amazing comeback of 33-year-old Occy, the 1999 ASP world champion, Garcia shed 25 pounds and abandoned his beloved junk-food diet. Surfing faster and more consistently than ever, he won the first two events of the 2000 season in Australia and never relinquished his lead. Upon clinching the title in the penultimate event in Brazil, he was greatly relieved but not ready to hang it up. True to his word, the fierce fighter returned to the ring, making another WQS run in 2008. While he didn't make the WCT, he did find love again, marrying for a third time, and maintaining his strong presence on his home Hawaiian court.",
              "Male", true, "Regular", "USA"));

      // Females
      SurferDB
          .addSurfer(new SurferFormData(
              "meganabubo",
              "Megan Abubo",
              "Hartford, Connecticut",
              "2004 WCT Rip Curl Malibu Pro",
              "http://www.lat34.com/_/Photo/_/megan_abubo05hornbaker.jpg",
              "http://farm3.static.flickr.com/2120/2037051178_13ee5c327f.jpg",
              "Growing up in Hawaii, Megan quickly became one of the 'beach boys' and worked her way to a spot on the World Championship Tour ranks in 1998. She has been on the WCT ever since and in 2000 she was runner up for the world title. She has had many victories both in and out of the water. In October 2004 Megan won the WCT Rip Curl Malibu Pro and shot from 14th to 9th in the ratings. In 2002, she won the WCT Figueira Pro in Portugal, and in 2001 she won the WCT Roxy Pro in Fiji. Throughout her career she has had 5 other WCT victories.",
              "Female", true, "Regular", "USA"));
      SurferDB
          .addSurfer(new SurferFormData(
              "serenabrooke",
              "Serena Brooke",
              "Coolangatta Queensland, Australia",
              "Billabong Pro Australia, 1995 Women's Rookie of the Year",
              "http://3.bp.blogspot.com/-ayVU8U4xE_w/T9-cGiDXA3I/AAAAAAAABgo/phpoxj3jlh4/s1600/serenaIndo3.jpg",
              "http://www.news.saltwater-dreaming.com/modules/xcgal/albums/ASP/serena-brooke.jpg",
              "Brooke began to compete in amateur competitions in 1990 where she was crowned the Queensland amateur surfing title as well as the Australian National Title. Following her graduation from high school in 1995 she entered the pro ranks and finished her rookie season with a #13 overall ranking on the woman's tour. She was named the 1995 Women's Rookie of the Year. Among her notable accomplishments was winning the Billabong Pro Australia title and achieving a temporary #1 overall ranking in 2001. She would finish with #2 ranking twice on the World Championship Tour (WCT). Serena Brooke is one of the most marketable athletes in woman's surfing having garnered numerous sponsorships including Angel Eyewear and Bud Light. In 2001 she starred in the surfing documentary 7 Girls, and has also starred in numerous surfing videos and occasionally holds surfing camps for children looking to learn how to surf. In 2001, she established the Serena Brooke Charity Foundation. The foundation, which was created in Huntington Beach, California, helps raise money for the Orange County Child Abuse Prevention Center, CSP Youth Centers, Breast Cancer Research, and the Surfrider Foundation among others. The highlight of the year for the foundation is the Serena Brooke Charity Day held in Huntington Beach.",
              "Female", true, "Goofy", "Australia"));
      SurferDB
          .addSurfer(new SurferFormData(
              "alanablanchard",
              "Alana Blanchard",
              "Kauai, Hawaii, United States",
              "Women’s Pipeline Championships, Rip Curl Girls Festival Jr. Pro",
              "http://www.sanuk.co.kr/xe/files/attach/images/65/028/002/Alana%20Blanchard1.jpg",
              "http://cdn.c.photoshelter.com/img-get/I0000tYw1p4k0.EA/s/880/880/Alana-Blanchard-20090719-1999.jpg",
              "Born on Kauai March 5th, 1990, Alana Rene Blanchard cut her teeth surfing the remote perfection on the Garden Isle that is both idyllic and raw. Surfing in the shadow of the Irons brothers and alongside the likes of Sebastian Zietz, she quickly progressed in as a surfer. By the time she was 15 years old, she had won several major competitions. Although she had proven her mettle with wins at the T&C Women’s Pipeline Championships, HASSA State Championships, NSSA Regionals, Rip Curl Grom Search, and the honor of Triple Crown Rookie Of The Year; Blanchard’s rise to fame came in a much darker way a few years prior when she would be unexpectedly catapulted her onto the global radar. On October 31, 2003, Alana was surfing with her friend Bethany Hamilton at a spot on Kauai’s North Shore near Hanalei when Bethany was attacked by a 14-foot tiger shark. The shark completely severed her left arm and caused her to lose massive amounts of blood. The tragic event was broadcast around the world and a tsunami of media attention ensued. Blanchard was interviewed ad nauseam as the “friend” in what began as a horrible event , but as Hamilton’s uncommonly sunny disposition and intense religious faith became evident, the vicious shark attack (learn more about sharks) morphed into testament to the human spirit. Hamilton became a symbol of strength and resolve for teenage girls everywhere, and soon the surfers involved became “characters” in the Hollywood drama, Soul Surfer. Lorraine Nicholson played Blanchard in the 2011 hit film. But as Hamilton traveled the world as a surfing ambassador, Blanchard quietly continued to work with wins at the Women’s Pipeline Championships in Hawaii, the Rip Curl Girls Festival Jr. Pro in Spain, the Roxy Pro Trials, Haleiwa in Hawaii, the Billabong Pro, Pre Trials in Maui, and at the Volcom Pufferfish Surf Series right at home at Pinetrees, Kauai. Blanchard had proven that she was the real deal with winning performances against the world’s best surfers, but as she matured physically, she found yet another successful avenue for success.",
              "Female", true, "Regular", "USA"));
      SurferDB
          .addSurfer(new SurferFormData(
              "bethanyhamilton",
              "Bethany Hamilton",
              "Lihue, Hawaii, United States",
              "ASP World Junior Championships 2008, NSSA National Competition",
              "http://bethanyhamilton.com/wp-content/gallery/photos/bethany_hamilton1-1024x6831.jpg",
              "http://www.bellaonline.com/review/issues/fall2012/images/PubPortrait_Cr_bethanyHamilton.jpg",
              "Bethany Hamilton has become a source of inspiration to millions through her story of faith, determination, and hope. Born into a family of surfers on February 8, 1990, on the island of Kauai, Hawaii, Bethany began surfing at a young age. At the age of eight, Bethany entered her first surf competition, the Rell Sun Menehune event on Oahu, where she won both the short and long board divisions. This sparked a love for surf competition within her spirit. At the age of thirteen, on October 31, 2003, Bethany was attacked by a 14-foot tiger shark while surfing off Kauai’s North Shore. The attack left Bethany with a severed left arm. After losing over 60% of her blood, and making it through several surgeries without infection, Bethany was on her way to recovery with an unbelievably positive attitude. Lifeguards and doctors believe her strong water sense and faith in God helped get her through the traumatic ordeal. Miraculously, just one month after the attack, Bethany returned to the water to continue pursuing her goal to become a professional surfer. In January of 2004, Bethany made her return to surf competition; placing 5th in the Open Women’s division of that contest. With no intention of stopping, Bethany continued to enter and excel in competition. Just over a year after the attack she took 1st place in the Explorer Women’s division of the 2005 NSSA National Championships – winning her first National Title.",
              "Female", true, "Goofy", "USA"));
      SurferDB
          .addSurfer(new SurferFormData(
              "jacquelinesilva",
              "Jacqueline Silva",
              "Florianopolis, Brazil",
              "1996 Brazilian Amateur Champion, 2001 World Champion in the World Qualifying Series",
              "http://resources0.news.com.au/images/2011/04/19/1226041/413516-jacqueline-silva.jpg",
              "http://www.sportsresgate.com.br/imagens/news/original/jacqueline-silva-03122010132401.jpg",
              "Jacqueline Silva is considered to be a pioneer in women's Brazilian surfing and has garnered the best results from someone from Brazil, male or female. She began at a time when there were no female categories in Brazilian surfing championships. Among her notable accomplishments was winning the 1996 Brazilian Amateur Champion and World Champion in the World Qualifying Series in 2001. In 2004 she became the first Brazilian to ever win an event in the World Championship Tour when she won the open at Australia’s Gold Coast.",
              "Female", true, "Regular", "Brazil"));
      SurferDB
          .addSurfer(new SurferFormData(
              "laynebeachley",
              "Layne Beachley",
              "Manly, New South Wales, Australia",
              "7 time Women's ASP World Champion",
              "http://resources3.news.com.au/images/2012/09/21/1226478/821975-layne-beachley.jpg",
              "http://www.lat34.org/quick_hits/wp-content/uploads/2008/10/layne_beachley.jpg",
              "Lively and charismatic Australian regularfoot surfer from Dee Why, Sydney; winner of seven world championship titles, including six consecutive from 1998-2003 (her seventh came in 2006), and regarded as one of the sport's greatest female big-wave riders. Beachley had no amateur contest to speak of when she turned pro in 1989. She didn't win a world tour event until 1993, then placed herself firmly near the top of the ratings, finishing fourth in 1994, second in 1995, third in 1996, and second in 1997. Beachley began the 1998 circuit accompanied by veteran Hawaiian big-wave surfer Ken Bradshaw, 19 years her senior, who had recently become her boyfriend, coach, boardmaker, and big-wave mentor. She dominated the schedule, winning five of 11 events, on her way to an easy world title victory. Beachley won Hawaii's Triple Crown of Surfing in 1997 and 1998. As of 2012, she was the all-time women's surfing prize money leader, having won just over $650,000. Beachley appeared in a number of surfing videos, including Empress (1999), Tropical Madness (2001), and 7 Girls (2002). She was the top vote-getter in Australia's Surfing Life magazine's Peer Poll in 1998, 1999, 2000, and 2001, and won the Surfer Magazine Poll Awards in 2003 and 2004.",
              "Female", true, "Regular", "Australia"));
      SurferDB
          .addSurfer(new SurferFormData(
              "lisaandersen",
              "Lisa Andersen",
              "San Clemente, California",
              "US Championships at Sebastien Inlet, Sports Illustrated 100 Greatest Sportswomen of the Century",
              "http://encyclopediaofsurfing.com/wp-content/uploads/2013/01/Lisa-Andersen-orange_Servais-Version-2.jpg",
              "http://blog.roxy.com/wp-content/uploads/sites/3/2011/08/Roxy_LisaAndersen_Lifestyle1-e1314399932281.jpg",
              "The story of Lisa began in Ormond Beach, Florida. She started surfing at the age of 13 and, at this time, she was the only girl surfing in her entire hometown. Indeed, in the early 80's the women surfing was still underground, and surfing in general was the property of men. But she worked hard to settle down and impress her peers with her smooth but aggressive style. At 16, as her parents were not very enthusiastic with her new passion, she decided to Run away to Huntington Beach, California to continue on the way she had chosen and to be able to train with the best surfers of America. Then, she entered amateur competitions and won 35 National Scholastic Surfing Association trophies in 8 months and, later, the US Championships at Sebastien Inlet in 1987. After this victory, she turned pro and finished her first year on the tour at the 12th rank and was elected as Rookie of the Year. She won her first pro events in 1990 in Australia, but she had big problems of concentration from one competition to another. She later found her focus through the birth of her first child, daughter Erika. And only a month later, she reached the final in Japan. This birth certainly gave her more concentration and a different point of view on the way to handle contests for an entire season. Making competitive history as a single mom wasn't enough as Andersen's persona soon became iconic, transforming women's surfing more than any surfer before her. She knocked the beach bunny image aside and edged out the stereotype often plaguing female athletics. What made Andersen unique was that she remained feminine and graceful while brimming with an aggressive energy that would set new standards for female surfers. Lisa didn't simply change how women surf but rather how they are perceived. She led droves of young girls to the sport and played a major role with sponsor Roxy in changing women's beach fashion with the development of the women's Boardshort. After battling back injuries and giving birth to her second child,Mason, Andersen semi retired in 2001 and moved into a global brand ambassador role with Roxy. she is the subject of Nick Carroll's biography 'Fearlessness'. While women surfers still trail behind men in terms of pay and coverage, there is no doubt that female surfing would have missed a crucial burst of progress without the style and performance juggernaut of Lisa Andersen.",
              "Female", true, "Regular", "USA"));
      SurferDB
          .addSurfer(new SurferFormData(
              "rochelleballard",
              "Rochelle Ballard",
              "Montebello, California",
              "ISA World Masters Surfing Championship",
              "http://surfintoyoga.com/wp-content/uploads/2011/03/rochelle_seq1_bjorn.jpg",
              "http://4.bp.blogspot.com/-wEunRYH774g/UKu5n36ibPI/AAAAAAAAJcY/MjRGNm41a_M/s1600/rochelleballard1203.jpg",
              "Rochelle Ballard is a professional female surfer who and veteran of the Association of Surfing Professional’s (ASP) World Championship Tour. She is considered the best female tube rider in the world and has been a pioneer to the advancement of women’s surfing in the past two decades. Ballard's mastery of big waves and support of women's surfing rank her among the surfing most elite. She also co-founded International Women's Surfing (IWS) and has appeared in several movies and television shows, most notably Step Into Liquid, Blue Crush, and Beyond the Break. In 2012 she won first in the Women's Division ISA World Masters Surfing Championship.",
              "Female", true, "Regular", "USA"));
      SurferDB
          .addSurfer(new SurferFormData(
              "sallyfitzgibbons",
              "Sally Fitzgibbons",
              "Gerroa, New South Wales, Australia",
              "ASP World Junior Champion 2007, ISA World Champion 2008, 2011 and 2012 RipCurl Pro Bells Beach",
              "http://1.bp.blogspot.com/-oDUWomf9Khw/T9IxPhhjAgI/AAAAAAAAAMQ/nv393_gMu8w/s1600/Sally_Fitzgibbons.jpg",
              "http://www.surfholidays.com/SurfHolidaysSite/files/e0/e0528f3f-4ba0-4f56-916d-4f55ec286fb5.jpg",
              "As a fourteen-year-old, Fitzgibbons won the ASP Pro Junior open event, an event open to any female surfer 21 and younger. Fitzgibbons started surfing at a young age, winning the Icon All-Girls Open Event Lennox Head in 2006 at age 16. She represented her State and Australia on many occasions in a number of different sports, including athletics, winning gold at the [2007 Australian Youth Olympic Festival] 800m and 1500m, touch football, soccer, surfing and cross-country running while attending Kiama High School. As a surfer, Fitzgibbons had her first significant results at the age of 14, becoming the youngest surfer to win an Association of Surfing Professionals (ASP) Pro Junior (Under 21’s) event, also finishing second at the World Qualifying Series (WQS) Billabong Easter Girls Festival on the same day. She continued to set records throughout her junior years, winning the Australasian Pro Junior Series in 2007 and again in 2008. At 15, Fitzgibbons represented Australia at the International Surfing Association (ISA) U18 World Surfing Titles in Brazil placing second; at 16, she traveled to Portugal for the ISA U18 World Titles to win her first World Title and backed it up the following year winning both the Billabong ASP U21 World Title and the ISA World Games Open Title. In her first attempt to reach the Women’s elite World Surfing Tour via the World Qualifying Series, Fitzgibbons set a record by wrapping up the 2008 WQS series in the first 5 events to become the youngest World Surfing Tour qualifier in ASP history.",
              "Female", true, "Regular", "Australia"));
      SurferDB
          .addSurfer(new SurferFormData(
              "stephaniegilmore",
              "Stephanie Gilmore",
              "Tweed Heads, New South Wales, Australia",
              "5 time Women's ASP World Tour Champion",
              "http://stefmcdonald.files.wordpress.com/2009/07/home_stephanie_gilmore.jpg",
              "http://s3.amazonaws.com/cmi-niche/assets/pictures/7209/content_surfer.jpg?1301408922",
              "Stephanie Louise Gilmore is an Australian professional surfer and five-time world champion on the Women's ASP World Tour (2007, 2008, 2009, 2010, 2012). She was born in Murwillumbah, New South Wales, Australia on 29 January 1988 and currently resides in Tweed Heads, New South Wales, Australia. Gilmore's life as a surfer began at age 10 when she stood on a bodyboard. By age 17 she was entering world tour events as a wild card competitor, which paid off with a victory at the 2005 Roxy Pro Gold Coast. In her next season she won another wild card event, the 2006 Havaianas Beachley Classic. Gilmore's success on the WQS (World Qualifying Series) tour qualified her for the 2007 Women's ASP World Tour and she did not disappoint. She won four of the eight events and claimed the 2007 World Title. She would repeat her success in 2008, 2009 and 2010.",
              "Female", true, "Regular", "Australia"));
      SurferDB
          .addSurfer(new SurferFormData(
              "wendybotha",
              "Wendy Botha",
              "East London, South Africa",
              "4 time ASP World Surfing Champion",
              "http://encyclopediaofsurfing.com/wp-content/uploads/2012/12/Botha_Brown_026.jpg",
              "http://www.surfline.com/surfaz/images/botha_wendy/chang_wbotha_port.jpg",
              "Wendy Botha was born 1965 in East London, South Africa. She didn’t start surfing until age 13 and even then had very few girls to surf with. So the logic goes that Botha grew up surfing with guys and thus emulated the aggressive style associated with men’s surfing. Success came quickly as she took 4 South African national titles before turning pro. She first competed on the ASP tour at age 17, surfing in Durban in the 1983 Gunston Pro. Unlike most young pros, her first full year on tour was a success, yielding a 7th place finish and recognition as Rookie of the Year. Botha won her first world title in 1987 as South African under management of Greg Day who also worked with Aussie Damien Hardman (the world title winner that same year).  She won the title again in 1989 with an astounding 7 tour victories. By this time, she was living in Avalon, Australia and was the country’s first female world champ. During the next few years, she would continue to spar with the likes of Pam Burridge, Kim Mearig and an up-and-coming Lisa Anderson; but her biggest rival was Florida’s Frieda Zamba with whom she traded world titles for several years. Botha would add 2 more titles to her legacy in 1991 and 1992.",
              "Female", true, "Regular", "South Africa"));

      // Groms
      SurferDB
          .addSurfer(new SurferFormData(
              "elliotivarra",
              "Elliot Ivarra",
              "Saint Barthelemy",
              "Quiksilver King of the Groms",
              "http://farm9.staticflickr.com/8177/8071333879_f8f9567017_b.jpg",
              "http://static.quiksilver-europe.com/www/quiksilverlive.com/html/upload/kotg2012/riders/__ID-33--5-elliotivarra.jpg",
              "Elliot Ivarra, 16, was born in Saint Martin, but lives in Saint Barthelemy Island. French surfer Elliot Ivarra won the European final of the Quiksilver King of the Groms in 3 feet fun waves at Ericeira, Portugal. The young french surfer had won his ticket for the Quiskslver King Of the Groms Euro Final thanks to his first place in trials yesterday. This place allowed him to compete in the main event. In Ericeira, the Frenchman ruled this final heat of competition with several backside tricks scoring to fun waves 5.83 pts then a last one 7.43 pts for a final score of 13.50 pts. His domination upon Europe's best 16 and under surfers was unquestionable even if the young French kid Nomme Mignot battled hard for the crown until the very last seconds of the heat. As he was leading the final, Nomme, from Surfing French Team, let Elliot the victory. None the less, both of them will fly to France to take part to the Quiksilver King of the Groms International final to be held during the Quiksilver Pro France - an ASP World Tour event- (From September 27th to October 8th) gathering the world's best surfers on the Landes coast. An extraordinary experience for these two groms.",
              "Grom", true, "Goofy", "French West Indies"));
      SurferDB
          .addSurfer(new SurferFormData(
              "kalanidavid",
              "Kalani David",
              "Haleiwa, Hawaii",
              "2013 Rip Curl Grom Search",
              "http://www.rvca.com/media/transfer/img/tom_0941_2.jpg",
              "http://cdn.surf.transworld.net/wp-content/blogs.dir/443/files/2012/10/Kalani-David.jpg",
              "It’s unlikely old age will be kind to Kalani David. The 14-year-old Costa-Rica-born-Hawaiian-pro-skater-slash-pro-surfer is looking very uncomfortable seated across from me at a roadside eatery in Bali. The World Junior Championships are on and as of yesterday, he is now the highest ranked surfer in the world for his age (having lost out in Round 4 to one of the event favorite’s, Conner Coffin). His biggest battle at the moment, however, is trying to reach the fried chicken on his plate.",
              "Grom", true, "Regular", "USA"));
      SurferDB
          .addSurfer(new SurferFormData(
              "dylanlehmann",
              "Dylan Lehmann",
              "Napili, Hawaii",
              "1st Place Hawaii State Championships, 1st Place Volcom Puffer Fish Series",
              "http://flanagansurfboards.com/wp-content/uploads/2012/06/DL_1.jpg",
              "http://moyabrand025.com/wp-content/uploads/2012/06/531399_317437765012704_749776903_n.jpg",
              "A born and bred Maui grom, Dylan is surrounded by amazing waves and amazingly talented surfers, which have both pushed him to perform in a maturity way beyond his years. If he is not surfing, he is either fishing, skateboarding, training or pulling of some sort of prank on someone, (rumor has it he can talk to fish) Dylan’s surfing has taken him all over the Hawaiian Island chain, Australia, South Africa, Indonesia, Mexico, Panama…and he’s only 13! Dylans surfing is a pleasure to watch, the kid has natural flow on all craft.",
              "Grom", true, "Goofy", "USA"));
      SurferDB
          .addSurfer(new SurferFormData(
              "jakemarshall",
              "Jake Marshall",
              "Encinitas, California",
              "U.S. Surfing Championships",
              "http://stwww.surfingmagazine.com/wp-content/blogs.dir/1/files/2013/06/jake-marshall.jpg",
              "http://www.nssa.org/photogallery/gallery/2010-11_Season/ANiemannweb.jpg",
              "Many young surfers have the potential to make an impact on our sport, but none look more poised to do so than Jake Marshall. Raised on the rippable beachbreaks and reefs of San Diego’s North County, Jake has developed a solid base of smooth rail work as well as the kind of flair that few 14-year-old surfers can match. His progression is due in no small part to the numerous world-class talents in his neighborhood that have taught him a thing or two about tearing Seaside apart. Already, he’s had remarkable success in a jersey, including a recent win at the U.S. Surfing Championships at Lower Trestles. But while surf stardom seems inevitable for Jake, he’s still just a kid, and knows where his priorities should be.",
              "Grom", true, "Regular", "USA"));
      SurferDB
          .addSurfer(new SurferFormData(
              "kyussking",
              "Kyuss King",
              "Byron Bay, New South Wales",
              "2011 U12 NSW State Titles Champion",
              "http://emerysurfboards.com/australia/wp-content/uploads/2011/05/Kyuss-King-age-9.jpg",
              "http://www.drdingsurfboardrepairs.com/uploads/5/1/3/8/5138975/1835044_orig.jpg",
              "Kyuss King born and lives in Byron Bay NSW Australia with his younger brother Rasmus, dad Kingie and mum Eva. Kyuss lives in a farm house on the country side of Byron Bay. Kyuss started surfing at the age of 2, surfing small days out the Pass on the front of his dads Mal, Kyuss would stand tall and ride the waves to shore clapping his hands, turn to his dad and say 'MORE'. At the age of 4 Kyuss featured on the front cover of the local newspaper surfing across a green face solo out the Pass and with a stance that true of a grounded point surfer. Kyuss's surfing talents were soon noticed by the surf brands and was sponsored by Volcom at the age of 6. Kyuss loved competing and went on to win many national junior events over the past years and recently claimed the 2011 U12 NSW State Titles Championship and added 2 perfect 10 point rides at state level. Kyuss has been travelling the world with his family, chasing the sun, surfing new waves, making new friends, living different cultures and learning life. Kyuss's passion are surfing, skating, guitar, music and art.",
              "Grom", true, "Regular", "Australia"));
      SurferDB
          .addSurfer(new SurferFormData(
              "lukemarks",
              "Luke Marks",
              "Melbourne Beach, Florida",
              "2009 Open Mini-Grom NSSA East Coast Champion, 2010 Explorer Menehune NSSA East Coast Champion, 2009 ESCS Menehune Champion",
              "http://cdn.surf.transworld.net/files/2011/10/lukegordon_img_5184-1000x666.jpg",
              "http://www.arborcollective.com/wp-content/uploads/2011/11/Luke.jpg",
              "Hailing from Melbourne beach (where he hones his skills at ultra competitive Sebastian Inlet on a regular basis) with the support of his parents and four siblings (who all surf together) has allowed Luke’s surfing to progress to a level of maturity rarely seen in kids his age. A proper bottom turn is not often found in the Menehune division. Luke, however, already has that going for him. Watch out for this guy, both now and in the future. If his competitive track record is any indication, that shouldn’t be difficult. Simply look to the finals of any major amateur surf contest on the East Coast and more often than not, Luke will be  right there.",
              "Grom", true, "Regular", "USA"));
      SurferDB
          .addSurfer(new SurferFormData(
              "noahbeschen",
              "Noah Beschen",
              "North Shore, Hawaii",
              "None",
              "http://www.surfline.com/surfnews/images/2011/04_april/ns_groms/full/SPS_5101-Noah-Beschen_Suitt.jpg",
              "http://media-cache-ak0.pinimg.com/236x/82/d8/f1/82d8f1419ab919685786fb37b2e9e642.jpg",
              "This seems to happen from father to son in surfing quite a bit:  Herbie Fletcher with his sons Christian and Nathan; Michael Ho with his son, Mason and daughter, Coco; Dino Andino with his son, Kolohe; and now Shane Beschen with his son, Noah. Beschen has been a force in surfing since the 90s, he's gone toe-to-toe with Slater on tour, as well as gone nose-to-nose with judges as to how a wave should be scored, which lead to the more progressive ASP we have today. And all along the way put more than a few stellar surf video sections. Now, it's his son Noah's turn. The first-born Beschen calls the North Shore of Oahu home. That environment combined with his father's pointers already have him turning heads in the world of riding waves. Noah is no one trick pony – if he’s not pulling in at V-Land then he’s probably ripping his backyard half-pipe on his skateboard. Noah and his little buddies will be ruling the North Shore for years to come.",
              "Grom", true, "Regular", "USA"));
      SurferDB
          .addSurfer(new SurferFormData(
              "tylergunter",
              "Tyler Gunter",
              "Newport Beach, California",
              "Open Mini Groms Salt Creek, Oceanside Open",
              "http://i.cdn-surfline.com/surfnews/images/2012/10_october/rocktober/full/surf-shot-Tyler-Gunter-29-Sept-2012--0210.jpg",
              "http://www.arnette.com/skin/adminhtml/default/default/aw_blog/js/tiny_mce/plugins/imagemanager/files/Brain_Freeze_Mammoth/zzcashpot_nb25.jpg",
              "Tyler Gunter holds the distinct honor of being the first surfer in the Hot 100 born in the 21st century. At 9 years old, Tyler is still very much a grom.What’s more impressive—and perhaps shocking—is how well the Newport kid surfs. The future looks bright for this child of the new millennium. Taking the calipers to Tyler, he measures 4'7 and 70 pounds. But the two soda kegs he stands on muscle some surprisingly strong turns, and the NSSA judges have taken notice. For the final event of the 2010-11 season, Tyler paddled out in overhead (our size) windblown peaks in Oceanside and took first in Open Boys and second in Open Mini Groms. His success in Oceanside came shortly after an Open Mini Groms first place finish at Salt Creek. An aggressive approach on waves like the one shown above took him to the podium.",
              "Grom", true, "Goofy", "USA"));
    }
  }
}
