import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import static org.mockito.Mockito.mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;


class HorseTest {
    @Test
    public void NullExT1() {
        assertThrows(IllegalArgumentException.class,()->new Horse(null,1,3));
    }
    @Test
    public void NullMessageExT2() {
        try{
            new Horse(null,1,3);
        }catch (IllegalArgumentException e){
            assertEquals("Name cannot be null.",e.getMessage());
        }
    }
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t"})
    public void blankExT3(String name) {
        assertThrows(IllegalArgumentException.class,()->new Horse(name,1,3));
    }
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t"})
    public void blankExT4(String name) {
        try{
            new Horse(name,1,3);
        }catch (IllegalArgumentException e){
            assertEquals("Name cannot be blank.",e.getMessage());
        }
    }
    @Test
    public void negativeSpeedExceptionT5() {
        assertThrows(IllegalArgumentException.class,()->new Horse("Max",-1,3));
    }
    @Test
    public void negativeSpeedExceptionMessageT6() {
        try{
            new Horse("Max",-1,3);
        }catch (IllegalArgumentException e){
            assertEquals("Speed cannot be negative.",e.getMessage());
        }
    }
    @Test
    public void negativeDistanceExceptionT7() {
        assertThrows(IllegalArgumentException.class,()->new Horse("Max",1,-3));
    }
    @Test
    public void negativeDistanceExceptionT8() {
        try{
            new Horse("Max",2,-3);
        }catch (IllegalArgumentException e){
            assertEquals("Distance cannot be negative.",e.getMessage());
        }
    }
    @Test
    public void getNameT9(){
        Horse horse = new Horse("Jerry",1,3);
        assertEquals("Jerry",horse.getName());
    }
    @Test
    public void getSpeedT10(){
        Horse horse = new Horse("Jerry",1,3);
        assertEquals(1,horse.getSpeed());
    }
    @Test
    public void getDistanceT11(){
        Horse horse = new Horse("Jerry",1,3);
        assertEquals(3,horse.getDistance());
    }
    @Test
    public void zeroDistanceBasicT12(){
        Horse horse = new Horse("Jerry",1);
        assertEquals(0,horse.getDistance());
    }
    @Test
    public void moveT13(){
        try (MockedStatic<Horse> mockedStatic = mockStatic(Horse.class)){
            new Horse("Jerry",1,3).move();
            mockedStatic.verify(()->Horse.getRandomDouble(0.2,0.9));
        }
    }
    @ParameterizedTest
    @ValueSource(doubles = {0.1, 0.2,0.3,0.4,})
    public void moveRandomT14(double random) {
        try (MockedStatic<Horse> mockedStatic = mockStatic(Horse.class)){
            Horse horse = new Horse("Jerry",1,3);
            int i = (int) ((int) horse.getSpeed()+horse.getDistance());
            mockedStatic.when(()->Horse.getRandomDouble(0.2,0.9)).thenReturn(random);
            horse.move();
            assertEquals(3+1*random,horse.getDistance());

        }
    }

    








}