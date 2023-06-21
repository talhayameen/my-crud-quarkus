package queries;

import javax.enterprise.context.RequestScoped;

import com.ibm.db2.cmx.runtime.Data;

import dto.dto;

@RequestScoped
public class queries {
    
    dto data_transfer_obj = new dto();

    public String get_all_user(){

        return "SELECT * FROM USERS";
    }

    public String add_user(){
        System.out.println(data_transfer_obj.toString());
        return "INSERT INTO USERS(user_id,user_name,user_class) VALUES ("+data_transfer_obj.getUSer_id()+",'"+data_transfer_obj.getUser_name()+"', '"+data_transfer_obj.getUser_class()+"')";
    }
    

    public String update_user(){
        return "UPDATE USERS SET USER_ID="+data_transfer_obj.getUSer_id()+", USER_NAME='"+data_transfer_obj.getUser_name()+"' WHERE USER_ID= "+data_transfer_obj.getUSer_id()+"";
    }

    // public String update_userProfileByUserId(int user_id){
    //     return "UPDATE USERS SET "
    // }
    
}
