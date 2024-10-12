package com.test.utilities;

public class General2 {

	static int a=2;
	int c=2;
	public static void b()
	{
		System.out.println(a++);
	}
	public void d()
	{
		System.out.println(c++);
		
	}
	
	public static void main(String args[])
	{
		General2 g=new General2();
		General2 gg=new General2();
		g.d();
		g.b();
		gg.d();
		gg.b();
	}
	}

