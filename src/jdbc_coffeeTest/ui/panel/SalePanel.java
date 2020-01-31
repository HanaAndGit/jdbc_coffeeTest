package jdbc_coffeeTest.ui.panel;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import jdbc_coffeeTest.dto.Sale;

public class SalePanel extends JPanel {
	private JPanel panel;
	private JLabel lblNo;
	private JTextField tfNo;
	private JLabel lblCode;
	private JTextField tfCode;
	private JLabel lblPrice;
	private JTextField tfPrice;
	private JLabel lblSalecnt;
	private JTextField tfSalecnt;
	private JLabel lblMargin;
	private JTextField tfMargin;

	/**
	 * Create the panel.
	 */
	public SalePanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(1, 0, 0, 0));
		
		panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblNo = new JLabel("번호");
		lblNo.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNo);
		
		tfNo = new JTextField();
		panel.add(tfNo);
		tfNo.setColumns(10);
		
		lblCode = new JLabel("제품 코드");
		lblCode.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblCode);
		
		tfCode = new JTextField();
		panel.add(tfCode);
		tfCode.setColumns(10);
		
		lblPrice = new JLabel("제품 가격");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblPrice);
		
		tfPrice = new JTextField();
		panel.add(tfPrice);
		tfPrice.setColumns(10);
		
		lblSalecnt = new JLabel("판매량");
		lblSalecnt.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblSalecnt);
		
		tfSalecnt = new JTextField();
		panel.add(tfSalecnt);
		tfSalecnt.setColumns(10);
		
		lblMargin = new JLabel("마진");
		lblMargin.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblMargin);
		
		tfMargin = new JTextField();
		panel.add(tfMargin);
		tfMargin.setColumns(10);
	}
	
	
	public Sale getSale() {
		int no = Integer.parseInt(tfNo.getText());
		String s_code = tfCode.getText();
		int price = Integer.parseInt(tfPrice.getText());
		int salecnt = Integer.parseInt(tfSalecnt.getText());
		int margin = Integer.parseInt(tfMargin.getText());
		
		return new Sale(no, s_code, price, salecnt, margin);
	}
	
	public void setSale(Sale sale) {
		tfNo.setText(Integer.toString(sale.getNo()));
		tfCode.setText(sale.getS_code());
		tfPrice.setText(Integer.toString(sale.getPrice()));
		tfSalecnt.setText(Integer.toString(sale.getSalecnt()));
		tfMargin.setText(Integer.toString(sale.getMarginRate()));
		
	}
	
	
	public void clearTf() {
		tfNo.setText("");
		tfCode.setText("");
		tfPrice.setText("");
		tfSalecnt.setText("");
		tfMargin.setText("");
	}
	
	
	
	
	

}
