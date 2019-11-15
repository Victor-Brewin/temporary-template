package com.brewin.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brewin.common.service.UserService;


@RequestMapping("/user")
//@PreAuthorize("hasAuthority('ROLE_ADMIN')")  // 指定角色权限才能操作方法
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/")
    public String index(
                        Model model) {
        model.addAttribute("users",userService.listUsers());
        return "index";
    }
}
