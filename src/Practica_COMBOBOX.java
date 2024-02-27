import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

class VentanaPrincipal extends JFrame implements ActionListener, KeyListener{
	
	//Atributos----------------------------------------------------------------------------------------------------------------------------------------------------------------
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	ConversorTemperatura ct = new ConversorTemperatura();
	
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
		cajaResu.setEditable(false);
		
		comboConver = new JComboBox<String>();
		agregarComponente(comboConver, 2, 0, 2, 1);
		comboConver.addItem("Elija una opcion...");
		comboConver.addItem("°Celsius");
		comboConver.addItem("°Fahrenheit");
		comboConver.addItem("°Kelvin");
		comboConver.addItem("°Rankine");
		comboConver.addActionListener(this);
		
		comboResu = new JComboBox<String>();
		agregarComponente(comboResu, 1, 1, 1, 1);
		comboResu.addItem("Elija una opcion...");
		
		cajaAConver.addKeyListener(this);
		
		comboConver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				byte opcion = (byte) comboConver.getSelectedIndex();
				
				if (opcion == 1) {

					comboResu.removeAllItems();
					comboResu.addItem("°Fahrenheit");
					comboResu.addItem("°Kelvin");
					comboResu.addItem("°Rankine");
					comboResu.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {

							byte opcion = (byte) comboResu.getSelectedIndex();
							
							if (opcion == 0) {
								
								cajaResu.setText( String.valueOf( ct.caF( Double.parseDouble( cajaAConver.getText() ) ) ) );
								
							} else if(opcion == 1) {

								cajaResu.setText( String.valueOf( ct.caK( Double.parseDouble( cajaAConver.getText() ) ) ) );
								
							}else if(opcion == 2) {

								cajaResu.setText( String.valueOf( ct.caR( Double.parseDouble( cajaAConver.getText() ) ) ) );
								
							}
							
						}
					});
					
				}else if(opcion == 2) {

					comboResu.removeAllItems();
					comboResu.addItem("°Celsius");
					comboResu.addItem("°Kelvin");
					comboResu.addItem("°Rankine");
					comboResu.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {

							byte opcion = (byte) comboResu.getSelectedIndex();
							
							if (opcion == 0) {
								
								cajaResu.setText( String.valueOf( ct.faC( Double.parseDouble( cajaAConver.getText() ) ) ) );
								
							} else if(opcion == 1) {

								cajaResu.setText( String.valueOf( ct.faK( Double.parseDouble( cajaAConver.getText() ) ) ) );
								
							}else if(opcion == 2) {

								cajaResu.setText( String.valueOf( ct.faR( Double.parseDouble( cajaAConver.getText() ) ) ) );
								
							}
							
						}
					});
					
				}else if(opcion == 3) {

					comboResu.removeAllItems();
					comboResu.addItem("°Celsius");
					comboResu.addItem("°Fahrenheit");
					comboResu.addItem("°Rankine");
					comboResu.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {

							byte opcion = (byte) comboResu.getSelectedIndex();
							
							if (opcion == 0) {
								
								cajaResu.setText( String.valueOf( ct.kaC( Double.parseDouble( cajaAConver.getText() ) ) ) );
								
							} else if(opcion == 1) {

								cajaResu.setText( String.valueOf( ct.kaF( Double.parseDouble( cajaAConver.getText() ) ) ) );
								
							}else if(opcion == 2) {

								cajaResu.setText( String.valueOf( ct.kaR( Double.parseDouble( cajaAConver.getText() ) ) ) );
								
							}
							
						}
					});
					

				}else if(opcion == 4) {
					
					comboResu.removeAllItems();
					comboResu.addItem("°Celsius");
					comboResu.addItem("°Fahrenheit");
					comboResu.addItem("°Kelvin");
					comboResu.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {

							byte opcion = (byte) comboResu.getSelectedIndex();
							
							if (opcion == 0) {
								
								cajaResu.setText( String.valueOf( ct.raC( Double.parseDouble( cajaAConver.getText() ) ) ) );
								
							} else if(opcion == 1) {

								cajaResu.setText( String.valueOf( ct.raF( Double.parseDouble( cajaAConver.getText() ) ) ) );
								
							}else if(opcion == 2) {

								cajaResu.setText( String.valueOf( ct.raK( Double.parseDouble( cajaAConver.getText() ) ) ) );
								
							}
							
						}
					});
					
				}else {
					
					JOptionPane.showMessageDialog(getContentPane(), "Debes elegir una temperatura");
					
				}
				
			}
		});
		
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
	@Override
	public void keyTyped(KeyEvent e) {
		
		char c = e.getKeyChar();
		
		if(c<'0' || c>'9') {
			
			e.consume();
			
		}
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
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
