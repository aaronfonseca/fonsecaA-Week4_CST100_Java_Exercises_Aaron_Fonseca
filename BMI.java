
/** Program: Exercise 10.02
* File: Exercise_10_02.java
* Summary: Chapter 10, Exercise 02. 
*
*	(The BMI class) Add the following new constructor in the BMI class:
*   Construct a BMI with the specified name, age, weight, feet, and inches
*
* Author: Aaron Fonseca
* Date: July 17, 2016
**/

public class BMI {
  private String name;
  private int age;
  private double weight; // in pounds
  private double height; // in inches
  private double feet;
  private double inches;
  public static final double KILOGRAMS_PER_POUND = 0.45359237; 
  public static final double METERS_PER_INCH = 0.0254;  
  
  public BMI(String name, int age, double weight, double height) {
    this.name = name;
    this.age = age;
    this.weight = weight;
    this.height = height;
  }
  
  public BMI(String name, double weight, double height) {
    this(name, 20, weight, height);
  }

  // Construct a BMI with the specified name, age, weight, feet, and inches
  public BMI(String name, int age, double weight, double feet, double inches){
    this.name = name;
    this.age = age;
    this.weight = weight;
    this.feet = feet;
    this.inches = inches;
    this.height = (feet * 12) + inches;
  }
  
  public double getBMI() {
    double bmi = weight * KILOGRAMS_PER_POUND / 
      ((height * METERS_PER_INCH) * (height * METERS_PER_INCH));
    return Math.round(bmi * 100) / 100.0;
  }
  
  public String getStatus() {
    double bmi = getBMI();
    if (bmi < 18.5)
      return "Underweight";
    else if (bmi < 25)
      return "Normal";
    else if (bmi < 30)
      return "Overweight";
    else
      return "Obese";
  }
  
  public String getName() {
    return name;
  }
  
  public int getAge() {
    return age;
  }
  
  public double getWeight() {
    return weight;
  }
  
  public double getHeight() {
    return height;
  }

   public double getInches() {
        return inches;
    }

	public void setInches(double inches) {
	    this.inches = inches;
	}
	
	public double getFeet() {
	    return feet;
	}
	
	public void setFeet(double feet) {
	    this.feet = feet;
	}
}
