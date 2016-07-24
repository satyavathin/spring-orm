package in.javahome.springorm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.javahome.springorm.dao.EmployeeDAO;

public class DeleteEmployee {
	public static void main(String[] args) {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("orm.xml");

		EmployeeDAO empDao = ioc.getBean(EmployeeDAO.class);

		empDao.delete(26);
	}
}
