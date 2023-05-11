package org.jsp.userproductapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.userproductapp.dto.User;

public class UserDao {
	EntityManager m = Persistence.createEntityManagerFactory("dev").createEntityManager();

	public User saveUser(User user) {
		m.persist(user);
		EntityTransaction t = m.getTransaction();
		t.begin();
		t.commit();
		return user;
	}

	public User updateUser(User user) {
		m.merge(user);
		EntityTransaction t = m.getTransaction();
		t.begin();
		t.commit();
		return user;
	}

	public User findUserById(int id) {
		return m.find(User.class, id);
	}

	public User verifyUser(long phone, String password) {
		Query q = m.createQuery("select u from User u where phone=?1 and password=?2");
		q.setParameter(1, phone);
		q.setParameter(2, password);
		try {
			return (User) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public boolean deleteUser(int id) {
		User u = findUserById(id);
		if (u != null) {
			 m.remove(u);
			EntityTransaction t = m.getTransaction();
			t.begin();
			t.commit();
			return true;
		}
		return false;
	}

}
