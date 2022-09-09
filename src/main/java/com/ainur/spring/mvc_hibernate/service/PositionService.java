package com.ainur.spring.mvc_hibernate.service;

import com.ainur.spring.mvc_hibernate.entity.Position;

import java.util.List;

public interface PositionService {
    List<Position> getAllPositions();

    void savePosition(Position position);

    Position getPosition(int id);

    void deletePosition(int id);
}
