package com.example.demo.Excpetion;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Error_Details {
	
	private String message;
	private String description;
	private LocalDateTime dateTime;

}
