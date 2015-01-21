package com.ibaiyun.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ibaiyun.vo.RoleEnum;

/**
 * 用户信息类
 * @author yang
 *
 */
@Entity
@Table(name="_member")
public class Member implements Serializable {
	private Long id;
	private String loginName;
	private String loginPwd;
	private String nickName;
	private RoleEnum roleRank;
	
	//constructor
	public Member() {}
	
	//full constructor
	public Member(String loginName, String loginPwd, String nickName,
			RoleEnum roleRank) {
		this.loginName = loginName;
		this.loginPwd = loginPwd;
		this.nickName = nickName;
		this.roleRank = roleRank;
	}
	
	//setter getter
	@Id
	@GeneratedValue
	@Column(name="_id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="_loginName")
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	@Column(name="_loginPwd")
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	@Column(name="_nickName")
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	@Column(name="_roleRank")
	public RoleEnum getRoleRank() {
		return roleRank;
	}
	public void setRoleRank(RoleEnum roleRank) {
		this.roleRank = roleRank;
	}

	@Override
	public String toString() {
		return "id:"+this.id+",loginName:"+this.loginName+",loginPwd:"+this.loginPwd+",nickName:"
				+this.nickName+",roleRank:"+this.roleRank;
	}
	
	
}
