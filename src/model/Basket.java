package model;

public class Basket
{
	private String id;
	private String pname;
	private String pcode;
	private String price;
	private int bcount;
	private String pimg;
	
	public String getPimg() {
		return pimg;
	}
	public void setPimg(String pimg) {
		this.pimg = pimg;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getBcount() {
		return bcount;
	}
	public void setBcount(int bcount) {
		this.bcount = bcount;
	}
	@Override
	public String toString() {
		return "Basket [id=" + id + ", pname=" + pname + ", pcode=" + pcode + ", price=" + price + ", bcount=" + bcount
				+ ", pimg=" + pimg + "]";
	}
	
	
}
