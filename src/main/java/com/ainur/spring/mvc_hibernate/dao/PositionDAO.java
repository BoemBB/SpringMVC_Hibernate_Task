package com.ainur.spring.mvc_hibernate.dao;

import com.ainur.spring.mvc_hibernate.entity.Position;

import java.util.List;

public interface PositionDAO {
    List<Position> getAllPositions();

    void savePosition(Position position);

    Position getPosition(int id);

    void deletePosition(int id);
}
