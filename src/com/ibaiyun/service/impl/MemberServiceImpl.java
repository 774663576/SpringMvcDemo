package com.ibaiyun.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ibaiyun.dao.MemberDao;
import com.ibaiyun.pojo.Member;
import com.ibaiyun.service.MemberService;

/**
 * 成员信息业务逻辑接口的实现
 * @author yang
 *
 */
@Component
public class MemberServiceImpl implements MemberService {
	private MemberDao memberDao;
	
	@Override
	public void save(Member member) {
		memberDao.add(member);
	}
	
	@Override
	public Member getMemberById(Long id) {
		return memberDao.getMemberById(id);
	}

	@Override
	public void deleteMemberById(Long id) {
		memberDao.deleteMemberById(id);
	}

	@Override
	public List<Member> getAllMember() {
		return memberDao.getAll();
	}

	
	
	public MemberDao getMemberDao() {
		return memberDao;
	}
	
	@Resource
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
}
