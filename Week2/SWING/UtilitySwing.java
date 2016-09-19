
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.StringBufferInputStream;
import java.util.HashSet;
import java.util.Set;

import javax.swing.*;

class Utility extends JFrame implements ActionListener{
	private JButton countLetters, removeDups, reverseLetters;
	private JTextField op, ip;
	private JLabel output, input;
	public Utility(){
		setTitle(" String Utility");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		int width = 130;
		int height = 30;
		
		setBounds(300,200,800,500);
		countLetters = new JButton("Count Letters");
		add(countLetters).setBounds(100,20,width,height);
		
		reverseLetters = new JButton("Reverse Letters");
		add(reverseLetters).setBounds(100,80,width,height);
		
		removeDups = new JButton("Remove Dups Letters");
		add(removeDups).setBounds(100,150,width,height);
		
		input = new JLabel("Input");
		add(input).setBounds(260,50,130,20);
		
		ip = new JTextField();
		add(ip).setBounds(260,80,130,20);
				
		output = new JLabel("Output");
		add(output).setBounds(260,100,130,20);
		
		op = new JTextField();
		add(op).setBounds(260,130, 130,20);
		
		countLetters.addActionListener(this);
		removeDups.addActionListener(this);
		reverseLetters.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s = e.getActionCommand();
		String  userInput = ip.getText();
		
		if(s.equals("Count Letters")){
			int text_length = userInput.length();
			String st = ""+text_length;
			op.setText(st);
		}else if(s.equals("Reverse Letters")){
			String reverse = "";
			for(int i = userInput.length()-1; i >= 0; i--){
				reverse =reverse +""+userInput.charAt(i);
			}
			op.setText(reverse);
		}else if(s.equals("Remove Dups Letters")){
			char[] newStr = new char[userInput.length()];
			StringBuilder sb = new StringBuilder();
			for(int i=0; i< userInput.length(); i++)
			{
				String st = Character.toString(userInput.charAt(i));
			
				if(!sb.toString().contains(st)){
					sb.append(st);
				}
			}
			
			op.setText(sb.toString());
		}
}
}
public class UtilitySwing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Utility u = new Utility();
		u.setVisible(true);
	}
}