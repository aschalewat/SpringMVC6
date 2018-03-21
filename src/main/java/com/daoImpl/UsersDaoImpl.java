package com.daoImpl;
 
import java.util.List;
 
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
import com.daoapi.UsersDao;
import com.entities.Users;

import javax.annotation.Resource;

@Repository
@Transactional
public class UsersDaoImpl implements UsersDao {

    @Autowired
    private SessionFactory sessionFactory;
    //SessionFactory factory =  new Configuration().configure().buildSessionFactory();

    //@Transactional
    public boolean saveOrUpdate(Users users) {
        // TODO Auto-generated method stub
        sessionFactory.getCurrentSession().getTransaction().begin();
        sessionFactory.getCurrentSession().saveOrUpdate(users);
        return true;
    }

    //@Transactionalfhgfhfhgtyytty
    public List<Users> list() {
        if (sessionFactory != null){
            System.out.println("SessionFactory is not null.");
        } else {
            System.out.println("SessionFactory is null");
        }
        sessionFactory.getCurrentSession().getTransaction().begin();
        return sessionFactory.getCurrentSession().createQuery("from Users").list();
    }

    //@Transactional
    public boolean delete(Users users) {
        try {
            sessionFactory.getCurrentSession().getTransaction().begin();
            sessionFactory.getCurrentSession().delete(users);
        } catch (Exception ex) {
            return false;
        }
 
        return true;
    }


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}