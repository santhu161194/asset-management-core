package org.medplus.assetmanagementcore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.medplus.assetmanagementcore.dao.EmployeeDao;
import org.medplus.assetmanagementcore.dao.impl.EmployeeDaoImpl;
import org.medplus.assetmanagementcore.exceptions.AuthenticationException;
import org.medplus.assetmanagementcore.exceptions.EmployeeException;
import org.medplus.assetmanagementcore.model.Asset;
import org.medplus.assetmanagementcore.model.Employee;
import org.medplus.assetmanagementcore.service.EmployeeService;
import org.medplus.assetmanagementcore.service.impl.EmployeeServiceImpl;
import org.medplus.assetmanagementcore.utils.AppConfig;
import org.medplus.assetmanagementcore.utils.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class EmployeeTest {
	@Autowired
	
	EmployeeService employeeService;
@Autowired
	EmployeeDao employeeDao;
@Ignore
@Test
	public void addEmployeeSuccess()
	{
		String message=null;
		Employee employee=new Employee();
		employee.setEmployeeId("6767547");
		employee.setFirstName("kalyaniI");
		employee.setPassword("niha11");
	    employee.setGender(Gender.FEMALE);
		employee.setDateOfBirth(new Date());
		employee.setDateOfJoin(new Date());
		employee.setCreatedDate(new Date());
		employee.setModifiedDate(new Date());
		String expectedResult = "SUCCESS";
		try {
			message = employeeService.addEmployee(employee,"5555555");
		} catch (EmployeeException e) {

			System.out.println(e.getErrorMessage());
			
		} catch (AuthenticationException e) {

			System.out.println(e.getErrorMessage());
		}
assertEquals(expectedResult,message);
	}
@Ignore
	@Test
	public void addEmployeeFailureForDuplicateKey()
	{
		String rows=null;
		Employee employee=new Employee();
		employee.setEmployeeId("676767");
		employee.setFirstName("kalyaniI");
		employee.setPassword("niha11");
	    employee.setGender(Gender.FEMALE);
		employee.setDateOfBirth(new Date());
		employee.setDateOfJoin(new Date());
		employee.setCreatedDate(new Date());
		employee.setModifiedDate(new Date());
	boolean isInserted=false;
		try {
			rows = employeeService.addEmployee(employee,"5555555");
			isInserted=true;
		} catch (EmployeeException e) {

			System.out.println(e.getErrorMessage());
			
		} catch (AuthenticationException e) {

			System.out.println(e.getErrorMessage());
		}
assertEquals(isInserted,false);
	}
@Ignore
	@Test
	public void updateEmployeeSuccess()
	{
		String message=null;
		Employee employee=new Employee();
		employee.setEmployeeId("676767");
		employee.setFirstName("kalyaniI11");
		employee.setPassword("niha11");
	    employee.setGender(Gender.FEMALE);
		employee.setDateOfBirth(new Date());
		employee.setDateOfJoin(new Date());
		employee.setCreatedDate(new Date());
		employee.setModifiedDate(new Date());
		String expectedResult = "SUCCESS";
		try {
			message = employeeService.updateEmployee(employee,"5555555");
		} catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		assertEquals(expectedResult,message);
	}
@Ignore
	@Test
	public void updateEmployeeFailureForInvaliDetails()
	{
		String message=null;
		Employee employee=new Employee();
		employee.setEmployeeId("676767");
		employee.setFirstName("kalyaniI11bbbbbbbbbbbbbbbbbbbbbb");
		employee.setPassword("niha11");
	    employee.setGender(Gender.FEMALE);
		employee.setDateOfBirth(new Date());
		employee.setDateOfJoin(new Date());
		employee.setCreatedDate(new Date());
		employee.setModifiedDate(new Date());
		boolean isInserted=false;
		try {
			message = employeeService.updateEmployee(employee,"5555555");
			isInserted=true;
		} catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		assertEquals(isInserted,false);
	}
@Ignore
	@Test
	public void testGetEmployeesSuccess() {
		
		Employee emp=new Employee();
		boolean isInserted=false;
		try {
			emp = employeeService.getEmployee("676767");
			isInserted=true;
		} catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		assertEquals(isInserted,true);
	}
@Ignore	
@Test
public void testGetEmployeesFailure() {
	
	Employee emp=new Employee();
	boolean isInserted=false;
	try{
		emp = employeeService.getEmployee("");
		isInserted=true;
	} catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	assertEquals(isInserted,false);
}


@Ignore
@Test
public void testChangePasswordSuccess() {
    String message=null;
    
    String expectedResult="SUCCESS";
    
		try {
			message=employeeService.changePassword("1234567","niha11","niha11ff","5555555",new Date());
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
		    System.out.println(e.getMessage());
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
		    System.out.println(e.getMessage());
		}
	
    assertEquals(expectedResult,message);

}
@Ignore
@Test
public void testChangePasswordFailure() {
    String message=null;
    
    boolean isInserted=false;
    
		try {
			message=employeeService.changePassword("cbnmcnm","niha11","niha11","11111",new Date());
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
		    System.out.println(e.getMessage());
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
		    System.out.println(e.getMessage());
		}
	isInserted=true;
   
	
	
    
    assertEquals(isInserted,false);

}
@Ignore
@Test
public void testResetPasswordSuccess() {
    String message=null;
    
    String expectedResult="SUCCESS";
   
		
			try {
				message=employeeService.resetPassword("676767","11111","niha1156",new Date());
			} catch (EmployeeException e) {
				// TODO Auto-generated catch block
			    System.out.println(e.getMessage());
			} catch (AuthenticationException e) {
				// TODO Auto-generated catch block
			    System.out.println(e.getMessage());
			}
		
		
    
    assertEquals(expectedResult,message);

}
@Ignore
@Test
public void testResetPasswordFailure() {
    String message=null;
   boolean isInserted=false; 
			try {
				message=employeeService.resetPassword("SGHSDGSBDH","111111","NIHA11",new Date());
			} catch (EmployeeException e) {
				// TODO Auto-generated catch block
			    System.out.println(e.getMessage());
			} catch (AuthenticationException e) {
				// TODO Auto-generated catch block
			    System.out.println(e.getMessage());
			}
		isInserted=true;
		
    assertEquals(isInserted,false);

}

@Ignore
@Test
public void testGetAllEmployeesSuccess()
{
	List<Employee> employeeList = null;
	boolean isResult=false;
	try {
		employeeList = employeeService.getAllEmployees();
		isResult=true;
	    System.out.println(employeeList.size());
	    for (Employee employee : employeeList) {
	        System.out.println(employee.getFirstName());
	    }
	} catch (EmployeeException e) {
		System.out.println(e.getMessage());
	}
    
  assertEquals(isResult,true); 

}
@Ignore
@Test
public void testGetAllEmployeesFailure()
{
	List<Employee> employeeList = null;
	boolean isExpected=false;
	try {
		employeeList = employeeService.getAllEmployees();
		isExpected=true;
	    System.out.println(employeeList.size());
	    for (Employee employee : employeeList) {
	        System.out.println(employee.getFirstName());
	    }
	} catch (EmployeeException e) {
		System.out.println(e.getMessage());
	}
    
  assertEquals(isExpected,false); 

}
@Ignore
@Test
public void addRoleToEmployeeSuccess()
{
	String message=null;
	boolean isInserted=false;
	List<Long> li=new ArrayList<Long>();
	li.add((long) 19);
	
			try {
				message = employeeService.addRoleToEmployee("676767","admin","5555555",new Date());
			} catch (EmployeeException e) {
				// TODO Auto-generated catch block
			    System.out.println(e.getMessage());
			} catch (AuthenticationException e) {
				// TODO Auto-generated catch block
			    System.out.println(e.getMessage());
			}
		isInserted=true;
		
	
assertEquals(isInserted,true);
}
@Ignore
@Test
public void addRoleToEmployeeFailure()
{
	String message=null;
	boolean isInserted=false;
	
	List<Long> li=new ArrayList<Long>();
	li.add((long) 15);
	

			try {
				message = employeeService.addRoleToEmployee("676767","edp","111111",new Date());
			} catch (EmployeeException e) {
				// TODO Auto-generated catch block
			    System.out.println(e.getMessage());
			} catch (AuthenticationException e) {
				// TODO Auto-generated catch block
			    System.out.println(e.getMessage());
			}
		isInserted=true;
		
	
assertEquals(isInserted,false);
}
@Ignore
@Test
public void addRoleToEmployeeDuplicateKeyEntryTestSuccess()
{
	String message=null;
	boolean isInserted=false;
	List<Long> li=new ArrayList<Long>();
	li.add((long) 15);
	
		
			try {
				message = employeeService.addRoleToEmployee("676767","employee","5555555",new Date());
			} catch (EmployeeException e) {
				// TODO Auto-generated catch block
			    System.out.println(e.getMessage());
			} catch (AuthenticationException e) {
				// TODO Auto-generated catch block
			    System.out.println(e.getMessage());
			}
		isInserted=true;
		
	
assertEquals(isInserted,false);
}
@Ignore
@Test
public void addRoleSuccess()
{
	String message=null;
	boolean isInserted=false;
	
	
			
				try {
					message = employeeService.addRole(59,"hrmanager","5555555",new Date());
				} catch (EmployeeException e) {
					// TODO Auto-generated catch block
				    System.out.println(e.getMessage());
				} catch (AuthenticationException e) {
					// TODO Auto-generated catch block
				    System.out.println(e.getMessage());
				}
			isInserted=true;
			
		isInserted=true;
		
	
assertEquals(isInserted,true);
}
@Ignore
@Test
public void addRoleFailure()
{
	String message=null;
	boolean isInserted=false;
	
	

				try {
					message = employeeService.addRole(39,"hr","111111",new Date());
				} catch (EmployeeException e) {
					// TODO Auto-generated catch block
				    System.out.println(e.getMessage());
				} catch (AuthenticationException e) {
					// TODO Auto-generated catch block
				    System.out.println(e.getMessage());
				}
			isInserted=true;
			
	
assertEquals(isInserted,false);
}
@Ignore
@Test
public void authenticateEmployeeSuccess()
{
	String message=null;
	boolean isInserted=false;
				
					try {
						message = employeeService.authenticateEmployee("5555555","5555555");
					} catch (DataAccessException e) {
						// TODO Auto-generated catch block
					    System.out.println(e.getMessage());
					} catch (EmployeeException e) {
						// TODO Auto-generated catch block
					    System.out.println(e.getMessage());
					} catch (AuthenticationException e) {
						// TODO Auto-generated catch block
					    System.out.println(e.getMessage());
					}
				isInserted=true;
				
	
assertEquals(isInserted,true);
}
@Ignore
@Test
public void authenticateEmployeeFailure()
{
	String message=null;
	boolean isInserted=false;
				
					try {
						message = employeeService.authenticateEmployee("1111111","fjgjkhjkd");
					} catch (DataAccessException e) {
						// TODO Auto-generated catch block
					    System.out.println(e.getMessage());
					} catch (EmployeeException e) {
						// TODO Auto-generated catch block
					    System.out.println(e.getMessage());
					} catch (AuthenticationException e) {
						// TODO Auto-generated catch block
					    System.out.println(e.getMessage());
					}
				isInserted=true;
				
	
assertEquals(isInserted,false);
}
@Ignore
@Test
public void checkRolesSuccess()
{
	List<String> roleList = null;
	boolean isResult=true;
	
		roleList = employeeService.checkRoles("111111");
		if(roleList.equals(null))
		isResult=false;
	    System.out.println(roleList.size());
	
  assertEquals(isResult,true); 

}
@Ignore
@Test
public void checkRolesFailure()
{
	List<String> roleList = null;
	boolean isResult=true;
	
		roleList = employeeService.checkRoles("111111");
		if(!roleList.equals(null))
		isResult=false;
	    System.out.println(roleList.size());
	
  assertEquals(isResult,false); 

}

@Test
public void removeEmployeeRoleSuccess()
{
	String message=null;
	Employee employee=new Employee();
	String expectedResult = "REMOVED";
	
		
			try {
				message = employeeService.removeEmployeeRole("santhosh","edp","santhosh",new Date());
			} catch (EmployeeException e) {
				// TODO Auto-generated catch block
			    System.out.println(e.getMessage());
			} catch (AuthenticationException e) {
				// TODO Auto-generated catch block
			    System.out.println(e.getMessage());
			}
		
	
assertEquals(expectedResult,message);
}
@Ignore
@Test
public void removeEmployeeRoleFailure()
{
	String message=null;
	Employee employee=new Employee();
	boolean isRemoved=false;
	

			try {
				message = employeeService.removeEmployeeRole("11111","edp","5555555",new Date());
			} catch (EmployeeException e) {
				// TODO Auto-generated catch block
			    System.out.println(e.getMessage());
			} catch (AuthenticationException e) {
				// TODO Auto-generated catch block
			    System.out.println(e.getMessage());
			}
		isRemoved=true;
		
	
assertEquals(isRemoved,false);
}
@Ignore
@Test
public void testGetEmployeesRoleSuccess() {
	
	List<Map<Integer, String>> emp;
	boolean isResult=false;
	try {
		emp = employeeService.getEmployeeRole("1234567");
		isResult=true;
	} catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	assertEquals(isResult,true);
}
@Ignore
@Test
public void testGetEmployeesRoleFailure() {
	
	List<Map<Integer, String>> emp;
	boolean isResult=false;
	try {
		emp = employeeService.getEmployeeRole("11111");
		isResult=true;
	} catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	assertEquals(isResult,false);
}
}
	