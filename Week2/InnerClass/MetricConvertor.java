import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.sun.glass.ui.Pixels.Format;


class Convertor extends JFrame{
	private JButton b1;
	private JLabel mile, pound, gallon, fahren, kilometer, kilogram, litre, celcius;
	private JTextField tmile, tpound, tgallon, tfahren, tkilometer, tkilogram, tlitre, tcelcius;
	int width = 80;
	int height = 30;
	public Convertor() {
			setTitle("Metric Conversion Assistant");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setBounds(200,200,500,250);
			setLayout(null);
			setVisible(true);
			
			mile = new JLabel("Miles");
			add(mile).setBounds(20, 20, width, height);
			
			tmile = new JTextField();
			add(tmile).setBounds(80, 20, width, height);
			
			kilometer = new JLabel("Kilometer");
			add(kilometer).setBounds(180, 20, width, height);
			
			tkilometer = new JTextField();
			add(tkilometer).setBounds(260, 20, width, height);
			
			pound = new JLabel("Pound");
			add(pound).setBounds(20, 50, width, height);
			
			tpound = new JTextField();
			add(tpound).setBounds(80, 50, width, height);
			
			kilogram = new JLabel("Kilogram");
			add(kilogram).setBounds(180, 50, width, height);
			
			tkilogram = new JTextField();
			add(tkilogram).setBounds(260, 50, width, height);
			
			gallon = new JLabel("Gallon");
			add(gallon).setBounds(20, 80, width, height);
			
			tgallon = new JTextField();
			add(tgallon).setBounds(80, 80, width, height);
			
			litre = new JLabel("Litre");
			add(litre).setBounds(180, 80, width, height);
			
			tlitre = new JTextField();
			add(tlitre).setBounds(260, 80, width, height);
			
			fahren = new JLabel("Farahen");
			add(fahren).setBounds(20, 110, width, height);
			
			tfahren = new JTextField();
			add(tfahren).setBounds(80, 110, width, height);
			
			celcius = new JLabel("Celcius");
			add(celcius).setBounds(180, 110, width, height);
			
			tcelcius = new JTextField();
			add(tcelcius).setBounds(260, 110, width, height);
			
			b1 = new JButton("Convert");
			add(b1).setBounds(140, 140, 120, height);
			
			b1.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					double mile = Double.parseDouble(tmile.getText());
//					double km = Double.parseDouble(tkilometer.getText());
					double p = Double.parseDouble(tpound.getText());
//					double kg = Double.parseDouble(tkilogram.getText());
					double gal = Double.parseDouble(tgallon.getText());
//					double lit = Double.parseDouble(tlitre.getText());
					double f = Double.parseDouble(tfahren.getText());
//					double c = Double.parseDouble(tcelcius.getText());
					
					double convertedkm = Math.round((mile / 1.6) * 100.0)/100.0 ;
					double convertedkg = Math.round((p / 0.45) *100.0)/100.0;
					double convertedlit = Math.round((gal / 3.78)*100.0)/100.0;
					double convertedc = Math.round(((f - 32) / 1.8)*100.0)/100.0;
					
					
//					double convertedmile = km * 1.6;
//					double convertedpound = kg * 0.45;
//					double convertedg = lit * 3.78;
//					double convertedf = (1.8 * c) + 32;
//					
					tkilometer.setText(Double.toString(convertedkm));
					tkilogram.setText(Double.toString(convertedkg));
					tlitre.setText(Double.toString(convertedlit));
					tcelcius.setText(Double.toString(convertedc));
					
//					tmile.setText(Double.toString(convertedkm));
//					tpound.setText(Double.toString(convertedpound));
//					tgallon.setText(Double.toString(convertedg));
//					tfahren.setText(Double.toString(convertedf));
				}
			} );
		// TODO Auto-generated constructor stub
	}
}
public class MetricConvertor {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Convertor();
	}

}
