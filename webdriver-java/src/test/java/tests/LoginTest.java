package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    @Test
    public void testLogin(){
        //Abrindo o Navegador
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Katia\\Drivers\\chromedriver.exe");
        //o comando WebDriver representa o meu browser
        //variavel do navegador do tipo WebDriver chamada navegador
        //variavel navegador tenha uma instancia do chrome
        WebDriver navegador=new ChromeDriver();

        //Navegando para a pagina de Login
        navegador.get("http://web1.qa.sambatech.com:10000/");

        //Clicar no Link Email




        //Validação
        assertEquals(1,1);
    }

}
