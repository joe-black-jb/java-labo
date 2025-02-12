// qucickmaster を quickmasters とかにすると /hello にアクセスしてもエラーになる
package quickmaster.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

@Controller
public class HelloController {
  @GetMapping("/hello")
  @ResponseBody
  public String index() {
    return "こんにちは、世界！";
  }

  @GetMapping("/greet")
  // Handler メソッド (grreet) に
  // Model 型の引数を渡すと Thymeleaf にデータを渡せる
  public String greet(Model model) {
    model.addAttribute("message", "こんにちは、世界！");
    return "greet";
  }
}
