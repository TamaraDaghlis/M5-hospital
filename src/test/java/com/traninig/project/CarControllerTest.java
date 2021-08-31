package com.traninig.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.traninig.project.controller.CarController;
import com.traninig.project.model.Car;
import com.traninig.project.service.CarService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.http.HttpHeaders;
import java.util.ArrayList;
import java.util.List;
import org.springframework.test.web.servlet.ResultActions;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.header;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@WebMvcTest(CarController.class)
public class CarControllerTest {

    @Autowired
    public MockMvc mockMvc;
    @MockBean
    private CarService carService;

    Car car = new Car(123,"van");

    @Test
    @DisplayName("Get all cars")
    public void testGetAllCars () throws Exception {

        List<Car> listcars= new ArrayList();
        listcars.add(new Car(123, "VAN"));
        listcars.add(new Car(223,"CAR"));

        Mockito.when(carService.getAllCars()).thenReturn(listcars);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/car"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        verify(carService,times(1)).getAllCars();
                //.andExpect(header().string(HttpHeaders.LOCATION, "/api/car"))
                //.andExpect((ResultMatcher)jsonPath("$",hasSize(2)))
                //.andExpect((ResultMatcher) jsonPath("$[0].plateNumber", is(123)))
                //.andExpect((ResultMatcher)jsonPath("$[0].carType", is("VAN")))
                //.andExpect((ResultMatcher)jsonPath("$[1].plateNumber", is(223)))
                //.andExpect((ResultMatcher)jsonPath("$[1].carType", is("CAR"))) ;

    }

    @Test
    @DisplayName("Post test")
    public void testAddCar () throws Exception {

        Car newCar = new Car(123 ,"van");
        Car returnedCar = new Car(123,"van") ;

       Mockito.when(carService.saveCar(newCar)).thenReturn(returnedCar);

       mockMvc.perform(MockMvcRequestBuilders.post("/api/car/add"))
              .andExpect(MockMvcResultMatchers.status().isOk())
               //.content(asJsonString(newCar))
               .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        verify(carService,times(1)).saveCar(any());


    }

    @Test @DisplayName("Get by id")
    public void testGetById () throws Exception{

        //Mockito.when(carService.findById(car.getPlateNumber()).thenReturn(car);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/car/getById/123"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print());
    }













    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
