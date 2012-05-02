package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

import models.Task;
import play.data.Form;

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
  
}
