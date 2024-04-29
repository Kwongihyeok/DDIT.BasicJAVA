package kr.or.ddit.study06.sec06.acess;

import kr.or.ddit.study06.sec06.AccesPrivate;
import kr.or.ddit.study06.sec06.AcessDefault;
import kr.or.ddit.study06.sec06.AcessProtect;
import kr.or.ddit.study06.sec06.AcessPublic;

public class AccesMain {
	public static void main(String[] args) {
		AccesPrivate ap = new AccesPrivate();
		AcessDefault ad = new AcessDefault();
//		int a =ad.a;
//		ad.defalutMethod2();
//		ad.defaultMethod1();
//		AcessProtect ap2 = new AcessProtect();
//		int a2 = ap2.a;
		AcessPublic ap3 = new AcessPublic();
		int a3 = ap3.a;
		ap3.publicMethod1();
	}
}
