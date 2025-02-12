package to.msn.wings.quickmaster;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Bean の練習
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.ConfigurableApplicationContext;

// OAuth2.0 対応
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// WebSecurityConfigurerAdapter は Spring Security 6 以降は使えないので
// 代わりに SecurityFilterChain を使う
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@RestController
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

  // https://spring.io/guides/tutorials/spring-boot-oauth2#github-register-application で記載されていたコード
  // => おそらく古いのでコメントアウト
  // @Override
  // protected void configure(HttpSecurity http) throws Exception {
  //   // @formatter:off
  //   http
  //     .authorizeRequests(a -> a
  //       .antMatchers("/", "/error", "/webjars/**").permitAll()
  //       .anyRequest().authenticated()
  //     )
  //     .exceptionHandling(e -> e
  //       .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
  //     )
  //     .oauth2Login();
  //   // @formatter:on
  // }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
      .authorizeHttpRequests(auth -> auth
        .requestMatchers("/", "/error", "/webjars/**").permitAll()
        .anyRequest().authenticated()
      )
      // .exceptionHandling(e -> e
      //   .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
      // )
      // exception 発生時に /error へリダイレクトするよう修正
      .exceptionHandling(e -> e
        .authenticationEntryPoint((request, response, authException) -> 
          response.sendRedirect("/error")
        )
      )
      .oauth2Login();
    return http.build();
  }

  /*
  CommandLineRunner
    - アプリ起動時に実行される
    - SB (Spring Boot) もしくはアプリによって作成された beans を取得しソートし、プリントしている
   */
  // @Bean
  // public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
  //   return args -> {
  //     System.out.println("Let's inspect the beans provided by Spring Boot:");

  //     String[] beanNames = ctx.getBeanDefinitionNames();
  //     Arrays.sort(beanNames);
  //     for (String beanName : beanNames) {
  //       System.out.println(beanName);
  //     }
  //   };
  // }
}

