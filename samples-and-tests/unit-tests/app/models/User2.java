package models;

import org.mongodb.morphia.annotations.Entity;
import play.modules.morphia.Model;

@SuppressWarnings("serial")
@Entity(value="User", noClassnameStored = true)
public class User2 extends Model {

    public String nm;
    public String tag = "testing";
    
}
