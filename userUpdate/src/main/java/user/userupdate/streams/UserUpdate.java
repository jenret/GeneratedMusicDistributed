package user.userupdate.streams;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import user.userupdate.model.UpdateUser;
import user.userupdate.model.User;
import user.userupdate.repositories.UserJpaRepo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
public class UserUpdate {

    @Autowired
    private UserJpaRepo repo;

    private ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "userupdate")
    public void listenGroupUsers(String message) {
        System.out.println("Received Message in group userupdate: " + message);

        try {
            UpdateUser updatedUser = objectMapper.readValue(message, UpdateUser.class);
            System.out.println(updatedUser.toString());

            User userToChange = updatedUser.getUserToChange();
            User newUser = updatedUser.getChangesMade();

            User user = repo.findUserByEmail(userToChange.getEmail());
            user.setUsername(newUser.getUsername());
            user.setPassword(newUser.getPassword());
            user.setFirstName(newUser.getFirstName());
            user.setLastName(newUser.getLastName());
            user.setUserAddress(newUser.getUserAddress());
            user.setSongsOwned(newUser.getSongsOwned());
            user.setSongsMade(newUser.getSongsMade());
            repo.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}