package ah.com.backend.Persistence;

import ah.com.backend.Model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @interface: UserDataRepository
 * @author: Anes Hodza
 * @version: 28.08.2021
 **/

public interface UserDataRepository extends JpaRepository<UserData, Long> {
}
