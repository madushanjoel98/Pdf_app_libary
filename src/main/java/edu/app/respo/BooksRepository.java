package edu.app.respo;

import edu.app.domains.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
public interface BooksRepository extends JpaRepository<Books, Long> {
    List<Books> findBySubcategory_Sutid(int sutid);
    @Query(value = "select b from Books b where upper(b.book_name) like upper(?1)",nativeQuery = true)
    List<Books> findinglikekey(String book_name);


}