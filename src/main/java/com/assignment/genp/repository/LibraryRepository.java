package com.assignment.genp.repository;
import com.assignment.genp.models.Book;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Sort;
import com.assignment.genp.models.Library;
import java.util.List;

public interface LibraryRepository extends CrudRepository<Library, Long> {


}
