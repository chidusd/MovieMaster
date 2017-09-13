package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyProperties {

	public String getProperty(String keyValue) throws IOException {
		Properties prop = new Properties();
		File file = new File(System.getProperty("user.dir")+"\\Properties\\MyProp.properties");
		InputStream stream = new FileInputStream(file);
		prop.load(stream);
		return prop.getProperty(keyValue);
	}

}
