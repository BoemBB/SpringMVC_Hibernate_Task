package com.ainur.spring.mvc_hibernate.service;

import com.ainur.spring.mvc_hibernate.dao.PositionDAO;
import com.ainur.spring.mvc_hibernate.entity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@EnableTransactionManagement
public class PositionServiceImpl implements PositionService{

    @Autowired
    private PositionDAO positionDAO;

    @Override
    @Transactional
    public List<Position> getAllPositions() {
        return positionDAO.getAllPositions();
    }

    @Override
    @Transactional
    public void savePosition(Position position) {

        positionDAO.savePosition(position);
    }

    @Override
    @Transactional
    public Position getPosition(int id) {
        return positionDAO.getPosition(id);
    }

    @Override
    @Transactional
    public void deletePosition(int id) {
        positionDAO.deletePosition(id);
    }
}
