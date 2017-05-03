package gradeSystem;

//import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class DataStorage {
	
	/**
	 * @uml.property  name="studentID"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="java.lang.Integer"
	 */
	private ArrayList<Integer>studentID = new ArrayList<Integer>();
	/**
	 * @uml.property  name="studentData"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="java.lang.String"
	 */
	private ArrayList<String> studentData = new ArrayList<String>();
	/**
	 * @uml.property  name="studentName"
	 * @uml.associationEnd  qualifier="valueOf:java.lang.Integer java.lang.String"
	 */
	private HashMap<Integer ,String>studentName = new HashMap<Integer, String>();
	/**
	 * @uml.property  name="gradePair"
	 * @uml.associationEnd  qualifier="valueOf:java.lang.Integer java.lang.String"
	 */
	private HashMap<Integer, String> gradePair = new HashMap<Integer, String>();
	/**
	 * @uml.property  name="firstOfArrayList"
	 */
	//private boolean firstOfArrayList;
	
	
	public DataStorage(){
		System.out.println("Error! No input stream");
		//System.out.println("Establish a data storage.");
	}
	
	/**
	 * Constructor throws IOException.
	 * @param reader
	 * 
	 * Time estimate: O(n)
	 */
	public DataStorage(BufferedReader reader){
		try{
			while(reader.ready()){		
				studentData.add(reader.readLine());
			}
		}catch(IOException e){
			System.out.println(e.getStackTrace());
		}
		this.splitStudentData();
	}
	
	/*public int getDataSize(){
		return studentData.size();
	}
	
	public void setStudentData(String input){
		studentData.add(input);
	}*/
	
	private void splitStudentData(){
		//firstOfArrayList = true;
		for(String i: studentData){
			//System.out.println(i.substring(0, 28));
			//if(firstOfArrayList){
				//System.out.println(Integer.parseInt(i.substring(0, 9)));
				gradePair.put(Integer.parseInt(i.substring(0, 9)), i.substring(14, 28));
				studentID.add(Integer.parseInt(i.substring(0, 9)));
				studentName.put(Integer.parseInt(i.substring(0, 9)),i.substring(10, 13));
				//firstOfArrayList = false;
			//}
			/*else{
				gradePair.put(Integer.parseInt(i.substring(0, 9)), i.substring(14, 28));
				studentID.add(Integer.parseInt(i.substring(0, 9)));
				studentName.put(Integer.parseInt(i.substring(0, 9)),i.substring(10, 13));
			}*/
		}
	}
	
	/**
	 * @param IDNum
	 * @return grades stored in type String
	 * 
	 * Time estimate: O(n)
	 */
	public String getGradeByID(int IDNum){
		return gradePair.get(IDNum);
	}
	
	/**
	 * @return studentID's array-list
	 * 
	 * Time estimate: O(1)
	 */
	public ArrayList<Integer> getStudentID(){
		return studentID;
	}
	
	/**
	 * @return student ID and studentName's Hash-map.
	 * 
	 * Time estimate: O(1)
	 */
	public HashMap<Integer, String> getStudentName(){
		return studentName;
	}
	
	/**
	 * Return boolean value to report whether studentID list contains the ID or not. 
	 * @param IDin
	 * @return boolean
	 * 
	 * Time estimate: O(n)
	 */
	public boolean containStudentID(int IDin){
		return studentID.contains(IDin);
	}
	
	/*
	public void showStudentData(){
		for(String i: studentData){
			System.out.println(i);
		}
	}*/
}
