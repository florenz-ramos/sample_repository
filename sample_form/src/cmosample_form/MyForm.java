package cmosample_form;
import javax.swing.*;
import java.awt.event.*;

public class MyForm extends JFrame{
	JButton btn1;
	JTextField txt1;
	JPasswordField txt2;
	JLabel lbl1;
	
	public MyForm(String title) {
		super();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setButton();
		setTextBox();
		setPassword();
		setLabel1();
		setLabel2();
		setTitle(title);
		setSize(400,200);
		setLocation(450,250);	
		setResizable(false);
		setVisible(true);
	}


	public void setButton() {
		btn1=new JButton("LOGIN");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user=txt1.getText().toString();
				String pass=txt2.getText().toString();
				if(user.equals("admin")&& pass.equals("12345")) {
					JOptionPane.showMessageDialog(MyForm.this,"Login Successfully");
					new MyForm2("Form 2");
					
				}
				else {
					JOptionPane.showMessageDialog(MyForm.this,"Login Failed");
				}
			}
		});
		btn1.setBounds(290,120,100,50);
		this.add(btn1);
	}
	public void setTextBox() {
		txt1=new JTextField();
		txt1.setBounds(90,10,300,50);
		this.add(txt1);
	}
	public void setPassword() {
		txt2=new JPasswordField();
		txt2.setBounds(90,65,300,50);
		this.add(txt2);
		
	}
	public void setLabel1() {
		lbl1=new JLabel("USERNAME:");
		lbl1.setBounds(10,10,100,50);
		this.add(lbl1);
	}
	public void setLabel2() {
		lbl1=new JLabel("PASSWORD:");
		lbl1.setBounds(10,60,100,50);
		this.add(lbl1);
	}
	
	
	
	
	
	
	
}
