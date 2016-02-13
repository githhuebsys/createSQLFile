package createSQLFile;

public class SQLParms {
	String parm1 = null;
	String parm2 = null;
	String parm3 = null;
	String parm4 = null;
	String parm5 = null;

	public String getParm1() {
		return parm1;
	}

	public void setParm1(String parm1) {
		this.parm1 = parm1;
	}

	public String getParm2() {
		return parm2;
	}

	public void setParm2(String parm2) {
		this.parm2 = parm2;
	}

	public String getParm3() {
		return parm3;
	}

	public void setParm3(String parm3) {
		this.parm3 = parm3;
	}

	public String getParm4() {
		return parm4;
	}

	public void setParm4(String endDate) {
		this.parm4 = endDate;
	}

	public String getParm5() {
		return parm5;
	}

	public void setParm5(String endTime) {
		this.parm5 = endTime;
	}

	public String toString() {
		String value = getParm1() + "," + getParm2() + "," + getParm3() + "," + getParm4() + "," + getParm5();
		return value;
	}
}
