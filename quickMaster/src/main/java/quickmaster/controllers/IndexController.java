// エラー
// package quickMaster.src.main.java.to.msn.wings.qucickmaster.controllers;
package quickmaster.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import quickmaster.logging.ApplicationLogger;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class IndexController {
  // ApplicationLogger を DI で注入
  private final ApplicationLogger applicationLogger;

  @Autowired
  public IndexController(ApplicationLogger applicationLogger) {
      this.applicationLogger = applicationLogger;
  }

  @GetMapping("/sample")
  public String root() {
    applicationLogger.logInfo("Hello ⭐️");
    return "home";
  }
}
