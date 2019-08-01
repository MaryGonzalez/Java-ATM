
package project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;


public class ATM 
{
    
    Account[] myaccts = new Account[3];
   
    
    public static void main(String[] args) throws IOException
    {
              
       ATM myATM = new ATM();
       myATM.AccountSelectMenu();
        
       myATM.saveAccount();
    }
    
        
    public void AccountSelectMenu() throws IOException
    {
       int selection;
       Scanner sc = new Scanner(System.in);
        
       boolean exit = false;
        
       while(!exit)
       {
           
              System.out.println("1) Load account");
              System.out.println("2) Create account");
              System.out.println("3) Access account");
              System.out.println("4) Exit");
              System.out.print("Please select an option:");
              selection = sc.nextInt();
               if (selection < 1 ||  selection > 4)
               {
                   System.out.println("Invalid choice. Try again: ");
               }
          
        
                switch(selection)
                       {
                           case 1:
                               loadAccount();
                               break;
                           case 2:
                               createAccount();                       
                               break;
                           case 3:
                               accessAccount();
                               break;
                           case 4:
                               exit();
                               break;
                        }
       }   
    }
    
    public void createAccount()
    {
     
        for(int i =0; i < myaccts.length; i++)
            {  
                myaccts[i] = new Account();
                
            }
      
    }
    
    
    public void accessAccount() throws IOException
    {
        int option;
        Scanner sc = new Scanner(System.in);
        
        
        do
        {
            System.out.println("0) Account 0");
            System.out.println("1) Account 1");
            System.out.println("2) Account 2");
            System.out.println("3) Exit");
            System.out.print("Select an account:");
            option = sc.nextInt();
             
          
        }while(option < 0 || option > 3);
       

        switch(option)
                   {
                       case 0:
                           myaccts[option].menu();
                           break;
                       case 1:
                            myaccts[option].menu();
                           break;
                       case 2:
                            myaccts[option].menu();
                           break;
                       case 3:
                           exit();
                           break;
                    }
    }
    
    
    
    public void saveAccount()
    {
        try
        {
        FileOutputStream outStream = new FileOutputStream("E:/file1.out");
        ObjectOutputStream os = new ObjectOutputStream(outStream);
        os.writeObject(myaccts);
        os.flush();
        os.close();
        }
        catch(IOException ioe)
        {
            System.err.println(ioe);
        }
        
    }
    
    
    public void loadAccount()
    {
        try
        {
        FileInputStream inStream = new FileInputStream("E:/file1.out");
        ObjectInputStream is = new ObjectInputStream(inStream);
        myaccts = (Account[]) is.readObject();
        is.close();
        }
        catch(Exception ioe)
        {
            System.out.println(ioe.getMessage());
        }
        
    }
    
    
    public void exit()
    {
        System.exit(0);
    }
    
    
}
