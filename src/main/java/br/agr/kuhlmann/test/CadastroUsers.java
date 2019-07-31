package br.agr.kuhlmann.test;

import static br.agr.kuhlmann.core.DriverFactory.getDriver;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.agr.kuhlmann.core.BaseTest;
import br.agr.kuhlmann.core.DSL;

public class CadastroUsers extends BaseTest {

	private DSL dsl;

	@Before
	public void inicializa() {
		getDriver().get("https://kseedsbayertesting.kuhlmann.agr.br");
		dsl = new DSL();

		dsl.escrever("#loginInput", "admin");
		dsl.escrever("senhaInput", "admin123");
		dsl.clicaButton("loginBtn");

	}

	@Test
	public void CadastroUserSucesso() {

		int random = (int) (Math.random() * 10000);
		Set<Integer> numeros = new TreeSet<Integer>();
		Random rand = new Random();
		while (numeros.size() < 1) {
			numeros.add(rand.nextInt(10000));
		}

		dsl.clicaButton("dropdownMenuButton2");
		dsl.clicaText("Kuhlmann Monitoramento Agrícola");
		dsl.clicaText("ADMINISTRAÇÃO");
		dsl.clicaText("USUÁRIOS");
		dsl.clicaText("Adicionar");
		dsl.escrever("nm_usuario", "User" + random);
		dsl.escrever("login", "user" + random);
		dsl.escrever("email", random + "user@gmail.com");
		dsl.selecionarCombo("language", "Português");
		dsl.clicaCssSelector("#form1 > div:nth-child(4) > div > button.btn.btn-success");
		getDriver().findElement(By.linkText("Sucesso: O item foi criado."));

	}
}
