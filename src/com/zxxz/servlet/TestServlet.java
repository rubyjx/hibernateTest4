package com.zxxz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.zxxz.dao.Testdao;
import com.zxxz.vo.GoodsDTO;

public class TestServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Testdao td = new Testdao();
		DetachedCriteria detacriteria=DetachedCriteria.forClass(GoodsDTO.class);
		detacriteria.add(Restrictions.eq("goodsID", 2));
		td.test2(detacriteria);
		resp.getWriter().println("111111111111");
	}
}
