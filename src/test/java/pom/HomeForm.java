package pom;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileReader;
import java.io.IOException;

public class HomeForm extends BasePage{

    private By inputNombre = By.xpath("//input[contains(@name,'nombre')]");
    private By inputEmail = By.xpath("//input[contains(@name,'email')]");
    private By inputEdad = By.xpath("//input[contains(@name,'edad')]");
    private By inputPass = By.xpath("//input[contains(@name,'contrasena')]");
    private By inputRepass = By.xpath("//input[contains(@name,'repetirContrasena')]");
    private By botonEnviar = By.className("submit-btn");
    private String msgOk = "Registro exitoso. Bienvenido/a,";
    private By msgOkLocator = By.id("mensajeExito");
    private String msgErrorEmail = "Por favor, introduce un email válido.";
    private By msgErrorEmailLocator = By.id("error-email");
    private String msgErrorPass = "Las contraseñas no coinciden.";
    private By msgErrorPassLocator = By.id("error-repetirContrasena");
    private String msgErrorEdad = "La edad debe ser mayor a 0.";
    private By msgErrorEdadLocator = By.id("error-edad");

    public String getMsgOk(){
        return msgOk;
    }
    public By getMsgOkLocator() {
        return msgOkLocator;
    }

    public String getMsgErrorEmail(){ return msgErrorEmail;}
    public By getMsgErrorEmailLocator(){ return msgErrorEmailLocator;}

    public String getMsgErrorPass(){ return msgErrorPass;}
    public By getMsgErrorPassLocator(){ return msgErrorPassLocator;}

    public String getMsgErrorEdad(){ return msgErrorEdad;}
    public By getMsgErrorEdadLocator(){ return msgErrorEdadLocator;}

    public void setInputNombre(String _nombre){ type(_nombre,inputNombre);}

    public void setInputEmail(String _email){type(_email, inputEmail);}

    public void setInputEdad(String _edad){ type(_edad,inputEdad);}

    public void setInputPass(String _pass){ type(_pass, inputPass);}

    public void setInputRepass(String _rePass){ type(_rePass,inputRepass);}

    public void clickBotonEnviar() throws Exception {
        this.click(botonEnviar);
    }

    public void completarFormulario(String accion){
        JSONParser jsonParser = new JSONParser();
        try {
            FileReader reader;
            switch (accion) {
                case "UsuarioOk":
                    reader = new FileReader("./src/test/resources/jsonfiles/UsuariosOk.json");
                    break;
                case "UsuarioEmailInvalido":
                    reader = new FileReader("./src/test/resources/jsonfiles/UsuariosEmailInvalido.json");
                    break;
                case "UsuarioPassNoCoincidentes":
                    reader = new FileReader("./src/test/resources/jsonfiles/UsuariosPassNoCoincidentes.json");
                    break;
                case "UsuarioEdadInvalida":
                    reader = new FileReader("./src/test/resources/jsonfiles/UsuariosEdadInvalida.json");
                    break;
                default:
                    reader = new FileReader("./src/test/resources/jsonfiles/UsuariosOk.json");
            }
            Object obj = jsonParser.parse(reader);
            JSONObject usuariojsonobj = (JSONObject)obj;

            // Se completan los datos del formulario con input del json
            setInputNombre((String)usuariojsonobj.get("nombre"));
            setInputEmail((String)usuariojsonobj.get("email"));
            setInputEdad((String) usuariojsonobj.get("edad"));
            setInputPass((String) usuariojsonobj.get("contrasena"));
            setInputRepass((String) usuariojsonobj.get("repContrasena"));

        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public HomeForm (WebDriver driver){ super(driver); }
}
