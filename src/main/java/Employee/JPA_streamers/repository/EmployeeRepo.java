package Employee.JPA_streamers.repository;

import Employee.JPA_streamers.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
}
