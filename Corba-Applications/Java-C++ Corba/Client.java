import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.NotFound;


public class Client extends JFrame {
	static int param1,param2,param3;
	static Add hello;
	JComboBox cb=new JComboBox(new Object[]{"Add","Substract","Division","Multiplication"});
	JTextField tf1=new JTextField(20);
	JTextField tf2=new JTextField(20);
	JButton submit=new JButton("Submit");
	Client(){
		setLayout(new BorderLayout());
		JLabel label=new JLabel("Enter Values for C++ Server");
		add(label,BorderLayout.NORTH);
		
		JPanel p2=new JPanel(new GridLayout(3,2,5,5));
		JLabel a=new JLabel("Enter first integer");
		
		
		
		JLabel b=new JLabel("Enter second integer");
		

		JLabel operation=new JLabel("Choose Operation");
		
		p2.add(a);
		p2.add(tf1);
		p2.add(b);
		p2.add(tf2);
		p2.add(operation);
		p2.add(cb);
		add(p2,BorderLayout.CENTER);
		
		
		
		
		add(submit,BorderLayout.SOUTH);
		
	
		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				param1=Integer.parseInt(tf1.getText());
				param2=Integer.parseInt(tf2.getText());
				param3=cb.getSelectedIndex();
				long a =hello.math_op(param1, param2, param3);
                        System.out.println("Result:" +a);
			JOptionPane.showMessageDialog(null, "Result : " + Long.toString(a));
				
		return;
			}
			});
		
		
	}
	
	public static void main(String args[]){
		JFrame frame=new Client();
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
        if (orb == null) System.exit(-1);

		
		try {

	       
			org.omg.CORBA.Object ns_obj = orb.resolve_initial_references("NameService");
            org.omg.CosNaming.NamingContext nc
                = org.omg.CosNaming.NamingContextHelper.narrow(ns_obj);
            org.omg.CosNaming.NameComponent [] path
                = { new org.omg.CosNaming.NameComponent("TestServer", "") };
            org.omg.CORBA.Object obj = nc.resolve(path);
            hello = AddHelper.narrow(obj);

			
			System.out.println("Resolved the Naming Service\n");
		}catch (Exception e) {
			System.out.println("Exception    " +e);

	        }
			
	}

}

