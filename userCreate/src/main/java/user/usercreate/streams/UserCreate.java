package user.usercreate.streams;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import user.usercreate.model.User;
import user.usercreate.repositories.UserJpaRepo;


@Component
public class UserCreate {

    @Autowired
    private UserJpaRepo repo;

    private ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "usercreate")
    public void listenGroupUsers(String message) {
        System.out.println("Received Message in group apiConsumer: " + message);

        try {
            User user = objectMapper.readValue(message, User.class);
            System.out.println("user mapped: " + user);

            repo.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}