package utils;

import java.io.File;

import java.io.FileReader;
import java.util.Properties;

import org.testng.TestListenerAdapter;





public class ReadConfig {
	
	
	  Properties p;
	
	public ReadConfig()  {
		File f= new File("./src/test/resources/config.properties");
		FileReader fr;
		try {
			
			fr = new FileReader(f);
			p = new Properties();
			p.load(fr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
	public String getURL()  {
		return p.getProperty("url");
		
	}
	public String getbrowser()  {
		return p.getProperty("browser");
		
	}
	
	
	
	

}
