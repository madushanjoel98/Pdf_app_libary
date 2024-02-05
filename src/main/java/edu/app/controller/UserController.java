package edu.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
@GetMapping("/login")
public String loadlogin() {
	return "login.html";
}
@GetMapping("/")
public String mainPage() {
	return "/view/mainpage.html";
}
@GetMapping("/logout")
public String logout() {
	return "redirect:/login";
}
}
