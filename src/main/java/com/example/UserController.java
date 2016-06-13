package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

	@Autowired
	UserRepository repository;


	@RequestMapping("/User/{id}")
	public String User(@PathVariable Long id, Model model) {
        model.addAttribute("User", repository.findOne(id));
        return "User";
	}

    @RequestMapping(value="/users",method=RequestMethod.GET)
	public String usersList(Model model) {
        model.addAttribute("users", repository.findAll());
        return "users";
	}

    @RequestMapping(value="/users",method=RequestMethod.POST)
	public String usersAdd(@RequestParam String content, 
						@RequestParam String username, 
						Model model) {
        User newUser = new User();
        newUser.setUsername(username);

        repository.save(newUser);

        model.addAttribute("User", newUser);
        return "redirect:/User/" + newUser.getId();
	}

    @RequestMapping(value="/User/{id}/skills", method=RequestMethod.POST)
	public String usersAddSkill(@PathVariable Long id, @RequestParam Long skillId, Model model) {
    	User User = repository.findOne(id);

    	if (User != null) {

    		repository.save(User);
            model.addAttribute("User", repository.findOne(id));

            return "redirect:/User/" + User.getId();
    	}

        model.addAttribute("users", repository.findAll());
        return "redirect:/users";
    }

}
