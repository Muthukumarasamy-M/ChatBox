package box;

import java.io.*;
import java.util.Scanner;

import org.json.simple.*;
import org.json.simple.parser.*;

public class JsonFileHandler {
	private static final Scanner scan = new Scanner(System.in);
	private static final String DISPLAY_FILE = "C:\\Users\\ramki\\eclipse-workspace\\Chat\\display.json";
	private static final String EXPENSE_FILE = "C:\\Users\\ramki\\eclipse-workspace\\Chat\\expense.json";
	private static final String INCOME_FILE = "C:\\Users\\ramki\\eclipse-workspace\\Chat\\income.json";

	public static void display(String string) throws Exception {

		JSONParser par = new JSONParser();
		JSONObject obj = (JSONObject) par.parse(new FileReader(DISPLAY_FILE));
		JSONArray arr = (JSONArray) obj.get(string);
		System.out.println(arr.size());
		if (arr.size() >= 0) {
			for (int i = 0; i < arr.size(); i++) {
				JSONObject jsonObjct = (JSONObject) arr.get(i);
				System.out.println(jsonObjct.get(Integer.toString(i)));

			}
		}
	}

	@SuppressWarnings("unchecked")
	public static void updateExpense() throws Exception {
		try {

			System.out.println("enter the category");
			String category = scan.next();
			System.out.println("enter the amount");
			double amount = scan.nextDouble();
			System.out.println("enter the month");
			String month = scan.next();
			JSONParser parser = new JSONParser();
			JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(EXPENSE_FILE));

			for (Object obj : jsonArray) {
				JSONObject jsonObject = (JSONObject) obj;

				if (jsonObject.get("Month").equals(month)) {
					JSONArray expensesArray = (JSONArray) jsonObject.get("expenses");

					for (Object expenseObj : expensesArray) {
						JSONObject expenseObject = (JSONObject) expenseObj;

						String expenseCategory = (String) expenseObject.get("category");

						if (expenseCategory.equals(category)) {
							double currentAmount = (double) expenseObject.get("amount");
							System.out
									.println("Current amount for " + category + " in " + month + ": ₹" + currentAmount);

							// Update the JSON with the new amount
							expenseObject.put("amount", amount + currentAmount);

							// Save the updated JSON to the file
							try (FileWriter fileWriter = new FileWriter(EXPENSE_FILE)) {
								fileWriter.write(jsonArray.toJSONString());
							}

							System.out.println("Expense updated for " + category + " in " + month + ".");
							return;
						}
					}
					System.out.println("Category '" + category + "' not found for " + month + ".");
					return;
				}
			}

			System.out.println("No matching month found.");
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}

	static void displayExpenses() {
		try {

			String month = scan.next();
			JSONParser parser = new JSONParser();
			JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(EXPENSE_FILE));

			for (Object obj : jsonArray) {
				JSONObject jsonObject = (JSONObject) obj;

				if (jsonObject.get("Month").equals(month)) {
					JSONArray expensesArray = (JSONArray) jsonObject.get("expenses");

					System.out.println("Expenses for " + month + ":");
					for (Object expenseObj : expensesArray) {
						JSONObject expenseObject = (JSONObject) expenseObj;

						String category = (String) expenseObject.get("category");
						double amount = (double) expenseObject.get("amount");

						System.out.println("Category: " + category + ", Amount: ₹" + amount);
					}

					return; // No need to continue searching
				}
			}

			System.out.println("No matching month found.");
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static void updateIncome() throws Exception {

		try {
			System.out.println("enter the category");
			String category = scan.next();
			System.out.println("enter the amount");
			double amount = scan.nextDouble();
			System.out.println("enter the month");
			String month = scan.next();
			JSONParser parser = new JSONParser();
			JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(INCOME_FILE));

			for (Object obj : jsonArray) {
				JSONObject jsonObject = (JSONObject) obj;
				if (jsonObject.get("Month").equals(month)) {
					JSONArray IncomeArray = (JSONArray) jsonObject.get("Income");
					for (Object IncomeObj : IncomeArray) {
						JSONObject IncomeObject = (JSONObject) IncomeObj;

						String IncomeCategory = (String) IncomeObject.get("category");

						if (IncomeCategory.equals(category)) {
							double currentAmount = (double) IncomeObject.get("amount");
							System.out
									.println("Current amount for " + category + " in " + month + ": ₹" + currentAmount);
							IncomeObject.put("amount", amount + currentAmount);

							// Save the updated JSON to the file
							try (FileWriter fileWriter = new FileWriter(INCOME_FILE)) {
								fileWriter.write(jsonArray.toJSONString());
							}

							System.out.println("Income updated for " + category + " in " + month + ".");
							return;
						}
					}
					System.out.println("Category '" + category + "' not found for " + month + ".");
					return;
				}
			}
			System.out.println("No matching month found.");
		} catch (IOException | ParseException e) {
			e.printStackTrace();

		}
	}

	public static void displayIncome() {
		try {
			String month = scan.next();
			JSONParser parser = new JSONParser();
			JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(INCOME_FILE));

			for (Object obj : jsonArray) {
				JSONObject jsonObject = (JSONObject) obj;

				if (jsonObject.get("Month").equals(month)) {
					JSONArray IncomeArray = (JSONArray) jsonObject.get("Income");

					System.out.println("Income for " + month + ":");
					for (Object IncomeObj : IncomeArray) {
						JSONObject IncomeObject = (JSONObject) IncomeObj;

						String category = (String) IncomeObject.get("category");
						double amount = (double) IncomeObject.get("amount");

						System.out.println("Category: " + category + ", Amount: ₹" + amount);
					}

					return; // No need to continue searching
				}
			}

			System.out.println("No matching month found.");
		} catch (IOException | ParseException e) {
			e.printStackTrace();

		}
	}

}