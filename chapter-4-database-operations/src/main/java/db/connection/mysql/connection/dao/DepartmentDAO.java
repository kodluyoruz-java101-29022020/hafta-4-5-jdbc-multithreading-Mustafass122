package db.connection.mysql.connection.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import db.connection.mysql.connection.DbSQLQuery;
import db.connection.mysql.connection.model.Department;


public class DepartmentDAO {

	private static final Logger logger = Logger.getLogger(DepartmentDAO.class);

	
	public List<Department> getAll() {
		
		List<Department> departments = new ArrayList<Department>();
		
		ResultSet resultSet = DbSQLQuery.select("select * from departmens");//Tüm departmanı getir
		
		try {
			
			if (resultSet == null) {
                return departments;
            }
			while (resultSet.next()) {
                Department mydepartment = new Department(resultSet.getString("dept_no"), resultSet.getString("dept_name"));
                departments.add(mydepartment);
            }
			
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return departments;
	}
	
}
