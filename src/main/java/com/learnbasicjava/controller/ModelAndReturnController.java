package com.learnbasicjava.controller;

import com.learnbasicjava.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class ModelAndReturnController {
    @RequestMapping("/output/r1")
    public String method1() {
        return "model-and-return/demo1";
    }

    /**
     * if void => return url
     */
    @RequestMapping("/model-and-return/demo1")
    public void method2() {

    }

    /**
     * forward => keep url
     * method1 continue excute
     *
     * @param model
     * @return
     */
    @RequestMapping("/return/r3")
    public String method3(Model model) {
        model.addAttribute("x", "I Come from Method 3");
        return "forward:/output/r1";
    }

    /**
     * * change url to /output/r1
     * chuyen huong voi att => set in url (nhu @RequestParams), nhu method get)
     *
     * @param params
     * @return
     */
    @RequestMapping("/return/r4")
    public String method4(RedirectAttributes params) {
        params.addAttribute("x", "I Come from Method 4");
        return "redirect:/output/r1";
    }

    /**
     * change url to /output/r1
     * excute method5 finish --> excute method1
     * model at method5 was remove
     *
     * @param model
     * @return
     */
    @RequestMapping("/return/r5")
    public String method5(Model model) {
        model.addAttribute("x", "I Come from Method 5");
        return "redirect:/output/r1";
    }

    /**
     * Demo  rest api
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/return/r6")
    public String method6() {
        List<User> list = Arrays.asList(
                new User("A", "789"),
                new User("B", "345"));
        return list.toString();
    }
}
