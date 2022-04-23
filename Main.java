import java.text.ParseException;

public class Main {
	
	public static void main (String[] args) throws ParseException {
		
		String[] lines1= ReadFromFiles.readFile(args[1]); //I created a array for priceList
		String[] lines2=ReadFromFiles.readFile(args[0]); //I created a array for shoppingList
		
		StatusCheck.checking(lines1, lines2); //I called the method for output screen

			}	
	}
