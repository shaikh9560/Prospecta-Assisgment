package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Entry;
import com.example.demo.Entity.EntryDTO;
import com.example.demo.Excpetion.EntryExpection;

public interface EntryService {
	
	public List<EntryDTO> getEntryByCategory(String category) throws EntryExpection;
    public Entry SaveEntry();
}
