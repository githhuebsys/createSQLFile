package createSQLFile;

public class SQLParms {
	String diagnosticCode = null;
	String description = null;
	String beginDate = null;
	String beginTime = null;
	String endDate = null;
	String endTime = null;

	public String getDiagnosticCode() {
		return diagnosticCode;
	}
	public void setDiagnosticCode(String diagnosticCode) {
		this.diagnosticCode = diagnosticCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String toString()	{
		String value = getDiagnosticCode() + " " +
				getDescription() + " " +
				getBeginDate() + " " +
				getBeginTime() + " " +
				getEndDate() + " " +
				getEndTime();
		return value;
	}
}
