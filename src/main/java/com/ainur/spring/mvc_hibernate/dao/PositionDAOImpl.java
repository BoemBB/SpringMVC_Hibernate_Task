package com.ainur.spring.mvc_hibernate.dao;

import com.ainur.spring.mvc_hibernate.entity.Position;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PositionDAOImpl implements PositionDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Position> getAllPositions() {
        Session session = sessionFactory.getCurrentSession();
        List<Position> allPositions = session.createQuery("from Position",
                Position.class).getResultList();
        return allPositions;
    }

    @Override
    public void savePosition(Position position) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(position);
    }

    @Override
    public Position getPosition(int id) {
        Session session = sessionFactory.getCurrentSession();
        Position position = session.get(Position.class, id);
        return position;
    }

    @Override
    public void deletePosition(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Position> query = session.createQuery("delete from Position where id =:positionId");
        query.setParameter("positionId", id);
        query.executeUpdate();
    }
}
