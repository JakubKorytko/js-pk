package org.example;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ShapeDAOTest {

    private static ShapeDAO shapeDAO;
    private static Color red;

    @BeforeAll
    public static void setUp() {
        shapeDAO = new ShapeDAO();
        red = new Color(255, 0, 0, 255);
    }

    @Transactional
    @Test
    public void testShapeCRUD() {
        Shape shape = new Triangle(3,4,5,red);
        shapeDAO.saveShape(shape);

        Shape fetchedShape = shapeDAO.getShapeById(shape.getId());
        assertNotNull(fetchedShape);
        assertEquals(fetchedShape.getId(), shape.getId());

        fetchedShape.setColor(new Color(0, 255, 0, 255));
        shapeDAO.updateShape(fetchedShape);

        Shape updatedShape = shapeDAO.getShapeById(fetchedShape.getId());
        assertNotNull(updatedShape);
        assertEquals(0, updatedShape.color.red);

        shapeDAO.deleteShape(fetchedShape.getId());
        Shape deletedShape = shapeDAO.getShapeById(fetchedShape.getId());
        assertNull(deletedShape);
    }

    @Test
    public void testShapeTableCreation() {
        assertDoesNotThrow(() -> shapeDAO.getShapeById(1L));
    }

    @AfterAll
    public static void tearDown() {
        shapeDAO.close();
    }
}
