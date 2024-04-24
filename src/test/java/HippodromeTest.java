import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class HippodromeTest {
    @Test
    public void NullException() {
        IllegalArgumentException e =assertThrows(IllegalArgumentException.class,()->new Hippodrome(null));
        assertEquals("Horses cannot be null.",e.getMessage());
    }
    @Test
    public void NullListException() {
        IllegalArgumentException e =assertThrows(IllegalArgumentException.class,()->new Hippodrome(new ArrayList<>()));
        assertEquals("Horses cannot be empty.",e.getMessage());
    }
    @Test
    public void getHorse(){
        ArrayList<Horse> horses = new ArrayList<>();
        for (int i = 0; i <10; i++) {
            horses.add(new Horse(""+i,i,i));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        assertEquals(horses,hippodrome.getHorses());
    }
    @Test
    public void move(){
        ArrayList<Horse> horses = new ArrayList<>();
        for (int i = 0; i <50; i++) {
            horses.add(mock(Horse.class));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        hippodrome.move();

        for(Horse horse : horses){
            verify(horse).move();
        }
    }
    @Test
    public void getWinner(){
        Horse horse = new Horse("Horse",1,1);
        Horse horse2 = new Horse("Horse2",2,1);
        Horse horse3 = new Horse("Horse3",3,1);
        Horse horse4 = new Horse("Horse4",4,11);
        Hippodrome hippodrome = new Hippodrome(List.of(horse,horse2,horse3,horse4));

        assertSame(horse4, hippodrome.getWinner());
    }

}
