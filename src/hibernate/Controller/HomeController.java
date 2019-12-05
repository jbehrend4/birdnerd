package hibernate.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

public class HomeController {
    @RequestMapping("/")
    public String showHomePage(HttpServletRequest request, Model model) {
        return "index";
    }


    @RequestMapping("/errors")
    public String showError(HttpServletRequest request, Model model) {
        int code = (Integer) request.getAttribute("javax.servlet.error.status_code");

        String errorMessage = "";

        switch (code) {
            case 400:
                errorMessage = "Bad Request";
                break;
            case 404:
                errorMessage = "Page Not Found";
                break;
            case 500:
                errorMessage = "Internal Service Error";
                break;
            default:
                errorMessage = "An unknown error has occurred";
        }

        model.addAttribute("error", errorMessage);

        return "errors";
    }
}
