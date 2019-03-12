package com.fmc.controller.menu;

import com.fmc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @RequestMapping(value="/initMenuPage.do")
    public String initMenuPage( Model model) throws Exception {

        return "/menu/menu";
    }
}
