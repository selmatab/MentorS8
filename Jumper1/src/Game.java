//Napraviti igricu jumper u kojoj ce player preskociti prepreke koje su postavljene.

 //TODO Ne registruje mi koliziju i ne resetuje mi niz prepreka,
//tj. smjesti ih u gornji desni ugao kao staticnu hrpu. Ne znam zasto.

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;


public class Game {
public static void main(String[] args) {
	
	JFrame frame=new JFrame("Game");
	frame.setSize(500, 500);
	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	GameGraphics panel=new GameGraphics();
	frame.setContentPane(panel);
	
	
	JTextField field=new JTextField(panel.counter);
	field.setLocation(250,30);
	
	panel.add(field);
	
	frame.setVisible(true);
	panel.requestFocus(false);
	
	
	
	
	
	
}
}

