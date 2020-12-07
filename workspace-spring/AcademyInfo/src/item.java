
public class item {
	String clgcpDivCd;
	String clgcpDivNm;
	int estbDivCd;
	String estbDivNm;
	String schlDivCd;
	String schlDivNm;
	String schlFullNm;
	String schlId;
	String schlKndCd;
	String schlKndNm;
	String schlKrnNm;
	int svyYr;
	int znCd;
	String znNm;
	
//	��Ŭ�� �� getter setter ���� �������̵� Ŭ�� �� toString 
	@Override
	public String toString() {
		return clgcpDivCd + "," + clgcpDivNm+ "," + estbDivCd+ "," + estbDivNm+ "," + schlDivCd
				+ "," + schlDivNm+ "," + schlFullNm+ "," + schlId+ "," + schlKndCd
				+ "," + schlKndNm+ "," + schlKrnNm+ "," + svyYr+ "," + znCd+ "," + znNm;
	}
	
	public String toSQL() {
		return "INSERT INTO academy VALUES(" 
	            + "'"+ clgcpDivCd + "','" +clgcpDivNm+ "'," +estbDivCd+ ",'" +estbDivNm+ "','" +schlDivCd+ "','" + schlDivNm+ "','" +schlFullNm+ "','" +schlId
	            + "','" +schlKndCd+ "','" + schlKndNm+ "','" +schlKrnNm+ "'," +svyYr+ "," +znCd+ ",'" +znNm +"');";
		
	}
	
	public String getClgcpDivCd() {
		return clgcpDivCd;
	}
	public void setClgcpDivCd(String clgcpDivCd) {
		this.clgcpDivCd = clgcpDivCd;
	}
	public String getClgcpDivNm() {
		return clgcpDivNm;
	}
	public void setClgcpDivNm(String clgcpDivNm) {
		this.clgcpDivNm = clgcpDivNm;
	}
	public int getEstbDivCd() {
		return estbDivCd;
	}
	public void setEstbDivCd(int estbDivCd) {
		this.estbDivCd = estbDivCd;
	}
	public String getEstbDivNm() {
		return estbDivNm;
	}
	public void setEstbDivNm(String estbDivNm) {
		this.estbDivNm = estbDivNm;
	}
	public String getSchlDivCd() {
		return schlDivCd;
	}
	public void setSchlDivCd(String schlDivCd) {
		this.schlDivCd = schlDivCd;
	}
	public String getSchlDivNm() {
		return schlDivNm;
	}
	public void setSchlDivNm(String schlDivNm) {
		this.schlDivNm = schlDivNm;
	}
	public String getSchlFullNm() {
		return schlFullNm;
	}
	public void setSchlFullNm(String schlFullNm) {
		this.schlFullNm = schlFullNm;
	}
	public String getSchlId() {
		return schlId;
	}
	public void setSchlId(String schlId) {
		this.schlId = schlId;
	}
	public String getSchlKndCd() {
		return schlKndCd;
	}
	public void setSchlKndCd(String schlKndCd) {
		this.schlKndCd = schlKndCd;
	}
	public String getSchlKndNm() {
		return schlKndNm;
	}
	public void setSchlKndNm(String schlKndNm) {
		this.schlKndNm = schlKndNm;
	}
	public String getSchlKrnNm() {
		return schlKrnNm;
	}
	public void setSchlKrnNm(String schlKrnNm) {
		this.schlKrnNm = schlKrnNm;
	}
	public int getSvyYr() {
		return svyYr;
	}
	public void setSvyYr(int svyYr) {
		this.svyYr = svyYr;
	}
	public int getZnCd() {
		return znCd;
	}
	public void setZnCd(int znCd) {
		this.znCd = znCd;
	}
	public String getZnNm() {
		return znNm;
	}
	public void setZnNm(String znNm) {
		this.znNm = znNm;
	}
}
