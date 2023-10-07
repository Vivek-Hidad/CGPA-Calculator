import java.util.Scanner;

import java.io.File;
import java.io.FileWriter;

class CGPA{
	static Scanner s=new Scanner(System.in);
	static long enr_no=0L;
	static String name="";
	static int t_sem=0;
	static String sem_sub[][] = new String[8][10];
	static int t_sub[]= new int[8];
	static double sub_marks[][] = new double[8][10];
	static double sem_cgpa[] = new double[8];
	static double F_cgpa=0;
	public static void cgpa_cal()
	{
		try
		{
			FileWriter fout=new FileWriter("Student.txt");
			
			System.out.println("Enter Enrollment Number : ");
			enr_no=s.nextLong();
			
			System.out.println("Enter Your Name         : ");
			name=s.next();
			System.out.println("Enter Total Semesters   : ");
			t_sem=s.nextInt();
			
			
			if(t_sem>=1 && t_sem<=8)
			{
				fout.write("\nEnrollment No   :  "+enr_no);
				fout.write("\nName            :  "+name);
				fout.write("\nTotal Semesters :  "+t_sem);
				for(int i=0;i<t_sem;i++)
				{
					System.out.println("\n\t-- Data For Semester "+(i+1)+" --\n");
					System.out.println("Enter Total Subjects Of Sem "+(i+1)+" : ");					
					t_sub[i]=s.nextInt();
					fout.write("\n\n-------------------------------------------");
					fout.write("\n\t Semester "+(i+1));
					
					
					for(int j=0;j<t_sub[i];j++)
					{
						System.out.println("Enter Name Of Sub"+(j+1)+"  : ");
			
						sem_sub[i][j]=s.next();
						System.out.println("Enter Marks for Subject "+sem_sub[i][j]+" : ");
						sub_marks[i][j]=s.nextDouble();
						sem_cgpa[i]+=sub_marks[i][j];
						fout.write("\n"+sem_sub[i][j]+"  : "+sub_marks[i][j]);
						
					}
					sem_cgpa[i]=sem_cgpa[i]/t_sub[i];
					sem_cgpa[i]=sem_cgpa[i]/9.5;
					F_cgpa+=sem_cgpa[i];
					fout.write("\nCGPA  : "+sem_cgpa[i]);
				}
			}
			F_cgpa=F_cgpa/t_sem;
			fout.write("\n\n-------------------------------------------");
			fout.write("\nOverall CGPA  : "+F_cgpa);
			fout.close();
			System.out.println("Successful");
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

	}
	
	void Display()
	{
		try
		{
			File fin=new File("Student.txt");
			Scanner sc=new Scanner(fin);
			while(sc.hasNextLine())
			{
				String s=sc.nextLine();
				System.out.println(s);
			}
			sc.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}

public class Cli_Finale_10_7 {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		CGPA c = new CGPA();
		int ch=0;
		while(true)
		{
			System.out.println("\n\t -- CGPA Calculator --\n");
			System.out.println("1. Calculate CGPA");
			System.out.println("2. Display");
			System.out.println("3. Exit\n"); 
			System.out.print("Enter Choice : ");
			ch=sc.nextInt();
			
			switch(ch)
			{
			case 1 : c.cgpa_cal();break;
			case 2 : c.Display();
			case 3 : System.exit(0);
			}
		
		}
	}
}