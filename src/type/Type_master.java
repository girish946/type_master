package type;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Type_master extends Frame
{
		public Type_master()
	{
		super("Type_master");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("images/textcur.gif"));
		setLayout(new BorderLayout());
		this.setMenuBar(mainmenu);
		mainmenu.add(Settings);
		mainmenu.add(ScoreFile);
		mainmenu.add(About);
		Settings.add(Speed);
		Settings.add(Pause);
		Settings.add(ViewIncorrect);
		ScoreFile.add(ViewScore);
		About.add(abtTypmaster);
		add(top,BorderLayout.NORTH);
		add(center_panel,BorderLayout.CENTER);
		add(bottom_panel,BorderLayout.SOUTH);
		top.setLayout(new BorderLayout());
		this.arrangeCenter();
		center_panel.setLayout(fl);
		bottom_panel.setLayout(new GridLayout(1,4));
		top.add(Thread_State,BorderLayout.EAST);
		bottom_panel.add(w_left);
		bottom_panel.add(Enter_Field);
		bottom_panel.add(go_button);
		bottom_panel.add(score);
		AssignListener asign=new AssignListener(this);
		addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
				System.exit(0);}
       		 });
		Enter_Field.addKeyListener(new java.awt.event.KeyAdapter(){public void keyPressed(KeyEvent key)
			{
				if (key.getKeyChar()=='\n')
				{
					chktext();
				}
			}
		});

		setSize(750,700);
		validate();
		invalidate();
		repaint();	
		this.setState(Frame.ICONIFIED);
		setResizable(false);
		incorrectwords=new IncorrectWords(this);
		genramtext=new GenerateRandomText(this,this);

	}
	public static void main(String arg[])
	{
		Type_master tm=new Type_master();
		tm.setVisible(true);
	}


	public void paint (Graphics g)
	{
		center_panel.setBackground(Color.red);		
	}
	public void arrangeCenter()
	{	
		for (int i=0;i<8 ;i++ )
				{
				Str_label[i]=new Label("");		
				Str_label[i].setFont(new Font("ArialBlack",Font.BOLD,24));
				Str_label[i].setBackground(Color.red);
				Str_label[i].setForeground(Color.white);
				Str_label[i].setAlignment(Label.CENTER);
				center_panel.add(Str_label[i]);
				}
	}


	class AssignListener
		{
			public AssignListener(Type_master parentw)
			{
				ImplementListener implement=new ImplementListener(parentw);
				Thread_State.addActionListener(implement);
				go_button.addActionListener(implement);
				ViewScore.addActionListener(implement);
				Pause.addActionListener(implement);
				Speed.addActionListener(implement);
				abtTypmaster.addActionListener(implement);
				ViewIncorrect.addActionListener(implement);
			}
		}
				class ImplementListener implements ActionListener
		{
				ImplementListener(Type_master tym)
			{
					tymas=tym;
			}
			public void actionPerformed(ActionEvent e)
			{
				if (e.getSource()==ViewIncorrect)
				{
					incorrectwords.setVisible(true);
				}
				if (e.getSource()==abtTypmaster)
				{
					System.out.println("About Box clocked");
					type.AboutDlg ad=new type.AboutDlg(tymas);
				}
				if (e.getSource()==Speed)
				{
					System.out.println("Speed clicked");
					tymas.incorrectwords=new type.IncorrectWords(tymas);
					tymas.incorrectwords.setVisible(true);
					genramtext.timer.stop();
					clearall();
					genramtext =new GenerateRandomText(tymas,tymas);
				}
				if (e.getSource()==ViewScore)
				{
					ScoreDlg sdlg=new ScoreDlg(tymas,tymas);
				}
				if (e.getSource()==Thread_State||e.getSource()==Pause)
				{
					System.out.println("Pause clicked");
					if (genramtext.next==true)
					{
						System.out.println("Pause clicked next true");
						tymas.incorrectwords=new IncorrectWords(tymas);
						tymas.incorrectwords.setVisible(false);
						genramtext.timer.stop();
						clearall();
						genramtext =new GenerateRandomText(tymas,tymas);
					}
					else
					{
						if (tstate==false)
						{
							System.out.println("Pause clicked tstate false");
							genramtext.timer.suspend();
							tstate=true;
						}
						else
						{
							System.out.println("Pause clicked tstate true");
							genramtext.timer.resume();
							tstate=false;
						}
					}
				}
				if (e.getSource()==go_button)
				{
					chktext();
				}
			}
			Type_master tymas;
		}
	public void chktext()
	{
		incorrectwords.allwords.addItem(genramtext.ary[genramtext.current]);
		incorrectwords.wrongwords.addItem(Enter_Field.getText());
		tvc=true;
		if (Enter_Field.getText().equals(genramtext.ary[genramtext.current]))
		{
			scoreInt=scoreInt+10;
			score.setText("    Score : -"+scoreInt);
		}
		else
		{
			incorrectwords.wrongwords.list.select(genramtext.current);
		}
		Enter_Field.setText("");
	}
	public void clearall()
	{
		genramtext=null;
		scoreInt=0;
		w_left.setText("Worrds Left 30");
		score.setText("    Score : -"+scoreInt);
	}
	public void endscore()
	{
		type.ScoreIn scin=new type.ScoreIn(genramtext.numberword);
		String[][] scorestring=scin.getDetailedArry();
		String[][] scoreadd=new String[11][3];
		for (int i=0;i<10 ;i++ )
		{
			for (int j=0;j<3 ;j++ )
			{
				scoreadd[i][j]=scorestring[i][j];
			}
		}
		scoreadd[10][0]=new String("11");
		scoreadd[10][1]= javax.swing.JOptionPane.showInputDialog("please Enter your name");
		Integer intg=scoreInt;
		scoreadd[10][2]=intg.toString();
		type.ScoreSort scsrt=new type.ScoreSort(scoreadd);
		scoreadd=scsrt.getSortedArray();
		type.ScoreOut sout=new type.ScoreOut(scoreadd);
		sout.writeData(genramtext.numberword);
		type.ScoreDlg scdlg=new type.ScoreDlg(this,this);
	}





	static final long serialVersionUID = 00000000l;
	private ImageIcon ico_pause=new ImageIcon("../images/stop.gif");
	private ImageIcon ico_play=new ImageIcon("../images/not.gif");
	private ImageIcon ico_bg=new ImageIcon("../images/start2.gif");
	private TextField Enter_Field=new TextField(10);
	private JButton Thread_State=new JButton(ico_pause);
	private JButton go_button=new JButton(ico_play);
	public Label w_left =new Label("Words Left 30");
	public int scoreInt=0;
	private Label score=new Label("    Score : -"+scoreInt);
	private Panel top =new Panel();
	public Panel center_panel=new Panel();
	private Panel bottom_panel=new Panel();
	private GridLayout fl=new GridLayout(8,1);
	public Label Str_label[]=new Label[8];
	private MenuBar mainmenu= new MenuBar();
	private Menu Settings =new Menu("Game");
	private Menu ScoreFile=new Menu("Score");
	private MenuItem Speed=new MenuItem("New");
	private MenuItem Pause=new MenuItem("Pause/Play");
	private MenuItem ViewScore=new MenuItem("Top Score");
	private MenuItem ViewIncorrect=new MenuItem("View Result");
	private Menu About =new Menu("About");
	private MenuItem abtTypmaster=new MenuItem("About Type_master");
	GenerateRandomText genramtext;
	IncorrectWords incorrectwords;
	private boolean tstate=false;
	public boolean tvc=false;
}
