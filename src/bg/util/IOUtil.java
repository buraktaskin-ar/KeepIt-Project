package bg.util;


import java.io.*;
import java.util.List;

public class IOUtil {
	
	public static void read( List<String> data, String filename) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader (new FileInputStream (filename), "UTF-8"))) {
			String line;
			int count = 0;
			while ((line = br.readLine()) != null) {
				data.add ( line );
				
			}
		} catch (UnsupportedEncodingException e) {
		
			e.printStackTrace();
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	
	public static String read(InputStream in) {
		StringBuilder text = new StringBuilder();
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"))) {
			String line;
			while ((line = br.readLine()) != null) {
				text.append(line).append("\n");
			}
		}
		
		catch (UnsupportedEncodingException e) {
		
			e.printStackTrace();
		}
		
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return text.toString();
	}
	
	public static void write(String webpage, long id,int a ) {
		try (BufferedWriter writer =
			     new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:/int/pro_ec_to_int/thrilio/src/pages2" + String.valueOf(id) + ".html"), "UTF-8"))) {
			writer.write(webpage);
		} catch (UnsupportedEncodingException e) {
		
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	

	
	
		public static void write(String webpage, long id) {
			String directoryPath = "C:/int/pro_ec_to_int/thrilio/src/pages2/";
			String filePath = directoryPath + id + ".html";
			
		
			File directory = new File(directoryPath);
			if (!directory.exists()) {
				boolean dirCreated = directory.mkdirs();
				if (!dirCreated) {
					System.out.println("Failed to create directory: " + directoryPath);
					return;
				}
			}
			try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8"))) {
				writer.write(webpage);
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Failed to save file: " + filePath);
			}
		}
		
	
	
	
	
	
	
	
	
	
	
	
	
}