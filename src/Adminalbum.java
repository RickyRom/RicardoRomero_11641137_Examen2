
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

    protected ArrayList<Albums> lista = new ArrayList();
    protected File archivo = null;
    
    public Adminalbum(String path) {
        archivo = new File(path);
    }

    public ArrayList<Albums> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Albums> lista) {
        this.lista = lista;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    @Override
    public String toString() {
        return "Adminalbum{" + "lista=" + lista + ", archivo=" + archivo + '}';
    }
    
     public ArrayList<Albums> CargarArchivo() {
        try {
            lista = new ArrayList();
            Albums temp;
            if (archivo.exists()) {
                FileInputStream entrada = new FileInputStream(archivo);
                ObjectInputStream objeto = new ObjectInputStream(entrada);
                try {
                    while ((temp = (Albums) objeto.readObject()) != null) {
                        lista.add(temp);
                    }
                } catch (EOFException e) {
                }
                objeto.close();
                entrada.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
     public void EscribirArchivo() {
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        try {
            fw = new FileOutputStream(archivo);
            bw = new ObjectOutputStream(fw);
            for (Albums t : lista) {
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
