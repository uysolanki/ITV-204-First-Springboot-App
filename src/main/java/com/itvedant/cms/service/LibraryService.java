package com.itvedant.cms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.cms.entity.Library;
import com.itvedant.cms.repository.LibraryRepository;

@Service
public class LibraryService {

	@Autowired
	LibraryRepository libraryRepository;
	
	public Library addLibrary(Library library) {
		return libraryRepository.save(library);
	}

	public void deleteLibrary(int lno) {
		libraryRepository.deleteById(lno);
	}

}
