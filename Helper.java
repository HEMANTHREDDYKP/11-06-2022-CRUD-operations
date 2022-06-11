package com;

public class Helper {

	public static void main(String[] args) {

		
		Employee employee=new Employee();
		employee.setId(100);
		employee.setName("ganga"); 
		
		ToConnect toConnect=new ToConnect();
		//toConnect.addDynamically(employee);
		//toConnect.toGet(100);
		//toConnect.toDelete(100);
		
		toConnect.toUpdate(100, "tom");
	}

}
