package com.itvedant.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itvedant.cms.entity.Library;
import com.itvedant.cms.service.LibraryService;

@RestController
@RequestMapping("/cms/v1")
public class LibraryController {
	
	@Autowired
	LibraryService libraryService;
	
	@PostMapping("/addLibrary")
	public Library addLibrary(@RequestBody Library library)
	{
		return libraryService.addLibrary(library);
	}
	
	@DeleteMapping("/deleteLibrary/{lno}")
	public String deleteLibrary(@PathVariable("lno") int lno)
	{
		libraryService.deleteLibrary(lno);
		return "Library Deleted";
	}

}
