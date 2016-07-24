package in.javahome.springorm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.javahome.springorm.dao.EmployeeDAO;
import in.javahome.springorm.entity.Employee;

public class SpringHibernateTest {
	public static void main(String[] args) {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("orm.xml");
		
		EmployeeDAO empDao =ioc.getBean(EmployeeDAO.class);

		Employee e = new Employee();
		e.setName("Raghu");
		e.setMail("ram@javahome.in");
		empDao.register(e);
	}
}
