package com.example.demo;

import com.example.demo.repository.Account;
import com.example.demo.repository.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class DemoApplicationTests {

	@Autowired
	private WebTestClient webClient;

	@Test
	public void whenCallingAccountsUrl_returnsHttpStatusOk() {

		webClient.get()
				.uri("/accounts")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk();

	}

	@Test
	public void whenCallingCustomerWithIdUrl_returnsHttpStatusOkAndData(){

		webClient.get()
				.uri("/accounts/customer/15001")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectBody(Customer.class);

	}

	@Test
	public void whenCallingAccountsViewIdUrl_returnsHttpStatusOk(){

		webClient.get()
				.uri("/accounts/customer/view/15001")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk();

	}

	@Test
	public void whenCallingAccountTransactionViewIdURl_returnsHttpStatusOk(){
		webClient.get()
				.uri("/accounts/transaction/view/16001")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk();

	}

}

