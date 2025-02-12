// package quickMaster.src.main.java.to.msn.wings.qucickmaster.controllers;
package quickmaster.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

public class ErrorController {
  @GetMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
      Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
      model.addAttribute("error", "認証に失敗しました。");
      return "error"; // error.html を表示
    }

    public String getErrorPath() {
      return "/error";
    }
}
