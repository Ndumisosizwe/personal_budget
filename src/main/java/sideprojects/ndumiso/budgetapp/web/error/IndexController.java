package sideprojects.ndumiso.budgetapp.web.error;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Ndumiso on 1/28/2018.
 */
@Controller
public class IndexController implements ErrorController {

    private static final String PATH = "/error";

    private HttpServletRequest httpServletRequest;

    public IndexController(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    @GetMapping(PATH)
    @ResponseBody
    public String error() {
        return "Resource does not exist";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
