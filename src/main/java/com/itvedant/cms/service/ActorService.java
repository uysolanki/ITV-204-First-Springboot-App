package com.itvedant.cms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.cms.entity.Actor;
import com.itvedant.cms.repository.ActorRepository;

@Service
public class ActorService {

	@Autowired
	ActorRepository actorRepository;
	
	public Actor addActor(Actor actor) {
		return actorRepository.save(actor);
	}

}
