package bg.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class HttpConnect {
	
	public static String download(String sourceUrl) throws MalformedURLException, URISyntaxException {
		System.out.println("Downloading: " + sourceUrl);
		URL url = new URI(sourceUrl).toURL();
		
		try {
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			int responseCode = con.getResponseCode();
			System.out.println("Response Code: " + responseCode);
			
			if (responseCode >= 200 && responseCode < 300) {
				System.out.println("Response OK, reading input stream...");
				String result = IOUtil.read(con.getInputStream());
				
				if (result != null)
				{
					System.out.println("Downloaded content: ") ;
				}
				else
				{
					System.out.println("Downloaded content is null.");
				}
				return result;
			}
			else {
				System.out.println("Failed to download content. Response code: " + responseCode);
			}
		} catch (IOException e)
		{
			System.out.println("IOException occurred: " + e.getMessage());
			e.printStackTrace();
		}
		
		return null;
	}
}
