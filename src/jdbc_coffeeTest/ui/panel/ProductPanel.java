package jdbc_coffeeTest.ui.panel;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import jdbc_coffeeTest.dto.Product;

import javax.swing.SwingConstants;

public class ProductPanel extends JPanel {
	private JPanel panel;
	private JLabel lblCode;
	private JTextField tfCode;
	private JLabel lblName;
	private JTextField tfName;

	public ProductPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(1, 0, 0, 0));
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\uC81C\uD488 \uAD00\uB9AC", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblCode = new JLabel("제품 코드");
		lblCode.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblCode);
		
		tfCode = new JTextField();
		panel.add(tfCode);
		tfCode.setColumns(10);
		
		lblName = new JLabel("제품 명");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblName);
		
		tfName = new JTextField();
		panel.add(tfName);
		tfName.setColumns(10);
	}
	
	
	public Product getProduct() {
		String code = tfCode.getText();
		String name = tfName.getText();
		return new Product(code, name);
		
	}
	
	public void setProduct(Product prd) {
		tfCode.setText(prd.getCode());
		tfName.setText(prd.getName());
	}
	
	public void clearTf() {
		tfCode.setText("");
		tfName.setText("");
	}
	
	

}
