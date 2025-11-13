package ultima_clase;

public class Usuario {
    private String username;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Usuario(String username,String name){
        this.username=username;
        this.name = name;
    }
     
}
