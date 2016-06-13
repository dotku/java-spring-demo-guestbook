package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

@Controller
public class EntryController {

	@Autowired
	EntryRepository repository;


	@RequestMapping("/entry/{id}")
	public String entry(@PathVariable Long id, Model model) {
        model.addAttribute("entry", repository.findOne(id));
        return "entry";
	}

    @RequestMapping(value="/entries",method=RequestMethod.GET)
	public String entriesList(Model model) {
        model.addAttribute("entries", repository.findAll());
        return "entries";
	}

    @RequestMapping(value="/entries",method=RequestMethod.POST)
	public String entriesAdd(@RequestParam String content, 
						@RequestParam String username, 
						Model model) {
        Entry newentry = new Entry();
        newentry.setContent(content);
        newentry.setUsername(username);

        repository.save(newentry);

        model.addAttribute("entry", newentry);
        return "redirect:/entry/" + newentry.getId();
	}

    @RequestMapping(value="/entry/{id}/skills", method=RequestMethod.POST)
	public String entriesAddSkill(@PathVariable Long id, @RequestParam Long skillId, Model model) {
    	Entry entry = repository.findOne(id);

    	if (entry != null) {

    		repository.save(entry);
            model.addAttribute("entry", repository.findOne(id));

            return "redirect:/entry/" + entry.getId();
    	}

        model.addAttribute("entries", repository.findAll());
        return "redirect:/entries";
    }

}
