package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Entry;
import com.example.demo.Entity.EntryDTO;
import com.example.demo.Excpetion.EntryExpection;
import com.example.demo.Service.EntryService;

@RestController
public class EntryController {
	
	@Autowired
	private EntryService entryService;
	
	
	@PostMapping("/Entries")
	public ResponseEntity<Entry>SaveEntryHandler()
	
	{
		Entry en = entryService.SaveEntry();
		return new ResponseEntity<Entry>(en,HttpStatus.OK);
	}
	
	
	@GetMapping("/entries/{category}")
	public ResponseEntity<List<EntryDTO>>findEntryBycategoryHandler(@PathVariable("category")String category) throws EntryExpection
	
	{	
     List<EntryDTO>	l = entryService.getEntryByCategory(category);
     return new ResponseEntity<>(l,HttpStatus.OK);
		
	}

}
