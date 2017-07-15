/*
Uses different classes to describe a car.
© 2015 MICHELLE BLUM ALL RIGHTS RESERVED
 */

public class Car {

private int yearModel = 2015, speed = 0;
private String make = "Corvette";

//constructor
public Car(int ym, String m)
{
	yearModel = ym;
	make = m;
}
//returns the car's year
public int getYear()
{
	return yearModel;
}
//returns car's make
public String getMake()
{
	return make;
}
//return the car's current speed
public int getSpeed()
{
	return speed;
}
//adds five to current speed
public void accelerate()
{
    if (speed != 100)
    	speed = speed+5;
}
public void brake()
{
	if (speed != 0)
		speed = speed-5;
}
}
