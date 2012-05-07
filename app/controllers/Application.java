package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

import models.Task;
import play.data.Form;

import play.db.ebean.Model;
import java.util.List;
import static play.libs.Json.toJson;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("hello, world"));
    }

    public static Result addTask() {
        Form<Task> form = form(Task.class).bindFromRequest();
        Task task = form.get();
        task.save();
        return redirect(routes.Application.index());
    }

    public static Result getTasks() {
        List<Task> tasks = new Model.Finder(String.class, Task.class).all();
        return ok(toJson(tasks));
    }

}
