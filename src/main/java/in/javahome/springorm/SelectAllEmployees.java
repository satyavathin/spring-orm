package in.javahome.springorm;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.javahome.springorm.dao.EmployeeDAO;
import in.javahome.springorm.entity.Employee;

public class SelectAllEmployees {
	public static void main(String[] args) {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("orm.xml");

		EmployeeDAO empDao = ioc.getBean(EmployeeDAO.class);

		List<Employee> empList = empDao.findAll();
		for (Employee emp : empList) {
			System.out.println(emp.getMail());
			System.out.println(emp.getName());

		}
	}
}
