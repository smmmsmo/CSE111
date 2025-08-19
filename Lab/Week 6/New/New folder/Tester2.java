public class Tester2 {
 public static void main(String[] args) {
  Spaceship falcon = new Spaceship("Falcon", 50000);
  Spaceship apollo = new Spaceship("Apollo", 100000);
  Spaceship enterprise = new Spaceship("Enterprise",220000);      
  System.out.println("1.===========");
  Cargo gold = new Cargo("Gold", 20000);
  Cargo platinum = new Cargo("Platinum", 25000);
  Cargo dilithium = new Cargo("Dilithium", 50000);
  Cargo trilithium = new Cargo("Trilithium", 70000);
  Cargo neutronium = new Cargo("Neutronium", 80000);
  System.out.println("2.===========");
  falcon.loadCargo(gold);
  falcon.loadCargo(platinum);
  falcon.displayDetails();
  System.out.println("3.===========");
  apollo.loadCargo(gold);
  apollo.displayDetails();
  System.out.println("4.===========");
  falcon.loadCargo(neutronium);
  System.out.println("5.===========");
  enterprise.loadCargo(dilithium);
  enterprise.loadCargo(trilithium);
  enterprise.loadCargo(neutronium);
  enterprise.displayDetails();
 }
}
