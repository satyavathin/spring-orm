package in.javahome.springorm.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;

import in.javahome.springorm.entity.Employee;

@Component
public class EmployeeDAO {

	@Autowired
	private HibernateTemplate template;

	@Transactional
	public void register(Employee emp) {
		template.save(emp);
	}

	@Transactional(rollbackFor = { SQLException.class }, timeout = 60)
	public void delete(Integer id) {
		Employee emp = template.load(Employee.class, id);
		template.delete(emp);
	}

	@Transactional(readOnly = true)
	public List<Employee> findAll() {
		return (List<Employee>) template.find("from Employee");
	}

	public List<Employee> findAllUsingCriteria() {
		DetachedCriteria crit = DetachedCriteria.forClass(Employee.class);
		return (List<Employee>) template.findByCriteria(crit);
	}
}
