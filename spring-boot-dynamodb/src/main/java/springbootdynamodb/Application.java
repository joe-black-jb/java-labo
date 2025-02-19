package springbootdynamodb;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dynamodb.common.DynamoDBConfig;
import dynamodb.simple.UserRepository;

@SpringBootApplication
// @ComponentScan(basePackages = {"springbootdynamodb", "dynamodb", "dynamodb.simple", "dynamodb.common", "springbootdynamodb.controllers"}) // ここで `dynamodb` をスキャン
// @EnableDynamoDBRepositories(basePackages = {"dynamodb.simple"}) // ここを追加
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, // No JPA
		DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableDynamoDBRepositories(mappingContextRef = "dynamoDBMappingContext", basePackageClasses = UserRepository.class)
// @EnableDynamoDBRepositories(mappingContextRef = "dynamoDBMappingContext", basePackages = {"dynamodb.simple"})
@Configuration
@Import({DynamoDBConfig.class})
@RestController
public class Application {

  @RequestMapping("/")
  public String home() {
    return "Hello Docker World!";
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
