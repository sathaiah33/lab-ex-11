/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB11;

/**
 *
 * @author rakesh
 */
public class Q2 
{  
int amount=10000;  
  
synchronized void withdraw(int amount)
{  
System.out.println("withdrawal is being processed");  
if(this.amount<amount)
{  
System.out.println("no balance  deposit the minimal amount");  
try
{
    wait();
}
catch(InterruptedException e){}  
}  
this.amount-=amount;  
System.out.println("withdraw completed");  
}  
  
synchronized void deposit(int amount)
{  
System.out.println("deposit is bing done");  
this.amount+=amount;  
System.out.println("deposit completed ");  
notify();  
}  
}  
  
class Test
{  
public static void main(String args[])
{  
final Customer c=new Customer();  
new Thread()
{  
@Override
public void run()
{
    c.withdraw(15000);
}  
}.start();  
new Thread()
{  
@Override
public void run()
{
    c.deposit(10000);
}  
}.start();  
  
}
}  
