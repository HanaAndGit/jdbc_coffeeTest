package jdbc_coffeeTest.ui.panel;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import jdbc_coffeeTest.dto.Product;

//StudentTblPanel_Test.java 

public class ProductTblPanel extends JPanel {
	private JScrollPane scrollPane;
	private JTable table;
	protected NotEditableModel model;
	/**
	 * Create the panel.
	 */
	public ProductTblPanel() {

		initialize();
	}
	
	
	
	public JTable getTable() {
		return table;
	}



	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		
		
	}
	
	//2. ArrayList에 model 부착
	public void loadData(ArrayList<Product> prdList) {
		model = new NotEditableModel(getRows(prdList), getColNames());
		table.setModel(model);
		
	}
	
	
	private Object[] getColNames() {
		return new String[] {
				"코드", "제품명"
		};
	}
	private Object[][] getRows(ArrayList<Product> prdList) {
		Object[][] rows =new Object[prdList.size()][];
		for(int i=0; i<rows.length; i++) {
			rows[i] = toArray(prdList.get(i));
		}
		return rows;
	}

	private Object[] toArray(Product product) {
		
		return new Object[] {
				product.getCode(),
				product.getName()
		};
	}
	
	
	//3. 테이블 컬럼 폭, 셀 수평 정렬
	private void setTblWidthAlign() {
		tableSetWidth(50, 100);
	}
	
	private void tableSetWidth(int...width) {
		TableColumnModel cModel = table.getColumnModel();
		for(int i=0; i<3; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
		
	}

	//4. (모델) 테이블에 데이터 추가
	protected void addProduct(Product prd) {
		model.addRow(toArray(prd));
	}
	//5. (모델) 테이블 데이터 수정
	public void updateRow(Product prd, int updateIdx) {
		model.setValueAt(prd.getCode(), updateIdx, 0);
		model.setValueAt(prd.getName(), updateIdx, 1);
	}
	
	//6. (모델) 테이블 데이터 삭제
	public void removeRow() {
		int selectedIdx = getSelectedRowIdx();
		model.removeRow(selectedIdx);
	}
	private int getSelectedRowIdx() {
		int idx = table.getSelectedRow();
		return idx;
	}
	
	
	//7. 테이블에서 데이터 객체 가져오기 
	public Product getSelectedItem() {
		int selectedIdx = table.getSelectedRow();
		String code = (String) model.getValueAt(selectedIdx, 0);
		String name = (String) model.getValueAt(selectedIdx, 1);
		
		return new Product(code, name);
	}
	
	public void setPopupMenu(JPopupMenu popupMenu) {
		scrollPane.setComponentPopupMenu(popupMenu);
		table.setComponentPopupMenu(popupMenu);
	}
	


	//1. 모델 클래스 
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
