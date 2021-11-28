package com.codegym.service;

import com.codegym.model.Music;
import com.codegym.model.MusicForm;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class MusicServiceImp implements IMusicService {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Music> findAll() {
        String queryStr = "SELECT m FROM Music AS m";
        TypedQuery<Music> query = entityManager.createQuery(queryStr, Music.class);
        return query.getResultList();
    }

    @Override
    public Music findById(Long id) {
        Music music = entityManager.find(Music.class, id);
        return music;
    }

    @Override
    public Music update(Music music) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Music origin = findById(music.getId());
            origin.setActor(music.getActor());
            origin.setLink(music.getLink());
            origin.setType(music.getType());
            session.saveOrUpdate(origin);
            transaction.commit();
            return origin;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public Music save(Music music) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(music);
            transaction.commit();
            return music;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public void remove(Integer id) {
        String queryStr = "DELETE FROM Music WHERE id = :id";
        TypedQuery<Music> query = entityManager.createQuery(queryStr, Music.class);
        query.setParameter("id", id);
        query.getSingleResult();
    }
}
