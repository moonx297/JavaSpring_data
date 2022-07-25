package com.spring.account;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation=Propagation.REQUIRED)

//service 구간이 트랜젝션이다. 트랜젝션을 주석 처리함으로 꺼버리면 어떤 현상이 일어나나?
// -> 

public class AccountService {
	private AccountDAO accDAO;

	public void setAccDAO(AccountDAO accDAO) {
		this.accDAO = accDAO;
	}

	public void sendMoney() throws Exception {
		accDAO.updateBalance1();	//돈 빠져나가고
		accDAO.updateBalance2();	//돈 들어오는것이 동시에 일어난다. account.xml에서 확인 가능
	}
}


