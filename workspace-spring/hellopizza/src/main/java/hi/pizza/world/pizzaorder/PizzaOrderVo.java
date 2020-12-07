package hi.pizza.world.pizzaorder;

import java.util.List;

public class PizzaOrderVo {

	
	//주문 관련
	
	//주문번호
	private int orId;
	//주문 회원
	private String orUser;
	//회원 이름
	private String orUname;
	
	//전화번호
	private String orUpn;
	//전화번호
	private String orUad;
	//가격
	private int orPrice;
	//지불수단
	private String orPay;
	
	
//	가격 총액 
	private int sumPri;
	
	
	public int getSumPri() {
		return sumPri;
	}
	public void setSumPri(int sumPri) {
		this.sumPri = sumPri;
	}
	/////주문관련
	public int getOrId() {
		return orId;
	}
	public void setOr_Id(int orId) {
		this.orId = orId;
	}
	public String getOrUser() {
		return orUser;
	}
	public void setOrUser(String orUser) {
		this.orUser = orUser;
	}
	public String getOrUname() {
		return orUname;
	}
	public void setOrUname(String orUname) {
		this.orUname = orUname;
	}
	public String getOrUpn() {
		return orUpn;
	}
	public void setOrUpn(String orUpn) {
		this.orUpn = orUpn;
	}
	public String getOrUad() {
		return orUad;
	}
	public void setOrUad(String orUad) {
		this.orUad = orUad;
	}
	public int getOrPrice() {
		return orPrice;
	}
	public void setOrPrice(int orPrice) {
		this.orPrice = orPrice;
	}
	public String getOrPay() {
		return orPay;
	}
	public void setOrPay(String orPay) {
		this.orPay = orPay;
	}
	
	
	
	
	
	/////////////////////////////////
	///주문메뉴목록

	private int liId;
	private String liUser;
	private int liMeid;
	private int liMeprice;
	private int liEa;
	private int liOrNum;
	private String liMename;
	
	private List<PizzaOrderVo> insLi;


	public int getLiId() {
		return liId;
	}
	public void setLiId(int liId) {
		this.liId = liId;
	}
	public String getLiUser() {
		return liUser;
	}
	public void setLiUser(String liUser) {
		this.liUser = liUser;
	}
	public int getLiMeid() {
		return liMeid;
	}
	public void setLiMeid(int liMeid) {
		this.liMeid = liMeid;
	}
	public int getLiMeprice() {
		return liMeprice;
	}
	public void setLiMeprice(int liMeprice) {
		this.liMeprice = liMeprice;
	}
	public int getLiEa() {
		return liEa;
	}
	public void setLiEa(int liEa) {
		this.liEa = liEa;
	}
	public int getLiOrNum() {
		return liOrNum;
	}
	public void setLiOrNum(int liOrNum) {
		this.liOrNum = liOrNum;
	}
	public String getLiMename() {
		return liMename;
	}
	public void setLiMename(String liMename) {
		this.liMename = liMename;
	}
	public List<PizzaOrderVo> getInsLi() {
		return insLi;
	}
	public void setInsLi(List<PizzaOrderVo> insLi) {
		this.insLi = insLi;
	}
	public void setOrId(int orId) {
		this.orId = orId;
	}
			



	
	
	
	
	
}
