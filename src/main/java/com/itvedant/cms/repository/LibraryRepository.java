package com.itvedant.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itvedant.cms.entity.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer>
{

}
