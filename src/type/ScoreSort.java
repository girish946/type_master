package type;
public class ScoreSort
{
	public ScoreSort(String[][] input)
	{
		this.input2d=input;
		for (int i=0;i<11 ;i++ )
		{
			for (int j=i+1;j<11 ;j++ )
			{
				if (Integer.parseInt(input2d[i][2])<Integer.parseInt(input2d[j][2]))
				{
					temps=input2d[i][1];
					input2d[i][1]=input[j][1];
					input2d[j][1]=temps;
					temps=input2d[i][2];
					input2d[i][2]=input2d[j][2];
					input2d[j][2]=temps;
				}
			}
		}
	}
	public String[][] getSortedArray()
	{
		return input2d;
	}
	java.lang.String temps;
	java.lang.String[][] input2d;
}
