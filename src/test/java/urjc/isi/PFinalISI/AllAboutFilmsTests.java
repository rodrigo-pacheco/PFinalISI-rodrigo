package urjc.isi.PFinalISI;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


import static org.mockito.Mockito.*;


import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;

import javax.xml.ws.Response;

import org.eclipse.jetty.http.MetaData.Request;
import org.junit.Test;

public class AllAboutFilmsTests {
	
	// Test para doMainInfo
	@Test()
	public void doMainInfo1() {
		Request request = null;
		Response response = null;
		Main.doLoadDDBB(request, response);
	}

}