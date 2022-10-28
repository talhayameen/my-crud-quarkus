package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.apache.http.impl.execchain.RetryExec;

import com.ibm.db2.jcc.am.dt;
import com.ibm.db2.jcc.am.s;

import Connections.connection;
import dto.dto;
import queries.queries;


@RequestScoped
public class user_service {
    
    @Inject
    connection datasource;

    @Inject
    queries userQueries;

    dto dto = new dto();

    int user_id;
    String user_name;
    String user_Class;
    String user_details;

    public String details(){

        try (
            
            Connection con = datasource.getconnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(userQueries.get_all_user());) {


                while (resultSet.next()) {
                    System.out.println("Welldone my boi");
                    user_id = resultSet.getInt("user_id");
                    user_name = resultSet.getString("user_name");
                    user_Class = resultSet.getString("user_Class");
                    this.user_details = "The user with id : " + user_id + " known as : " +user_name + " is in class : " + user_Class + ".";
                    System.out.println(("user_details"));
                }
            


            return user_details;

        } catch (Exception e) {
            // TODO: handle exception
            e.getStackTrace();
        }
        return "Un-done";
    }

    public String addUser(dto dto) {

        try (
            
            Connection connection = datasource.getconnection();
            Statement statement = connection.createStatement();

        ){
            int resultSet = statement.executeUpdate(userQueries.add_user());
            System.out.println("Added Successfully");
        }
        
        
        
        catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return null;
    }

    public String UserUpdateProfile(int user_id){

        try (
            Connection connection = datasource.getconnection();
            Statement statement = connection.createStatement();

        )
        {
            System.out.println("Profile update is working..");
            System.out.println("student id =="+user_id);
            int resultSet = statement.executeUpdate("UPDATE STUDENTS SET STUDENT_ID=1010100 ,STUDENT_NAME ='ARAHAMA NASIR' WHERE STUDENT_ID = "+user_id);
            return "Student Profile has been updated.";
        
            
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
        return null;

    }

    public String UserDeleteProfile(int user_id){

        try(
            Connection connection = datasource.getconnection();
            Statement statement = connection.createStatement();

        ) {

            System.out.println("Profile deleted is working..");
            System.out.println("student id == "+user_id);
             statement.executeUpdate("DELETE(SELECT * FROM USERS WHERE USER_ID="+user_id+")");
            return " Student Profile has been deleted. ";

        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
        return null;
    }

}
