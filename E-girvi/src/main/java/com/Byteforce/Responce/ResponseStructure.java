package com.Byteforce.Responce;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class ResponseStructure<T> {
	private String msg;
	private int status;
	private T data;
}
