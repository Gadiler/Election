package messages;

import javax.swing.JOptionPane;

public class GraphicalUI implements Messageable {

	public void showMessage(String str) {
		JOptionPane.showMessageDialog(null, str);

	}

	public String getMessage(String str) {
		return JOptionPane.showInputDialog(str);
	}

}
