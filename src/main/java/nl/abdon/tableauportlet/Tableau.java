package nl.abdon.tableauportlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Tableau {
	
	static Logger _log = LogManager.getLogger(Tableau.class);
	
	public static String getTrustedTicket(String user) throws Exception {
		
		OutputStreamWriter out = null;
		BufferedReader in = null;
		try {
			// Encode the parameters
			StringBuffer data = new StringBuffer();
			data.append(URLEncoder.encode("username", "UTF-8"));
			data.append("=");
			data.append(URLEncoder.encode(user, "UTF-8"));

			// Send the request
			_log.info("Getting ticket for user " + user);
			
			URL url = new URL("http://tableau.vm/trusted");
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			out = new OutputStreamWriter(conn.getOutputStream());
			out.write(data.toString());
			out.flush();

			// Read the response
			StringBuffer rsp = new StringBuffer();
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				rsp.append(line);
			}
			
			_log.info("Ticket: " + rsp.toString());

			return rsp.toString();

		} catch (Exception e) {
			_log.error(e.getMessage());
			throw e;
		} finally {
			try {
				if (in != null)
					in.close();
				if (out != null)
					out.close();
			} catch (IOException e) {
			}
		}
	}
}
