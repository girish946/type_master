package type;
import java.util.*;
import java.io.*;
public class Obtain_list
{
	public Obtain_list()
	{
			wfile=new File("words.txt");
			if (wfile.exists())
			{
				
			long fl=wfile.length();
			 try{
			 bufred=new BufferedReader(new FileReader(wfile));}
			 catch(FileNotFoundException e)
			{
		}
			try
			{	
				word_list=new String[852];
				for (int i=0;i<852;i++ )
			{
			 temp=bufred.readLine();
			word_list[i]=temp;
			}
			}
			catch (IOException e)
			{
			}
			
			}
			else
		{
				 // javax.swing.JOptionPane.showMessageDialog("Words.txt Not Found");
		}
	}
	public static void main(String a[])
	{
		new Obtain_list();
	}
	public String[] getArray()
	{
		return word_list;
	}
	public String[] getRandomArray(int number)
	{
		 random_String=new String [number];
		for (int i=0;i<number ;i++ )
		{
			int randomInt = rint.nextInt(852);
			random_String[i]=word_list[randomInt];
		}
		return random_String;
	}
	File wfile;
	BufferedReader bufred;
				private String[] word_list;
				private String temp;
				private Random rint=new Random();
				private String [] random_String;
}
