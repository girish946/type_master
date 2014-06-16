package type;
import java.awt.*;
import javax.swing.*;
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
		addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
				System.exit(0);}
       		 });

		setSize(750,700);
		validate();
		invalidate();
		repaint();	
		this.setState(Frame.ICONIFIED);
		setResizable(false);

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
}
