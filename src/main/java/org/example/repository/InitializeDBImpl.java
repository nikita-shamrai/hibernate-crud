package org.example.repository;

import org.example.entities.Client;
import org.example.entities.MyEntity;
import org.example.repository.util.HibernateUtil;
import org.example.util.DateGenerator;
import org.example.util.DateGeneratorImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class InitializeDBImpl implements InitializeDB {

    @Override
    public boolean createAndFillTable() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        DateGenerator dateGenerator = new DateGeneratorImpl();
        for (int i = 1; i <= 50; i++) {
            MyEntity client = new Client(i, "Name " + i, dateGenerator.generateDate());
            session.save(client);
        }
        transaction.commit();
        session.close();
        return true;
    }

}
