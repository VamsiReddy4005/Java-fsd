package pack1;

import java.util.Scanner;
import java.io.*;


public class MonthlyBudget {
    private Scanner sc = new Scanner(System.in);
    private int mb = 0;
    public int getMb() {
		return mb;
	}

	public void setMb(int mb) {
		this.mb = mb;
	}

	private final String BUDGET_FILE = "budget.txt";


	public MonthlyBudget() {
        readBudgetFromFile();
    }

    private void readBudgetFromFile() {
        try {
            File file = new File(BUDGET_FILE);
            if (file.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String value = br.readLine();
                if (value != null && !value.trim().isEmpty()) {
                    this.mb = Integer.parseInt(value.trim());
                    
                }
                br.close();
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the budget file.");
        } catch (NumberFormatException e) {
            System.err.println("Invalid number in budget file.");
        }
    }

    private void saveBudgetToFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(BUDGET_FILE));
            bw.write(Integer.toString(this.mb));
            bw.close();
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the budget file.");
        }
    }

    public void budget(int mb) {
        if (this.mb == 0) {
            this.mb = mb;
            saveBudgetToFile();
            System.out.println("YOUR MONTHLY BUDGET HAS BEEN UPDATED SUCCESSFULLY");
        } else {
            System.out.print("MONTHLY BUDGET IS ALREADY SET, DO YOU WANT TO UPDATE IT? (Y:YES | N:NO)");
            char ch = sc.next().charAt(0);
            if (ch == 'Y' || ch == 'y') {
                this.mb = mb;
                saveBudgetToFile();
                System.out.println("YOUR MONTHLY BUDGET HAS BEEN UPDATED SUCCESSFULLY");
            } else if (ch == 'N' || ch == 'n') {
                System.out.println("Budget update canceled. Your monthly budget remains unchanged.");
            }
        }
    }
}
