package type;
public class ScoreOut extends java.lang.Object
{
	public ScoreOut()
	{
		super();
	}
	public ScoreOut(String[][] input)
	{
		input2d=input;
	}
	public void writeData(int scor)
	{
		java.io.File targetFile =new java.io.File("Topscore-"+scor+".score");
		if (targetFile.exists())
		{ 
			try
			{
				
			java.io.FileWriter filew=new java.io.FileWriter(targetFile);
			java.io.PrintWriter print=new java.io.PrintWriter(filew,true);
			for (int i=0;i<3 ;i++ )
			{
				for (int j=0;j<10 ;j++ )
				{
					print.println(input2d[j][i]);
				}
			}
			}
			catch (java.io.FileNotFoundException fnf)
			{
				fnf.printStackTrace();
			}
			catch(java.io.IOException ioe)
			{
				ioe.printStackTrace();
			}
		}
		else
		{
			writeBlankFile(scor);
		}
	}
	public void writeBlankFile(int scor)
	{
		System.out.println("Writing blank file");
		java.io.File targetFile =new java.io.File("Topscore-"+scor+".score");
		try
			{
				
			java.io.FileWriter filew=new java.io.FileWriter(targetFile);
			java.io.PrintWriter print=new java.io.PrintWriter(filew,true);
				for (int j=0;j<10 ;j++ )
				{
					print.println(j+1);
				}
				for (int i=0;i<10 ;i++ )
				{
					print.println("-------");
				}
				for (int k=0;k<10 ;k++ )
				{
					print.println("00");
				}
			}
			catch (java.io.FileNotFoundException fnf)
			{
				fnf.printStackTrace();
			}
			catch(java.io.IOException ioe)
			{
				ioe.printStackTrace();
			}
		}
	String[][] input2d;
}
