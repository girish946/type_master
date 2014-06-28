package type;
/**
 *
 * @author girish
 */
public class GenerateRandomText extends Thread
{

	public GenerateRandomText(Type_master typemaster,java.awt.Frame typframe)
	{
			timer=new Thread(this);
			fram=typframe;
			sdlg=new type.SpeedDlg(typframe,this);
			this.typemaster=typemaster;
			timer.start();
	}
	public void nextRun()
	{
		//timer.stop();
		sdlg=new type.SpeedDlg(fram,this);
			ary=new Obtain_list().getRandomArray(sdlg.getSpeedInt());
	}
		public void run()
	{
			try{
			while (!sdlg.getOk())
			{
				timer.sleep(50);
			}
			ary=new Obtain_list().getRandomArray(sdlg.getSpeedInt());
			typemaster.w_left.setText("Words Left "+((sdlg.getSpeedInt()-1)-current));
			delay=sdlg.getSpeed();
			numberword=sdlg.getSpeedInt();
			}
			catch(java.lang.InterruptedException iexc)
		{
		}
		
			for(int i=0;i<numberword;i++)
		{
				this.changeText(ary[i]);		
				typemaster.tvc=false;
		}
		typemaster.Str_label[0].setText("you'r score is "+typemaster.scoreInt);
		next=true;
		typemaster.endscore();
		
	}
	public void changeText(String text)
	{		this.clearLabel();
			try{
					for (int j=0;j<=6 ;j++ )
					{
						if (typemaster.tvc==true)
						{
							millis=01;
						}
						else
						{
							millis=delay;
						}
						typemaster.Str_label[0].setText(text);
						typemaster.Str_label[j+1].setText(text);
						if(j!=0)
						{
							typemaster.Str_label[j].setText(" ");
						}
						timer.sleep(millis);
					}
		typemaster.Str_label[7].setText("");
		current++;
		//numberword--;
		int tempint=numberword-current;
		typemaster.w_left.setText("Words Left "+tempint);
		}
		catch(InterruptedException ie){}
	}
	private void clearLabel()
	{
			for (int i=0;i<=6 ;i++ )
			{
				typemaster.Str_label[i].setText(" ");
			}
	}
	public  	String[] ary;
			Thread timer;
	public int current=0;
	Type_master typemaster;
	boolean change=false;
	long millis=1000;
	public boolean next=false;
	type.SpeedDlg sdlg;
	java.awt.Frame fram;
	float timeint;
	long delay;
	int numberword;
}
