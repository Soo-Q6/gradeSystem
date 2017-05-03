package gradeSystem;

import java.util.Scanner;

public class UserInterface {

public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int userID = 0;	
		String input;
		DataStorage load = null;
		GradeStatus grade = null;
		Boolean enteredID = false;
		
		try{
			ReadTxt read = new ReadTxt();
			load = new DataStorage(read.getBufReader());
			grade = new GradeStatus(load);
		}catch(Exception e){
			e.getStackTrace();
		}
		System.out.println(load.getGradeByID(985002038));
		while(true){	
					
			if(!enteredID){
				System.out.println("Hi, who are you?(Type your Student ID number please. Q to quit system.)");
				input = in.next();
				//System.out.println(input);
				if(input.equals("Q")){
					System.out.println("Thanks for using, good bye!");
					break;
				}
				try{
					userID = Integer.parseInt(input);
				}catch(Exception e){
					e.getStackTrace();
					continue;
				}
				
				if(!load.containStudentID(userID)){
					System.out.println("Such Student ID doesn't exist!, What is your Student ID?");
					continue;
				}else{
					System.out.println("Welcome!"+grade.getStudentName(userID));
					enteredID = true;
				}
			}
			if(enteredID){
				System.out.println("Hello! Which service do you want?(G=�@ʾ�ɿ�; R=�@ʾ����; A=�@ʾƽ��; W=�������; E=�x�_�x��)");
				input = in.next();
				switch(input){
					case "G":
						grade.showScoreByID(userID);
						break;
					case "R":
						System.out.println(grade.getStudentName(userID)+"������"+grade.getRank(userID));
						break;
					case "A":
						grade.showMean();
						break;
					case "W":
						grade.setNewWeight(in);
						break;
					case "E":
						System.out.println("ʹ�����˳�");
						userID = 0;
						enteredID = false;
						break;
					default:
						System.out.println("Ոݔ��Ϸ�ָ���x�x��");
				}
			}	
		}
		in.close();
	}
}
