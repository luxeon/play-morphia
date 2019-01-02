package models;

import org.mongodb.morphia.annotations.Entity;
import play.modules.morphia.Model;

@SuppressWarnings("serial")
@Entity(noClassnameStored = true)
public class User extends Model {

    @Column("nm")
    public String name;
    public String tag = "testing";

    public User() {}

    public User(String name, String tag) {
        this.name = name;
        this.tag = tag;
    }

}
