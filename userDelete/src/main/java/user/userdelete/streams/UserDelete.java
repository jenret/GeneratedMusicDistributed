package user.userdelete.streams;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import user.userdelete.model.User;
import user.userdelete.repositories.UserJpaRepo;


@Component
public class UserDelete {

    @Autowired
    private UserJpaRepo repo;

    private ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "userdelete")
    public void listenGroupUsers(String message) {
        System.out.println("Received Message in group apiConsumer: " + message);

        try {
            User user = objectMapper.readValue(message, User.class);
            System.out.println("user mapped: " + user);

            repo.deleteUserByUsername(user.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}