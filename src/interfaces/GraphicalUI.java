package interfaces;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import id_311217905_id_312126055.Election;
import id_311217905_id_312126055.Party;
import id_311217905_id_312126055.Party.eFaction;

public class GraphicalUI implements Messageable {

	public void showMessage(String str) {
		JOptionPane.showMessageDialog(null, str);
	}

	public String getString(String str) {
		return JOptionPane.showInputDialog(str);
	}
	@Override
	public long getLong(String str) {
		return Long.parseLong(JOptionPane.showInputDialog(str));
	}

	@Override
	public eFaction getEnum(String str) {
		return eFaction.valueOf(JOptionPane.showInputDialog(str));
	}

	public void showMessages(Object o) {
		JTextArea textArea = new JTextArea(40, 70);
	    textArea.setText(o.toString());
	    textArea.setEditable(false);
	    JScrollPane scrollPane = new JScrollPane(textArea);
	    
		JOptionPane.showMessageDialog(null, scrollPane);
	}
	
	public void showPartyMessage(String str) {
		JTextArea textArea = new JTextArea(40, 70);
	    textArea.setText(str);
	    textArea.setEditable(false);
	    JScrollPane scrollPane = new JScrollPane(textArea);
	    
		JOptionPane.showMessageDialog(null, scrollPane);
	}
	
}
