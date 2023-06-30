package gic.i4c.tp16c.Tp16Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Tp16Controller {
    @GetMapping("/tp16/task1")
    public String index() {
        return "<h1>Welcome to TP16 Task1</h1>";
    }

    @GetMapping("/tp16/task2")
    public ModelAndView taske2() {
        ModelAndView mnv = new ModelAndView("task2");
        // mnv.addObject("username", "luna");
        return mnv;
    }
    @GetMapping("/tp16/task3")
    public Object task3(){
        return new ModelAndView("task3");
    }
    @GetMapping("/tp16/task4")
    public Object task4(){
        return new ModelAndView("task4");
    }
    @GetMapping("/tp16/task5")
    public Object task5(String username, String password){
        if(username.equals("vysingsun")&&password.equals("123456")){
            return new ModelAndView("task5");
        }
        return new ModelAndView("task2");
    }
}
