import java.util.ArrayList;
import java.time.LocalTime; 
import java.time.LocalDate;
import java.util.Scanner;
public class Logop
{
	    
    static ArrayList<Logs> log  = new ArrayList<>();
    static ArrayList<AccidentLog> alog  = new ArrayList<>();
    static ArrayList<TrafficViolationLog> vlog = new ArrayList<>();
    static ArrayList<Vehicle> vehicle = new ArrayList<>();
    
    public static Logs return_log(int LID){
        for(int i=0;i<log.size();i++){
            if(LID == log.get(i).LogID){
                return log.get(i);
            }
        }
        return null;
    }
  
    public static AccidentLog return_accident(int AID){
        for(int i=0;i<alog.size();i++){
            if(AID == alog.get(i).AccID){
                return alog.get(i);
            }
        }
        return null;
    }

    public static TrafficViolationLog return_violation(int VID){
        for(int i=0;i<vlog.size();i++){
            if(VID == vlog.get(i).VID){
                return vlog.get(i);
            }
        }
        return null;
    }
    
    public static Vehicle return_vehicle(String regno){
        for(int i=0;i<vehicle.size();i++){
            if(regno == vehicle.get(i).Regno){
                return vehicle.get(i);
            }
        }
        return null;
    }



 public static void addViolation(){
        System.out.println("--------------------------");
        System.out.println();
        System.out.println("Enter Violation ID : ");
        Scanner input = new Scanner(System.in);
        int VID = input.nextInt();
        System.out.println("Enter Registration number : ");
        String regno = input.next();
        System.out.println("Enter Speed : ");
        double speed = input.nextDouble();
        System.out.println("Enter Reason : ");
        String reason = input.next();
        System.out.println("Enter Penalty amount : ");
        double penalty = input.nextDouble();
        
        System.out.println("Enter Road ID : ");
        int RID = input.nextInt();
        System.out.println("Enter Police ID : ");
        int PID = input.nextInt();
        System.out.println("Enter Station ID : ");
        int SID = input.nextInt();

        input.close();
        vlog.add(new TrafficViolationLog(VID,penalty,reason,regno,speed,RID,PID,SID,"Violation"));
        System.out.println("Violation entry added successfully");
        System.out.println();
        System.out.println("--------------------------");
    }
    

    public static void addAccident(){
        System.out.println("--------------------------");
        System.out.println();
        System.out.println("Enter Accident ID : ");
        Scanner input = new Scanner(System.in);
        int AID = input.nextInt();
        System.out.println("Enter Number of People Injured : ");
        int ni = input.nextInt();
        System.out.println("Enter Damage caused : ");
        String damage = input.next();
        System.out.println("Enter Reason : ");
        String reason = input.next();
        System.out.println("Enter Number of Vehicles : ");
     
        ArrayList<String> vehicles = new ArrayList<>();
        int nov = input.nextInt();
        int i = 0;
        while(i<nov){
            System.out.println("Enter Registration Number"+(i+1)+" : "); //check if i+1 is working
            String Regno = input.next();
            Vehicle v = return_vehicle(Regno);
            if(v == null){
                System.out.println("Vehicle does not exist. Try again...");
            }
            else{
                vehicles.add(Regno);
                i++;
            }

        }
        
        System.out.println("Enter Road ID : ");
        int RID = input.nextInt();
        System.out.println("Enter Police ID : ");
        int PID = input.nextInt();
        System.out.println("Enter Station ID : ");
        int SID = input.nextInt();
        input.close();
        alog.add(new AccidentLog(AID,damage,reason,ni,nov,vehicles,RID,PID,SID,"Accident"));
        System.out.println("Accident entry added successfully");
        System.out.println();
        System.out.println("--------------------------");
    }
    
    

    public static void listViolation(){
        System.out.println("--------------------------");
        System.out.println();
        System.out.println("List of Violations : \n");
        for(int i = 0;i<vlog.size();i++){
            System.out.print("Violation ID : ");
            System.out.println(vlog.get(i).VID);
            System.out.print("Registration Number : ");
            System.out.println(vlog.get(i).regno);
            System.out.print("Reason : ");
            System.out.println(vlog.get(i).Reason);
            System.out.print("Speed : ");
            System.out.println(vlog.get(i).speed);
            System.out.print("Penalty amount : ");
            System.out.println(vlog.get(i).PenaltyAmount);
            System.out.print("Road ID : ");
            System.out.println(vlog.get(i).RoadID);
            System.out.print("Police ID : ");
            System.out.println(vlog.get(i).PoliceID);
            System.out.print("Station ID : ");
            System.out.println(vlog.get(i).StationID);
            System.out.print("Date : ");
            System.out.println(vlog.get(i).date);
            System.out.print("Time : ");
            System.out.println(vlog.get(i).time);
            
            System.out.println();
        }
        System.out.println("--------------------------");
    }
    

    public static void listAccident(){
        System.out.println("--------------------------");
        System.out.println();
        System.out.println("List of Accidents : \n");
        for(int i = 0;i<alog.size();i++){
            System.out.print("Accident ID : ");
            System.out.println(alog.get(i).AccID);
            System.out.print("Number of people injured : ");
            System.out.println(alog.get(i).NoofPersonsInjured);
            System.out.print("Damage Caused : ");
            System.out.println(alog.get(i).DamageCaused);
            System.out.print("Reason for the accident : ");
            System.out.println(alog.get(i).AccReason);
            System.out.print("Number of Vehicles involved : ");
            System.out.println(alog.get(i).NoofVehicles);
            System.out.print("Vehicles involved : ");
            System.out.println(alog.get(i).regnos);
            System.out.print("Road ID : ");
            System.out.println(vlog.get(i).RoadID);
            System.out.print("Police ID : ");
            System.out.println(alog.get(i).PoliceID);
            System.out.print("Station ID : ");
            System.out.println(alog.get(i).StationID);
            System.out.print("Date : ");
            System.out.println(alog.get(i).date);
            System.out.print("Time : ");
            System.out.println(alog.get(i).time);
            
            System.out.println();
        }
        System.out.println("--------------------------");
    }

    
    public static void deleteViolation(){
        System.out.println("--------------------------");
        System.out.println();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Violation ID : ");
        int VID = input.nextInt();
        input.close();
        TrafficViolationLog v = return_violation(VID);
        Logs l = return_log(VID);
        
        if(v == null){
            System.err.println("Violation log does not exist");
        }
        else{
            vlog.remove(v);
            log.remove(l);
            System.out.println("Violation Successfully deleted");
        }

//        if(l == null){
//            System.err.println("Log does not exist");
//        }
//        else{
//            log.remove(l);
//            System.out.println("Log Successfully deleted");
//        }
//        
        System.out.println();
        System.out.println("--------------------------");
    }

    
    
    public static void deleteAccident(){
        System.out.println("--------------------------");
        System.out.println();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Accident ID : ");
        int AID = input.nextInt();
        input.close();
        AccidentLog a = return_accident(AID);
        Logs l = return_log(AID);
        
        if(a == null){
            System.err.println("Accident log does not exist");
        }
        else{
            alog.remove(a);
            log.remove(l);
            System.out.println("Accident log Successfully deleted");
        }

//        if(l == null){
//            System.err.println("Log does not exist");
//        }
//        else{
//            log.remove(l);
//            System.out.println("Log Successfully deleted");
//        }
        
        System.out.println();
        System.out.println("--------------------------");
    }


}
