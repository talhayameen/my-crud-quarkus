package web;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.hibernate.annotations.Polymorphism;

import dto.dto;
import services.user_service;


@Path("/dexter")
public class webResource {
    
    @Inject
    user_service service;

    @Inject 
    dto dto;


    @GET
    @Path("/userdetails")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String hello(){
        return service.details();
    }

    @POST
    @Path("/adduser")
    public String adduser(@QueryParam(value = "id") int id){
        return service.UserUpdateProfile(id);    
    }

    @DELETE
    @Path("/deleteUser/{id}")
    public String deleteuser(@PathParam(value = "id") int id){
        System.out.println("working");
        return service.UserDeleteProfile(id);
    }

}
