/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB11;
import java.util.Scanner;
/**
 *
 * @author rakesh
 */
public class q1 {
    
int n;
	int nums[];
	q1(int n)
	{
		this.n = n;
	}
	public void readNumbers()
	{
		Scanner in = new Scanner(System.in);
		nums = new int[n];
		System.out.println("Enter " + n + " numbers");
		for(int i = 0; i < n; i++)
		{
			nums[i] = in.nextInt();
		}
	}
	public void divisiblebyfive()
	{
		System.out.println(" numbers divisible by five in the range 1 - " + n);
		for(int i = 2; i <= n; i = i + 2)
                {
                    if((i%5)==0)
                    System.out.println(i + " ");
                }
	}
	public void average()
	{
		int sum = 0;
		float avg = 0.0f;
		for(int i = 0; i < n; i++)
			sum = sum + nums[i];
		avg = (float) sum / n;
		System.out.println("Average is : " + avg);
	}
}

class Thread1 implements Runnable
{
	Thread t;
	q1 l;
	Thread1(q1 l)
	{
		this.l = l;
		t = new Thread(this);
		t.start();
	}
        @Override
	public void run()
	{
		l.readNumbers();
	}
}

class Thread2 implements Runnable
{
	Thread t;
	q1 l;
	Thread2(q1 l)
	{
		this.l = l;
		t = new Thread(this);
		t.start();
	}
        @Override
	public void run()
	{
		l.divisiblebyfive();
	}
}

class Thread3 implements Runnable
{
	Thread t;
	q1 l;
	Thread3(q1 l)
	{
		this.l = l;
		t = new Thread(this);
		t.start();
	}
	public void run()
	{
		l.average();
	}
}

 class Q1
{	
	public static void main(String[] args) throws InterruptedException
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter n: ");
		int n = in.nextInt();
		q1 l = new q1(n);
		Thread1 t1 = new Thread1(l);
		Thread2 t2 = new Thread2(l);
		Thread3 t3 = new Thread3(l);
				
	}
}
