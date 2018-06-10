package urjc.isi.PFinalISI;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


import static org.mockito.Mockito.*;
import static spark.Spark.port;

import java.sql.Connection;
import java.sql.DriverManager;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import java.net.URI;

import spark.Request;
import spark.Response;

public class AllAboutFilmsTests {
	
	Request request = null;
	Response response = null;
	private static Connection connection;
		
	// Los tests para doMainInfo, doActorHTML, doFilmHTML son todos happy path (1-2-3). Se puede comprobar su funcionamiento
	// utilizando la propia apliacaicón en Heroku (https://pfinal-isi-rodrigo.herokuapp.com/  ;
	// https://pfinal-isi-rodrigo.herokuapp.com/actor  ; https://pfinal-isi-rodrigo.herokuapp.com/film) respectivamente
	
	// Test para doLoadDDBB. Path 1-2-3-4
	// El HappyPath (1-2-3-5-6-7-8-9-8-6-10) se omite porque al usar la propia aplicación en Heroku se comprueba que cunfiona
	@Test(expected=IllegalArgumentException.class)
	public void doMainInfo1() throws SQLException {
		Main.doLoadDDBB(request, response);
	}
	
	// Tests para doSearchFilm
	// El happy path de doSearchFilm (1-2-3-5-6-7-8-9-8-10-12-/12+1/14-15) puede ser comprobado usando la apliación
	// con una búsqueda correcta (nodo 12+1) o una búsqueda incorrecta 14
	
	// Test para el camino 1-2-3-4 -> Actor null
	@Test(expected=NullPointerException.class)
	public void doSearchFilm1(){
		Main.doSearchFilm(request, response);
	}
	
  
	//Test para comprobar la excepción del Select (6-7-8-11) -> retorno a null por fallo en tabla
//	@Test()
//	public void select() throws SQLException, URISyntaxException {
//		String tabla = "TablaNoExistente";			// Tabla incorrecta
//		String pelicula = "101 Dalmatians (1996)";	// Película correcta
		
//		Class.forName("com.mysql.jdbc.Driver");
//		connection = DriverManager.getConnection("jdbc:mysql://localhost:6666/jcg", "root", "password");
//		assertEquals(null, Main.select(connection, tabla, pelicula));
//	}
	
	
	// Test para doSearchActor
	// El happy path puede ser comprobado usando la propia apliación con un actors que se encuentre en el grafo
	// (1-2-3-5-6-7-8-10-11-12-12+1-14-15-16-17-18-19-20-21-22-20-23) o de un actor que NO se encuentre en el grafo
	// (1-2-3-5-6-7-8-10-11-12-12+1-14-15-16-17-18-19-20-23)
	@Test(expected=NullPointerException.class)
	public void doSearchActor1() throws ClassNotFoundException, URISyntaxException{
		Main.doSearchActor(request, response);
	}

}