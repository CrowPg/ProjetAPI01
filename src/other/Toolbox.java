package other;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;

public class Toolbox
{
	public static String load_file(String filename) {
		String content = null;
		File file =  new File(filename);
		if(file.exists()) {
		    try {
		       BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
		       StringWriter out = new StringWriter();
		       int b;
		       while ((b=in.read()) != -1) {
		    	   out.write(b);
		       }
		       out.flush();
		       out.close();
		       in.close();
		       content = out.toString();
		    }
		    catch (IOException ie)
		    {
		         ie.printStackTrace(); 
		    }
		}
	    return content;
	}
	
	public static String parse_filename(String filename)
	{
		if (filename != null) {
			filename = filename.replace('/',File.separatorChar).replace('\\',File.separatorChar);
		}
		return filename;
	}
}
