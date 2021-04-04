package model;

public class Member {
	private String id;
	private String pass;
	private String name;
	private String birth;
	private String tel;
	private String address;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthyy() {
		return birth;
	}
	public void setBirthyy(String birthyy) {
		this.birth = birthyy;
	}
	public String getBirthmm() {
		return birth;
	}
	public void setBirthmm(String birthmm) {
		this.birth = birthmm;
	}
	public String getBirthdd() {
		return birth;
	}
	public void setBirthdd(String birthdd) {
		this.birth = birthdd;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress1() {
		return address;
	}
	public void setAddress1(String address1) {
		this.address = address1;
	}
	public String getAddress2() {
		return address;
	}
	public void setAddress2(String address2) {
		this.address = address2;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", pass=" + pass + ", name=" + name + ", birth=" + birth + ", tel=" + tel
				+ ", address=" + address + "]";
	}
	
}
