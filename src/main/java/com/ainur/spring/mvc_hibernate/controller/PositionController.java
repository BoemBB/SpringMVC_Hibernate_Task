package com.ainur.spring.mvc_hibernate.controller;

import com.ainur.spring.mvc_hibernate.entity.Position;
import com.ainur.spring.mvc_hibernate.execption_handling.NoSuchEmployeeException;
import com.ainur.spring.mvc_hibernate.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PositionController {
    @Autowired
    private PositionService positionService;

    @GetMapping("/positions")
    public List<Position> showAllPositions(){
        List<Position> allPositions = positionService.getAllPositions();

        return allPositions;
    }

    @GetMapping("/positions/{id}")
    public Position getPosition(@PathVariable int id){
        Position position = positionService.getPosition(id);

        if(position == null){
            throw new NoSuchEmployeeException("there is no Position with this id " + id);
        }
        return position;
    }

    @PostMapping("/positions")
    public Position addNewPosition(@RequestBody Position position){
        positionService.savePosition(position);
        return position;
    }

    @PutMapping("/positions")
    public Position updatePosition(@RequestBody Position position){
        positionService.savePosition(position);
        return position;
    }

    @DeleteMapping("/positions/{id}")
    public String deletePosition(@PathVariable int id){
        Position position = positionService.getPosition(id);
        if (position == null){
            throw new NoSuchEmployeeException("there is no Position with id " + id);
        }
        positionService.deletePosition(id);
        return "Position " + id + "was deleted";
    }
}
