package team_55;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * A Page simulating a sparseIndex pointing toward either:
 * a (DensePage) or a (BrinSparsePage)
 * aiming to develop a BrinIndex 
 *
 * 
 * @author Basem Rizk
 *
 */

public class BrinSparsePage implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Object> minIndexCol;
	private ArrayList<Object> maxIndexCol;
	private ArrayList<String> refCol;
	
	public BrinSparsePage(String typeOfRef) {
		this.minIndexCol = new ArrayList<Object>();
		this.maxIndexCol = new ArrayList<Object>();
		
		this.refCol = new ArrayList<String>();
	}
	
	public void serializeBrinSparsePage(String sparsePagePath) {
		
		try {
			
            FileOutputStream fos = new FileOutputStream(sparsePagePath);
            ObjectOutputStream oos;
            oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
            fos.close();
	        
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Object> getMinIndexCol() {
		return minIndexCol;
	}

	public ArrayList<Object> getMaxIndexCol() {
		return maxIndexCol;
	}
	
	public static BrinSparsePage deserializeBrinSparsePage(String sparsePagePath) {
		BrinSparsePage page = null;
		
		try {
	        
            FileInputStream fis = new FileInputStream(sparsePagePath);
            ObjectInputStream ois;
            ois = new ObjectInputStream(fis);
            page = (BrinSparsePage) ois.readObject();
            ois.close();
            fis.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return page;
	}
	
	public Object getMin(int index) {
		return minIndexCol.get(index); 
	}
	
	public Object getMax(int index) {
		return maxIndexCol.get(index); 
	}
	
	public Object getRef(int index) {
		return refCol.get(index);
	}
	
	public int getSize() {
		return minIndexCol.size();
	}
	
}
