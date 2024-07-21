/**
 * 
 * I declare that this code was written by me, slenc. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Slency
 * Student ID: 22009748
 * Class: E63C
 * Date created: 2024-Jul-21 3:13:32 pm 
 * 
 */

package e66d.slency.fyp;

/**
 * @author slenc
 *
 */
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class data{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private double retainedEarnings;
	private double marketValue_total_fiscal;
	private double earningsBeforeInterest;
	private double commonEquity_liquidationValue;
	private double stockholdersEquity_total;
	private double employees;
	private double totalDebt_totalAsset;
	private double grossProfit_loss;
	private double debtInCurrentLiabilities_total;
	private double operatingActivities_netCashFlow;
	private String excelFileName; 

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public double getRetainedEarnings() {
		return retainedEarnings;
	}
	
	public void setRetainedEarnings(double retainedEarnings) {
		this.retainedEarnings = retainedEarnings;
	}
	
	public double getMarketValue_total_fiscal() {
		return marketValue_total_fiscal;
	}
	
	public void setMarketValue_total_fiscal(double marketValue_total_fiscal) {
		this.marketValue_total_fiscal = marketValue_total_fiscal;
	}
	
	public double getEarningsBeforeInterest() {
		return earningsBeforeInterest;
	}
	
	public void setEarningsBeforeInterest(double earningsBeforeInterest) {
		this.earningsBeforeInterest = earningsBeforeInterest;
	}
	
	public double getCommonEquity_liquidationValue() {
		return commonEquity_liquidationValue;
	}
	
	public void setCommonEquity_liquidationValue(double commonEquity_liquidationValue) {
		this.commonEquity_liquidationValue = commonEquity_liquidationValue;
	}
	
	public double getStockholdersEquity_total() {
		return stockholdersEquity_total;
	}
	
	public void setStockholdersEquity_total(double stockholdersEquity_total) {
		this.stockholdersEquity_total = stockholdersEquity_total;
	}
	
	public double getEmployees() {
		return employees;
	}
	
	public void setEmployees(double employees) {
		this.employees = employees;
	}
	
	public double getTotalDebt_totalAsset() {
		return totalDebt_totalAsset;
	}
	
	public void setTotalDebt_totalAsset(double totalDebt_totalAsset) {
		this.totalDebt_totalAsset = totalDebt_totalAsset;
	}
	
	public double getGrossProfit_loss() {
		return grossProfit_loss;
	}
	
	public void setGrossProfit_loss(double grossProfit_loss) {
		this.grossProfit_loss = grossProfit_loss;
	}
	
	public double getDebtInCurrentLiabilities_total() {
		return debtInCurrentLiabilities_total;
	}
	
	public void setDebtInCurrentLiabilities_total(double debtInCurrentLiabilities_total) {
		this.debtInCurrentLiabilities_total = debtInCurrentLiabilities_total;
	}
	
	public double getOperatingActivities_netCashFlow() {
		return operatingActivities_netCashFlow;
	}
	
	public void setOperatingActivities_netCashFlow(double operatingActivities_netCashFlow) {
		this.operatingActivities_netCashFlow = operatingActivities_netCashFlow;
	}
	public String getExcelFileName() {
		return excelFileName;
	}

	public void setExcelFileName(String excelFileName) {
		this.excelFileName = excelFileName;
	}
	
}
