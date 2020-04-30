package db.connection.mysql.connection.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.connection.mysql.connection.DbSQLQuery;
import db.connection.mysql.connection.model.Employee;
import db.connection.mysql.connection.model.Manager;

public class ManagerDAO {

	public List<Manager> loadAllActiveManagers() {
		
		List<Manager> managers = new ArrayList<Manager>();		
		
		String sorgu = "select emp.* , dm.* , from employees emp left join"
				+ "dept_manager dm om dm.emp_no = emp.em_no left join "
				+ "depertmens dp on dp.dept_no";
		
				ResultSet rs = DbSQLQuery.select(sorgu);
				
				try {
					while(rs.next()) {
						Employee employee = new Employee();
					    employee.setLastName(rs.getString("last_name"));
					    employee.setHireDate(rs.getDate("hire_date"));
					    employee.setName(rs.getString("first_name"));
					    employee.setBirthDate(rs.getDate("birth_date"));
					    employee.setGender(rs.getString("gender"));
					    employee.setId(rs.getLong("emp_no"));
					    managers.add(new Manager(employee,rs.getString("dept_name")));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		
		
		return managers;
	}
	
}
