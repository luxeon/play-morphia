package controllers;

import models.User;
import org.apache.commons.lang.RandomStringUtils;
import play.mvc.Controller;

import java.io.File;

public class Application extends Controller {

    public static void index() {
        session.clear();
        renderText(session.getId());
    }

    public static void uploadImage(File image) {
        notFoundIfNull(image);
        User u = new User();
        u.name = RandomStringUtils.randomAlphabetic(5);
        u = u.save();

        renderText(u.getId());
    }
}
