package view;

import util.ScanUtil;

public class Print {
	
	public void printLine() {
		System.out.print("==========================");
	}
	public void printNewLine() {
		System.out.println("==========================");
	}
	
	public int scanMenu() {
		int sel = ScanUtil.nextInt("입력 >> ");
		
		return sel;
	}
	
	
	
	//print color
	private  String ANSI_BLACK = "\u001B[30m";
	private  String ANSI_RED = "\u001B[31m";
	private  String ANSI_GREEN = "\u001B[32m";
	private  String ANSI_YELLOW = "\u001B[33m";
	private  String ANSI_BLUE = "\u001B[34m";
	private  String ANSI_PURPLE = "\u001B[35m";
	private  String ANSI_CYAN = "\u001B[36m";
	private  String ANSI_WHITE = "\u001B[37m";
	
	public void print_RED(String insert) {
		System.out.print(ANSI_RED+insert+ANSI_BLACK);
	}
	public void print_GREEN(String insert) {
		System.out.print(ANSI_GREEN+insert+ANSI_BLACK);
	}
	public void print_YELLOW(String insert) {
		System.out.print(ANSI_YELLOW+insert+ANSI_BLACK);
	}
	public void print_BLUE(String insert) {
		System.out.print(ANSI_BLUE+insert+ANSI_BLACK);
	}
	public void print_PURPLE(String insert) {
		System.out.print(ANSI_PURPLE+insert+ANSI_BLACK);
	}
	public void print_CYAN(String insert) {
		System.out.print(ANSI_CYAN+insert+ANSI_BLACK);
	}
	public void print_WHITE(String insert) {
		System.out.print(ANSI_WHITE+insert+ANSI_BLACK);
	}
	
}
