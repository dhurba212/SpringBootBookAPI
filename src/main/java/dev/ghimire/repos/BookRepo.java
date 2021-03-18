package dev.ghimire.repos;

import dev.ghimire.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Component //please read this class/interface and use it to make beans
@Repository //Stereotype saying this interface is used to save data
//<entity,type of the primary key>
public interface BookRepo extends CrudRepository<Book,Integer> {
    //u can define extra methods for your repos
    //Spring data will auto create the implementatin for it
    //u must follow spring data naming convention for abstract methods
    Set<Book> findBooksByBookCondition(int condition);
    Set<Book>findBooksByAuthorLike(String author);

    //findEntityByFieldCondition
    Set<Book> findBooksByBookConditionBetween(int lower,int higher);
}
