package to.msn.wings.quickmaster.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import to.msn.wings.quickmaster.logging.ApplicationLogger;

@Controller
public class LogOutController {
  private final ApplicationLogger applicationLogger;

  @Autowired
  public LogOutController(ApplicationLogger applicationLogger) {
    this.applicationLogger = applicationLogger;
  }

  @PostMapping("/logout")
  public String logout(HttpSecurity http) throws Exception {
    applicationLogger.logInfo("ログアウト実行⭐️");
    http.logout(l -> l
      .logoutSuccessUrl("/").permitAll()
    ).csrf(c -> c
      .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
    );
    return "home";
  }
}
