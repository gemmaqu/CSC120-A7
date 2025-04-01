/* This is a stub for the Library class */

import java.util.Enumeration;
import java.util.Hashtable;

public class Library extends Building implements LibraryRequirements {


  //attributes
  private Hashtable<String, Boolean> collection;



    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String,Boolean>();//empty hastable
      System.out.println("You have built a library: 📖");
    }
  
    public void addTitle(String title){
      if(!this.collection.containsKey(title)){
        this.collection.put(title,true);
        System.out.println(title+"has been addded to our collection.");
      }else{
        System.out.println(title+"has already on our collection.");
      }
    }

    public String removeTitle(String title){
      if(this.collection.containsKey(title)){
        this.collection.remove("title"); 
        return title;
        }else{
          System.out.println(title+"is not in our collection");
          return null;
        }
    }

    public void checkOut(String title){
      if(this.collection.containsKey(title)){
        if (this.collection.get(title)){// to check whether the book is available 
          this.collection.replace(title, false);
          System.out.println(title+"has been succesfully checked out"); 
        } else{
          System.out.println("Sorry"+title+"is already checked out");
      }
      }else{
        System.out.println("Sorry"+title+"is not in our library");
    }
  }

    public void returnBook(String title){
      if(this.collection.containsKey(title)){
        if (!this.collection.get(title)){// to check whether the book is checked out by chekcing whether the book is on the library
          this.collection.replace(title, true);
          System.out.println(title+"has been succesfully returned"); 
        } else{
          System.out.println("Sorry,"+title+"is already in our library");
      }
      }else{
        System.out.println("Sorry"+title+"is not part of our collection");
      }
    }

    public boolean containsTitle(String title){
      return this.collection.containsKey(title);
    }

    public boolean isAvailable(String title){
     return this.collection.containsKey(title) && this.collection.get(this); //need to check the book EXISTS AND AVAILABLE
    }

    public void printCollection(){
      System.out.println("\nLibrary Collection:");
      Enumeration<String>titles = this.collection.keys();
      while (titles.hasMoreElements()) {
          String title = titles.nextElement();
          String status = this.collection.get(title) ? "Available" : "Checked Out";
          System.out.println("- " + title + " (" + status + ")");
        }

    }

    public static void main(String[] args) {
      Library Neilson = new Library("Neilson Library", "Neilson way 123", 5);
      Neilson.addTitle("The Little Prince");
      Neilson.addTitle("1984");
      Neilson.addTitle("Gone with the wind");
      Neilson.checkOut("Gone with the wind");
      Neilson.returnBook("Gone with the wind");
      Neilson.printCollection();
    }
  
  }