import java.io.*;
class marks
{
	InputStreamReader in=new InputStreamReader(System.in);
	BufferedReader br=new BufferedReader(in);
	void get_info()
	{
	int roll;
	char name[20];
	int marks1;
	int marks2;
	int marks3;
	int total;
	}
	void cal()
	{
		int total;
		total=m1+m2+m3;
	}
	void disp()
	{
		System.out.println("Roll:"+roll);
		System.out.println("Name:"+name);
		System.out.println("Mark1:"+m1);
		System.out.println("Marks2:"+m2);
		System.out.println("Marks3:"+m3);
		System.out.println("Total:"+total);

}
class demomarks
{
	public static void main()throws IOException
	{
	marks obj[]=new obj[5];
	for(i=0;i<5;i++)
	{
		obj[i].get_info();
		obj[i].cal();
	}
	for(i=0;i<obj.length;i++)
	{
		obj[i].disp();
		System.out.println("");
	}
}