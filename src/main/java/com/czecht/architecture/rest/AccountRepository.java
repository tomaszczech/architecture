package com.czecht.architecture.rest;

import org.springframework.data.jpa.repository.JpaRepository;

import com.google.common.base.Optional;

/**
 * Created by czecht on 2017-08-17.
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
	Optional<Account> findByUsername(String username);
}
