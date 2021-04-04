package model;

public class Productinfo
{
	private String id;
	private String pimg;
	private String pname;
	private String price;
	private String pcontent;
	private String pcode;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPimg() {
		return pimg;
	}
	public void setPimg(String pimg) {
		this.pimg = pimg;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPcontent() {
		return pcontent;
	}
	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	@Override
	public String toString() {
		return "Productinfo [id=" + id + ", pimg=" + pimg + ", pname=" + pname + ", price=" + price + ", pcontent="
				+ pcontent + ", pcode=" + pcode + "]";
	}
	
	
}
