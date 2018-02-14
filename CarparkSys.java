
package carparksys;
import java.util.Scanner;
import java.io.*;
import javax.swing.*;
import java.util.*;
import java.text.*;


public class CarparkSys {
    
        private static String add;
        private static String back;
        private static final Scanner input = new Scanner(System.in);
        

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
              
                String username;
                String password;
                
                System.out.println(" --- WELCOME TO APU CAR PARK SYSTEM --- ");
                System.out.println("Please enter your username below: ");
                        username = input.nextLine();
                System.out.println("Please enter user password below: ");
                        password = input.nextLine();
                       
                if(username.equals("admin") && password.equals("admin123"))
                {
                    System.out.println("Login successful!");
                    startSys.setText("Enter to launch System.");
                }
                else
                {
			System.out.println("Invalid username or password, please try again.");
                        System.out.println(" ");
                        
                     CarparkSys.main(args);
                } 
                
             
    }
    
        private static class startSys {
        private static String[]args;
        private static void setText(String back) throws IOException {
            
            String mainmenu;
           
             
             System.out.println(" ");
             System.out.println("*** MAIN MENU ***");
             System.out.println("Choose one of the options below: ");
             System.out.println("1 . Register Student");
             System.out.println("2 . Update Record");
             System.out.println("3 . Delete Record");
             System.out.println("4 . Create Report");
             System.out.println("5 . Logout");
             System.out.println("6 . Exit");
             System.out.println(" ");
             
             mainmenu = input.nextLine();
             
             switch (mainmenu) {
                case "1":
                    register.setText("registr");
                    break;
                case "2":
                    update.setText("updat");
                    break;
                case "3":
                    delete.setText("delet");
                    break;
                case "4":
                    report.setText("repot");
                    break;
                case "5": 
                    CarparkSys.main(args);
                    break;
                case "6":
                    System.out.println("You have exitted the System, have a nice day.");
                    break;
                default:  
                	System.out.println("please select one of the above options.");
                        System.out.println("");
                                startSys.setText(back);
                     break;
             }
        }
     }
        
   
        
             
        private static class register {
        
        private static void setText(String registr) throws IOException{
            
            System.out.println("To register a student, select 1. Select 2 to return to main menu.");
            System.out.println("1. register new student");
            System.out.println("2. back");
            
            String main = input.nextLine();
            
            switch (main){
                case "1":
                    registerNew.newfile(add);
                    break;
                case "2":
                    startSys.setText(back);
                    break;
                default:
                    System.out.println("Invalid input, select one of the options below.");
                    System.out.println("");
                    
                    register.setText(registr);
                    break;
                    
            }
        } 
     }

        private static class registerNew {
            
            private static String registr,today, expiry;
        
        private static void newfile(String add) throws IOException {
            
       String expiry,today;

      Date dateNow = new Date();
      SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
      Calendar calen = Calendar.getInstance();
      dateNow = calen.getTime();
      today = ft.format(dateNow);
      calen.add(Calendar.MONTH, 3);
      Date expDate = calen.getTime();
      expiry = ft.format(expDate);
            
        String stud_id, first_name, last_name, tel_no, email, plate_no, lot_no;
        
        lot_no = JOptionPane.showInputDialog("Enter a Lot NUmber between 1 and 45:");
        first_name = JOptionPane.showInputDialog("First Name:");
        last_name = JOptionPane.showInputDialog("Last name:");
        stud_id = JOptionPane.showInputDialog("Student ID:");
        tel_no = JOptionPane.showInputDialog("Phone Number:");
	email = JOptionPane.showInputDialog("Email Address:");
	plate_no = JOptionPane.showInputDialog("Car Registation Number:");
      
            BufferedWriter StudentFile;
              
            try{
                
                File file = new File("/home/mwendwa/Desktop/Java/" +lot_no +".txt");
                file.createNewFile();
                
                StudentFile =  new BufferedWriter(new FileWriter(file));
                
                StudentFile.write("Lot Number  : " + lot_no); 
                StudentFile.newLine();
                StudentFile.write("Student ID : " + stud_id);
                StudentFile.newLine();
                StudentFile.write("Full name : " + first_name +" "+last_name);
                StudentFile.newLine();
                StudentFile.write("Contact Number : " + tel_no);
                StudentFile.newLine();
                StudentFile.write("E-mail Address : " + email);
                StudentFile.newLine();
                StudentFile.write("Car Plate Number : " + plate_no);
                StudentFile.newLine();
                StudentFile.write("Registration Date : " + today);
                StudentFile.newLine();
                StudentFile.write("Expiry Date : " + expiry);
                
            
                StudentFile.close();
                
                System.out.println("The file has been saved as " + lot_no + " .txt");
            }
	        
		
            catch (IOException e) {
		}
         
            register.setText(registr);
         }   
    }
              
        private static class update {
        
        private static void setText(String updat) throws IOException{
            
            System.out.println("To update a record, select 1. Select 2 to return to main menu.");
            System.out.println("1 . Update Student Record");
            System.out.println("2 . Back");
            System.out.println(" ");
           
            String main = input.nextLine();
            
            switch (main){
                case "1": 
                    registerNew.newfile(add);
                    break;
                    
                case "2":
                    startSys.setText(back);
                    break;
                    
                default:
                    System.out.println("Invalid input, select one of the options below.");
                    System.out.println("");
                    
                    update.setText(updat);
                    break;
            }
        }
    }

        private static class report {
        
        private static String slots;
        
        private static void setText(String repot) throws IOException{
            
                System.out.println("");
    		System.out.println("--The Record Module --");
    		System.out.println("1 . View Occupied Car Slots");
                System.out.println("2 . View Available Slot Details");
                System.out.println("3 . Back");
                System.out.println(" ");
          
             String repping;
             repping = input.nextLine();
             
             switch (repping){
             case "1" :

            		String path = "/home/mwendwa/Desktop/Java/"; 
            	 
            	  String files;
            	  File folder = new File(path);
            	  File[] listOfFiles = folder.listFiles(); 
            	 
            	  for (int i = 0; i < listOfFiles.length; i++) 
            	  {
            	 
            	   if (listOfFiles[i].isFile()) 
            	   {
            	   files = listOfFiles[i].getName();
            	       if (files.endsWith(".txt") || files.endsWith(".TXT"))
            	       {
            	          System.out.println(files);
            	        }
            	     }
            	  }
            		
                 report.setText(repot);
            	 break;
             case "2" : 
            	 slot.setText(slots);
            	 break;
             case "3" :
            	 startSys.setText(back);
            	 break;
             default : 
            	  System.out.println("Invalid input, select one of the options below.");
                  System.out.println("");
                
            	  report.setText(repot);
                
            }
        }
    }
    
        private static class slot {
        
        private static String repot;
                
        private static void setText(String slots) throws IOException{
       		
       		String lot_num, line;

            System.out.println("Enter the lot number to view");
            lot_num = input.nextLine();

      	    
       	  try{  
       	 FileReader file = new FileReader("/home/mwendwa/Desktop/Java/"+ lot_num +".txt");
         BufferedReader writer = new BufferedReader(file);
         

      	line = writer.readLine();
        
      	while (line != null) {
	         System.out.println(line);   
	     }
        
      	System.out.println(""); 
        
        report.setText(repot);   	
     	      
       	}
          catch(Exception e){
       		
       		System.out.println(lot_num +".txt" + " cannot be found.");
       		System.out.println("");
                
       		report.setText(repot);
    	}
        }   
    }

        private static class delete {
        
        private static void setText(String delet)throws IOException{
            
            System.out.println("To delete a record, select 1. Select 2 to return to main menu.");
            System.out.println("1. Delete record");
            System.out.println("2. Back");
            System.out.println(" ");
            
            String main;
            main = input.nextLine();
            
            switch(main){
                case "1":                  
                    
                    String Delete = JOptionPane.showInputDialog(null, "Please key in the lot number that you want to delete");
                    int lot_no = Integer.parseInt(Delete);            
                    
                    try{
                        File file = new File("/home/mwendwa/Desktop/Java/" + lot_no + ".txt");
                        if (file.delete())
                        {
                            JOptionPane.showMessageDialog(null,"File has been successfully deleted!" );
                        }
                        else
                        {
                          JOptionPane.showInputDialog(null, "File cannot be found. Ensure you have input the correct Lot Number");
                        }
               
                    }
                    catch (Exception e){}
                
                delete.setText(delet);
                break;
                    
                case "2":
                    startSys.setText(back);
                    break;
                    
                default:
                    System.out.println("Invalid option, select one of the options below.");
                    System.out.println("");
                    delete.setText(delet);
                    break;
                            }   
            }
        }
        
       


}
    
        

        
   
    
    


    
 

