package com.universitywest.assignment.backend.repo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.universitywest.assignment.backend.entity.Person;
@Repository
public interface PersonRepository extends CrudRepository<Person,Long> {

}
