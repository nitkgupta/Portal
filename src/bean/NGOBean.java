package bean;

public class NGOBean {
	String ngoId;
	String name;
	String area;
	String type;
	String state;
	String email;
	int pin;
	int totalFund;
	int fundRecieved;
	int fundUsed;
	public String getNgoId() {
		return ngoId;
	}
	public void setNgoId(String ngoId) {
		this.ngoId = ngoId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public int getTotalFund() {
		return totalFund;
	}
	public void setTotalFund(int totalFund) {
		this.totalFund = totalFund;
	}
	public int getFundRecieved() {
		return fundRecieved;
	}
	public void setFundRecieved(int fundRecieved) {
		this.fundRecieved = fundRecieved;
	}
	public int getFundUsed() {
		return fundUsed;
	}
	public void setFundUsed(int fundUsed) {
		this.fundUsed = fundUsed;
	}
}
