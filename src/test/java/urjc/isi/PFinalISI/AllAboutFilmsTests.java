package urjc.isi.PFinalISI;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


import static org.mockito.Mockito.*;


import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import spark.Request;
import spark.Response;

public class AllAboutFilmsTests {
	
	// Test para doLoadDDBB
	@Test()
	public void doMainInfo1() throws SQLException {
		Request request = null;
		Response response = null;
		Main.doLoadDDBB(request, response);
	}

}