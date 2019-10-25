package com.codewithmansoor;

import java.io.File;
import java.io.FileInputStream;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/greet")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @POST
    public void showme(String input) {
        File file = new File("/Users/pankaj/source.txt" + input);
        byte[] b = new byte[100];
        try (FileInputStream fis = new FileInputStream(file)) {
            fis.read(b);
        }

        catch (Exception e) {
            // TODO: handle exception

            System.err.println("Desktop is not supported");
        }
        // first check if Desktop is supported by Platform or not
        // let's try to open PDF file
        // desktop.open(file);
    }
}