package com.codewithmansoor;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/greet")
public class GreetingResource {
    final Logger logger = LoggerFactory.getLogger(GreetingResource.class);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @POST
    public void showmeError(String input) {
        java.nio.file.Path filePath = Paths.get("/tmp", input);
        if (!Files.exists(filePath)) {
            logger.warn("File does not exist", filePath.toAbsolutePath().toString());
            return;
        }
        // expect to see error
        File file = new File("/Users/pankaj/source.txt" + input);
        byte[] b = new byte[100];
        try (FileInputStream fis = new FileInputStream(file)) {
            fis.read(b);
        }

        catch (Exception e) {
            logger.error("Err", e);
        }
        // first check if Desktop is supported by Platform or not
        // let's try to open PDF file
        // desktop.open(file);
    }
}