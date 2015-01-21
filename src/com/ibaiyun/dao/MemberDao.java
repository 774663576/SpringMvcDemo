package com.ibaiyun.dao;

import java.util.List;

import com.ibaiyun.pojo.Member;

/**
 * 成员信息操作接口
 * @author yang
 *
 */
public interface MemberDao {
	/**
	 * 添加一个成员
	 * @param member
	 */
	void add(Member member);
	/**
	 * 根据ID获取一个成员
	 * @param id
	 * @return
	 */
	Member getMemberById(Long id);
	/**
	 * 获取所有成员
	 * @return 一个成员的泛型
	 */
	List<Member> getAll();
	/**
	 * 根据ID删除一个成员
	 * @param id
	 */
	void deleteMemberById(Long id);
}
