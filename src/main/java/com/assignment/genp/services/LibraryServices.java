package com.assignment.genp.services;

import java.util.List;

import com.assignment.genp.exceptions.LibrarayNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.genp.models.Library;
import com.assignment.genp.repository.LibraryRepository;
@Service
public class LibraryServices  extends GenericService{
	
	@Autowired
	LibraryRepository libraryRepository;
	@Autowired
	BooksServices booksServices;

	public Library getLibrary(long id) {
		return libraryRepository.findById(id).orElseThrow(()->new LibrarayNotFoundException("Library not Found with " +
				"given id: "+id));

	}

	public List<Library> getLibraries() {
		return (List<Library>)libraryRepository.findAll();
	}
	/***
	 * public List<Library> getLibraries(int offset,int limit) {
	 * 		Pageable paging = PageRequest.of(offset, limit);
	 * 		Page<Library> pagedResult = libraryRepository.findAll(paging);
	 * 		if(pagedResult.hasContent()) {
	 * 			return pagedResult.getContent();
	 *                } else {
	 * 			return new ArrayList<Library>();
	 *        }    * 	}
	 */

	/***
	 *
	 * @param libraryToBeAdded
	 * @return
	 */

	public Library addLibrary(Library libraryToBeAdded) {
		return libraryRepository.save(libraryToBeAdded);
	}

	public Library updateLibrary(long id, Library libraryDetails) {
		return libraryRepository.save(libraryDetails);
	}

}
