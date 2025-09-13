public class Holder<E> {
    private E obj1;
    private E obj2;
    
    public Holder(E firstObject, E secondObject){
        obj1 = firstObject;
        obj2 = secondObject;
    }
    
    public E getObj1(){
        return obj1;
    }
    public E getObj2(){
        return obj2;
    }
    public void setObj1(E newObject){
        obj1= newObject;
    }
    public void setObj2(E newObject){
        obj2= newObject;
    }
    @Override
    public String toString(){
        return "The first object is " + obj1 + ", the second object is " + obj2 + ".";
    }
}
