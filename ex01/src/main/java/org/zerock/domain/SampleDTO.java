package org.zerock.domain;

import lombok.Data;

@Data //lombok = @ToString + @Setter + @Getter + @AllArgsContructor 다 포함하고 있다.
//@component를 쓰거나 @data를 쓰면 된다.
public class SampleDTO {
	
	private String name;
	private int age;
}
