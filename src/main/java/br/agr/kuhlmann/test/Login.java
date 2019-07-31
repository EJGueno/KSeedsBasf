package br.agr.kuhlmann.test;

import static br.agr.kuhlmann.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.agr.kuhlmann.core.BaseTest;
import br.agr.kuhlmann.core.DSL;

public class Login extends BaseTest {
			
	private DSL dsl;
	
	@Before
	public void inicializa() {
		getDriver().get("https://kseedsbayertesting.kuhlmann.agr.br");
		dsl = new DSL();
		
	}
	
	@Test
	public void loginSucesso() {
		dsl.escrever("#loginInput", "admin");
		dsl.escrever("senhaInput", "admin123");
		dsl.clicaButton("loginBtn");
		Assert.assertEquals("Kseeds Bayer", getDriver().getTitle());
		
	}
	
	@Test
	public void loginFalha() {
		dsl.escrever("#loginInput", "admin");
		dsl.escrever("senhaInput", "44441544");
		dsl.clicaButton("loginBtn");
		Assert.assertEquals("Kseeds", getDriver().getTitle());
						
	}
	
}
