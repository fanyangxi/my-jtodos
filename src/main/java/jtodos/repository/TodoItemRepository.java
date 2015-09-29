package jtodos.repository;

import jtodos.domain.TodoItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by yxfan on 9/28/15.
 */

public interface TodoItemRepository extends CrudRepository<jtodos.domain.TodoItem, Long> {

//    //new jtodos.domain.TodoItem(t.name, t.content)
//
//    @Query("select t "
//            + "from todoitems t "
//            + "where t.userid = ? "
//            + "order by t.name ASC")
//    public List<TodoItem> findUserSpecificTodoItems(long userId);

//    Iterable<TodoItem> findUserSpecificTodoItems(long userId);
}
