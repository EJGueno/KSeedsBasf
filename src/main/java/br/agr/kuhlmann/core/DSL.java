package br.agr.kuhlmann.core;

import static br.agr.kuhlmann.core.DriverFactory.getDriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {

	
	public void escrever(By by, String texto){
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(texto);
	}
		
	public void escrever(String id_campo, String texto){
		escrever(By.id(id_campo), texto);
	}
	
	
	public void clicaButton(String id) {
		getDriver().findElement(By.id(id)).click();
	}

	
	public String obterValorSucesso(String xpath) {
		return getDriver().findElement(By.xpath(xpath)).getAttribute("Sucesso");
	
	}

	public String clicaText(String valor) {
		getDriver().findElement(By.linkText(valor)).click();
		return valor;
		
	}
	public String clicaClass(String valor) {
		getDriver().findElement(By.className(valor)).click();
		return valor;
		
	}
	public String clicaCssSelector(String valor) {
		getDriver().findElement(By.cssSelector(valor)).click();
		return valor;
		
	}
	public String clicaXpath(String xpath) {
		getDriver().findElement(By.xpath(xpath)).click();
		return xpath;
		
	}
	public String clicaTagName(String tag) {
		getDriver().findElement(By.tagName(tag)).click();
		return tag;
		
	}
	
	
	
	public void selecionarCombo(String id, String valor) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
}
