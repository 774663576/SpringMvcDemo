package com.ibaiyun.dao.common;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

/**
 * 基础操作Dao
 * 
 * @author yang
 * 
 */
@Component
public class BaseDao {
	private HibernateTemplate hibernateTemplate;

	// 添加
	public void add(Object o) {
		hibernateTemplate.save(o);
	}

	// 修改
	public void update(Object o) {
		hibernateTemplate.update(o);
	}

	// 修改(在session中已存在这个对象的修改)
	public void merge(Object o) {
		hibernateTemplate.merge(o);
	}

	// 根据ID获取对象
	public Object getById(Class<?> c, Serializable id) {
		return hibernateTemplate.get(c, id);
	}

	// 删除对象
	public void delete(Object o) {
		hibernateTemplate.delete(o);
	}

	// 根据ID删除对象
	public void deleteById(Class<?> c, Serializable id) {
		delete(getById(c, id));
	}

	// 获取所有的记录
	public List<?> getAll(Class<?> c) {
		return hibernateTemplate.find("from " + c.getName());
	}

	// 批量修改
	public void bulkUpdate(String hql, Object... objects) {
		hibernateTemplate.bulkUpdate(hql, objects);
	}

	// 得到唯一值
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object getUnique(final String hql, final Object... objects) {
		return hibernateTemplate.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				if (objects != null)
					for (int i = 0; i < objects.length; i++)
						query.setParameter(i, objects[i]);
				return query.uniqueResult();
			}
		});
	}

	// 分页查询
	@SuppressWarnings("rawtypes")
	public List<?> pageQuery(final String hql, final Integer page,
			final Integer size, final Object... objects) {
		return hibernateTemplate.executeFind(new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				if (objects != null)
					for (int i = 0; i < objects.length; i++) {
						query.setParameter(i, objects[i]);
					}
				if (page != null && size != null)
					query.setFirstResult((page - 1) * size).setMaxResults(size);
				return query.list();
			}
		});
	}

	// 不分页查询
	public List<?> pageQuery(String hql, Object... objects) {
		return pageQuery(hql, null, null, objects);
	}

	public void save(Object o) {
		if (o != null)
			hibernateTemplate.saveOrUpdate(o);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void update(final String hql, final Object... objects) {
		hibernateTemplate.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				if (objects != null)
					for (int i = 0; i < objects.length; i++)
						query.setParameter(i, objects[i]);
				return query.executeUpdate();
			}
		});
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
