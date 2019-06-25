import facebook4j.Comment;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.PagableList;
import facebook4j.Post;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;

public class facebook {

/**
 * A simple Facebook4J client which
 * illustrates how to access group feeds / posts / comments.
 * 
 * @param args
 * @throws FacebookException 
 */
public static void main(String[] args) throws FacebookException {

    // Generate facebook instance.
    Facebook facebook = new FacebookFactory().getInstance();
    // Use default values for oauth app id.
    facebook.setOAuthAppId("834089786975603", "X4GOIFxvF6xnolNTft5X9rMMX-Q");
    // Get an access token from: 
    // https://developers.facebook.com/tools/explorer
    // Copy and paste it below.
    String accessTokenString = "EAAL2mal2pXMBAA9rIfi8l8TA1BLr6UGExqSzbO81F0QToJZC59873c520ZACQ3cKeyZCilH4Dv42kheKPZAZAaR3Nn2PoZBqZBgmI1vIoZAD5YvyCGi97f2Ibhp17qHMdMBTZA74pkn4zcjqigFqZB1footj2vOmMaWV17OM7EAfiEmwZDZD";
    AccessToken at = new AccessToken(accessTokenString);
    // Set access token.
    facebook.setOAuthAccessToken(at);

    // We're done.
    // Access group feeds.
    // You can get the group ID from:
    // https://developers.facebook.com/tools/explorer

    // Set limit to 25 feeds.
    ResponseList<Post> feeds = facebook.getFeed("100001643530274",
            new Reading().limit(25));
            //System.out.println(feeds);

        // For all 25 feeds...
        for (int i = 0; i < feeds.size(); i++) {
            // Get post.
            Post post = feeds.get(i);
            
            // Get (string) message.
            String message = post.getMessage();
                            // Print out the message.
            System.out.println(message);

            // Get more stuff...
            PagableList<Comment> comments = post.getComments();
            //String date = post.getCreatedTime().toString();
            //String name = post.getFrom().getName();
            String id = post.getId();
        }           
    }
}