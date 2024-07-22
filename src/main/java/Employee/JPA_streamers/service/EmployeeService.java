package Employee.JPA_streamers.service;

import Employee.JPA_streamers.model.Employee;
import Employee.JPA_streamers.repository.EmployeeRepo;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    private final JPAStreamer jpaStreamer;
    @Autowired
    public EmployeeService( final JPAStreamer jpaStreamer) {
        this.jpaStreamer = jpaStreamer;
    }

    public Map<String, List<Employee>> groupByCity() {
        return jpaStreamer.stream(Employee.class)
                .collect(Collectors.groupingBy(Employee::getCity));
    }

    public List<Employee> groupbyEmployeeByPaymentTier() {
        return employeeRepo.findAll() ;
    }

    public List<Employee> saveEmployee(List<Employee> employee) {
        return employeeRepo.saveAll(employee);
    }

    public List<Employee> rangeByAge(int initialAge, int finalAge) {
        return jpaStreamer.stream(Employee.class)
                .filter(employee -> employee.getAge() >= initialAge && employee.getAge() <= finalAge)
                .collect(Collectors.toList());
    }

    public Map<String,List<Employee>> groupByEducation() {
        return jpaStreamer.stream(Employee.class)
                .collect(Collectors.groupingBy(Employee::getEducation));
    }

    public String getCountByGender(String gender) {
        long count=0;
        count = jpaStreamer.stream(Employee.class)
                .filter(e -> gender.equalsIgnoreCase(e.getGender()))
                .count();
        return "Total number of "+gender+" are ==> "+count;
    }

    public List<Employee> listByYear(int year) {
        return jpaStreamer.stream(Employee.class)
                .filter(e -> year==(e.getJoiningYear()))
                .collect(Collectors.toList());
    }

    public String getGenderCountByYear(int joiningYear) {
        long maleCount=0;
        long femaleCount=0;
        maleCount = jpaStreamer.stream(Employee.class)
                .filter(e -> e.getGender().equalsIgnoreCase("Male") && e.getJoiningYear()==joiningYear)
                .count();
        femaleCount = jpaStreamer.stream(Employee.class)
                .filter(e -> e.getGender().equalsIgnoreCase("Female") && e.getJoiningYear()==joiningYear)
                .count();
        return "Total number of Males joined in "+joiningYear+" are ==> "+maleCount+
                "\nTotal number of Females joined in "+joiningYear+" are ==> "+femaleCount;

    }

//    public List<Employee> getByFilter(int joiningYear, String gender, String education) {
//        return jpaStreamer.stream(Employee.class)
//                .filter(e->gender.equalsIgnoreCase(e.getGender()) && e.getJoiningYear()==joiningYear && e.getEducation().equalsIgnoreCase(education))
//                .collect(Collectors.toList());
//    }

    public List<Employee>getByFilter(Integer joiningYear, String gender, String education,Integer age,String everBenched, Integer experienceInCurrentDomain,Integer leaveOrNot,Integer paymentTier, String city){
        return jpaStreamer.stream(Employee.class)
                .filter(e->joiningYear==null || e.getJoiningYear()==joiningYear)
                .filter(e-> gender == null || e.getGender().equalsIgnoreCase(gender))
                .filter(e-> education == null || e.getEducation().equalsIgnoreCase(education))
                .filter(e->age==null || e.getAge()==age)
                .filter(e-> everBenched == null || e.getEverBenched().equalsIgnoreCase(everBenched))
                .filter(e->experienceInCurrentDomain==null || e.getExperienceInCurrentDomain()==experienceInCurrentDomain)
                .filter(e->leaveOrNot==null || e.getLeaveOrNot()==leaveOrNot)
                .filter(e->paymentTier==null || e.getPaymentTier()==paymentTier)
                .filter(e-> city == null || e.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }
}
