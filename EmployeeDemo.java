package pra.com;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
public class EmployeeDemo {

	public static void main(String[] args) {
		
		List<Employee> list =readBooksFromCSV("inputfile.csv");
		
		for(Employee emp: list)
		{
			System.out.println(emp);
		
	    }
		List<Employee> list1=firstNameSort(list);
		for(Employee emp: list1)
		{
			System.out.println(emp.getFname());
		}
		
		filterlistcity(list);
	}
 
	

private static List<Employee> readBooksFromCSV(String filename)
{
	List<Employee> list =new ArrayList<>();
			Path pathToFile=Paths.get(filename);
			
			try(BufferedReader br= Files.newBufferedReader(pathToFile,StandardCharsets.US_ASCII)) {
			
			String line =br.readLine();
					while(line!=null)
					{
						String[] attributes =line.split(",");
						Employee emp= createBook(attributes);
						list.add(emp);
						line= br.readLine();
					}
			}
					catch (IOException ioe)
			{
						ioe.printStackTrace();
			}
			return list;
}
private static Employee createBook(String[] metadata)
{
	String first_name=metadata[0];
	String last_name=metadata[1];
	String company_name=metadata[2];
	String address=metadata[3];
	String city=metadata[4];
	String country=metadata[5];
	String state=metadata[6];
	String zip=metadata[7];
	String phone1=metadata[8];
	String phone2=metadata[9];
	String email=metadata[10];
	String web =metadata[11];
	
	return new Employee(first_name,last_name,company_name,address,city,country,state,zip,phone1,phone2,email,web);
}

public static List<Employee> firstNameSort(List <Employee> l)
{
	for(int i=0;i<l.size()-1;i++)
	{
		for(int j=i+1;j<l.size()-1;j++)
		{
			if(l.get(i).getFname().compareTo(l.get(j).getFname())>0)
			{
				Collections.swap(l, i, j);
			
				
		}
	}
}
	return l;
}
public static void filterlistcity(List<Employee> k)
{
	for(Employee emp:k)
	{
		if(emp.getCity().equals("New york"))
		{
			System.out.println(emp.getFname()+"   "+emp.getLname()+"  "+emp.getCity());
			
		}
	}
}


}


