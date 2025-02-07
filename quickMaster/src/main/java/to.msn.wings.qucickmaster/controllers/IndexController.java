// エラー
// package quickMaster.src.main.java.to.msn.wings.qucickmaster.controllers;
package to.msn.wings.quickmaster.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Logger の DI 用
import to.msn.wings.quickmaster.logging.ApplicationLogger;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class IndexController {
  // ApplicationLogger を DI で注入
  private final ApplicationLogger applicationLogger;

  @Autowired
  public IndexController(ApplicationLogger applicationLogger) {
      this.applicationLogger = applicationLogger;
  }

  @GetMapping("/")
  public String root() {
    applicationLogger.logInfo("Hello ⭐️");
    return "home";
  }
}
