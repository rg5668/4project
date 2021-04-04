package model;

public class Buy //구매목록에 대한 모델
{
	private String pnum;
	private String pdate;
	private String price;
	private String pname;
	private String pcontent;
	private String pimg;
	private String id;
	private String pcode;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getPimg() {
		return pimg;
	}
	public void setPimg(String pimg) {
		this.pimg = pimg;
	}
	public String getPnum() {
		return pnum;
	}
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}

	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPcontent() {
		return pcontent;
	}
	public void setPcontent(String content) {
		this.pcontent = content;
	}
	@Override
	public String toString() {
		return "Buy [pnum=" + pnum + ", pdate=" + pdate + ", price=" + price + ", pname=" + pname + ", pcontent="
				+ pcontent + ", pimg=" + pimg + ", id=" + id + ", pcode=" + pcode + "]";
	}
	
	
	
}
