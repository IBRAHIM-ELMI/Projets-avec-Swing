package application.calculatrice;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;



public class Fenetre extends JFrame {
	static double val1, val2;
	static double result;
	String message;
	int type;
	public Fenetre() {
		
		this.setTitle("Réaliser par youssouf");
		
		JPanel jp = new JPanel();
		JLabel lb = new JLabel("<html><h3>Youssouf IBRAHIM ELMI</h3> <br>Formation à ISSMI <br>Date de début : 04/02/2019</html>");
		jp.add(lb);
		add(jp, BorderLayout.LINE_START);
		
		
		JPanel jp8  = new JPanel(); 
		JPanel jp1 = new JPanel();
		JLabel lb1 = new JLabel("Veuillez saisir votre premier valeur =>");
		JTextField text1 = new JTextField();
		text1.setColumns(10);
		jp1.add(lb1);
		jp1.add(text1);
		jp8.add(jp1, BorderLayout.WEST);
		
		JPanel jp2 = new JPanel();
		JLabel lb2 = new JLabel("Veuillez saisir votre deuxième valeur =>");
		JTextField text2 = new JTextField();
		text2.setColumns(10);
		jp2.add(lb2);
		jp2.add(text2);
		jp8.add(jp2,BorderLayout.EAST);
		add(jp8,BorderLayout.NORTH);
		
	
		JPanel panel = new JPanel(new GridLayout(0, 1));
		Border border = BorderFactory.createTitledBorder("Sélectionner votre choix d'operation ");
		panel.setBorder(border);
		ButtonGroup group = new ButtonGroup();
		JRadioButton radio1 = new JRadioButton("+");
		radio1.setMnemonic(KeyEvent.VK_1);
		JRadioButton radio2 = new JRadioButton("-");
		radio2.setMnemonic(KeyEvent.VK_2);
		JRadioButton radio3 = new JRadioButton("*");
		radio3.setMnemonic(KeyEvent.VK_3);
		radio3.setActionCommand("Choix_3");
		JRadioButton radio4 = new JRadioButton("/");
		radio4.setMnemonic(KeyEvent.VK_4);
		
		group.add(radio1);
		panel.add(radio1);
		group.add(radio2);
		panel.add(radio2);
		group.add(radio3);
		panel.add(radio3);
		group.add(radio4);
		panel.add(radio4);
		add(panel, BorderLayout.CENTER);
		
		
		JPanel jp3 = new JPanel();
		JButton button = new JButton("Valider");
		jp3.add(button);
		add(jp3, BorderLayout.LINE_END);
		
		JPanel jp4 = new JPanel();
		JLabel affiche = new JLabel();
		jp4.add(affiche);
		add(jp4, BorderLayout.PAGE_END);
		
		
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					val1 = Integer.parseInt(text1.getText());//recupere le donnée qui se trouve dans le JTextField1
					val2 = Integer.parseInt(text2.getText());//recupere le donnée qui se trouve dans le JTextField2
					affiche.setText("Votre resulttat = " + result);
					pack();	
				} catch (NumberFormatException exp) {
					message= "champs vide ou contient des caracteres!!!";
					type=JOptionPane.ERROR_MESSAGE; 
					JOptionPane.showMessageDialog(null,message,"Message d'erreur",type);   
				}
				
			}
		});
		
		radio1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {	
					val1 = Integer.parseInt(text1.getText());//recupere le donnée qui se trouve dans le JTextField1
					val2 = Integer.parseInt(text2.getText());//recupere le donnée qui se trouve dans le JTextField2
					result = Calcule.addition(val1, val2);
				}catch (NumberFormatException exp) {
					message= "Saisissez d'abord les valeurs!!!";
					type=JOptionPane.ERROR_MESSAGE; 
					JOptionPane.showMessageDialog(null,message,"Message d'erreur",type);   
				}
			}
			
		});
		
		radio2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					val1 = Integer.parseInt(text1.getText());//recupere le donnée qui se trouve dans le JTextField1
					val2 = Integer.parseInt(text2.getText());//recupere le donnée qui se trouve dans le JTextField2
					result = Calcule.soustraction(val1, val2);
				}catch (NumberFormatException exp) {
					message= "Saisissez d'abord les valeurs!!!";
					type=JOptionPane.ERROR_MESSAGE; 
					JOptionPane.showMessageDialog(null,message,"Message d'erreur",type);   
				}
			}
			
		});
		
		radio3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
					val1 = Integer.parseInt(text1.getText());//recupere le donnée qui se trouve dans le JTextField1
					val2 = Integer.parseInt(text2.getText());//recupere le donnée qui se trouve dans le JTextField2
					result = Calcule.multiplication(val1, val2);
				}catch (NumberFormatException exp) {
					message= "Saisissez d'abord les valeurs!!!";
					type=JOptionPane.ERROR_MESSAGE; 
					JOptionPane.showMessageDialog(null,message,"Message d'erreur",type);   
				}
			}
			
		});
		
		radio4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					val1 = Integer.parseInt(text1.getText());//recupere le donnée qui se trouve dans le JTextField1
					val2 = Integer.parseInt(text2.getText());//recupere le donnée qui se trouve dans le JTextField2
					result = Calcule.division(val1, val2);
					}catch (NumberFormatException exp) {
						message= "Saisissez d'abord les valeurs!!!";
						type=JOptionPane.ERROR_MESSAGE; 
						JOptionPane.showMessageDialog(null,message,"Message d'erreur",type);   
					}
			}
			
		});
		
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		
	}

}
