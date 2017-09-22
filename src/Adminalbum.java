
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
public class Adminalbum {

    ArrayList<Albums> listaalbum = new ArrayList();
    File archivo = null;


    public Adminalbum(String path) {
        archivo = new File(path);
    }

    public ArrayList<Albums> getListaAlbum() {
        return listaalbum;
    }

    public void setListaAlbum(ArrayList<Albums> listaalbum) {
        this.listaalbum = listaalbum;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }


    //extra mutador
    public void setAlbum(Albums p) {
        this.listaalbum.add(p);
    }

    public void cargarArchivo() {
        try {
            listaalbum = new ArrayList();
            Albums temp;
            if (archivo.exists()) {
                FileInputStream entrada = new FileInputStream(archivo);
                ObjectInputStream objeto = new ObjectInputStream(entrada);
                try {
                    while ((temp = (Albums) objeto.readObject()) != null) {
                        listaalbum.add(temp);
                    }
                } catch (EOFException e) {
                    //encontro el final del archivo
                }
                objeto.close();
                entrada.close();
            }//fin if
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void escribirArchivo() {
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        try {
            fw = new FileOutputStream(archivo);
            bw = new ObjectOutputStream(fw);
            for (Albums t : listaalbum) {
                bw.writeObject(t);
            }
            bw.flush();
        } catch (Exception e) {
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception e) {
            }
        }
    }

}
