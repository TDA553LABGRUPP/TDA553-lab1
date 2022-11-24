package labb1;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import java.awt.*;

public class CarTest {
    @Test
    public void saab_is_subtype_of_car(){
        Saab95 saab = new Saab95(Color.red, 2, 3, 1, 1);

        assert(saab instanceof Car);
    }

    @Test
    public void volvo_is_subtype_of_car(){
        Volvo240 volvo = new Volvo240(Color.red, 2, 3, 1, 1);

        assert(volvo instanceof Car);
    }

    @Test
    public void car_types_are_subs_of_movable(){
        Volvo240 volvo = new Volvo240(Color.red, 2, 3, 1, 1);

        assert(volvo instanceof Movable);
    }



    @Test
    public void saab95_has_two_doors(){
        
        
        Saab95 saab = new Saab95(Color.red, 2, 3, 1, 1);

        assertEquals(2, saab.vehicle.getNrDoors());
    }
    
    @Test
    public void saab95_has_125_engine(){
        
        
        Saab95 saab = new Saab95(Color.red, 2, 3, 1, 1);

        assertEquals(125, saab.getEnginePower(), 0);
    }

    @Test
    public void saab95_gasing_increases_speed_by_amount_times_direction_times_speedFactor(){
        
        
        Saab95 saab = new Saab95(Color.red, 2, 3, 1, 1);

        saab.gas(0.1);

        assertEquals( 0.1*saab.speedFactor(), saab.getCurrentSpeedX(), 0); assertEquals(0.1*saab.speedFactor(), saab.getCurrentSpeedY(), 0); 

    }

    @Test
    public void car_moves_when_moving(){
        
        
        Saab95 saab = new Saab95(Color.red, 2, 3, 1, 1);

        saab.gas(0.1);

        double prevX = saab.getX();
        double prevY = saab.getY();

        saab.move();

        assert(saab.getX()> prevX && saab.getY()> prevY);
    }

    @Test
    public void car_speed_doesnt_get_negative_when_breaking(){
        
        
        Saab95 saab = new Saab95(Color.red, 2, 3, 1, 1);

        saab.brake(saab.getCurrentSpeedX() +0.5);

        assertTrue(saab.getCurrentSpeedX()>=0); assert(saab.getCurrentSpeedY() >= 0);
    }

     @Test
     public void car_that_turns_left_moves_less_in_the_x_direction_than_car_that_stays_straight(){
        
        
        Saab95 saabToBeTurned = new Saab95(Color.red, 2, 3, 0, 0);
        Saab95 saabStayingStraight = new Saab95(Color.red, 2, 3, 0, 0);

        saabToBeTurned.turnLeft();
        saabToBeTurned.gas(0.4);
        saabToBeTurned.move();

        saabStayingStraight.gas(0.4);
        saabStayingStraight.move();

        assert(saabToBeTurned.getX() < saabStayingStraight.getX());

     }

     @Test
     public void car_that_turns_right_moves_more_in_the_x_direction_than_car_that_stays_straight(){
        
        
        Saab95 saabToBeTurned = new Saab95(Color.red, 2, 3, 0, 0);
        Saab95 saabStayingStraight = new Saab95(Color.red, 2, 3, 0, 0);

        saabToBeTurned.turnRight();
        saabToBeTurned.gas( 0.1);
        saabToBeTurned.move();

        saabStayingStraight.gas(0.1);
        saabStayingStraight.move();
      
        assert(saabToBeTurned.getX() > saabStayingStraight.getX());
     }

     @Test
     public void saab_is_faster_than_volvo_when_turbo(){
        Saab95 saab = new Saab95(Color.red, 1, 1, 1, 1);
        Volvo240 volvo = new Volvo240(Color.blue, 1, 1, 1, 1);

        saab.setTurboOn();
        saab.gas(0.1);
        volvo.gas(0.1);
        volvo.move();
        saab.move();

        assert(volvo.getX() < saab.getX() && volvo.getY() < saab.getY());
     }

