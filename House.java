/* This is a stub for the House class */

import java.util.ArrayList;

public class House extends Building implements HouseRequirements{

   //Attributes
   private ArrayList<Student> residents; // The <Student> tells Java what kind of data we plan to store IN the ArrayList
   private boolean hasDiningRoom;

  public House(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = true;
    System.out.println("You have built a house: 🏠");
  }
  
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  public int nResidents(){
    return this.residents.size();
  }

  public void moveIn(Student s){
    if(!this.residents.contains(s)) {
      this.residents.add(s);
      System.out.println(s.getName()+"has moved into the House.");
    }else{
      System.out.println(s.getName()+"has already in the House.");
    }  
  }

  public Student moveOut(Student s){
    if(this.residents.contains(s)){
      this.residents.remove(s);
      System.out.println(s.getName()+"has moved out the House.");
      return s;
    }else{
      System.out.println(s.getName()+"is not in the House.");
      return null;
    }
  }

  public boolean isResident(Student s){
    if(this.residents.contains(s)){
      return true;
    }else{
      return false;
    }
  }
  



  public static void main(String[] args) {
    Student Abby = new Student("Abby", "1234", 2027);
    House Talbot = new House("Talbot", "prospect street 25", 4);
    Talbot.moveIn(Abby);
    Talbot.isResident(Abby);
   
  }

}