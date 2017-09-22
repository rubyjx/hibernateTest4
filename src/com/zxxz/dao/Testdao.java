package com.zxxz.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import com.zxxz.util.HibernateUtil;
import com.zxxz.vo.GoodsDTO;
import com.zxxz.vo.Order1DTO;

public class Testdao {
	public void test1() {
		// 定义session
		Session session = null;
		Date date = new Date();
		// 定义transaction
		Transaction transction = null;
		session = HibernateUtil.getSession();
		// 创建商品实体类
		GoodsDTO g1 = new GoodsDTO();
		GoodsDTO g2 = new GoodsDTO();
		// 订单实体类
		Order1DTO orderdto = new Order1DTO();
		g1.setGoodsName("笔记本");
		g1.setGoodsPrice(23.4);
		g2.setGoodsName("土豆");
		g2.setGoodsPrice(24.1);

		orderdto.setOrderName("订单1");
		orderdto.setOrderTime(date);
		g1.getOrderlist().add(orderdto);
		g2.getOrderlist().add(orderdto);
		// 开启事务
		try {
			transction = session.beginTransaction();
			session.save(g1);
			session.save(g2);
			transction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transction.rollback();
		}finally {
			session.close();
		}
	}
	public void test2(DetachedCriteria detacriteria) {
		// 定义session
		Session session = null;
		Date date = new Date();
		// 定义transaction
		Transaction transction = null;
		session = HibernateUtil.getSession();
	
		// 开启事务
		try {
			transction = session.beginTransaction();
	        Criteria criteria=detacriteria.getExecutableCriteria(session);
	        List<GoodsDTO> list=criteria.list();
	        for (GoodsDTO goodsDTO : list) {
				System.out.println(goodsDTO);
			}
			transction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transction.rollback();
		}finally {
			session.close();
		}
	}
}
