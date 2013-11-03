

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Scanner;

public class ListFormatter 
{
	final static String FILENAME = "C:\\Lists\\input.txt";
	final static String OUTPUT_FILENAME = "C:\\Lists\\output.txt";
	private static final int ROWCOUNT = 15;
	
	static String line = "";
	public static void main(String[] args) 
	{				
		ArrayList<String> ids = new ArrayList<String>();
		try
		
		{
			File file = new File(FILENAME);
			Scanner scanner = new Scanner(file);
			scanner.useDelimiter(",");
			while(scanner.hasNext())
			{
				String id = scanner.next();
				id.trim();
				id = id.replace("\n", "").replace("\r", "").replace("\t", "");
				ids.add(id);
				
			}
			scanner.close();
			int count = 1;

			PrintWriter pw = new PrintWriter(new FileOutputStream(OUTPUT_FILENAME));
			StringBuilder builder = new StringBuilder();
			for (String id : ids)
			{
				line = builder.append(id + ",").toString();
				if(count % (ROWCOUNT + 1) == 0)
				{
					pw.println(line);
					builder = new StringBuilder();
				}
				
				count ++;
			}
			if(builder.length() > 0)
			{
				pw.println(line);
			}
			pw.close();
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}