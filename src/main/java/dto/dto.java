package dto;
import javax.enterprise.context.RequestScoped;;



@RequestScoped
public class dto {
    

    private int user_id;
    private String user_name;
    private String user_class;


    public int getUSer_id(){
        return user_id;
    }

    public void setUser_id(int user_id){
        this.user_id = user_id;
    }

    public String getUser_name(){
        return user_name;
    }

    public void setUser_name(String user_name){
        this.user_name = user_name;
    }

    public String getUser_class(){
        return user_class;
    }

    public void setUser_class(String user_class){
        this.user_class = user_class;
    }

    public String result(){

        return "No Issue Found in DTO";
    }

    @Override
    public String toString(){
        return "StudentDto [user_class=" + user_class + ", user_id=" + user_id + ", user_name=" + user_name + "]";
    }
}
