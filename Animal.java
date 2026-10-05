public class Animal
{
    String family ;
    String name ;
    int age ;
    boolean ismammal ;

    Animal(){};
    Animal(String family, String name, int age, boolean ismammal)
    {
        this.family = family ;
        this.name = name ;
        this.age = age ;
        this.ismammal = ismammal ;
    }
    public String toString()
    {
        return "Animal Name: " + this.name + ", Family: " + this.family + ", Age: " + this.age + ", Is Mammal: " + this.ismammal;
    }
}