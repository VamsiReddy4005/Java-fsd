import java.util.ArrayList; 

public class validEmail { 
    public static void main(String[] args) { 
        ArrayList<String> emailID = new ArrayList<String>(); 
        emailID.add("jack24@gmail.com"); 
        emailID.add("john25@gmail.com"); 
        emailID.add("74y34reh@gmx.com"); 
        emailID.add("y38e65e@gmx.com"); 
        emailID.add("834ueidjdhj@gmx.com"); 
        emailID.add("12fhd@gmx.com"); 
        emailID.add("john@gmx.com"); 
        
        String searchElement = "john@gmx.com"; 
        
        for(int i=0; i<emailID.size(); i++) { 
            if(searchElement.equals(emailID.get(i))) { 
                System.out.println("\n"); 
                System.out.println("email ID " + searchElement + " found at position "+i); 
                break; 
            } 
        } 
    } 
} 
