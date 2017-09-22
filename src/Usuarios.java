
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ricky
 */
public class Usuarios {
    String nombre, edad, username, password;
    ArrayList<cancion> playlists = new ArrayList();
    ArrayList<cancion> favoritos = new ArrayList();

    public Usuarios(String nombre, String edad, String username, String password) {
        this.nombre = nombre;
        this.edad = edad;
        this.username = username;
        this.password = password;
    }

    public Usuarios() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<cancion> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList<cancion> playlists) {
        this.playlists = playlists;
    }

    public ArrayList<cancion> getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(ArrayList<cancion> favoritos) {
        this.favoritos = favoritos;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
