package Employee.JPA_streamers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"Employee.JPA_streamers","com.speedment.jpastreamer"})
public class JpaStreamersApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaStreamersApplication.class, args);
	}

}
