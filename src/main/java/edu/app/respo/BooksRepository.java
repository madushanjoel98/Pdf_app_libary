package edu.app.respo;

import edu.app.domains.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Optional;


public interface BooksRepository extends JpaRepository<Books, Long> {
    List<Books> findBySubcategory_Sutid(int sutid);

    @Query("select b from Books b where b.book_name like ?1")
    List<Books> findByBook_nameLike(String book_name);


}