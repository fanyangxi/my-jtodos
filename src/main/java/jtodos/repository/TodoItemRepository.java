package jtodos.repository;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by yxfan on 9/28/15.
 */

@Transactional
public interface TodoItemRepository extends CrudRepository<jtodos.domain.TodoItem, Long> {
}
