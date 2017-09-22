package com.zxxz.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//sessionFactory������
public class HibernateUtil {
	// ����sessionFactory
	private static final SessionFactory sessionFactory;
	static {
		// ����herbinate.properties��
		Configuration config = new Configuration();
		// ����hibernate.cfg.xml
		config.configure();
		// ����sessionFactory
		sessionFactory = config.buildSessionFactory();

		// �ر������ʱ,�ͷ�SessionFactory
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("������ر�!�ͷ���Դ");
				sessionFactory.close();
			}
		}));
	}

	// ����sessionFactoryʵ��
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	// ��ȡsessionʵ��
	public static Session getSession() {
		return sessionFactory.openSession();
	}

	// ��ȡ��ǰ�̰߳󶨵�sessionʵ��
	public static Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}
