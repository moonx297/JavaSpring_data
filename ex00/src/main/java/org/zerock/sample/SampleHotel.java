package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
@Component
@ToString
@Getter
@RequiredArgsConstructor //생성자의 역할을 하는 어노테이션. 그렇기에 this 제거


public class SampleHotel {
	@NonNull
	private Chef chef;
	
	
}
