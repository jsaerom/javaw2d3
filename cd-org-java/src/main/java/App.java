import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      //Artist newArtist = new Artist("none");
      List<Artist> artists = Artist.all();
      model.put("artists", artists);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/artist-success.vtl");
      model.put("template2", "templates/index.vtl");
      String artist = request.queryParams("artistName");
      Artist newArtist = new Artist(artist);
      List<Artist> artists = Artist.all();
      model.put("artists", artists);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("artists/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/artist.vtl");
      Artist artist = Artist.find(Integer.parseInt(request.params(":id")));
      model.put("artist", artist);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("artists/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template2", "templates/artist.vtl");
      model.put("template", "templates/success.vtl");

      String album = request.queryParams("album");
      String genre = request.queryParams("genre");
      Organizer newCD = new Organizer(album, genre);
      Artist artist = Artist.find(Integer.parseInt(request.params(":id")));
      artist.addCD(newCD);

      model.put("artist", artist);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
