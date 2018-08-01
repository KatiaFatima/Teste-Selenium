package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    @Test
    public void testLogin(){
        //Abrindo o Navegador

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Katia\\Drivers\\chromedriver.exe");
        //o comando WebDriver representa o meu browser

        //Espera o Browser ser aberto para conseguir achar todos os elementos
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //Navegando para a pagina de Login
        navegador.get("http://web1.qa.sambatech.com:10000/");


        //Digitar o email avaliacao_qa_samba@sambatech.com.br no link Email que possui o ID inputEmail
       WebElement formularioInputEmail=((ChromeDriver) navegador).findElement(By.id("inputEmail"));
        formularioInputEmail.click();
        ((ChromeDriver) navegador).findElement(By.id("inputEmail")).sendKeys(new StringBuffer("avaliacao_qa_samba@sambatech.com.br"));


        // Digitar a senha 123456789 no link Senha que possui o ID password
        WebElement formularioPassord=((ChromeDriver) navegador).findElement(By.id("inputPassword"));
        ((ChromeDriver) navegador).findElement(By.id("inputPassword")).sendKeys(new StringBuffer("123456789"));

        //Clicar no link Matenha-me conectado que possui o ID rememeberMe
        WebElement MantenhaLogado=navegador.findElement(By.id("rememeberMe"));
        ((ChromeDriver) navegador).findElement(By.id("rememeberMe")).click();

        //Clicar no botão Entrar que possui ID login
        WebElement formularioLogin=((ChromeDriver) navegador).findElement(By.id("login"));
        ((ChromeDriver) navegador).findElement(By.id("login")).click();


        //Verificar que o login foi feito om sucesso.Validar o link avaliação existente na tela após login.ID navbar-project-name
        WebElement Avaliacao=navegador.findElement(By.id("navbar-project-name"));
        String textoElementoAvaliacao=Avaliacao.getText();
        assertEquals("avaliacao",textoElementoAvaliacao);



        //Fechar o Browser
        //Fecha todas as abas abertas
        navegador.close();


    }

}
