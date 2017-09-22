package com.zxxz.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//sessionFactory工具类
public class HibernateUtil {
	// 定义sessionFactory
	private static final SessionFactory sessionFactory;
	static {
		// 加载herbinate.properties。
		Configuration config = new Configuration();
		// 加载hibernate.cfg.xml
		config.configure();
		// 创建sessionFactory
		sessionFactory = config.buildSessionFactory();

		// 关闭虚拟机时,释放SessionFactory
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("虚拟机关闭!释放资源");
				sessionFactory.close();
			}
		}));
	}

	// 返回sessionFactory实例
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	// 获取session实例
	public static Session getSession() {
		return sessionFactory.openSession();
	}

	// 获取当前线程绑定的session实例
	public static Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}
