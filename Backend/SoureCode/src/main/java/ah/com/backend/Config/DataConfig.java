package ah.com.backend.Config;

import ah.com.backend.Model.UserData;
import ah.com.backend.Persistence.UserDataRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @class: DataConfig
 * @author: Anes Hodza
 * @version: 28.08.2021
 **/

@Configuration
public class DataConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserDataRepository userDataRepository) {
        return args -> {
            UserData anes = new UserData(
                    1L,
                    "anes.hodza",
                    "1234",
                    10
            );

            userDataRepository.save(anes);
        };
    }
}
