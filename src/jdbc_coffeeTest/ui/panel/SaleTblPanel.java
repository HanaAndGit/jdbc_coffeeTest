package jdbc_coffeeTest.ui.panel;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SaleTblPanel extends JPanel {
	private JScrollPane scrollPane;
	private JTable table;
	private NotEditableModel model;

	/**
	 * Create the panel.
	 */
	public SaleTblPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(1, 0, 0, 0));
		
		scrollPane = new JScrollPane();
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
	
	
	private class NotEditableModel extends DefaultTableModel{
		public NotEditableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
		
	}

}
