package type;
public class AboutDlg extends java.awt.Dialog implements java.awt.event.ActionListener
{
	public AboutDlg(java.awt.Frame parent)
	{
		super(parent,"About Type_master");
			this.setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage("../images/textcur.gif"));
		centerpanel=new java.awt.Panel();
		southpanel=new java.awt.Panel();
		northpanel=new java.awt.Panel();
		typlogo=new javax.swing.ImageIcon("../images/textcur.gif");
		//SmtechLogo=new javax.swing.ImageIcon("../images/smtechLogo.JPG");
		Ok__button=new java.awt.Button("     OK     ");
		text=new javax.swing.JLabel(typlogo);
		text.setText("Type_master version1.6.0");
		centerpanel.add(text);
		centerpanel.add(new javax.swing.JLabel("©2014"));
		centerpanel.add(new javax.swing.JLabel("girish joshi"));
		centerpanel.add(new javax.swing.JLabel("This program comes with ABSOLUTELY NO WARRANTY"));
		centerpanel.add(new javax.swing.JLabel(" Contact: girish946@gmail.com"));
		southpanel.add(Ok__button);
		northpanel.add(new javax.swing.JLabel(SmtechLogo));
		Ok__button.addActionListener(this);
		        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
			dispose();
            }
        });
		this.add(northpanel,java.awt.BorderLayout.NORTH);
		this.add(centerpanel,java.awt.BorderLayout.CENTER);
		this.add(southpanel,java.awt.BorderLayout.SOUTH);
		validate();
		invalidate();
		repaint();
		setVisible(true);
		setSize(450,350);
		setResizable(false);
	}
	public void actionPerformed(java.awt.event.ActionEvent e)
	{
		dispose();
	}
	java.awt.Panel centerpanel,southpanel,northpanel;
	java.awt.Button Ok__button;
	javax.swing.JLabel text;
	javax.swing.ImageIcon typlogo,SmtechLogo;
}
