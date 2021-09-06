package ah.com.backend.Service;

import ah.com.backend.Model.ReturnMessage;
import ah.com.backend.Model.UserData;
import ah.com.backend.Persistence.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

/**
 * @class: UserDataService
 * @author: Anes Hodza
 * @version: 28.08.2021
 **/

@Service
public class UserDataService {

    private final UserDataRepository userDataRepository;

    @Autowired
    public UserDataService(UserDataRepository userDataRepository) {
        this.userDataRepository = userDataRepository;
    }

    public List<UserData> getUsers() {
        return userDataRepository.findAll();
    }

    public Object attemptLogin(UserData userData) {
        Optional<UserData> user = userDataRepository.findAll()
                .stream()
                .filter(u -> u.getUsername().equals(userData.getUsername()))
                .filter(u -> u.getPassword().equals(userData.getPassword()))
                .findFirst();
        if (user.isPresent()) {
            return user.get();
        } else {
            return new ReturnMessage("The login did not work", false);
        }
    }

    public ReturnMessage addPoint(Long id) {
        try {
            UserData user = userDataRepository.findAll()
                    .stream()
                    .filter(p -> p.getId().equals(id))
                    .findFirst()
                    .get();
            user.addPoint();
            userDataRepository.save(user);
            return new ReturnMessage("Added the point", true);
        } catch (Exception e) {
            return new ReturnMessage("Something went wrong...", false);
        }
    }

    public Object registerUser(UserData userData) {
        if (userDataRepository.findAll().stream().
                anyMatch(p -> p.getUsername().equals(userData.getUsername()))
        ) {
            return new ReturnMessage("This username is already taken", false);
        }
        try {
            userData.initializeDate();
            userDataRepository.save(userData);
            return userData;
        } catch (Exception e) {
            return new ReturnMessage("Something went wrong...", false);
        }
    }

    public Object getMyPoints(Long id) {
        Optional<UserData> user = userDataRepository.findAll()
                .stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        if (user.isPresent()) {
            return user.get().getAmountPoints();
        } else {
            return new ReturnMessage("The user has not been found", false);
        }
    }
}
