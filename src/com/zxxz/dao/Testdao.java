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
		// ����session
		Session session = null;
		Date date = new Date();
		// ����transaction
		Transaction transction = null;
		session = HibernateUtil.getSession();
		// ������Ʒʵ����
		GoodsDTO g1 = new GoodsDTO();
		GoodsDTO g2 = new GoodsDTO();
		// ����ʵ����
		Order1DTO orderdto = new Order1DTO();
		g1.setGoodsName("�ʼǱ�");
		g1.setGoodsPrice(23.4);
		g2.setGoodsName("����");
		g2.setGoodsPrice(24.1);

		orderdto.setOrderName("����1");
		orderdto.setOrderTime(date);
		g1.getOrderlist().add(orderdto);
		g2.getOrderlist().add(orderdto);
		// ��������
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
		// ����session
		Session session = null;
		Date date = new Date();
		// ����transaction
		Transaction transction = null;
		session = HibernateUtil.getSession();
	
		// ��������
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
