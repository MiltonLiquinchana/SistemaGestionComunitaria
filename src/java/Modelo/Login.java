package Modelo;

public class Login {

    /*los mismos parametros que en una tabla*/
    private int pk_login;
    private String usuario;
    private String contrasenia;
    private int fk_tipousuario;
    private int fk_comunero;

    public Login() {
    }

    public Login(int pk_login, String usuario, String contrasenia, int fk_tipousuario, int fk_comunero) {
        this.pk_login = pk_login;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.fk_tipousuario = fk_tipousuario;
        this.fk_comunero = fk_comunero;
    }

    /*contructores getters y setter*/
    public int getPk_login() {
        return pk_login;
    }

    public void setPk_login(int pk_login) {
        this.pk_login = pk_login;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getFk_tipousuario() {
        return fk_tipousuario;
    }

    public void setFk_tipousuario(int fk_tipousuario) {
        this.fk_tipousuario = fk_tipousuario;
    }

    public int getFk_comunero() {
        return fk_comunero;
    }

    public void setFk_comunero(int fk_comunero) {
        this.fk_comunero = fk_comunero;
    }

}
