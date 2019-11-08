import com.mongodb.MongoClientOptions;
import org.junit.Before;
import org.junit.Test;
import play.modules.morphia.MorphiaPlugin;
import play.test.UnitTest;

public class MongoOptionsTest extends UnitTest {

	private MongoClientOptions options;

	@Before
	public void before()
	{
        options = MorphiaPlugin.ds().getMongo().getMongoClientOptions();
	}
	
    @Test
    public void testMongoOptionsCanBeSetInApplicationConf() {
        assertEquals(11, options.getThreadsAllowedToBlockForConnectionMultiplier());
        assertEquals(12, options.getConnectionsPerHost());
        assertTrue(options.getReadPreference().isSlaveOk());
    }
}