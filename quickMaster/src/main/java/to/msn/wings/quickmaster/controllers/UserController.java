// エラー
// package quickMaster.src.main.java.to.msn.wings.qucickmaster.controllers;
package to.msn.wings.quickmaster.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// OAuth2.0 用
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collections;
import java.util.Map;
import org.springframework.ui.Model;

// Logger の DI 用
import to.msn.wings.quickmaster.logging.ApplicationLogger;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class UserController {
    // ApplicationLogger を DI で注入
    private final ApplicationLogger applicationLogger;

    @Autowired
    public UserController(ApplicationLogger applicationLogger) {
        this.applicationLogger = applicationLogger;
    }

    // OAuth2.0 対応
    // @GetMapping("/user")
    // public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
    //   return Collections.singletonMap("name", principal.getAttribute("name"));
    // }

    // Thymeleaf 用
    @GetMapping("/")
    public String user(@AuthenticationPrincipal OAuth2User principal, Model model) {
      // ユーザー情報をログに出力
      applicationLogger.logInfo("principal ⭐️: " + principal);

      if (principal == null) {
        return "home";
      } else {
        applicationLogger.logInfo("Username ⭐️: " + principal.getName());
        applicationLogger.logInfo("attrs ⭐️: " + principal.getAttributes());

        // model.addAttribute("name", principal.getAttribute("name"));
        model.addAttribute("user", principal.getAttributes());
      }
      return "home";  // Thymeleaf の `home.html` テンプレートを返す
    }
}
