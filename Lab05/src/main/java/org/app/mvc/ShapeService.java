package org.app.mvc;

import org.app.shapes.Color;
import org.app.shapes.Shape;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Service
public class ShapeService {

    private final ShapeRepository shapeRepository;
    private final ColorRepository colorRepository;

    public ShapeService(ShapeRepository shapeRepository, ColorRepository colorRepository) {
        this.shapeRepository = shapeRepository;
        this.colorRepository = colorRepository;
    }

    @Transactional
    public Shape saveShape(Shape shape) {
        if (shape.color != null) {
            Color color = shape.color;
            if (color.getId() == null) {
                colorRepository.save(color);
            }
        }

        return shapeRepository.save(shape);
    }

    public List<Shape> getAllShapes() {
        return shapeRepository.findAll();
    }
}
