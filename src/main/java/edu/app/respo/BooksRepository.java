package edu.app.respo;

import edu.app.domains.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BooksRepository extends JpaRepository<Books, Long> {
    List<Books> findBySubcategory_Sutid(int sutid);



}