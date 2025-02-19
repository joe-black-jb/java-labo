package springbootdynamodb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dynamodb.simple.User;
import dynamodb.simple.UserRepository;
import springbootdynamodb.logging.ApplicationLogger;


@RestController
public class DynamoController {

  private final ApplicationLogger log;

  @Autowired
  public DynamoController(ApplicationLogger log) {
    this.log = log;
  }

  @Autowired UserRepository userRepository;

  @GetMapping("/dynamo/user")
  public Iterable<User> getDynamoUser() {
    log.info("ユーザ取得処理開始 ⭐️");
    return userRepository.findAll();
  }

  @PostMapping("/dynamo/user")
  public User postDynamoUser(@RequestBody User user) {
    log.info("ユーザ登録処理開始 ⭐️");
    log.info(String.format("user ⭐️: %s", user));
    // User user
    userRepository.save(user);
    return user;
  }
}
