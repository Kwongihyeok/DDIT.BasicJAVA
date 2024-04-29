package kr.or.ddit.study06.sec06;

import javax.annotation.Generated;

public class MemberNo {
	static int year;
	private String id;
	private String pass;
	private String name;
	
	
	public MemberNo() {
	
	}


	public MemberNo(String id, String pass, String name) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
	}


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


	@Override
	public String toString() {
		return "MemberNo [id=" + id + ", pass=" + pass + ", name=" + name + "]";
	}
	
	
}
