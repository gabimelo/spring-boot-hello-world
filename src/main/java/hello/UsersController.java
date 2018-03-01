package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class UsersController {

    @Autowired
    private UserRepository repository;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public String usersList() {

        String users = "Users: ";

        for (User user : repository.findAll()) {
          users += user.userName + ", ";
        }

        return users;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public @ResponseBody List<User> addUser(@RequestParam(value="userName", required=true) String userName) {

        repository.save(new User(userName));

        List<User> insertedUser = repository.findByUserName(userName);

        return insertedUser;
    }

}
