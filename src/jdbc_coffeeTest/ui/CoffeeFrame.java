package jdbc_coffeeTest.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import jdbc_coffeeTest.dto.Product;
import jdbc_coffeeTest.ui.panel.ProductPanel;
import jdbc_coffeeTest.ui.panel.ProductTblPanel;

public class CoffeeFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private ProductPanel pInput;
	private JPanel pBtnsTbl;
	private JPanel pBtns;
	private ProductTblPanel pTbl;
	private JButton btnOK;
	private JButton btnCnl;
	private ArrayList<Product> prdList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoffeeFrame frame = new CoffeeFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CoffeeFrame() {
		
		
		initialize();
	}
	private void initialize() {
		setTitle("메뉴 관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		pInput = new ProductPanel();
		contentPane.add(pInput, BorderLayout.NORTH);
		
		pBtnsTbl = new JPanel();
		contentPane.add(pBtnsTbl, BorderLayout.CENTER);
		pBtnsTbl.setLayout(new BorderLayout(0, 0));
		
		pBtns = new JPanel();
		pBtnsTbl.add(pBtns, BorderLayout.NORTH);
		
		btnOK = new JButton("확인");
		btnOK.addActionListener(this);
		pBtns.add(btnOK);
		
		btnCnl = new JButton("취소");
		btnCnl.addActionListener(this);
		pBtns.add(btnCnl);
		
		pTbl = new ProductTblPanel();
		
		prdList = new ArrayList<Product>();
		prdList.add(new Product("A001", "아메리카노"));
		prdList.add(new Product("A002", "카푸치노"));
		prdList.add(new Product("A003", "헤이즐넛"));
		pTbl.loadData(prdList);

		pBtnsTbl.add(pTbl, BorderLayout.CENTER);
		pTbl.setPopupMenu(createPopup());
	}
	
	private JPopupMenu createPopup() {
		JPopupMenu popup = new JPopupMenu();
		
		JMenuItem editItem = new JMenuItem("수정");
		editItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Product newPrd = pTbl.getSelectedItem();
				pInput.setProduct(newPrd);
			}
			
		});
		popup.add(editItem);
		return popup;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCnl) {
			btnCnlActionPerformed(e);
		}
		if (e.getSource() == btnOK) {
			btnOKActionPerformed(e);
		}
	}
	protected void btnOKActionPerformed(ActionEvent e) {
		Product prd = pInput.getProduct();
		int selectedIdx = pTbl.getTable().getSelectedRow();
		pTbl.updateRow(prd, selectedIdx);
	}
	protected void btnCnlActionPerformed(ActionEvent e) {
		dispose();
	}
}
