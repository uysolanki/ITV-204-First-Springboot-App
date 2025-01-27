package com.itvedant.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itvedant.cms.entity.Actor;
import com.itvedant.cms.service.ActorService;

@RestController
@RequestMapping("/cms/v1")
public class ActorController {

	@Autowired
	ActorService ActorService;
	
	@PostMapping("/addActor")
	public Actor addActor(@RequestBody Actor actor)
	{
		return ActorService.addActor(actor);
	}
	
//	@DeleteMapping("/deleteActor/{ano}")
//	public String deleteActor(@PathVariable("ano") int ano)
//	{
//		ActorService.deleteActor(ano);
//		return "Actor Deleted";
//	}

}
