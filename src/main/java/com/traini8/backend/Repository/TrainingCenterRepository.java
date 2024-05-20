package com.traini8.backend.Repository;

import com.traini8.backend.DAO.TrainingCenter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TrainingCenterRepository {
    public  List<TrainingCenter> findAll(){
        Configuration configuration = new Configuration().configure().addAnnotatedClass(TrainingCenter.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Query<TrainingCenter> query = session.createQuery("FROM TrainingCenter", TrainingCenter.class);
        List<TrainingCenter> trainingCenters = query.getResultList();
        transaction.commit();
        session.close();
        sessionFactory.close();
        return trainingCenters;
    }

    public TrainingCenter save(TrainingCenter trainingCenter){
        Configuration configuration = new Configuration().configure().addAnnotatedClass(TrainingCenter.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        session.save(trainingCenter);
        transaction.commit();
        session.close();
        sessionFactory.close();
        return trainingCenter;
    }
}
