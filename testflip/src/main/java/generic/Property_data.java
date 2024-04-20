package generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//import gen_utilities.Sites_and_data;

public class Property_data {
		public String readdatafrompropfile(String key) throws IOException
		{
			FileInputStream fis=new  FileInputStream(Sites_and_data.filepath);
			Properties pro =new Properties();
			pro.load(fis);
			String value=pro.getProperty(key);
			return value;
		}
	}

