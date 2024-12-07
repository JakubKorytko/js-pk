package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.NullSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ShapeServiceTest {

    private AutoCloseable closeable;

    @Mock
    private ShapeRepository shapeRepository;

    @Mock
    private ColorRepository colorRepository;

    @InjectMocks
    private ShapeService shapeService;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
        when(shapeRepository.save(any(Shape.class))).thenAnswer(invocation -> invocation.getArgument(0));
        when(colorRepository.save(any(Color.class))).thenAnswer(invocation -> invocation.getArgument(0));
    }

    @Test
    void testSaveShapeWithNullColor() {
        Rectangle shape = new Rectangle(2, 4, null);
        Shape savedShape = shapeService.saveShape(shape);

        assertNotNull(savedShape);

        verify(colorRepository, never()).save(any(Color.class));
        verify(shapeRepository).save(shape);
    }

    @Test
    void testSaveShapeWithNewColor() {
        Color color = new Color(255, 0, 0, 255);
        Triangle shape = new Triangle(2, 4, 5, color);

        Shape savedShape = shapeService.saveShape(shape);

        assertNotNull(savedShape);
        verify(colorRepository).save(color);
        verify(shapeRepository).save(shape);
    }

    @Test
    void testSaveShapeWithExistingColor() {
        Color color = new Color(255, 0, 0, 255);
        Triangle shape = new Triangle(2, 4, 5, color);

        color.setId(1L);
        Shape savedShape = shapeService.saveShape(shape);

        assertNotNull(savedShape);
        verify(colorRepository, never()).save(any(Color.class));
        verify(shapeRepository).save(shape);
    }

    @Test
    void testGetAllShapes() {
        List<Shape> shapes = Arrays.asList(new Triangle(), new Rectangle());
        when(shapeRepository.findAll()).thenReturn(shapes);

        List<Shape> result = shapeService.getAllShapes();

        assertEquals(2, result.size());
        verify(shapeRepository).findAll();
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }
}
