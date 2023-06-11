package bo.edu.ucb.med_control.medControl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@EnableTransactionManagement
public class MedControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedControlApplication.class, args);
	}

}
