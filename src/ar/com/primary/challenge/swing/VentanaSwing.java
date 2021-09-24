package ar.com.primary.challenge.swing;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
 
public class VentanaSwing {
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = false;
    
 
    public void addComponentsToPane(Container pane) 
    {
    	pane.setLayout(new GridBagLayout());
    	GridBagConstraints c = new GridBagConstraints();

    	JLabel jlRta;
    	jlRta = new JLabel("Respuesta");
    	c.fill = GridBagConstraints.FIRST_LINE_START;
    	c.insets = new Insets(5,5,0,0);
    	c.gridx = 0;
    	c.gridy = 0;
    	pane.add(jlRta, c);

    	JTextArea jtArea = new JTextArea();
    	c.fill = GridBagConstraints.BOTH;
    	c.ipady = 100;  
    	c.ipadx = 180;  
    	c.weightx = 1;
    	c.weighty = 1;
    	c.insets = new Insets(0,5,0,5);
    	c.gridwidth = 5;
    	c.gridx = 0;
    	c.gridy = 1;
    	JScrollPane scroll = new JScrollPane(jtArea);
    	scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); 
    	pane.add( scroll , c);

    	//Botones
    	JButton button;
    	c.weightx = 0;
    	c.weighty = 0;
    	c.insets = new Insets(10,10,5,5);
    	c.gridwidth = 1;
    	c.ipady = 0; 
    	c.ipadx = 0;


    	button = new JButton("Ejecutar");
    	c.fill = GridBagConstraints.FIRST_LINE_START;
    	c.gridx = 0;       
    	c.gridy = 2;       
    	c.insets = new Insets(5,5,5,5);  

    	pane.add(button, c);

    	button = new JButton("Cancelar");
    	c.fill = GridBagConstraints.FIRST_LINE_START;
    	c.gridx = 1;       
    	c.gridy = 2;       
    	c.insets = new Insets(5,5,5,5); 
    	button.setEnabled(false);
    	pane.add(button, c);

    	button = new JButton("Copiar");
    	c.fill = GridBagConstraints.FIRST_LINE_START;
    	c.gridx = 2;       
    	c.gridy = 2;    
    	c.insets = new Insets(5,5,5,5); 
    	button.setEnabled(false);
    	pane.add(button, c);

    	button = new JButton("Cerrar");
    	c.fill = GridBagConstraints.FIRST_LINE_START;
    	c.gridx = 3;       
    	c.gridy = 2;      
    	c.insets = new Insets(5,5,5,5);  

    	pane.add(button, c);
    	
    	ImageIcon icon = new ImageIcon(this.getClass().getResource("/recursos/icons8-windows8-16.png"));

    	button = new JButton(icon);
    	c.fill = GridBagConstraints.FIRST_LINE_END;
    	c.anchor = GridBagConstraints.FIRST_LINE_END;


    	c.gridx = 4;       //aligned with button 2 
    	c.gridy = 2;       //third row
    	c.insets = new Insets(5,5,5,5);  //top padding

    	pane.add(button, c);

    }
 

    private void createAndShowGUI() {
 
        JFrame frame = new JFrame("Verificación de conectividad");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setMinimumSize(new Dimension(500,350));
 
        addComponentsToPane(frame.getContentPane());
 

        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               new VentanaSwing().createAndShowGUI();
            }
        });
    }
    
}
