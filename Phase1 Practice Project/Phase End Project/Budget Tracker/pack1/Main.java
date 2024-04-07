package pack1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


class Login
{
	private String username="admin";
	private String password;
	private static final String PASSWORD_FILE="password.txt";
	
	public Login() throws IOException
	{
		this.password=readPasswordFromFile();
	}
	boolean loginaccess(String username,String password)
	{
		if(this.username.equals(username) && this.password.equals(password))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) throws IOException {
		this.password = password;
		writePasswordToFile(password);
	}
	
	private String readPasswordFromFile() throws IOException {
        File file = new File(PASSWORD_FILE);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                return reader.readLine();
            }
        }
        // Default password if file not found
        return "admin123";
    }

    private void writePasswordToFile(String newPassword) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PASSWORD_FILE))) {
            writer.write(newPassword);
        }
    }
	
}

public class Main {
	public static void main(String[] args) throws IOException
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("+-------------------------------------+");
		System.out.println("|     WELCOME TO BUDGET TRACKER APP   |");
		System.out.println("+-------------------------------------+");
		
		System.out.println("PLEASE LOGIN TO CONTINUE -");
		System.out.print("USERNAME- ");
		String username=sc.next();
		System.out.print("PASSWORD- ");
		String password=sc.next();
		Login l=new Login();
		boolean a=l.loginaccess(username,password);
		if(a==true)
		{
		    System.out.println("1. SET MONTHLY BUDGET");
		    System.out.println("2. RECORD AN EXPENSE");
		    System.out.println("3. BUDGETARY LOGS");
		    System.out.println("4. CHANGE PASSWORD");
		    System.out.println("5. EXIT");
		    int i=sc.nextInt();
			switch(i)
			{
			case 1:
				System.out.print("ENTER THE MONTHLY BUDGET AMOUNT FOR EVERY MONTH -");
				int mb=sc.nextInt();
				MonthlyBudget m=new MonthlyBudget();
				m.budget(mb);
				break;
			case 2:
				System.out.println("CHOOSE THE EXPENSE CATEGORY -");
				System.out.println("1. CLOTHES");
				System.out.println("2. ELECTRICITY BILL");
				System.out.println("3. EXAM FEES");
				System.out.println("4. FOOD");
				System.out.println("5. FUEL");
				System.out.println("6. HOUSE RENT");
				System.out.println("7. TRAVELLING");
				System.out.println("8. OTHER");
				int expense_num=sc.nextInt();
				System.out.print("ENTER EXPENSE AMOUNT -");
				int expense_amt=sc.nextInt();
				System.out.print("ENTER YOUR PASSWORD -");
				String pass=sc.next();
				MonthlyExpense me=new MonthlyExpense();
				if(l.getPassword().equals(pass))
				{
					me.expense(expense_num,expense_amt);
				}
				else
				{
					System.out.println("Wrong Password");
				}
				
				
				break;
			case 3:
				System.out.println("1. DATE-WISE LOG");
				System.out.println("2. MONTH-WISE LOG");
				System.out.println("3. TOTAL BUDGET");
				System.out.println("4. DELETE BUDGETARY LOG");
				System.out.print("SELECT THE BUDGET LOG YOU WANT TO DISPLAY -");
				int budget_log_num=sc.nextInt();
				new BudgetaryLogs(budget_log_num);
				break;
			case 4:
				System.out.print("ENTER THE OLD PASSWORD - ");
				String oldpass=sc.next();
				if(l.getPassword().equals(oldpass))
				{
				    System.out.print("ENTER THE NEW PASSWORD - ");
				    String newpass=sc.next();
				    l.setPassword(newpass);
				    System.out.println("YOUR PASSWORD HAS BEEN CHANGED SUCCESSFULLY.");
				}
				else
				{
					System.out.println("Wrong Password");
				}
				break;
			case 5:
				System.out.println("THANK YOU");
				break;
			default:
				System.out.println("Enter the right number");
				
			}
			
		}
		else
		{
			System.out.println("Wrong Password");
		}
		sc.close();
	}

}
