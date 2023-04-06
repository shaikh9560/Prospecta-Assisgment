package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Entity.All_Entry_DTO;
import com.example.demo.Entity.Entry;
import com.example.demo.Entity.EntryDTO;
import com.example.demo.Excpetion.EntryExpection;
import com.example.demo.Repo.Entry_Repo;

@Service
public class Entry_Implemetation  implements EntryService{

	  @Autowired
	  private Entry_Repo ERepo;
	  
	  @Autowired
	  private RestTemplate restTemplate;
	
	
	@Override
	public List<EntryDTO> getEntryByCategory(String category) throws EntryExpection {
		String uri = "https://api.publicapis.org/entries";
		
		ResponseEntity<All_Entry_DTO> resp = restTemplate.getForEntity(uri, All_Entry_DTO.class);
		
       System.out.println(resp.getBody().getEntries());
       
       List<EntryDTO> lst = new ArrayList<>();
       
       for(Entry i:resp.getBody().getEntries()) {
    	   if(category.equals(i.getCategory())) {
    		   lst.add(new EntryDTO(i.getTitle(),i.getDescription()));
    	   }
    	   
    	   System.out.println(lst);
       }
       if(lst.size()==0) {
    	   throw new EntryExpection("No entry found with category"+category);
       }
       else {
    	   return lst;
       }
		
	}

	@Override
	public Entry SaveEntry() {
		
		String URL = "https://api.publicapis.org/entries";
		ResponseEntity<All_Entry_DTO> resp = restTemplate.getForEntity(URL, All_Entry_DTO.class);
		Entry en = resp.getBody().getEntries().get(0);
		return ERepo.save(en);
	}

}
