package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class TesteLoginInvalido {

    @Test
    public void testLoginIvalido() throws InterruptedException {
        //Abrindo o Navegador

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Katia\\Drivers\\chromedriver.exe");
        //o comando WebDriver representa o meu browser
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //Navegando para a pagina de Login
        navegador.get("http://web1.qa.sambatech.com:10000/");

        //Digitar o email inválido no link Email que possui o ID inputEmail
        WebElement formularioInputEmail = ((ChromeDriver) navegador).findElement(By.id("inputEmail"));
        formularioInputEmail.click();
        ((ChromeDriver) navegador).findElement(By.id("inputEmail")).sendKeys(new StringBuffer("fkatia.infor@gmail.com"));


        // Digitar a senha 123456789 no link Senha que possui o ID password
        WebElement formularioPassord = ((ChromeDriver) navegador).findElement(By.id("inputPassword"));
        ((ChromeDriver) navegador).findElement(By.id("inputPassword")).sendKeys(new StringBuffer("123456789"));

        //Clicar no botão Entrar que possui ID login
        WebElement formularioLogin = ((ChromeDriver) navegador).findElement(By.id("login"));
        ((ChromeDriver) navegador).findElement(By.id("login")).click();

        //Verificar que o login não foi feito.Validar a mensagem após clicar no botão Entrar.ID password_incorrect
        WebElement LoginInvalido=navegador.findElement(By.id("password_incorrect"));
        String textoElementoLoginInvalido=LoginInvalido.getText();
     assertEquals("Email ou senha incorretos. Saiba Mais",textoElementoLoginInvalido);

        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Clicar no Link Esqueci Minha Senha
        navegador.findElement(By.xpath("//*[@id=\"forgot-pwd-link\"]")).click();

        //Escrever Email para recuperar a Senha
        WebElement RecuperarSenha = ((ChromeDriver) navegador).findElement(By.name("email"));
        RecuperarSenha.click();
        ((ChromeDriver) navegador).findElement(By.name("email")).sendKeys(new StringBuffer("avaliacao_qa_samba@sambatech.com.br"));

        //Clicar no botão Prosseguir que possui xpath //*[@id="type-email"]/div[2]/div[1]/button
        WebElement Prosseguir = ((ChromeDriver) navegador).findElement(By.xpath("//*[@id=\"type-email\"]/div[2]/div[1]/button"));
        Prosseguir.click();


        //Fechar o Browser
        navegador.close();


    }
}