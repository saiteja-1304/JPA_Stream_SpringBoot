package Employee.JPA_streamers.controller;

import Employee.JPA_streamers.model.Employee;
import Employee.JPA_streamers.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

     @GetMapping("/groupByCity")
    public Map<String, List<Employee>> groupByCity(){
        return employeeService.groupByCity();
    }
    @PostMapping("/save")
    public List<Employee> saveEmployee(@RequestBody List<Employee> employee){
        return employeeService.saveEmployee(employee);
    }
    @GetMapping("/findall")
    public List<Employee> groupbyEmployeeByPaymentTier(){
        return employeeService.groupbyEmployeeByPaymentTier();
    }
    @GetMapping("/rangeByAge")
    public List<Employee> rangeByAge(@RequestParam int initialAge, @RequestParam int finalAge){
        return employeeService.rangeByAge(initialAge,finalAge);
    }

    @GetMapping("/groupByEducation")
    public Map<String,List<Employee>> groupByEducation(){
        return employeeService.groupByEducation();
    }

    @GetMapping("/getCountByGender")
    public String getCountByGender(@RequestParam String gender){
         return employeeService.getCountByGender(gender);
    }
    @GetMapping("/listByYear")
    public List<Employee> listByYear(@RequestParam int joiningYear){
        return employeeService.listByYear(joiningYear);
    }
    @GetMapping("/getGenderCountByYear")
    public String getGenderCountByYear(@RequestParam int joiningYear){
        return employeeService.getGenderCountByYear(joiningYear);
    }

    @GetMapping("/getByFilter")
    public List<Employee> getByFilter(@RequestParam int joiningYear, @RequestParam String gender, @RequestParam String education){
        return employeeService.getByFilter(joiningYear, gender, education);
    }

}
