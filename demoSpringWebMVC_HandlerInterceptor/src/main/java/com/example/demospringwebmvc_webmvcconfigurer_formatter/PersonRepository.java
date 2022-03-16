package com.example.demospringwebmvc_webmvcconfigurer_formatter;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
