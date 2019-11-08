package models.why;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.List;

public class PureMorphiaApp {

    private static Datastore getDatastore() {
        Morphia morphia = new Morphia();
        PureMorphiaUser.ensureMapped(morphia);
        MongoClient client = new MongoClient();
        return morphia.createDatastore(client, "mydatabase");
    }

    public static void crud() {
        Datastore ds = getDatastore();
        // create
        PureMorphiaUser user = new PureMorphiaUser("John", "Smith");
        ds.save(user);
        // read
        PureMorphiaUser user2 = ds.get(PureMorphiaUser.class, user.id);
        // update
        user2.fName = "Tom";
        ds.save(user2);
        // delete
        ds.delete(user2);
    }
    
    public static void query() {
        Datastore ds = getDatastore();
        // find
        List<PureMorphiaUser> users = ds.createQuery(PureMorphiaUser.class)
                .filter("fName", "John").filter("lName", "Smith").asList();
    }
    
}
