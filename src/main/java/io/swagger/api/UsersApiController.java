package io.swagger.api;

import io.swagger.configuration.UserCreateProducer;
import io.swagger.configuration.UserDeleteProducer;
import io.swagger.configuration.UserUpdateProducer;
import io.swagger.model.User;
import io.swagger.model.Users;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.repositories.UserJpaRepository;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-03-04T01:37:48.013595613Z[GMT]")
@RestController
public class UsersApiController implements UsersApi {

    private static final Logger log = LoggerFactory.getLogger(UsersApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private UserJpaRepository repo;

    @Autowired
    private UserCreateProducer createProducer;

    @Autowired
    private UserDeleteProducer deleteProducer;

    @Autowired
    private UserUpdateProducer updateProducer;

    @org.springframework.beans.factory.annotation.Autowired
    public UsersApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> deleteUser(@Parameter(in = ParameterIn.PATH, description = "Username of user that needs to be deleted", required=true, schema=@Schema()) @PathVariable("username") String username) {
        try {
            User user = repo.findUserByUsername(username);
            deleteProducer.send(user.toString());
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<User> getUserByEmail(@Parameter(in = ParameterIn.PATH, description = "User email", required=true, schema=@Schema()) @PathVariable("email") String email) {
        try {
            User user = repo.findUserByEmail(email);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<User> getUserByUsername(@Parameter(in = ParameterIn.PATH, description = "Username", required=true, schema=@Schema()) @PathVariable("username") String username) {
        try {
            User user = repo.findUserByUsername(username);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Users> getUsers() {
        try {
            List<User> users = repo.findAll();
            Users userList = new Users();
            for(User user: users){
                userList.add(user);
            }
            return new ResponseEntity<Users>(userList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Users>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Users> postUser(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody User body) {
        try {
            System.out.println(body);
            createProducer.send(body.toString());
            return getUsers();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Users>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<User> updateUserByUsername(@Parameter(in = ParameterIn.PATH, description = "Username of user that needs to be updated", required=true, schema=@Schema()) @PathVariable("username") String username,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody User body) {
        try {
            User user = repo.findUserByUsername(username);
            String message = "{ \n" + "\"userToChange\": " +  user.toString() + ",\n \"changesMade\": " + body + "\n }";
            updateProducer.send(message);
            return getUserByEmail(user.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
