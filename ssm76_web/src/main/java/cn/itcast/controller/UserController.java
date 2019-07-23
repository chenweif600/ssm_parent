package cn.itcast.controller;

import cn.itcast.pojo.User;
import cn.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @version V1.0
 * @author: chenweifeng
 * @date: 2019/7/19 20:39
 * @description:
 */

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("users")
    public String toUser(Model model) {
       List<User> userList = userService.queryUserList();
        model.addAttribute("userList", userList);
        return "users";
    }

    @RequestMapping("deleteUserById")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:users";
    }
}
