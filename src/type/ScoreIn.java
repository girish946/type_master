package type;
public class ScoreIn
{
	public ScoreIn(int scor)
	{

		try{
			mainString=new java.lang.String[30];
				scorefile=new java.io.File("Topscore-"+scor+".score");
//				System.out.println(scorefile.toString());
				if (scorefile.exists())
				{
				
		 bufread=new java.io.BufferedReader(new java.io.FileReader(scorefile));
//		System.out.println(bufread.toString());
		 for (int i=0;i<30 ;i++ )
		 {
			 mainString[i]=bufread.readLine();
	//		 System.out.println(mainString[i]);
		 }
				}
				else
			{
					sout=new type.ScoreOut();
					sout.writeBlankFile(scor);
					 bufread=new java.io.BufferedReader(new java.io.FileReader(scorefile));
//		System.out.println(bufread.toString());
		 for (int i=0;i<30 ;i++ )
		 {
			 mainString[i]=bufread.readLine();
	//		 System.out.println(mainString[i]);
		 }
			}
		}
		catch(java.io.FileNotFoundException fnf)
		{
			fnf.printStackTrace();
		}
		catch(java.io.IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	public String[][] getDetailedArry()
	{
//		System.out.println("getDetailedArry called");
		obtainedString=new java.lang.String[10][3];
		for (int i=0;i<10 ;i++ )
		{
			obtainedString[i][0]=mainString[i];
		}
		for (int j=0;j<10 ;j++ )
		{
			obtainedString[j][1]=mainString[10+j];
		}
		for (int k=0;k<10 ;k++ )
		{
			obtainedString[k][2]=mainString[20+k];
		}
	//	printObtainedString();
		return obtainedString;
	}
	private void printObtainedString()
	{
		for (int i=0;i<10 ;i++ )
		{
			for (int j=0;j<3;j++ )
			{
				System.out.print(obtainedString[i][j]+"\t");
			}
			System.out.print("\n");
		}
	}
/*	public static void main(String a[])
	{
		ScoreIn sc= new ScoreIn();
		String[][] temps=sc.getDetailedArry();
	}*/
			java.lang.String[][] obtainedString;
			java.lang.String[] mainString;
			java.lang.StringBuffer tempbuf=new java.lang.StringBuffer();
			java.io.File scorefile;
			java.io.BufferedReader bufread;
			int count=0;
			type.ScoreOut sout;
}
