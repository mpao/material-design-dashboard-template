package it.tim.applicationname;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("api/")
public class ApiController {

    private int sleepForMillisecs(){
        // aspetta da 5 a 15 secondi
        return ThreadLocalRandom.current().nextInt(5, 16) * 1000;
    }

    @GetMapping(value = "sample-1", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String sample01() throws InterruptedException {
        Thread.sleep(this.sleepForMillisecs());
        return "{\n" +
                "  \"title\": \"Giornate Piovose\",\n" +
                "  \"description\": \"I dati sono aggiornati ad oggi. Rappresentano i valori mensili per le giornate di maltempo\",\n" +
                "  \"data\": {\n" +
                "    \"gennaio\": 18,\n" +
                "    \"febbraio\": 15,\n" +
                "    \"marzo\": 9,\n" +
                "    \"aprile\": 10,\n" +
                "    \"maggio\": 11\n" +
                "  }\n" +
                "}";
    }

    @GetMapping(value = "sample-2", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String sample02() throws InterruptedException {
        Thread.sleep(this.sleepForMillisecs());
        return "{\n" +
                "  \"title\": \"Giornate Soleggiate\",\n" +
                "  \"description\": \"I dati sono aggiornati ad oggi. Rappresentano i valori mensili per le giornate di sole\",\n" +
                "  \"data\": {\n" +
                "    \"gennaio\": 3,\n" +
                "    \"febbraio\": 2,\n" +
                "    \"marzo\": 3,\n" +
                "    \"aprile\": 7,\n" +
                "    \"maggio\": 4\n" +
                "  }\n" +
                "}";
    }

    @GetMapping(value = "error", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String error() throws InterruptedException {
        Thread.sleep(this.sleepForMillisecs());
        throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "In caso di errore, le API sono progettate per inviare un messaggio all'utente.");
    }

}
