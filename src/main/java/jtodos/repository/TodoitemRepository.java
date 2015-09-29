package jtodos.repository;

import jtodos.domain.Todoitem;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by yxfan on 9/28/15.
 */

public interface TodoitemRepository extends CrudRepository<Todoitem, Long> {

//    //new jtodos.domain.Todoitem(t.name, t.content)
//
//    @Query("select t "
//            + "from todoitems t "
//            + "where t.userid = ? "
//            + "order by t.name ASC")
//    public List<Todoitem> findUserSpecificTodoitems(long userId);

//    Iterable<Todoitem> findUserSpecificTodoitems(long userId);
}
