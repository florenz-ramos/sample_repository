package cmosample_form;
import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

public class MyForm2 extends JFrame {
	JLabel lbl1;
	JTextField txt1;
	JComboBox<String> cmb;
	JRadioButton rb;
	ButtonGroup bg;
	JCheckBox chk1;
	JTextArea txtArea;
	JButton btn1;
	JTextField txt2;
	JRadioButton rb2;
	JCheckBox chk2;
	JCheckBox chk3;
	public static double Gross = 0;
	public static double tax=0;
	public static double nPay=0;
	public static String val;
	public static String val1;
	public static String val2;
	public static double Fallowance=0;
	public static double Tallowance=0;
	public static double Dem=0;
	public MyForm2(String title) {
		super();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setLabel1();
		setTextBox();
		setComboBox();
		setButtonGroup();
		setCheckBox();
		setTextArea();
		setButton();
		setBackground(Color.GRAY);
		setTitle(title);
		setSize(350,500);
		setLocation(450,100);
		setResizable(false);
		setVisible(true);
	}
	public void setLabel1() {
		lbl1=new JLabel("NAME:");
		lbl1.setBounds(10,10,100,50);
		this.add(lbl1);
		JLabel lbl2=new JLabel("POSITION:");
		lbl2.setBounds(10,50,100,50);
		this.add(lbl2);
		JLabel lbl3=new JLabel("TYPE:");
		lbl3.setBounds(10,120,100,50);
		this.add(lbl3);
		JLabel lbl4=new JLabel("WITH:");
		lbl4.setBounds(10,170,100,50);
		this.add(lbl4);
		JLabel lbl5=new JLabel("HOURS WORK:");
		lbl5.setBounds(10,90,100,50);
		this.add(lbl5);
	}
	public void setTextBox() {
		txt1=new JTextField();
		txt1.setBounds(55,20,280,30);
		this.add(txt1);
		txt2=new JTextField();
		txt2.setBounds(100,95,238,30);
		this.add(txt2);
	}
	public void setComboBox() {
		String[] position= {"ADMIN","IT","ACCT","HR"};
		cmb=new JComboBox<String>(position);
		cmb.setBounds(70,60,265,30);
		cmb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String pos=cmb.getSelectedItem().toString();
			JOptionPane.showMessageDialog(MyForm2.this,"You selected "+pos);
			}
		});
		this.add(cmb);
	}
	public void setButtonGroup() {
		rb=new JRadioButton("PERMANENT");
		rb.setBounds(70,130,265,30);
		rb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getTax();
			}
		});
		rb2=new JRadioButton("CONTRACTUAL");
		rb2.setBounds(70,155,265,30);
		rb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tax=0.0;
			}
		});
		bg=new ButtonGroup();
		bg.add(rb);
		bg.add(rb2);
		this.add(rb);
		this.add(rb2);
	}
	public String GetText() {
		String fa=chk1.getText().toString();
		val=fa;
		return val;
		
	}
	public String GetText2() {
		String ta=chk2.getText().toString();
		val1=ta;
		return val1;
	}
	public String GetText3() {
		String d=chk3.getText().toString();
		val2=d;
		return val2; 
	}
	
	
	
	
	public void setCheckBox() {
		chk1=new JCheckBox("Food Allowance");
		chk1.setBounds(70,190,265,30);
	    //val=chk1.getText().toString();
		chk1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JCheckBox c=(JCheckBox) e.getSource();
			if(c.isSelected()) {
				JOptionPane.showMessageDialog(MyForm2.this,"STATUS:ON");
				GetText();	
				getFAllowance();
			}
			else {
				JOptionPane.showMessageDialog(MyForm2.this,"STATUS:OFF");
				val="";
				Fallowance=0.0;
			}
		}
	});
		this.add(chk1);
		chk2=new JCheckBox("Trasnfortation Allowance");
		chk2.setBounds(70,215,265,30);
		chk2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCheckBox c=(JCheckBox) e.getSource();
				if(c.isSelected()) {
					JOptionPane.showMessageDialog(MyForm2.this,"STATUS:ON");
					GetText2();
					getTAllowance();
				}
				else {
					JOptionPane.showMessageDialog(MyForm2.this,"STATUS:OFF");	
					val1="";
					Tallowance=0.0;
				}
			}
		});
		
		this.add(chk2);
		chk3=new JCheckBox("Deminimis");
		chk3.setBounds(70,240,265,30);
		chk3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCheckBox c=(JCheckBox) e.getSource();
				if(c.isSelected()) {
					JOptionPane.showMessageDialog(MyForm2.this,"STATUS:ON");
					GetText3();
					getDem();
				}
				else {
					JOptionPane.showMessageDialog(MyForm2.this,"STATUS:OFF");
					val2="";
					Dem=0.0;
				}
			}
		});
		this.add(chk3);
		
		
	}
	public double getFAllowance() {
		Fallowance=getGross()+800;
		return Fallowance;
	}
	public double getTAllowance() {
		Tallowance=getGross()+500;
		return Tallowance;
	}
	public double getDem() {
		Dem=getGross()*0.10;
		return Dem;
	}
	public double getNetPay() {
		nPay=getGross()-getTax();
		return nPay;
	}
	public double getTax() {
		tax=getGross()*0.20;
		return tax;
	}
	public double getGross() {
		try {
		String pos=cmb.getSelectedItem().toString();
		int hrsWork=Integer.parseInt(txt2.getText());				
		if(pos.equals("ADMIN")) {
			Gross=300*hrsWork;
			
			
		}
		else if(pos.equals("IT")) {
			Gross=350*hrsWork;
		}
		else if(pos.equals("ACCT")) {
			Gross=250*hrsWork;
		}
		else if(pos.equals("HR")) {
			Gross=300*hrsWork;
		}
		else { }
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(MyForm2.this,ex.getMessage());
		}
		return Gross;
	}
	public void setButton() {
		btn1=new JButton("COMPUTE");
		btn1.setBounds(235,270,100,30);
		btn1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String name=txt1.getText().toString();
				String pos=cmb.getSelectedItem().toString();
				int hrsWork=Integer.parseInt(txt2.getText());
				double tal=Tallowance+500;
				txtArea.setText(
						"NAME:"+name+"-"+pos+
						"\n"+"Hours Work:"+hrsWork+
						"\n"+"Gross:"+getGross()+
						"\n"+"Tax:"+tax+
						"\n"+"With:"+"\n"+
						val +":"+Fallowance+"\n"+
						val1+":"+tal+"\n"+
						val2+":"+Dem+
						"\n"+"NetPay:"+getNetPay());
			}	
		});
	
		this.add(btn1);
	}
	
	
	public void setTextArea() {
		txtArea=new JTextArea();
		txtArea.setBounds(10,305,325,155);
		this.add(txtArea);
	}
}
