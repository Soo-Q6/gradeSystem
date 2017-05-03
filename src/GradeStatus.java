package gradeSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class GradeStatus {
	/**
	 * @uml.property  name="weight" multiplicity="(0 -1)" dimension="1"
	 */
	private float[] weight = new float[5];
	/**
	 * @uml.property  name="firstOfArrayList"
	 */
	//private boolean firstOfArrayList;
	/**
	 * @uml.property  name="iD"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="java.lang.Integer"
	 */
	private ArrayList<Integer>ID;
	
	/**
	 * @uml.property  name="nameList"
	 * @uml.associationEnd  qualifier="valueOf:java.lang.Integer java.lang.String"
	 */
	private HashMap<Integer, String> nameList = new HashMap<Integer, String>();
	/**
	 * @uml.property  name="lab1"
	 * @uml.associationEnd  qualifier="valueOf:java.lang.Integer java.lang.Integer"
	 */
	private HashMap<Integer, Integer> lab1 = new HashMap<Integer, Integer>();
	/**
	 * @uml.property  name="lab2"
	 * @uml.associationEnd  qualifier="valueOf:java.lang.Integer java.lang.Integer"
	 */
	private HashMap<Integer, Integer> lab2 = new HashMap<Integer, Integer>();
	/**
	 * @uml.property  name="lab3"
	 * @uml.associationEnd  qualifier="valueOf:java.lang.Integer java.lang.Integer"
	 */
	private HashMap<Integer, Integer> lab3 = new HashMap<Integer, Integer>();
	/**
	 * @uml.property  name="midTerm"
	 * @uml.associationEnd  qualifier="valueOf:java.lang.Integer java.lang.Integer"
	 */
	private HashMap<Integer, Integer> midTerm = new HashMap<Integer, Integer>();
	/**
	 * @uml.property  name="final"
	 * @uml.associationEnd  qualifier="valueOf:java.lang.Integer java.lang.Integer"
	 */
	private HashMap<Integer, Integer> Final = new HashMap<Integer, Integer>();
	/**
	 * @uml.property  name="average"
	 * @uml.associationEnd  multiplicity="(0 -1)" ordering="true" elementType="java.lang.Object" qualifier="valueOf:java.lang.Integer java.lang.Object"
	 */
	private HashMap<Integer, Float> average = new HashMap<Integer, Float>();
	/**
	 * @uml.property  name="averageList"
	 */
	LinkedList<Float> averageList = new LinkedList<Float>();
	
	public GradeStatus() {
		System.out.println("Error! No input data.");
	}
	/**
	 * Constructor, input DataStorage data, to set all properties in GradeStatus.
	 * 
	 * Time estimate: O(n)
	 */
	public GradeStatus(DataStorage data){
		for(int i=0; i<5; i++)
			weight[i] = 20;
		this.ID = data.getStudentID();
		this.nameList = data.getStudentName();
		//firstOfArrayList = true;
		for(int i: ID){
			//if(firstOfArrayList){
				//System.out.println(data.getGradeByID(i).substring(0,14));
				lab1.put(i, Integer.parseInt(data.getGradeByID(i).substring(0, 2)));
				lab2.put(i, Integer.parseInt(data.getGradeByID(i).substring(3, 5)));
				lab3.put(i, Integer.parseInt(data.getGradeByID(i).substring(6, 8)));
				midTerm.put(i, Integer.parseInt(data.getGradeByID(i).substring(9, 11)));
				Final.put(i, Integer.parseInt(data.getGradeByID(i).substring(12, 14)));
				average.put(i, weight[0]/100*lab1.get(i)+weight[1]/100*lab2.get(i)+weight[2]/100*lab3.get(i)+weight[3]/100*midTerm.get(i)+weight[4]/100*Final.get(i));
				//firstOfArrayList = false;
			//}
			/*else{
				lab1.put(i, Integer.parseInt(data.getGradeByID(i).substring(0, 2)));
				lab2.put(i, Integer.parseInt(data.getGradeByID(i).substring(3, 5)));
				lab3.put(i, Integer.parseInt(data.getGradeByID(i).substring(6, 8)));
				midTerm.put(i, Integer.parseInt(data.getGradeByID(i).substring(9, 11)));
				Final.put(i, Integer.parseInt(data.getGradeByID(i).substring(12, 14)));
				average.put(i, weight[0]/100*lab1.get(i)+weight[1]/100*lab2.get(i)+weight[2]/100*lab3.get(i)+weight[3]/100*midTerm.get(i)+weight[4]/100*Final.get(i));
			}*/
		}
		this.renewAverage();
	}
	
	/**
	 * A method resets the value of weight. Sending Scanner in into this method to read value entered from user.
	 * 
	 * Time estimate: O(n) due to call the private method renewAverage to renew the total grade's average. 
	 */
	public void setNewWeight(Scanner in){
		System.out.print("舊配分\nlab1 " + weight[0]+"%\nlab2 " + weight[1]+"%\nlab3 " + weight[2]+"%\nmid-term "+ weight[3]+"%\nfinal exam " + weight[4]+"%\n");
		int[] weight_tmp = new int[5];
		//Scanner in = new Scanner(System.in);
		System.out.println("輸入新配分");
		System.out.print("lab1  ");
		weight_tmp[0] = in.nextInt();
		System.out.print("lab2  ");
		weight_tmp[1] = in.nextInt();
		System.out.print("lab3  ");
		weight_tmp[2] = in.nextInt();
		System.out.print("mid-term  ");
		weight_tmp[3] = in.nextInt();
		System.out.print("final exam  ");
		weight_tmp[4] = in.nextInt();
		System.out.println("確認新配分");
		System.out.println("lab1  "+weight_tmp[0]+"%");
		System.out.println("lab2  "+weight_tmp[1]+"%");
		System.out.println("lab3  "+weight_tmp[2]+"%");
		System.out.println("mid-term  "+weight_tmp[3]+"%");
		System.out.println("final exam  "+weight_tmp[4]+"%");
		System.out.print("是否正確？(Y/N)");
		while(in.hasNext()){
			if(in.next().equalsIgnoreCase("Y")){
				for(int i=0; i<5; i++){
					weight[i] = weight_tmp[i];
				}
				System.out.print("新配分\nlab1 " + weight[0]+"%\nlab2 " + weight[1]+"%\nlab3 " + weight[2]+"%\nmid-term "+ weight[3]+"%\nfinal exam " + weight[4]+"%\n");
				break;
			}else break;
		}
		//in.close();
		this.renewAverage();
	}
	
	private void renewAverage(){
			averageList.clear();
		for(int i=0; i<this.ID.size(); i++){			
			average.replace(this.ID.get(i), weight[0]/100*lab1.get(this.ID.get(i))+weight[1]/100*lab2.get(this.ID.get(i))+weight[2]/100*lab3.get(this.ID.get(i))+weight[3]/100*midTerm.get(this.ID.get(i))+weight[4]/100*Final.get(this.ID.get(i)));
			averageList.add(average.get(this.ID.get(i)));
		}
	}
	
	/**
	 * Display the Student's every grade.
	 * @param IDNum
	 * 
	 * Time estimate: O(n)
	 */
	public int showScoreByID(int IDNum){
			float total=(lab1.get(IDNum)*weight[0]+lab2.get(IDNum)*weight[1]+lab3.get(IDNum)*weight[2]+midTerm.get(IDNum)*weight[3]+Final.get(IDNum)*weight[4])/100;
			System.out.println((lab1.get(IDNum))<60?this.getStudentName(IDNum)+"成绩: lab1="+lab1.get(IDNum)+"*":this.getStudentName(IDNum)+ " 成绩:lab1="+lab1.get(IDNum));
			System.out.println((lab2.get(IDNum))<60?" lab2="+lab2.get(IDNum)+"*": " lab2="+lab2.get(IDNum));
			System.out.println((lab3.get(IDNum))<60?" lab3="+lab3.get(IDNum)+"*": " lab3="+lab3.get(IDNum));
			System.out.println((midTerm.get(IDNum))<60?" mid-term="+midTerm.get(IDNum)+"*": " mid-term="+midTerm.get(IDNum));
			System.out.println((Final.get(IDNum))<60?" final exam="+Final.get(IDNum)+"*": " final exam="+Final.get(IDNum));
			System.out.println(total<60?" total grade="+(int)total+'*':" total grade="+(int)total);
			return (int)total;
	}
	
	/**
	 * Display the whole class' average grade.
	 * 
	 * Time estimate: O(n)
	 */
	public String showMean(){
		/*float sum = 0;
		for(int i: ID)
			sum += lab1.get(i);
		System.out.println("lab1平均："+sum/ID.size());
		sum = 0;
		for(int i: ID)
			sum += lab2.get(i);
		System.out.println("lab2平均："+sum/ID.size());
		sum = 0;
		for(int i: ID)
			sum += lab3.get(i);
		System.out.println("lab3平均："+sum/ID.size());
		sum = 0;
		for(int i: ID)
			sum += midTerm.get(i);
		System.out.println("mid-term平均："+sum/ID.size());
		sum = 0;
		for(int i: ID)
			sum += Final.get(i);
		System.out.println();*/
		System.out.println(this.showLab1Mean());
		System.out.println(this.showLab2Mean());
		System.out.println(this.showLab3Mean());
		System.out.println(this.showMidTermMean());
		System.out.println(this.showfinalMean());
		return this.showLab1Mean()+this.showLab2Mean()+this.showLab3Mean()+showMidTermMean()+showfinalMean();
	}
	
	/**
	 * get the whole class' Lab1 average grade.
	 * 
	 * @return the whole class' Lab1 average grade
	 */
	private String showLab1Mean(){
		float sum = 0;
		for(int i: ID)
			sum += lab1.get(i);
		return "lab1平均："+sum/ID.size();
	}
	
	/**
	 * get the whole class' Lab2 average grade.
	 * 
	 * @return the whole class' Lab2 average grade
	 */
	private String showLab2Mean(){
		float sum = 0;
		for(int i: ID)
			sum += lab2.get(i);
		return "lab2平均："+sum/ID.size();
	}
	
	/**
	 * get the whole class' Lab3 average grade.
	 * 
	 * @return the whole class' Lab3 average grade.
	 * 
	 */
	private String showLab3Mean(){
		float sum = 0;
		for(int i: ID)
			sum += lab3.get(i);
		return "lab3平均："+sum/ID.size();
	}
	
	/**
	 * get the whole class' mid-term average grade.
	 * 
	 * @return the whole class' mid-term average grade
	 */
	private String showMidTermMean(){
		float sum = 0;
		for(int i: ID)
			sum += midTerm.get(i);
		return "mid-term平均："+sum/ID.size();
	}
	
	/**
	 * get the whole class' final exam average grade.
	 * 
	 * @return the whole class' final exam average grade
	 */
	private String showfinalMean(){
		float sum = 0;
		for(int i: ID)
			sum += Final.get(i);
		return "final exam平均："+sum/ID.size();
	}
	/**
	 * Report the target student's rank in class.
	 * @param IDNum
	 * @return student's rank
	 * 
	 * Time estimate: O(n^2)
	 */
	public int getRank(int IDNum){
		averageList.sort(null);
		return averageList.size()-averageList.indexOf(average.get(IDNum));
	}
	
	/**
	 * Report the target student's name.
	 * @param IDNum
	 * @return student's name by his ID.
	 * 
	 * Time estimate: O(n)
	 */
	public String getStudentName(int IDNum){
		    return nameList.get(IDNum);
	}
}
