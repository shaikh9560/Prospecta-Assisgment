package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.Entity.Entry;
import com.example.demo.Entity.EntryDTO;


@Repository
public interface Entry_Repo extends JpaRepository<Entry, Integer> {
	public List<EntryDTO> findByCategory(String category);
}
