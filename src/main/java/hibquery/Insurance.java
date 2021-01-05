package hibquery;

import java.util.Date;

public class Insurance {
	private int insuranceId;
	private String insuranceName;
	private int investmentAmount;
	private Date investmentDate;
	
	public Insurance() {
		
	}
	
	public Insurance(int insuranceId, String insuranceName, int investmentAmount, Date investmentDate) {
		super();
		this.insuranceId = insuranceId;
		this.insuranceName = insuranceName;
		this.investmentAmount = investmentAmount;
		this.investmentDate = investmentDate;
	}
	public int getInsuranceId() {
		return insuranceId;
	}
	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}
	public String getInsuranceName() {
		return insuranceName;
	}
	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}
	public int getInvestmentAmount() {
		return investmentAmount;
	}
	public void setInvestmentAmount(int investmentAmount) {
		this.investmentAmount = investmentAmount;
	}
	public Date getInvestmentDate() {
		return investmentDate;
	}
	public void setInvestmentDate(Date investmentDate) {
		this.investmentDate = investmentDate;
	}
	@Override
	public String toString() {
		return "Insurance [insuranceId=" + insuranceId + ", insuranceName=" + insuranceName + ", investmentAmount="
				+ investmentAmount + ", investmentDate=" + investmentDate + "]";
	}
	
}
