package type;
public class ScoreDlg extends java.awt.Dialog
{
	public ScoreDlg(java.awt.Frame parent,Type_master tymas)
	{
		super(parent,"Score");
			this.setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage("textcur.gif"));
			this.setLayout(new java.awt.BorderLayout());
		centerpanel=new javax.swing.JPanel();
		centerpanel.setLayout(new java.awt.BorderLayout());
		System.out.println("score in init success \n getDetailedArry");
		tebcont= new java.lang.String[11][3];
		/*
		*insert the code to get the score in tabcont.
		*/
		scoreTable=new javax.swing.JTable(tebcont,tebhead);
		centerpanel.add(scoreTable);
		   addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
			dispose();
						}
        });
		centerpanel.setSize(scoreTable.getWidth(),scoreTable.getHeight());
		add(centerpanel);
		validate();
		invalidate();
		repaint();
		setSize(350,195);
		show();
		repaint();
		setResizable(false);
	}
	java.lang.String[] tebhead={"No","Name","Score" };
	java.lang.String[][] tebcont;
	javax.swing.JTable scoreTable;
	javax.swing.JPanel centerpanel;
}
