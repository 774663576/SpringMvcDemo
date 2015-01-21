package com.ibaiyun.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibaiyun.pojo.Member;
import com.ibaiyun.service.MemberService;
import com.ibaiyun.util.RequestUtil;
import com.ibaiyun.vo.RoleEnum;

/**
 * 成员信息controller
 * 
 * @author yang
 * 
 */
@Controller
@RequestMapping("/member")
public class MemberController {
	private static Logger log = Logger.getLogger(MemberController.class);
	private MemberService memberService;

	/**
	 * 添加一个成员
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/test")
	public String saveMember(Model model) {
		// Member member = new Member(1L,"hui","hui","hui",RoleEnum.A);
		Member member = new Member("yang", "yang", "yang", RoleEnum.A);
		memberService.save(member);
		return "test";
	}

	/**
	 * 获取所有成员
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/show")
	public String getMember(Model model) {
		// Member member = new Member(1L,"hui","hui","hui",RoleEnum.A);
		List<Member> memberList = memberService.getAllMember();
		model.addAttribute("memberList", memberList);
		return "show";
	}

	/**
	 * 获取所有成员
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/showAll")
	public void getAllMember(HttpServletResponse response, Model model) {
		// Member member = new Member(1L,"hui","hui","hui",RoleEnum.A);
		List<Member> memberList = memberService.getAllMember();
		output(response, JSONArray.fromObject(memberList).toString());
	}

	/**
	 * 根据ID，获取一个成员，以json格式输出到页面
	 * 
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping("/showById")
	public void getMemberById(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		String sid = RequestUtil.getString(request, "id", "1");
		Long id = Long.parseLong(sid);
		Member member = memberService.getMemberById(id);
		model.addAttribute("member", member);
		output(response, JSONObject.fromObject(member).toString());
	}

	@RequestMapping("/delById")
	public void deleteMemberById(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		String sid = RequestUtil.getString(request, "id", null);
		Boolean isDel = true;
		if (sid == null) {
			isDel = false;
		}
		try {
			memberService.deleteMemberById(Long.parseLong(sid));
		} catch (Exception e) {
			isDel = false;
			log.info("根据ID删除成员失败。");
			log.error(e.getMessage(), e);
		}
		output(response, isDel.toString());
	}

	/**
	 * 输出结果到response中
	 * 
	 * @param response
	 * @param str
	 */
	private void output(HttpServletResponse response, String str) {
		try {
			response.getOutputStream().write(str.getBytes("UTF-8"));
			response.getOutputStream().flush();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public MemberService getMemberService() {
		return memberService;
	}

	@Resource
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

}
