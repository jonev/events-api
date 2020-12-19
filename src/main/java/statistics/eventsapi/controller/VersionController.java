package statistics.eventsapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("version")
public class VersionController {

    @Value("${app.version}")
    private String version;

    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public String getVersion() {
        return version;
    }
}
