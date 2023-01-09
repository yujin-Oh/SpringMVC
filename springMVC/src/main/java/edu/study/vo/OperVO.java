package edu.study.vo;

public class OperVO {
	
	private int num1;
	private int num2;
	private String oper;
	
	
	
	@Override
	public String toString() {
		return "OperVO [num1=" + num1 + ", num2=" + num2 + ", oper=" + oper + "]";
	}
	
	
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	public String getOper() {
		return oper;
	}
	public void setOper(String oper) {
		this.oper = oper;
	}
	
	
}
