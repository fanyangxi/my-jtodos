package jtodos.repository;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by yxfan on 9/28/15.
 */

@Transactional
public interface UserRepository extends CrudRepository<jtodos.domain.User, Long> {
//    public Iterable<Person> findByName(String name);
//
//    @Query("select p from Person p where p.name = :name order by p.name")
//    public Iterable<Person> findByNameUsingJPQL(@Param("name") String name);
}
