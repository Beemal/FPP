package travelcalculator;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

class TravelTime{
	Scanner sc = new Scanner(System.in);
	String city;
	int speed, distance;
	double acTime = 0.0;
	int timeDiff = 0;
String makeChoice(){
		int choice = sc.nextInt();
		switch(choice){
		case 1:
			city = "Chicago";
			break;
		case 2:
			city = "Los_Angeles";
			break;
		case 3:
			city = "New_York";
			break;
		case 4:
			city = "Denver";
			break;
		default:
			System.out.println("Wrong Choice !!");
		}
	
		return city;
	}
	void displayChoice(){
		System.out.print("1. Chicago\t  2. Los Angeles \n3.New York\t  4. Denver\n");
	}
	void askDate(){
		System.out.println("Enter Date (YYYY-MM-DD)");
		String date = sc.next();
	}
	void setDistance(int d){
		this.distance = d;
	}
	void setSpeed(int s){
		this.speed = s;
	}
	int getSpeed(){
		return speed;
	}
	int getDistance(){
		return distance;
	}
	void calculateTimeDiff(int aTime, int dTime){
		
		if(aTime > dTime)
			timeDiff = aTime - dTime;
		else
			timeDiff = dTime - aTime;
		int minuteTime = timeDiff%60;
		int hrsDiff = timeDiff/60;

//		System.out.println("Time difference is "+hrsDiff +" hrs "+minuteTime+" min");
	}
	int getTimeDiff(){
		return timeDiff;
	}
	double calculateActualTime(){
		double actualTime =  distance/speed;
			 // return time in minutes
		return acTime = actualTime*60;
	}
	double calculateApparentTime(){
		double apparentTime = acTime + timeDiff;
		return apparentTime;
	}
	
}


public class AirwayTimeCalculator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TravelTime t = new TravelTime();
		System.out.println("From: ");
		t.displayChoice();
		String arrivalCity = t.makeChoice();
		System.out.println("To: ");
		t.displayChoice();
		String departureCity = t.makeChoice();
		
		System.out.println("From: "+arrivalCity+" To: "+departureCity);	
		
		ZonedDateTime arTime = ZonedDateTime.now(ZoneId.of("America/"+arrivalCity));
		ZonedDateTime dpTime = ZonedDateTime.now(ZoneId.of("America/"+departureCity));
		
		int aTime =  arTime.getHour()*60 + arTime.getMinute();
		int dTime = dpTime.getHour()*60 + dpTime.getMinute();
		t.calculateTimeDiff(aTime, dTime);
		
		
		System.out.println("Enter Speed of Plane (miles/hr): ");
		t.setSpeed(sc.nextInt());
		
		System.out.println("Enter Distance between Cities: ");
		t.setDistance(sc.nextInt());
		
		System.out.println("The actual time is: "+t.calculateActualTime()/60+" hrs"+t.calculateActualTime()%60+" minutes");
		
		System.out.println("The apparent time is:"+t.calculateApparentTime()/60+" hrs"+t.calculateApparentTime()%60+" minutes");
	}
}
