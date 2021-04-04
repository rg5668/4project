package model;

public class Product4 {
	private String pcode;
	private String pname;
	private int price;
	private int pcount;
	private String pimg;
	private String pcontent;
	private String subpcode;

	
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPcount() {
		return pcount;
	}
	public void setPcount(int pcount) {
		this.pcount = pcount;
	}
	public String getPimg() {
		return pimg;
	}
	public void setPimg(String pimg) {
		this.pimg = pimg;
	}
	public String getPcontent() {
		return pcontent;
	}
	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}
	public String getSubpcode() {
		return subpcode;
	}
	public void setSubpcode(String subpcode) {
		this.subpcode = subpcode;
	}
	@Override
	public String toString() {
		return "Product4 [pcode=" + pcode + ", pname=" + pname + ", price=" + price + ", pcount=" + pcount + ", pimg="
				+ pimg + ", pcontent=" + pcontent + ", subpcode=" + subpcode + "]";
	}
	
}
