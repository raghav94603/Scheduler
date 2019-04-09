/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Raghav Asawa
 */

import java.util.*;

public class osscheduler {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        
        
      int i,j,k,processes,number = 0;     //required variables declaration
      int arrival[]=new int[50]; int burst[]=new int[50];  int remaining[]=new int[50];int waiting[]=new int[50]; int turnaround[]=new int[50];
      int time=3000000;int complete[]=new int[50];float twt=0,ttt=0;
      char alpha[][]=new char[50][40];
      int t1=6,t2=10;      //time period mentioned in the question alloted
      int max=1,beta;
      
      System.out.println("*-*-*-*-*-WELCOME TO THE SCHEDULER-*-*-*-*-*");
        
        System.out.println("Enter the number of processes :-");
        processes=s.nextInt();
        
        for(i=0;i<processes;i++)
        {
            
            System.out.println("Enter the arrival time of process[%d]:-"+(i+1));
            arrival[i]=s.nextInt();
            s.nextLine();
            
            System.out.println("Enter the burst time for processes[%d]:-"+i+1);
            burst[i]=s.nextInt();
            
        }
   
   for (i = 0; i < processes; ++i)
{
	if (arrival[i]<time)
	{
		time=arrival[i];
	}
}

for(k = 0; k < 3; ++k)
{
    	if (k==0)
		{
		for ( i = 0; i <processes; ++i)
		{
			if (time<arrival[i])
			{
				time=arrival[i];
			}
			if (burst[i]>t1)
			{
				
				remaining[i]=burst[i]-t1;
				time=time+t1;
			}
			else if (burst[i]<=t1 )
			{
			time=time+burst[i];
             remaining[i]=0;
             complete[i]=time;

			}
			}
		}

		if (k==1)
		{
		for ( i = 0; i <processes; ++i)
		{
			if (remaining[i]>t2 && remaining[i]!=0)
			{
				
				remaining[i]=remaining[i]-t2;
				time=time+t2;
				complete[i]=time;
			}
			else if (remaining[i]<=t2 && remaining[i]!=0)
			{
			time=time+remaining[i];
            remaining[i]=0;
            complete[i]=time;
			}
		
		}
	}
		if (k==2 )
		{	
		for (i = 0; i <processes; ++i)

		{
         if (remaining[i]!=0)
         {
         	
         	max=remaining[i];
         	if (max<remaining[i])
         	{
         		max=remaining[i];
         		
         	}
         }
		
		}
		
		for (i = 0; i <processes; ++i)
		{
			
		if (remaining[i]==max && remaining[i]!=0)
		{
			
			time=time+remaining[i];
			remaining[i]=0;
			complete[i]=time;
			
		}
		}
		
}

   for (i = 0; i <processes; ++i)
		{  
		 if (remaining[i]==0)
		{
			
			turnaround[i]=complete[i]-arrival[i];
			waiting[i]=turnaround[i]-burst[i];
			if (waiting[i]<=0)
			{
				waiting[i]=0;
			}

		}
			
			
		}
		
	}



	       System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-HERE IS YOU TABLE-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
	System.out.println("Process ||   BURST TIME  ||   ARRIVAL TIME || COMPLETION TIME ||  TURNAROUND TIME  ||     WAITING TIME\n");
	
		for (i = 0; i <processes; ++i)
		{  
		 if (remaining[i]==0)
		{
			
			System.out.println("Process[]           ||                  ||                      ||                      ||                  ||\n"+"     "+(i+1)+"                  "+burst[i]+"               "+arrival[i]+"             "+complete[i]+"             "+turnaround[i]+"            "+waiting[i]);
		}
			
			
		}


		for (i = 0; i <processes; ++i)
		{ 
		 if (remaining[i]==0)
		{
			
		     number++;
			ttt=(float)ttt+turnaround[i];
            twt=(float)twt+waiting[i];

		}
	}
		// printf("Number of process%f\n",total_trunaround);
		// printf("Number of process%f\n",total_waiting );
		// printf("Number of process%d\n",number );
		System.out.println("\nAverage waiting="+twt/number);	
		System.out.println("\nAverage turnaround=\n"+ttt/number);
		
	for (i = 0; i <processes; ++i)
		{  
		 if (remaining[i]>0)
		{
			
		System.out.println("\n process p[%d] is terminated\n"+i+1);

		}
	}


	}







   
   
    }