     @Test
     public void gas_should_only_accept_values_from_0_to_1_as_argument_and_throw_error_if_below_that(){
        Saab95 saab = new Saab95(Color.red, 1, 1, 1, 1);
        Volvo240 volvo = new Volvo240(Color.blue, 1, 1, 1, 1);

        assertThrows(IllegalArgumentException.class, () -> {saab.gas(-1);});
        assertThrows(IllegalArgumentException.class, () -> {volvo.gas(-1);});
     }

     @Test
     public void gas_should_only_accept_values_from_0_to_1_as_argument_and_throw_error_if_above_that(){
        Saab95 saab = new Saab95(Color.red, 1, 1, 1, 1);
        Volvo240 volvo = new Volvo240(Color.blue, 1, 1, 1, 1);

        assertThrows(IllegalArgumentException.class, () -> {saab.gas(2);});
        assertThrows(IllegalArgumentException.class, () -> {volvo.gas(2);});
     }

     @Test
     public void brake_should_only_accept_values_from_0_to_1_as_argument_and_throw_error_if_below_that(){
        Saab95 saab = new Saab95(Color.red, 1, 1, 1, 1);
        Volvo240 volvo = new Volvo240(Color.blue, 1, 1, 1, 1);

        assertThrows(IllegalArgumentException.class, () -> {saab.brake(-1);});
        assertThrows(IllegalArgumentException.class, () -> {volvo.brake(-1);});
     }

     @Test
     public void brake_should_only_accept_values_from_0_to_1_as_argument_and_throw_error_if_above_that(){
        Saab95 saab = new Saab95(Color.red, 1, 1, 1, 1);
        Volvo240 volvo = new Volvo240(Color.blue, 1, 1, 1, 1);

        assertThrows(IllegalArgumentException.class, () -> {saab.brake(2);});
        assertThrows(IllegalArgumentException.class, () -> {volvo.brake(2);});
     }
 
     @Test
     public void calling_the_gas_method_results_in_the_speed_increasing(){
        Saab95 saab = new Saab95(Color.red, 1, 1, 1, 1);
        double speedBeforeX = saab.getCurrentSpeedX();
        double speedBeforeY = saab.getCurrentSpeedY();
        saab.gas(0.9);
        

        double speedAfterX = saab.getCurrentSpeedX();
        double speedAfterY = saab.getCurrentSpeedY();

        assertTrue(speedAfterX > speedBeforeX); assertTrue(speedAfterY > speedBeforeY);

     }

     @Test
     public void calling_the_brake_method_results_in_the_speed_decreasing(){
        Saab95 saab = new Saab95(Color.red, 1, 1, 1, 1);
        saab.gas(0.5);
        double speedBeforeX = saab.getCurrentSpeedX();
        double speedBeforeY = saab.getCurrentSpeedY();
        saab.brake(0.1);

      
        double speedAfterX = saab.getCurrentSpeedX();
        double speedAfterY = saab.getCurrentSpeedY();

        assertTrue(speedAfterX < speedBeforeX); assertTrue(speedAfterY < speedBeforeY);

     }

     @Test
     public void when_the_speed_is_zero_and_braking_the_speed_remains_zero(){
       Saab95 saab = new Saab95(Color.red, 1, 1, 1, 1);
       saab.brake(0.9);
       assertTrue(saab.getCurrentSpeedX() == 0 && saab.getCurrentSpeedY() == 0);
     }

     @Test
     public void saab_doesnt_exceed_max_speed_engine_power(){
       Saab95 saab = new Saab95(Color.red, 1, 1, 1, 1);
       for(int i = 0; i < 100; i++){
       saab.gas(0.9);
       }
       assertTrue(saab.getCurrentSpeedX() <= saab.enginePower && saab.getCurrentSpeedY() <= saab.enginePower);
     }


     @Test
     public void volvo_doesnt_exceed_max_speed_engine_power(){
       Volvo240 volvo = new Volvo240(Color.blue, 1, 1, 1, 1);
       for(int i = 0; i < 100; i++){
         volvo.gas(0.9);
         }

       assertTrue(volvo.getCurrentSpeedX() <= volvo.enginePower && volvo.getCurrentSpeedY() <= volvo.enginePower);
     }
}



