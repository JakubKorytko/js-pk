package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ShapeControllerTest {

    private ShapeService shapeService;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        shapeService = Mockito.mock(ShapeService.class);  // Mocking the service directly
        mockMvc = MockMvcBuilders.standaloneSetup(new ShapeController(shapeService)).build();
    }

    @Test
    public void testGetAllShapes() throws Exception {
        Shape shape1 = new Triangle(3, 4, 5, new Color(255, 0, 0, 255));
        Shape shape2 = new Rectangle(2, 5, new Color(0, 0, 255, 255));
        List<Shape> shapes = Arrays.asList(shape1, shape2);

        when(shapeService.getAllShapes()).thenReturn(shapes);

        mockMvc.perform(get("/api/shapes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].type").value("triangle"))
                .andExpect(jsonPath("$[1].type").value("rectangle"));

        verify(shapeService).getAllShapes();
    }

    @Test
    public void testCreateShape() throws Exception {
        Shape newShape = new Triangle(3, 4, 5, new Color(255, 0, 0, 255));

        when(shapeService.saveShape(any(Shape.class))).thenReturn(newShape);

        mockMvc.perform(post("/api/shapes")
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(newShape)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.type").value("triangle"))
                .andExpect(jsonPath("$.color.red").value(255))
                .andExpect(jsonPath("$.color.green").value(0))
                .andExpect(jsonPath("$.color.blue").value(0))
                .andExpect(jsonPath("$.color.alpha").value(255));

        verify(shapeService).saveShape(any(Shape.class));
    }
}
