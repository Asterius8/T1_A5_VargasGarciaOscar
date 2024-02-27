import java.awt.*;
import javax.swing.*;

class VentanaPrincipal extends JFrame{
	
	//Atributos----------------------------------------------------------------------------------------------------------------------------------------------------------------
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	
	JLabel txtConver, txtA, txtIgual;
	JTextField cajaAConver, cajaResu;
	JComboBox<String> comboConver, comboResu;
	
	//Constructor(es)----------------------------------------------------------------------------------------------------------------------------------------------------------
	public VentanaPrincipal() {
		
		getContentPane().setLayout(gbl);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Conversor Temperatura");
		setVisible(true);
		
		txtConver = new JLabel("Convertir: ");
		agregarComponente(txtConver, 0, 0, 1, 1);
		
		txtA = new JLabel("A:");
		agregarComponente(txtA, 0, 1, 1, 1);
		
		txtIgual = new JLabel("=");
		agregarComponente(txtIgual, 2, 1, 1, 1);
		
		cajaAConver = new JTextField("70");
		agregarComponente(cajaAConver, 1, 0, 1, 1);
		
		cajaResu = new JTextField();
		agregarComponente(cajaResu, 3, 1, 1, 1);
		
		comboConver = new JComboBox<String>();
		agregarComponente(comboConver, 2, 0, 2, 1);
		comboConver.addItem("°Celsius");
		comboConver.addItem("°Fahrenheit");
		comboConver.addItem("°Kelvin");
		comboConver.addItem("°Rankine");
		
		comboResu = new JComboBox<String>();
		agregarComponente(comboResu, 1, 1, 1, 1);
		comboResu.addItem("°Celsius");
		comboResu.addItem("°Fahrenheit");
		comboResu.addItem("°Kelvin");
		comboResu.addItem("°Rankine");
		
		pack();
		setLocationRelativeTo(null);
		
	}
	//Metodos------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public void agregarComponente(JComponent c, int x, int y, int w, int h){
		
		gbc.gridx = x;
		gbc.gridy =y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gbc.ipadx = 10;
		gbc.ipady = 10;
		gbl.setConstraints(c, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(c);
		
	}//Metodo
}


public class Practica_COMBOBOX {

	public static void main(String[] args) {
		
SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				
				new VentanaPrincipal();
				
			}
			
		}
		
		);

	}

}
