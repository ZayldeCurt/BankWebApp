package repository;

import domain.BankAccount;
import hibernateUtil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Optional;

public class BankAccountRepository {

    public static Long saveOrUpdate(BankAccount bankAccount) {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            session.getTransaction().begin();
            session.saveOrUpdate(bankAccount);
            session.getTransaction().commit();
            return bankAccount.getId();
        } catch (Exception e) {
            if (session != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return 0L;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
    public static Optional<BankAccount> findBankAccount(String accountNumber){
        Session session = null;

        try {
            session= HibernateUtil.openSession();
            String hql = "SELECT b FROM BankAccount b WHERE b.accountNumber=:accountNumber";
            Query query = session.createQuery(hql);
            query.setParameter("accountNumber", accountNumber);
            BankAccount userResult = (BankAccount) query.getSingleResult();
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
