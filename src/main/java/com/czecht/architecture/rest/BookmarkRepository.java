package com.czecht.architecture.rest;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by czecht on 2017-08-17.
 */
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
	Collection<Bookmark> findByAccountUsername(String username);
}
