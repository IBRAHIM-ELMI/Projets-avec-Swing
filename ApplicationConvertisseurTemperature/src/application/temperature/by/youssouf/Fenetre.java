package application.temperature.by.youssouf;

import java.awt.BorderLayout;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 * 
 * @author Youssouf IBRAHIM ELMI
 * mail: yous-souf93@hotmail.com
 */

public class Fenetre extends JFrame{
	static int cel; 
	public Fenetre () {
		this.setTitle("Convertisseur des témperatures. ->By Youssouf");
		
		
		 
		JPanel jp = new JPanel();
		JButton bf = new JButton("Conversion en Fahrenheit");
		JButton bk = new JButton("Conversion en Kelvin");
		JButton br = new JButton("restart");
		jp.add(bf, BorderLayout.WEST);
		jp.add(br, BorderLayout.CENTER);
		jp.add(bk, BorderLayout.EAST);
		add(jp, BorderLayout.CENTER);
		
		JPanel jp1 = new JPanel();
		JLabel text = new JLabel("Veuillez saisir votre degré Celsicus => ");
		JTextField textField = new JTextField();
		textField.setColumns(5);
		
		jp1.add(text, BorderLayout.WEST);
		jp1.add(textField, BorderLayout.EAST);
		add(jp1, BorderLayout.NORTH);
	
		//affichage fahrenheit
		JPanel jp2 = new JPanel();
		 JLabel l = new JLabel(); 
		 jp2.add(l,BorderLayout.EAST);
		 add(jp2, BorderLayout.SOUTH);
	
		// Action button Fahrenheit
		bf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent r) {
				try {
					cel = Integer.parseInt(textField.getText());//recupere le donnée qui se trouve dans le JTextField
					float result = Convertisseur.ConverterFahrenheit(cel);
					l.setText(result+" °F");
					pack();
				} catch (NumberFormatException exp) {
					String message= "champs vide ou contient des caracteres!!!";
					int type=JOptionPane.ERROR_MESSAGE; 
					JOptionPane.showMessageDialog(null,message,"Message d'erreur",type);   
				}	
			}
		});
		// Action button Kelvin
		bk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {cel = Integer.parseInt(textField.getText());//recupere le donnée qui se trouve dans le JTextField
					int result1 = (int) Convertisseur.ConverterKelvin(cel);
					l.setText(result1+" K");
						pack();
					}catch (NumberFormatException exp) {
						String message= "champs vide ou contient des caracteres!!!";
						int type=JOptionPane.ERROR_MESSAGE; 
						JOptionPane.showMessageDialog(null,message,"Message d'erreur",type);	    
					}
			}
		});	
			// Action button restar
		br.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
					l.setText("");
					pack();
			}
		});
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();	
	}

}
