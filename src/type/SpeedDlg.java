package type;
public class SpeedDlg extends java.awt.Dialog implements java.awt.event.ActionListener,java.awt.event.ItemListener
{
	public SpeedDlg(java.awt.Frame parent,type.GenerateRandomText grt)
	{
		super(parent,"Speed");
		this.setIconImage(type.Global.icon_img);
		this.grt=grt;
		this.setLayout(new java.awt.BorderLayout());
		cbgpanel=new java.awt.Panel();
		Labelpanel=new java.awt.Panel();
		ButtonPanel=new java.awt.Panel();
		cbgpanel.setLayout(new java.awt.GridLayout(8,1));
			mainCbg=new java.awt.CheckboxGroup();
		//	cbgpanel.add(mainCbg);
		speedcbg=new java.awt.CheckboxGroup();
		slow=new java.awt.Checkbox("Slow",speedcbg,true);
		medium=new java.awt.Checkbox("medium",speedcbg,false);
		fast=new java.awt.Checkbox("Fast",speedcbg,false);
		slow.addItemListener(this);
		medium.addItemListener(this);
		fast.addItemListener(this);
		option=new java.awt.Checkbox[7];
		for (int i=0,sint=30;i<7 ;i++,sint=sint+10 )
		{
			option[i]=new java.awt.Checkbox(sint+"Words",mainCbg,false);
			cbgpanel.add(option[i]);
			option[i].addItemListener(this);
		}
	
		this.add(Labelpanel,java.awt.BorderLayout.NORTH);
		this.add(cbgpanel,java.awt.BorderLayout.CENTER);
		this.add(ButtonPanel,java.awt.BorderLayout.SOUTH);
		Labelpanel.add(new java.awt.Label("Select Typing Speed"));
			Labelpanel.add(slow);
		Labelpanel.add(medium);
		Labelpanel.add(fast);
		ok_Button=new java.awt.Button("OK");
		ok_Button.addActionListener(this);
		ButtonPanel.add(ok_Button);
		option[0].setState(true);
		  addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
				for (int i=0,scr=30;i<7 ;i++ )
				{
					if (option[i].getState())
					{
						speedint=scr;
					}
					scr=scr+10;
				}
				if (slow.getState())
				{
					delaylong=3000;
				}
				else
				{
					if (medium.getState())
					{
						delaylong=2000;
					}
					else
						delaylong=1000;
				}
				okclicked=true;
				dispose();
            }
        });
		okclicked=false;
		validate();
		invalidate();
		setSize(450,300);
		repaint();	
		show();
		setResizable(false);
	}
	public void actionPerformed(java.awt.event.ActionEvent e)
	{
		for (int i=0,scr=30;i<7 ;i++ )
				{
					if (option[i].getState())
					{
						speedint=scr;
					}
					scr=scr+10;
				}
				if (slow.getState())
				{
					delaylong=3000;
				}
				else
				{
					if (medium.getState())
					{
						delaylong=2000;
					}
					else
						delaylong=1000;
				}
		okclicked=true;
		this.dispose();

	}
	public void itemStateChanged(java.awt.event.ItemEvent ie)
	{
		if (ie.getSource()==option[0])
		{
			speedint=30;
		}
		if (ie.getSource()==option[1])
		{
			speedint=40;
		}

if (ie.getSource()==option[2])
		{
			speedint=50;
		}

if (ie.getSource()==option[3])
		{
			speedint=60;
		}

if (ie.getSource()==option[4])
		{
			speedint=70;
		}
		if (ie.getSource()==option[5])
		{
			speedint=80;
		}
		if (ie.getSource()==option[6])
		{
			speedint=90;
		}
		if (ie.getSource()==slow)
		{
			delaylong=3000;
		}
		if (ie.getSource()==medium)
		{
			delaylong=2000;
		}
		if (ie.getSource()==fast)
		{
			delaylong=1000;
		}

	}
	public int getSpeedInt()
	{
		return speedint;
	}
	public long getSpeed()
	{
		return delaylong;
	}
	public boolean getOk()
	{
		return okclicked;
	}
	java.awt.Panel cbgpanel,Labelpanel,ButtonPanel;
	java.awt.CheckboxGroup mainCbg;
	java.awt.Checkbox[] option;
	java.awt.CheckboxGroup speedcbg;
	java.awt.Checkbox slow,medium,fast;
	java.awt.Button ok_Button;
	int speedint=30;
	long delaylong=1000;
	type.GenerateRandomText grt;
	boolean okclicked=false;
}
