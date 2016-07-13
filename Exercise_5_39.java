
public class Exercise_5_39 {

	public static void main(String[] args) {
		
	     	double commission = 0;
	        double salesAmount = 0;
	        
	        do{
	            salesAmount += 0.01;

	            if (salesAmount >= 10000.01) 
	            {
	                commission = 900.0 + (salesAmount - 10000.0) * 0.12;
	            } else if (salesAmount >= 5000.01) 
	            {
	                commission = 400.0 + (salesAmount - 5000.0) * 0.10;
	            } else 
	            {
	                commission = salesAmount * 0.08;
	            }
	            // don't forget $5000 base pay
	        } while (commission < 25000.0);

	        System.out.println("You need $" + (int)(salesAmount * 100.0) / 100.0 +
	                " in sales to make a commission of $25000");
	    }

	}
