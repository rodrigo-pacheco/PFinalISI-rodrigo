package urjc.isi.PFinalISI;

import static spark.Spark.*;

import spark.Request;
import spark.Response;

import java.net.URISyntaxException;

public class Main {
  
    public static String doMainInfo(Request request, Response response) throws ClassNotFoundException, URISyntaxException {
		String result = new String("<h1>Welcome to All About Films</h1></br>" +
				 				   "<p>This are our options:</br>" + 
								   "To load the Data Base click this" +
				 				   "<a href=\"https://pfinal-isi-rodrigo.herokuapp.com/load\"> link</a></br></p>");
	
		return result;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        port(getHerokuAssignedPort());

        // spark server
        get("/", 	 Main::doMainInfo);
//        get("/load",  Main:: doLoadDDBB);
//        get("/actor", Main:: doSearchActor);
//        get("/film", Main:: doSearchFilm);

    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
