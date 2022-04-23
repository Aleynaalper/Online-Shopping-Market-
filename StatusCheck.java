import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StatusCheck {
	
	static ArrayList<String> valueofproducts= new ArrayList<String>();
	//I created an ArrayList for add the elements in the priceList 

	public static void checking(String[] lines1, String[]lines2) throws ParseException {
		for(int i=0;i<lines1.length;i++) {
			String[] a= lines1[i].split("	");  //I separated the items on the priceList with split
				for(int j=0 ; j < a.length; j++){
					valueofproducts.add(a[j]); //and I added to the ArrayList respectively
			}
		}
	
		for(int i=0;i<lines2.length;i++) {
		String[] a= lines2[i].split("	");//I separated the items on the shoppingList with split
			
			int m= 3 ;  //I created m to control "a"
			int n= 0 ;  //I created n to control "valueofproducts" 
			String l = ""; //I created this variable to print the names once 
			double total = 0.0; //I created total to add the price of the products
			
		while(n<valueofproducts.size()) {
										
			if(m<a.length) {
					
				if(a[m].equals(valueofproducts.get(n))) {
					
						String x =a[2];   //It's the date that person bought the products
						String y=valueofproducts.get(n+2);//The date ranges of that product by line
						String z=valueofproducts.get(n+3);
					
						SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
						Date personaldate = sdf.parse(x);
						Date date1 = sdf.parse(y);  //I used java.util.Date
						Date date2 = sdf.parse(z);
				    
				    if(personaldate.compareTo(date1) >= 0 && personaldate.compareTo(date2) <= 0 && valueofproducts.get(n+1).equals(a[1])) {  
				    	
				    /*For compareTo condition;
				    if value is 0, dates are equal
					if value is greater than 0 , date is after the date argument(date1 or date2)
					if value is less than 0,date is before the date argument */
				    	
				    	
				    	Double productsnumber =Double.valueOf(a[m+1]); 
				    	Double price= Double.valueOf(valueofproducts.get(n+4));
				    	double result=productsnumber * price ;
				    	//I converted to "double" to calculate the price
				    	
				    	if (!(l.equals(a[0]))) {
				    		System.out.println("---"+a[0]+"---");
				    		l = a[0];
				    		/*I actually wrote "else" wherever "if(!)" was,
				    		 but when I wrote "else" in a row,
				    		 I encountered an error, so I had to write this way*/
				    			
				    	} 
				    	System.out.println(a[m]+"	"+price+"	"+a[m+1]+"	"+String.format(java.util.Locale.US,"%.1f",result));
						total+=result;
				    	m+=2; //After checking the product,
				    		  //I added 2 to the number m to go to the next product
				    	n=0;  //I restarted the valueofproducts from the beginning
				    	continue;	
				    	}
				    
				    if(!(personaldate.compareTo(date1) >= 0 && personaldate.compareTo(date2) < 0 && valueofproducts.get(n+1).equals(a[1]))) {
				    	n+=5;    //Since the product is not in the date range,
				    	         //I added 5 to n to move to the next line of the "valueofproducts".
				    	continue;
				    	}
					}
				
				if(!(a[m].equals(valueofproducts.get(n)))) {
					n+=5;       //Since the product is not in same type(gold-silver-bronze),
	    	         			//I added 5 to n to move to the next line of the "valueofproducts".
					continue;
					}
				}
			
			else {
				System.out.println("Total	"+String.format(java.util.Locale.US,"%.1f",total));
				n=0;      //After the check was completed I calculated the total
				break;
				}
			}
		}

	}

}
