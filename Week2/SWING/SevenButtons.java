import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.invoke.SwitchPoint;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class SevenButtons extends JFrame implements ActionListener {
	private JButton b1, b2, b3, b4, b5, b6, b7;
	private int w = 150;
	private int h = 100;
	private JLabel tx;
	public SevenButtons(){
		setTitle("Rainbow Color Frame");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setBounds(150,200,1200,400);
		setResizable(true);
		setVisible(true);
		
		b1 = new JButton("R");
		b1.setPreferredSize(new Dimension(150,300));
		add(b1).setBackground(Color.RED);
		
		b2 =new JButton("O");
		b2.setPreferredSize(new Dimension(150,300));
		add(b2).setBackground(Color.ORANGE);
		
		b3 =new JButton("G");
		b3.setPreferredSize(new Dimension(150,300));
		add(b3).setBackground(Color.GREEN);
		
		b4 =new JButton("B");
		b4.setPreferredSize(new Dimension(150,300));
		add(b4).setBackground(Color.BLUE);
		
		b5 =new JButton("Y");
		b5.setPreferredSize(new Dimension(150,300));
		add(b5).setBackground(Color.YELLOW);
		
		b6 =new JButton("I");
		b6.setPreferredSize(new Dimension(150,300));
		add(b6).setBackground(Color.GRAY);
		
		b7 =new JButton("V");
		b7.setPreferredSize(new Dimension(150,300));
		add(b7).setBackground(Color.lightGray);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		
		tx = new JLabel();
		tx.setBackground(Color.ORANGE);
		add(tx);
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SevenButtons();
		
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton src = (JButton) e.getSource();

		if(e.getActionCommand() == "R"){
			JOptionPane.showMessageDialog(src, "Red  signifies passion, vitality, enthusiasm and security ",
					"Color- Meaning: " + src.getText(), JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getActionCommand() == "V"){
			JOptionPane.showMessageDialog(src, "Deeper shades of violet or purple denote high spiritual mastery. ",
					"Color- Meaning: " + src.getText(), JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getActionCommand() == "I"){
			JOptionPane.showMessageDialog(src, "Indigo  Indigo colored gem stones are often " +
					"used for spiritual attainment, psychic abilities, self awareness and enhancement of Intuition.",
					"Color- Meaning: " + src.getText(), JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getActionCommand() == "B"){
			JOptionPane.showMessageDialog(src, "Blue  associated with Spirituality and Divinity. ",
					"Color- Meaning: " + src.getText(), JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getActionCommand() == "G"){
			JOptionPane.showMessageDialog(src, "Green  denotes fertility, growth, balance, health and wealth. ",
					"Color- Meaning: " + src.getText(), JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getActionCommand() == "Y"){
			JOptionPane.showMessageDialog(src, "Yellow  signifies  clarity of thought, wisdom, orderliness and energy.",
					"Color- Meaning: " + src.getText(), JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getActionCommand() == "O"){
			JOptionPane.showMessageDialog(src, "Orange  It is a dynamic color representing creativity, practicality, playfulness as well as equilibrium or control",
					"Color- Meaning: " + src.getText(), JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
