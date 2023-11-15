package box;

import java.util.*;
public class ExpenseManager {
	
	static Stack<String> stack = new Stack<>();
	public static final Scanner scan = new Scanner(System.in);
    public static void main(String []args) throws Exception{
    	
    	start();
  	  	
     }

	private static void start() throws Exception{
		
		int select ;
		introduction();
		stack.push("press");
		
		JsonFileHandler.display("press");
		exit();
		do {
			
			Scanner scan = new Scanner(System.in);
			System.out.println();
			System.out.print("Enter your Option :");
			select = scan.nextInt();
			if(select ==9)
			{
				stack.pop();
				if(stack.isEmpty())
					break;
			}
			else if(select ==0)
				break;
			else
				stack.push(stack.peek()+"_"+select);
			String string =stack.peek();
			JsonFileHandler.display(string);
			switch(string)
			{
				case "press_1_1":
					JsonFileHandler.updateExpense();
					break;
				case "press_1_2":
					JsonFileHandler.updateIncome();
					break;
				case "press_2_1":
					JsonFileHandler.displayExpenses();
					break;
				case "press_2_2":
					JsonFileHandler.displayIncome();
					break;
				
			}
			exit();
		}while(select !=0);
		
		System.out.println("exited");
		
	}
public static void exit()
{
	System.out.println("press -> 9   to  back or 0 to exit");
}



	private static void introduction() {
		System.out.println(" *   **   **   **   **   **   **   **   **   **   **   **   **   **   **   *");
		System.out.println("I am Expense tracker!,i can help you to easily record your daily spendings \n");
		
	}
    
}

