package org.fisco.bcos.asset.UI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.fisco.bcos.asset.client.AssetClient;
import java.awt.Label;
import java.awt.TextField;

public class gui extends JFrame{
	Boolean ispain=false;
	AssetClient client = new AssetClient();
	public gui() {
		super("client");
		this.setSize(800, 400);
		this.setBackground(Color.WHITE);
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ispain=false;
		init(this.getGraphics());
		this.setVisible(true);
		
		try {
			//client.initialize();
			client = new AssetClient();
			client.initialize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void addSearch() {
		
	}
	
	void addHuan() {
	}
	
	public void init(Graphics g) {
		addDeploy();
		addSearch();
		addTransfer();
		addHuan();
	}
	
	void addDeploy() {
		getContentPane().setLayout(null);
		JButton deploy = new JButton("Bank Register");
		deploy.setBackground(Color.LIGHT_GRAY);
		deploy.setForeground(Color.BLACK);
		deploy.setBounds(103, 3, 144, 40);
		getContentPane().add(deploy);
		JTextField jt = new JTextField();
		jt.setBounds(366, 66, 181, 31);
		getContentPane().add(jt);
		jt.setText("");
		jt.setColumns(20);
		JTextField totext = new JTextField("");
		totext.setBounds(141, 110, 106, 31);
		getContentPane().add(totext);
		totext.setColumns(10);
		JTextField fromText = new JTextField("");
		fromText.setBounds(135, 71, 106, 26);
		getContentPane().add(fromText);
		fromText.setColumns(10);
		JTextField amount = new JTextField("");
		amount.setBounds(137, 153, 108, 31);
		getContentPane().add(amount);
		amount.setColumns(10);
		
		JButton jb = new JButton("Tranfer");
		jb.setBackground(Color.LIGHT_GRAY);
		jb.setBounds(103, 280, 144, 40);
		getContentPane().add(jb);
		JLabel jt2 = new JLabel("The result: ");
		jt2.setBounds(336, 105, 78, 40);
		getContentPane().add(jt2);
		JTextField pay = new JTextField();
		pay.setBounds(381, 259, 145, 34);
		getContentPane().add(pay);
		pay.setText("");
		pay.setColumns(10);
		JButton dopay = new JButton("Payment");
		dopay.setBackground(Color.LIGHT_GRAY);
		dopay.setBounds(554, 255, 130, 40);
		getContentPane().add(dopay);
		JButton query = new JButton("Query");
		query.setBackground(Color.LIGHT_GRAY);
		query.setBounds(578, 68, 106, 31);
		getContentPane().add(query);
		JLabel re = new JLabel("");
		re.setBounds(481, 110, 307, 26);
		getContentPane().add(re);
		
		TextField textField = new TextField();
		textField.setBounds(468, 172, 74, 26);
		getContentPane().add(textField);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(466, 204, 76, 26);
		getContentPane().add(textField_1);
		
		JButton btnAcReceivable = new JButton("AC Receivable");
		btnAcReceivable.setBackground(Color.LIGHT_GRAY);
		btnAcReceivable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("transfer");
				client.transferOfAccountsReceivable2Chain(totext.getText(), fromText.getText(),new BigInteger(amount.getText()));
			}
		});
		btnAcReceivable.setBounds(103, 216, 144, 40);
		getContentPane().add(btnAcReceivable);
		
		JButton btnNewButton = new JButton("Finance");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a = textField.getText();
				String b = textField_1.getText();
				System.out.println("finance: appler" +a+ "amount:"+  b+"succeed");
			}
		});
		btnNewButton.setBounds(588, 190, 96, 40);
		getContentPane().add(btnNewButton);
		
		Label label = new Label("Applier");
		label.setBounds(366, 160, 96, 38);
		getContentPane().add(label);
		
		Label label_1 = new Label("Amount");
		label_1.setBounds(361, 204, 84, 26);
		getContentPane().add(label_1);
		
		Label label_2 = new Label("From");
		label_2.setBounds(46, 110, 68, 21);
		getContentPane().add(label_2);
		
		Label label_3 = new Label("To");
		label_3.setBounds(61, 66, 68, 21);
		getContentPane().add(label_3);
		
		Label label_4 = new Label("Amount");
		label_4.setBounds(46, 151, 68, 21);
		getContentPane().add(label_4);
		
		
		query.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=new String();
				s=client.getReceiptsAmount(jt.getText());
				String u=client.getReceiptsfromUser(jt.getText());
				System.out.println("get user account: "+s+" and the user "+u);
				re.setText(s+" from "+u);
			}
		});
		dopay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client.paymentSettlement2Chain(pay.getText());
				System.out.println("pay back");
			}
		});
		
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("transfer");
				client.transferOfAccountsReceivable2Chain(totext.getText(), fromText.getText(),new BigInteger(amount.getText()));
			}
		});
		
		deploy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("deploy");
				client.deployAssetAndRecordAddr();
			}
		});
	}
	
	void addTransfer() {
	}
	
	public static void main(String[] args) {
		gui a=new gui();
		
	}
}
