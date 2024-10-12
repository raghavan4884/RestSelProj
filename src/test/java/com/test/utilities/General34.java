package com.test.utilities;

public class General34 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		General33 g3=new General33();
		String browser=g3.getPropValue("browser", "src/test/resources/1.properties");
		System.out.println(browser);
		String time=g3.getPropValue("time", "src/test/resources/1.properties");
		System.out.println(time);
	}

}
