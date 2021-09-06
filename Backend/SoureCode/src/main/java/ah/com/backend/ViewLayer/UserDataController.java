package ah.com.backend.ViewLayer;

import ah.com.backend.Model.ReturnMessage;
import ah.com.backend.Model.UserData;
import ah.com.backend.Service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @class: UserDataController
 * @author: Anes Hodza
 * @version: 28.08.2021
 **/

@RestController
@RequestMapping(path = "api/users")
@CrossOrigin("*")
public class UserDataController {

    private final UserDataService userDataService;

    @Autowired
    public UserDataController(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    @GetMapping
    public List<UserData> getUsers() {
        return userDataService.getUsers();
    }

    @PostMapping(path = "/login")
    public Object attemptLogin(@RequestBody UserData userData) {
        return userDataService.attemptLogin(userData);
    }

    @GetMapping(path = "/{id}/addPoint")
    public ReturnMessage addPoint(@PathVariable Long id) {
        return userDataService.addPoint(id);
    }

    @GetMapping(path = "/{id}/myPoints")
    public Object getMyPoints(@PathVariable Long id) {
        return userDataService.getMyPoints(id);
    }

    @PutMapping
    public Object registerUser(@RequestBody UserData userData) {
        return userDataService.registerUser(userData);
    }
}
