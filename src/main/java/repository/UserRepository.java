package repository;

import org.hibernate.Session;
import org.hibernate.query.Query;

import domain.User;
import hibernateUtil.HibernateUtil;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    public static Long saveOrUpdate(User user){
        Session session = null;

        try {

            session = HibernateUtil.openSession();
            session.getTransaction().begin();
            session.saveOrUpdate(user);
            session.getTransaction().commit();
            return user.getId();
        } catch (Exception e) {
            if(session != null && session.getTransaction().isActive()){
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return 0L;
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public static Optional<User> findByEmail(String email,String password){
        Session session = null;

        try {
            session= HibernateUtil.openSession();
            String hql = "SELECT u FROM User u WHERE u.email=:email AND u.password=:password";
//            String hql = "SELECT u FROM User u WHERE u.email=:email";
            Query query = session.createQuery(hql);
            query.setParameter("password", password);
            query.setParameter("email", email);
            User userResult = (User)query.getSingleResult();
            return Optional.ofNullable(userResult);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public static Optional<User> findUser(Long id){
        Session session = null;

        try {
            session= HibernateUtil.openSession();
            String hql = "SELECT u FROM User u WHERE u.id=:id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            User userResult = (User)query.getSingleResult();
            return Optional.ofNullable(userResult);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }
}
