package com.ttisv.common.utils;

public class testmaincore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CorebankDao core=new CorebankDao();
		core.sessionNo="wwwwwwww";
		CorebankDao core1=new CorebankDao();
		core1.sessionNo="11111111111111111";
		System.out.println(core1.sessionNo);
		System.out.println(	core.sessionNo);
		CorebankDao1 core2=new CorebankDao1();
		core2.sessionNo="33333333";
		System.out.println(	core.sessionNo);
		System.out.println(	core2.sessionNo);
	}

}
