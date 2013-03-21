package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GuiCalculadora extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private Container container;
	private JPanel panel;
	private BorderLayout border;
	private GridLayout grid;
	private JButton[] button;
	private JTextField text;
	private ManejadorEventos manejador;
	private String s;
	private char op;
	private double a = 0;
	private double b = 0;
	
	public GuiCalculadora() {
		super("Qalkuladora");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(350, 200);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		container = this.getContentPane();
		panel = new JPanel();
		border = new BorderLayout(5,5);
		grid = new GridLayout(4,1,5,5);
		button = new JButton[20];
		text = new JTextField();
		manejador = new ManejadorEventos();
		s = "";
		
		text.setHorizontalAlignment(JTextField.RIGHT);
		text.setEnabled(false);
		text.setDisabledTextColor(Color.BLACK);
		text.setPreferredSize( new Dimension( 200, 50 ) );
		
		container.setLayout(border);
		panel.setLayout(grid);
		
		for(int i = 0; i < button.length; i++) {
			button[i] = new JButton("" + i);
			button[i].addActionListener(manejador);
			button[i].setFocusable(false);
			panel.add(button[i]);
		}
		
		this.setButtonsNames();
		
		container.add(text, BorderLayout.NORTH);
		container.add(panel, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	
	private class ManejadorEventos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			JButton btn = (JButton) e.getSource();
			boolean firstOperator = true;
			
			if("1" == btn.getText()) s = s += "1";
			else if("2" == btn.getText()) s = s += "2";
			else if("3" == btn.getText()) s = s += "3";
			else if("4" == btn.getText()) s = s += "4";
			else if("5" == btn.getText()) s = s += "5";
			else if("6" == btn.getText()) s = s += "6";
			else if("7" == btn.getText()) s = s += "7";
			else if("8" == btn.getText()) s = s += "8";
			else if("9" == btn.getText()) s = s += "9";
			else if("0" == btn.getText()) s = s += "0";
			else if("DEL" == btn.getText()) {
				if(s.length() > 0) {
					s = s.substring(0,s.length() - 1);
				}
			} else if("AC" == btn.getText()) {
				a = 0.0;
				b = 0.0;
				s = "";
				text.setText(s);
			} else if("x" == btn.getText()) {
				op = 'x';
				if(firstOperator) {
					firstOperator = false;
					a = Double.parseDouble(s);
					s = "";
					text.setText(s);
				}
			} else if("/" == btn.getText()) {
				op = '/';
				if(firstOperator) {
					firstOperator = false;
					a = Double.parseDouble(s);
					s = "";
					text.setText(s);
				}
			} else if("+" == btn.getText()) {
				op = '+';
				if(firstOperator) {
					firstOperator = false;
					a = Double.parseDouble(s);
					s = "";
					text.setText(s);
				}
			} else if("-" == btn.getText()) {
				if(s == "") {
					s += "-";
				} else {
					op = '-';
					if(firstOperator) {
						firstOperator = false;
						a = Double.parseDouble(s);
						s = "";
						text.setText(s);
					}
				}
			} else if("." == btn.getText()) {
				s = s += ".";
			} else if("EXP" == btn.getText()) {
			} else if("Ans" == btn.getText()) {
			} else if("=" == btn.getText()) {
				switch(op) {
					case 'x':
						b = Double.parseDouble(s);
						s = "" + (a * b);
						text.setText(s);
						break;
					case '/':
						b = Double.parseDouble(s);
						s = "" + (a / b);
						text.setText(s);
						break;
					case '+':
						b = Double.parseDouble(s);
						s = "" + (a + b);
						text.setText(s);
						break;
					case '-':
						b = Double.parseDouble(s);
						s = "" + (a - b);
						text.setText(s);
						break;
					default:
						break;
				}				
				op = '\0';
			}
			text.setText(s);
		}
	}

	private void setButtonsNames() {
		button[0].setText("7");
		button[1].setText("8");
		button[2].setText("9");
		button[3].setText("DEL");
		button[4].setText("AC");
		button[5].setText("4");
		button[6].setText("5");
		button[7].setText("6");
		button[8].setText("x");
		button[9].setText("/");
		button[10].setText("1");
		button[11].setText("2");
		button[12].setText("3");
		button[13].setText("+");
		button[14].setText("-");
		button[15].setText("0");
		button[16].setText(".");
		button[17].setText("EXP");
		button[18].setText("Ans");
		button[19].setText("=");
		
		button[17].setToolTipText("Esta funcion no esta habilitada");
		button[18].setToolTipText("Esta funcion tampoco esta habilitada");
		
	}
}
