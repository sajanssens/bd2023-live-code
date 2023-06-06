package nl.belastingdienst.rest;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

// http(s)://serveraddress:serverport/context-root/...
// http(s)://localhost:9080/rest/api/
@ApplicationPath("api")
public class App extends Application {

    // dit is onze "main"

}
