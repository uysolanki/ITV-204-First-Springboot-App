package com.itvedant.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itvedant.cms.entity.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer>
{

}
