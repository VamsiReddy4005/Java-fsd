package pack1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class BudgetaryLogs {
    static int count_id = 0;
    String Date;
    String category;
    int amount;
    String description;
    int bln;
    private final String BUDGET_FILE = "budget.txt";
    static List<BudgetaryLogs> logs = new ArrayList<>();
    static final String LOGS_FILE = "budgetary_logs.txt";
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    
    // Calculate the total width including spaces between columns
    int totalWidth = (15 * 2) + (20*2)+(4 * 1)+10; //columns each 10,15,20 wide, plus 4 spaces between them
	String dashes = "-".repeat(totalWidth); // Repeat '-' to match the total width


    // Private constructor for internal use
    private BudgetaryLogs(String Date, String category, int amount, String description) {
        this.Date = Date;
        this.category = category;
        this.amount = amount;
        this.description = description;
    }
    public BudgetaryLogs(int bln) throws IOException
	{
		this.bln=bln;
		budget_log_display(bln);
	}


    // Public static method to add a log
    public static void addLog(String Date, String category, int amount, String description) {
        BudgetaryLogs log = new BudgetaryLogs(Date, category, amount, description);
        logs.add(log);
        appendLogToFile(log);
    }

    // Append a log entry to the file
    private static void appendLogToFile(BudgetaryLogs log) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(LOGS_FILE, true))) {
            bw.write(log.Date + "," + log.category + "," + log.amount + "," + log.description);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Error writing log to file: " + e.getMessage());
        }
    }

    // Load existing logs from the file
    public static void loadLogsFromFile() {
        File file = new File(LOGS_FILE);
        if (!file.exists()) return; // No file to load

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    logs.add(new BudgetaryLogs(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading logs from file: " + e.getMessage());
        }
    }

    
    void budget_log_display(int bln) throws IOException
	{
		this.bln=bln;
		if(bln==1)
		{
			datewiselog();
		}
		else if(bln==2)
		{
			monthwiselog();
		}
		else if(bln==3)
		{
			total_budget();
		}
		else if(bln==4)
		{
			delete_log();
		}
		else
		{
			System.out.println("Enter Right Number");
		}
	}

    
    
 // Directly reading from file for date-wise logs
    public void datewiselog()throws IOException {
        System.out.println("ENTER THE DATE IN DD-MM-YYYY FORMAT FOR WHICH YOU WANT TO DISPLAY THE BUDGETARY LOGS -");
        String userGivenDate = sc.next();
        printHeader();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(LOGS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4 && parts[0].equals(userGivenDate)) {
                    System.out.format("%10s %15s %20s %15s %20s\n",++count_id, parts[0], parts[1], parts[2], parts[3]);
                }
            }
            System.out.println(dashes);
        }
    }

    // Directly reading from file for month-wise logs
    public void monthwiselog() throws IOException {
        System.out.println("ENTER THE MONTH NUMBER BETWEEN 1 TO 12 FOR WHICH YOU WANT TO DISPLAY THE BUDGETARY LOGS -");
        int userGivenMonth = sc.nextInt();
        printHeader();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(LOGS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                LocalDate logDate = LocalDate.parse(parts[0], formatter);
                if (logDate.getMonthValue() == userGivenMonth) {
                    System.out.format("%10s %15s %20s %15s %20s\n", ++count_id, parts[0], parts[1], parts[2], parts[3]);
                }
            }
            System.out.println(dashes);
        }
    }
    
    public void total_budget() throws IOException {
    	LocalDate currentDate = LocalDate.now();
        String currentMonth = currentDate.format(DateTimeFormatter.ofPattern("MM"));
        String currentYear = currentDate.format(DateTimeFormatter.ofPattern("yyyy"));

        int total = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(LOGS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    // Extract month and year from the log's date
                    String[] dateParts = parts[0].split("-");
                    String logMonth = dateParts[1];
                    String logYear = dateParts[2];

                    // Check if the log's month and year match the current month and year
                    if (logMonth.equals(currentMonth) && logYear.equals(currentYear)) {
                        total += Integer.parseInt(parts[2]); // Sum amounts for the current month
                    }
                }
            }
        } 
        try {
        File file = new File(BUDGET_FILE);
        if (file.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String value = br.readLine();
            int monthly_budget = Integer.parseInt(value.trim());
            printHeader1(monthly_budget,total,monthly_budget-total);
            br.close();
            }
        }
        catch(IOException e)
        {
        	System.err.println("An error occurred while reading the budget file.");
        }
    }

    // Delete log by month directly in file
    public void delete_log() throws IOException {
        System.out.print("ENTER THE MONTH NUMBER BETWEEN 1 to 12 FOR DELETETING THE LOG -");
        int month_delete = sc.nextInt();
        
        Month month = Month.of(month_delete);
        String fullName = month.getDisplayName(TextStyle.FULL, Locale.getDefault());
        
        File tempFile = new File(LOGS_FILE + ".tmp");
        try (BufferedReader reader = new BufferedReader(new FileReader(LOGS_FILE));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
             
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                LocalDate logDate = LocalDate.parse(parts[0], formatter);
                if (logDate.getMonthValue()!=month_delete) { 
                    writer.write(line);
                    writer.newLine();
                } else {
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No logs found for the given date to delete.");
            } else {
                System.out.println("BUDGETARY LOG FOR MONTH " +fullName.toUpperCase()+"("+month_delete+")"+" HAS BEEN DELETED SUCCESSFULLY.");
            }
        }

        // Replace original file with updated temp file
        File originalFile = new File(LOGS_FILE);
        if (originalFile.delete()) {
            tempFile.renameTo(originalFile);
        } else {
            System.out.println("Could not delete the original file. Deletion may not be complete.");
        }
    }
    

	void printHeader()
	{
		
		
		System.out.println(dashes);
		System.out.format("%10s %15s %20s %15s %20s\n", "ID", "DATE", "CATEGORY", "AMOUNT", "DESCRIPTION");
		System.out.println(dashes);
	}

	void printHeader1(int monthly_budget,int spending,int current_budget)
	{
		// Header and footer lines
        String line = "+---------------------------------+";
        
        System.out.println(line);
        System.out.printf("| MONTHLY BUDGET  : %10d    |\n", monthly_budget);
        System.out.printf("| CURRENT BUDGET  : %10d    |\n", current_budget);
        System.out.printf("| TOTAL SPENDING  : %10d    |\n", spending);
        System.out.println(line);
	}
}

