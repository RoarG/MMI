package oving1;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class ButtonsNText extends JPanel {
	
	
	static JTextField TextLine = new JTextField(20);
	static JCheckBox ContinuousButton = new JCheckBox("This is a checkbox");
	
	
	static JToggleButton UpperCaseButton = new JToggleButton("Upper Case");
	static JToggleButton LowerCaseButton = new JToggleButton("Lower Case");
	
	
	private static Boolean upperC = false;
	private static Boolean lowerC = false;
	private static Boolean contB = false;
	private static String str = ""; 
	private static String oldStr = ""; 

	
	
//	Makes the text in the TextField a String
	private static void toStr(){
		str = TextLine.getText();
		oldStr = str;
	}
	
//	Sets the TextField
	private static void toTextF(String str){
		TextLine.setText(str);
	}
	
//	Sets the orginal text to the Field
	private static void toOldText() {
		TextLine.setText(oldStr);		
	}

//	Makes the string lower case
	private static void LowerCase() {
		str = str.toLowerCase();	
	}
	
//	Makes the sring upper case
	private static void UpperCase() {
		str = str.toUpperCase();	
	}
	

// Sets the frame and panel and adds alle the neede components.
	public static void Frame() {
		JFrame frame = new JFrame("Assgnment 1");
		JPanel panel = new JPanel();
		
//		Sets the defaults
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 75);
		frame.setVisible(true);

//		Adds componenst
		panel.add(TextLine);
		panel.add(UpperCaseButton);
		panel.add(LowerCaseButton);
		panel.add(ContinuousButton);
		
//		Sets panel to North 
		frame.add(panel, BorderLayout.NORTH);		
		
//		ButtonGroup for the Toggelbuttons
		ButtonGroup group = new ButtonGroup();
		group.add(UpperCaseButton);
		group.add(LowerCaseButton);
		

		
//		Adds a listener for the uppercase button 
		UpperCaseButton.addItemListener(new ItemListener() {
		
//			Calls the string method and make the sting uppercase when button is selected
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					System.out.println("UpperCase_Button is selected");
					upperC = true;
					toStr();
					UpperCase();
					toTextF(str);
					
				}
//				Reverses the string back to its orginal, when deselected
				else if (e.getStateChange() == ItemEvent.DESELECTED) {
					System.out.println("Button is DEselected");
					System.out.println("OldStr er: " + oldStr );
					UpperCaseButton.setSelected(false);
					upperC = false;
					toOldText();
					
					
				}
			}
		} );
		
//		Adds a listener for the uppercase button 
		LowerCaseButton.addItemListener(new ItemListener() {
			
//			Calls the string method and make the sting uppercase when button is selected
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					System.out.println("LowerCase_Buttong is selected");
					lowerC = true;
					toStr();
					LowerCase();
					toTextF(str);
					
				}
//				Reverses the string back to its orginal, when deselected
				else if (e.getStateChange() == ItemEvent.DESELECTED) {
					System.out.println("Button is DEselected");
					System.out.println("OldStr er: " + oldStr );
					LowerCaseButton.setSelected(false);
					lowerC = false;
					toOldText();
					
					
				}
			}
		} );
//		Adds listener for the checkbox
		ContinuousButton.addItemListener(new ItemListener() {

//			
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					System.out.println("Checkbox selected");
					contB = true;
				}
				else if (e.getStateChange() == ItemEvent.DESELECTED) {
					System.out.println("Checkbox deselected");
					
				}
			}
		});
	
		TextLine.getDocument().addDocumentListener(new DocumentListener() {
			
			public void removeUpdate(DocumentEvent e) {
				System.out.println("RemoveUpdate");
			}
			
			public void insertUpdate(DocumentEvent e) {
				if (contB == true && upperC == true) {
					toStr();
					System.out.println(str);
					}
				else {
					System.out.println("InsertUpdate ELSE");
					
				}
				
			}
			
			public void changedUpdate(DocumentEvent e) {
				System.out.println("ChangeUpdate");
				
			}
		});
	}
	

//	Main method; Call the frame
	public static void main(String[] args) {
		Frame();
		
	}
	
	
	

}
