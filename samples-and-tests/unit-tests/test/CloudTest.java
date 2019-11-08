import org.junit.Before;
import org.junit.Test;
import org.mongodb.morphia.annotations.Entity;
import play.modules.morphia.Model;
import play.test.UnitTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class CloudTest extends UnitTest {
    
    protected Map<String, Long> cloud;
    
    @Before
    public void setup() {
        cloud = null;
        Post.deleteAll();
    }
    
    @SuppressWarnings("serial")
    @Entity public static class Post extends Model {
        public String author;
        public String content;
        public List<String> mytags;
        
        Post(String author, String content, String... tags) {
            this.author = author;
            this.content = content;
            this.mytags = new ArrayList<>(Arrays.asList(tags));
        }
    }
    
    protected void $(String key, long value) {
        assertEquals((long)cloud.get(key), value);
    }
    
    @Test
    public void test() {
        new Post("green", "play morphia is a play plugin", "playframework", "morphia", "mongodb").save();
        new Post("green", "greenscript is another play plugin", "playframework", "greenscript", "javascript", "stylesheet", "minimize", "compress").save();
        
        cloud = Post._cloud("mytags");
        $("playframework", 2);
        $("morphia", 1);
        $("greenscript", 1);
    }

}
