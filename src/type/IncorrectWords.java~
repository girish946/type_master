package type;
public class IncorrectWords extends java.awt.Dialog implements java.awt.event.ActionListener
{
	public IncorrectWords(java.awt.Frame parent)
	{
		super(parent,"Words You Typed");
			this.setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage("../images/textcur.gif"));
		this.setLayout(new java.awt.BorderLayout());
		this.totalwords=new java.awt.List(30,false);
		this.Incorrectwords=new java.awt.List(30,false);
		allwords=new listpanel(totalwords,"All Words");
		wrongwords=new listpanel(Incorrectwords,"You Typed");
		centerpanel=new java.awt.Panel();
		southpanel=new java.awt.Panel();
		centerpanel.setLayout(new java.awt.GridLayout(1,2));
		centerpanel.add(allwords);
		centerpanel.add(wrongwords);
		correct =new java.awt.Label("Correct  words :-0");
		incorrect=new java.awt.Label("Incorrect  words :-0");
		close=new java.awt.Button("Close");
		close.addActionListener(this);
		southpanel.add(correct);
		southpanel.add(incorrect);
		southpanel.add(close);
		this.add(centerpanel,java.awt.BorderLayout.CENTER);
		this.add(southpanel,java.awt.BorderLayout.SOUTH);
		 addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
			dispose();
            }
        });
		validate();
		invalidate();
		repaint();
		setVisible(true);
		setSize(250,250);
		setResizable(false);
	}
	public void actionPerformed(java.awt.event.ActionEvent e)
	{
		dispose();
	}
	class listpanel extends java.awt.Panel
	{
		listpanel(java.awt.List list,java.lang.String label)
		{
			this.list=list;
			this.label=new java.awt.Label(label);
			labelpanel=new java.awt.Panel();
			listpanel=new java.awt.Panel();
			listpanel.setLayout(new java.awt.BorderLayout());
			labelpanel.add(this.label);
			listpanel.add(this.list);
			listpanel.setSize(this.list.getWidth(),this.list.getHeight());
			this.setLayout(new java.awt.BorderLayout());
			add(labelpanel,java.awt.BorderLayout.NORTH);
			add(listpanel,java.awt.BorderLayout.CENTER);
			this.setSize(listpanel.getWidth(),labelpanel.getHeight()+listpanel.getHeight());
			this.resize(1,1);
			this.setSize(listpanel.getWidth(),labelpanel.getHeight()+listpanel.getHeight());
			repaint();
			this.setVisible(true);
		}
		public void addItem(java.lang.String string)
		{
			this.list.add(string);
			this.list.select(this.list.getItemCount()-1);
		}
	
		java.awt.List list;
		java.awt.Label label;
		java.awt.Panel labelpanel,listpanel;
	}
	java.awt.Panel centerpanel,southpanel;
	listpanel allwords,wrongwords;
	java.awt.List totalwords,Incorrectwords;
	java.awt.Button close;
	java.awt.Label correct,incorrect;
}
