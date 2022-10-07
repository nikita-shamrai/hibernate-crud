package org.example.repository;

import org.example.entities.Client;
import org.example.entities.MyEntity;
import org.example.repository.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import java.util.stream.Collectors;

public class ClientRepoImpl implements ClientRepo {

    @Override
    public MyEntity create(MyEntity entity) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(entity);
        session.getTransaction().commit();
        session.close();
        return entity;
    }

    @Override
    public MyEntity read(int id) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        MyEntity entity = session.get(Client.class, id);
        transaction.commit();
        session.close();
        return entity;
    }

    @Override
    public List<MyEntity> readAll() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        List<MyEntity> resultList = session.createQuery("FROM Client", Client.class).getResultList()
                .stream().map(client -> (MyEntity) client).collect(Collectors.toList());
        transaction.commit();
        session.close();
        return resultList;
    }

    @Override
    public MyEntity update(int id, MyEntity entity) {
        Client entityById = (Client) read(id);
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        entityById.setName(((Client) entity).getName());
        entityById.setRegistrationDate(((Client) entity).getRegistrationDate());
        session.update(entityById);
        transaction.commit();
        session.close();
        return entityById;
    }

    @Override
    public boolean delete(int id) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.get(Client.class, id));
        transaction.commit();
        session.close();
        return true;
    }
}
