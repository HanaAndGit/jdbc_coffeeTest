package jdbc_coffeeTest.dto;

public class Sale {
	private int no;
	private String s_code;
	private int price;
	private int salecnt;
	private int marginRate;
	public Sale() {
		// TODO Auto-generated constructor stub
	}
	public Sale(int no, String s_code, int price, int salecnt, int marginRate) {
		this.no = no;
		this.s_code = s_code;
		this.price = price;
		this.salecnt = salecnt;
		this.marginRate = marginRate;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getS_code() {
		return s_code;
	}
	public void setS_code(String s_code) {
		this.s_code = s_code;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSalecnt() {
		return salecnt;
	}
	public void setSalecnt(int salecnt) {
		this.salecnt = salecnt;
	}
	public int getMarginRate() {
		return marginRate;
	}
	public void setMarginRate(int marginRate) {
		this.marginRate = marginRate;
	}
	
	
	
	@Override
	public String toString() {
		return String.format("%s, %s, %s, %s, %s]", no, s_code, price, salecnt, marginRate);
	}
	
	
	
}
