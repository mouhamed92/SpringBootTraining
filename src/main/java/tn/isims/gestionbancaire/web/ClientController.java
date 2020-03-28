package tn.isims.gestionbancaire.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {

    @GetMapping(path ="client")
    public String Client(){
        return "client";
    }
    @GetMapping(path = "index")
    public String index(){

        return "index" ;
    }

}
