package project;

import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class Account 
{
    double balance = 100;
    protected int firstdate;
    protected int seconddate;
    protected Calendar cal1 = new GregorianCalendar();
    protected Calendar cal2 = new GregorianCalendar();
    protected boolean dateflag = false;
    protected double rate;
         
    public void menu() throws IOException
    {
        int option;
        Scanner sc = new Scanner(System.in);
                 
               
           do
           {
              System.out.println("1) Deposit");
              System.out.println("2) Withdraw");
              System.out.println("3) Check Balance");
              System.out.println("4) Exit");
              System.out.print("Please select an option:");
              option = sc.nextInt();
             
              switch(option)
               {
                   case 1:                     
                        if (dateflag == true)
                        {
                            getDate2();
                            getInterest();                
                        }
                        else
                        {
                            getDate1(); 
                        }
                       deposit();
                       break;
                       
                   case 2:
                       if (dateflag == true)
                        {
                            getDate2();
                            getInterest();                
                        }
                        else
                        {
                            getDate1();
                        }
                       withdraw();
                       break;
                   case 3:
                       if (dateflag == true)
                        {
                            getDate2();
                            getInterest();                
                        }
                        else
                        {
                            getDate1(); 
                        }
                       checkBalance();
                       break;
                   
               }
              
           }while(option >= 1 && option < 4);   
          
                      
    }
    
   public void deposit() throws IOException
    {
        getInterest();
        
        int deposit;
        Scanner sc = new Scanner(System.in);
        System.out.print("How much do you want to deposit? ");
        deposit = sc.nextInt();
        
        balance = getbalance() + deposit;
        System.out.println("Your balance is " + balance);
       
    }
       
    public void withdraw() throws IOException
    {
        int withdraw;
        Scanner sc = new Scanner(System.in);
        System.out.print("How much would you like to withdraw? ");
        withdraw = sc.nextInt();
        
        balance = getbalance() - withdraw;
        System.out.println("Your balance is " + balance);
              
    }
    
     public double getbalance() throws IOException
    {
        NumberFormat currencyFormatter;
        String currencyOut;
        
        currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        currencyOut = currencyFormatter.format(balance);
                
        return balance;
    }
    
    public void checkBalance()
    {
       System.out.println("Your balance is " + balance);
    }
    

    public void getInterest()

        {

            int datediff = seconddate - firstdate;

            rate = .10/365;

            double ratetime = Math.pow(1+rate,datediff);

            balance = balance * ratetime;

            firstdate = seconddate;

        }
    
    private void getDate1()throws IOException
    {
        Scanner sc = new Scanner(System.in);
        String year;
        
        System.out.print("Enter todays date (mm/dd/yyy): ");
        year = sc.next();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyy");
        ParsePosition pos = new ParsePosition(0);
        
        Date date = formatter.parse(year, pos);
        
        cal1.setTime(date);
        
        firstdate = cal1.get(Calendar.DAY_OF_YEAR);
        dateflag = true;
        
    }
    private void getDate2() throws IOException
    {
        Scanner sc = new Scanner(System.in);
        String year;
        
        System.out.print("Enter todays date (mm/dd/yyy");
        year = sc.next();
        
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyy");
        ParsePosition pos = new ParsePosition(0);
        Date date = new Date();
        date = formatter.parse(year,pos);
        
        cal2.setTime(date);
        
        seconddate = cal2.get(Calendar.DAY_OF_YEAR);
        
        if(firstdate > seconddate)
        {
            System.out.println("You must enter a future date");
            getDate2();
        }
        
        
    }
}
