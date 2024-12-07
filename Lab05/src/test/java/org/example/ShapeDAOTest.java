package org.example;

import jakarta.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = ShapeDAO.class)
public class ShapeDAOTest {

    @Autowired @Qualifier("shapeDAO")
    private ShapeDAO shapeDAO;

    @Mock
    private SessionFactory sessionFactory;

    @Test
    public void testShapeCRUD() {
        Color red = new Color(255, 0, 0, 255);

        Shape shape = new Triangle(3,4,5,red);
        shapeDAO.saveShape(shape);

        Shape fetchedShape = shapeDAO.getShapeById(shape.getId());
        assertNotNull(fetchedShape);
        assertEquals(fetchedShape.getId(), shape.getId());

        List<Shape> shapes = shapeDAO.getAllShapes();
        assert(!shapes.isEmpty());

        fetchedShape.setColor(new Color(0, 255, 0, 255));
        shapeDAO.updateShape(fetchedShape);

        Shape updatedShape = shapeDAO.getShapeById(fetchedShape.getId());
        assertNotNull(updatedShape);
        assertEquals(0, updatedShape.color.red);

        shapeDAO.deleteShape(fetchedShape.getId());
        Shape deletedShape = shapeDAO.getShapeById(fetchedShape.getId());
        assertNull(deletedShape);

        shapeDAO.setCustomSessionFactory(sessionFactory);

        shapeDAO.close();

        verify(sessionFactory).close();
    }

    @Test
    public void testShapeTableCreation() {
        assertDoesNotThrow(() -> shapeDAO.getShapeById(1L));
    }
}
