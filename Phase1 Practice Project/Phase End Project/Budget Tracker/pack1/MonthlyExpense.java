package pack1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MonthlyExpense {
    int expense_num=0;
    int expense_amt;
    String category="";
    String description="";
    LocalDate today=LocalDate.now();
	DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
	String Date=today.format(formatter);

    void expense(int expense_num, int expense_amt) {
        this.expense_num = expense_num;
        this.expense_amt = expense_amt;
        expense_category();
    }

    void display() {
        System.out.println("EXPENSE RECORDED SUCCESSFULLY");
    }

    void expense_category() {
        boolean validExpense = false;
        
        switch(expense_num) {
            case 1:
                category = "CLOTHES";
                description = "CLOTHES";
                validExpense = true;
                break;
            case 2:
                category = "ELECTRICITY BILL";
                description = "ELECTRICITY BILL";
                validExpense = true;
                break;
            case 3:
                category = "EXAM FEES";
                description = "EXAM FEES";
                validExpense = true;
                break;
            case 4:
                category = "FOOD";
                description = "FOOD";
                validExpense = true;
                break;
            case 5:
                category = "FUEL";
                description = "FUEL";
                validExpense = true;
                break;
            case 6:
                category = "HOUSE RENT";
                description = "HOUSE RENT";
                validExpense = true;
                break;
            case 7:
                category = "TRAVELLING";
                description = "TRAVELLING";
                validExpense = true;
                break;
            case 8:
                category = "OTHER";
                description = "OTHER";
                validExpense = true;
                break;
            default:
                System.out.println("Enter the right number");
                break;
        }

        if (validExpense) {
            BudgetaryLogs.addLog(Date, category, expense_amt, description);
            display();
        }
    }
}

    