package urjc.isi.PFinalISI;

import static spark.Spark.*;

import spark.Request;
import spark.Response;

import java.net.URISyntaxException;

public class Main {
	
	static final String LINK_HOME = "<p><a href=\"https://pfinal-isi-rodrigo.herokuapp.com/\">Return to homepage</a></p>";
	
	public static String doSearchActor(Request request, Response response) throws ClassNotFoundException, URISyntaxException {
		String actor = request.queryParams("Actor");
		if (actor == null) {
			String result = "<h1>Please insert valid actor, not null</h1>" + LINK_HOME;
			return result;
		}
		String result = "<h1>Actor " + actor + " appears in:</h1></br><p>";
		String path = "Documentacion_Proporcionada/resources/data/other-data/tinyMovies.txt";
		String separator = "/";
		Graph graph = new Graph(path, separator);
		
		for (String movie:graph.adjacentTo(actor)) {
			if (graph.st.contains(movie)){
				result = result + movie + "</br>";
			}
		}
		
		result = result + LINK_HOME;
		return result;
		
	}
	
    public static String doFilmHTML(Request request, Response response) throws ClassNotFoundException, URISyntaxException {
		String result = new String("<h1>Search to know more about a film</h1></br>" + 
								   "<p><form action=\"https://pfinal-isi-rodrigo.herokuapp.com/film\" method=\"post\">" +
								   "Film: <input type=\"text\" name=\"film\"><br>" + 
								   "<input type=\"submit\" value=\"Search\"></form></p></br>" + 
								   LINK_HOME);
		return result;
    }
	
    public static String doActorHTML(Request request, Response response) throws ClassNotFoundException, URISyntaxException {
		String result = new String("<h1>Search to know more about an actor</h1></br>" + 
								   "<p><form action=\"https://pfinal-isi-rodrigo.herokuapp.com/actor\" method=\"post\">" +
								   "Actor: <input type=\"text\" name=\"actor\"><br>" + 
								   "<input type=\"submit\" value=\"Search\"></form></p></br>" + 
								   LINK_HOME);
		return result;
    }
  
    public static String doMainInfo(Request request, Response response) throws ClassNotFoundException, URISyntaxException {
		String result = new String("<h1>Welcome to '' All About Films ''</h1></br>" +
				 				   "<p>What can you do?</br></br>" + 
								   "To load the <b>Data Base</b> click this " +
				 				   "<a href=\"https://pfinal-isi-rodrigo.herokuapp.com/load\">link</a></br>" + 
								   "To search for an <b>actor's films</b> click this " + 
								   "<a href=\"https://pfinal-isi-rodrigo.herokuapp.com/actor\">link</a></br>" + 
								   "To search for an the actors casting in a <b>film</b> click this " + 
								   "<a href=\"https://pfinal-isi-rodrigo.herokuapp.com/film\">link</a></br>" + 
				 				   "</p>");
	
		return result;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        port(getHerokuAssignedPort());

        // spark server
        get("/", 	 Main::doMainInfo);
//        get("/load",  Main:: doLoadDDBB);
        get("/actor", Main:: doActorHTML);
        get("/film", Main:: doFilmHTML);
        
		post("/actor", Main::doSearchActor);
		//post("/film", Main::doSearchFilm);

    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
