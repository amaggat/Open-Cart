package opencart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(scanBasePackages = {"opencart"}, exclude = JpaRepositoriesAutoConfiguration.class)
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class OpenCartApp {
    public static void main(String[] args) {
        SpringApplication.run(OpenCartApp.class, args);
    }
}
