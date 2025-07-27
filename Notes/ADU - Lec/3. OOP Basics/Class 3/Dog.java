//INCOMPLETE
public class Dog{
  public String name;
  public String color;
  
  public String bark(){
    if(name == null && color == null){
      return "A dog is barking";
    }else if(name != null && color != null){
      return name + " the " + color + " dog is barking";
    }else if(name != null){
      return name + " is barking";
    }
    else{
      
    }
  }
}