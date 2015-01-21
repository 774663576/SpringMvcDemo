package com.ibaiyun.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ibaiyun.pojo.Member;
import com.ibaiyun.service.MemberService;
import com.ibaiyun.vo.RoleEnum;

public class BatchSave {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("/WEB-INF/applicationContext.xml");
		/*
		ApplicationContext ctx = new FileSystemXmlApplicationContext("D:/Project/MyTest/SpringMVC_Hibernate_001/webapp/WEB-INF/applicationContext.xml");
		MemberService service = (MemberService) ctx.getBean("memberService");
		for(int i=1;i<21;i++){
			System.out.println(i);
			Member member = new Member();
			member.setLoginName("name_"+i);
			member.setLoginPwd("pwd_"+i);
			member.setNickName("nick_"+i);
			if(i%2==0) member.setRoleRank(RoleEnum.C);
			else if(i%3==0) member.setRoleRank(RoleEnum.D);
			else member.setRoleRank(RoleEnum.E);
			service.save(member);
		}
		*/
		
		zhBatchSave();
	}

	private static void zhBatchSave() {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("D:/Project/MyTest/SpringMVC_Hibernate_001/webapp/WEB-INF/applicationContext.xml");
		MemberService service = (MemberService) ctx.getBean("memberService");
		String k = null;
		for(int i=1;i<21;i++){
			if(i<10) k = "0"+i;
			else k = i+"";
			System.out.println(k);
			Member member = new Member();
			member.setLoginName("名_"+k);
			member.setLoginPwd("密_"+k);
			member.setNickName("昵_"+k);
			if(i%2!=0) member.setRoleRank(RoleEnum.C);
			else if(i%3!=0) member.setRoleRank(RoleEnum.D);
			else member.setRoleRank(RoleEnum.E);
			service.save(member);
		}
	}

}
