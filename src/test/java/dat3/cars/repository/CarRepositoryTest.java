package dat3.cars.repository;

import dat3.cars.entity.Car;
import dat3.cars.entity.Member;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CarRepositoryTest {

    @Autowired
    CarRepository CarRepository;

    static int car1;
    static int car2;
    @BeforeAll
    public static void setUpData(@Autowired CarRepository carRepository){
        Car c1 = new Car ( "wv", "turbo", 12, 21);
        Car c2 = new Car ( "vw", "torbu2", 3214, 124);

        carRepository.save(c1);
        carRepository.save(c2);
        car1 = c1.getId();
        car2 = c2.getId();

    }

    @Test
    public void testFindById(){
        Car found = CarRepository.findById(car1).get();
        assertEquals(car1, found.getId());
        assertEquals("wv", found.getBrand());

    }

    @Test
    public void testCarByEmail(){
        Car found = CarRepository.findCarByModel("torbu2");
        assertEquals(car2, found.getId());
    }


}