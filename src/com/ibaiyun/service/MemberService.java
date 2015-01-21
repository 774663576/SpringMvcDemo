package com.ibaiyun.service;

import java.util.List;

import com.ibaiyun.pojo.Member;

/**
 * 成员信息业务逻辑接口
 * @author yang
 *
 */
public interface MemberService {
	/**
	 * 添加一个成员
	 * @param member
	 */
	void save(Member member);
	/**
	 * 根据ID，获取一个成员
	 * @param id
	 * @return
	 */
	Member getMemberById(Long id);
	/**
	 * 获取所有成员
	 * @return 一个成员的泛型
	 */
	List<Member> getAllMember();
	/**
	 * 根据ID删除一个成员
	 * @param id
	 */
	void deleteMemberById(Long id);
}
