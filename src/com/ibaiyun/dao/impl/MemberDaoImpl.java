package com.ibaiyun.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ibaiyun.dao.MemberDao;
import com.ibaiyun.dao.common.BaseDao;
import com.ibaiyun.pojo.Member;

/**
 * 成员信息操作接口的实现
 * @author yang
 *
 */
@Component
public class MemberDaoImpl extends BaseDao implements MemberDao {

	@Override
	public void add(Member member) {
		System.out.println("a member is added : "+member);
		super.add(member);
	}

	@Override
	public Member getMemberById(Long id) {
		Object object = super.getById(Member.class, id);
		return (Member)object;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Member> getAll() {
		List<Member> list = (List<Member>) super.getAll(Member.class);
		return list;
	}

	@Override
	public void deleteMemberById(Long id) {
		super.deleteById(Member.class, id);
	}
	
}
