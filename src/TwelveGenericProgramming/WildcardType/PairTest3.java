package TwelveGenericProgramming.WildcardType;

import FourObjectsAndClasses.StaticVariablesAndStaticMethods.Employee;
import FourObjectsAndClasses.StaticVariablesAndStaticMethods.Manager;
import TwelveGenericProgramming.DefineSimpleGenericClasses.Pair;

/**
 * @Author: shanzhihua
 * @Date: 2022/6/30 9:44
 * @Version 1.0
 */

public class PairTest3 {
    public static void main(String[] args) {
        Manager ceo = new Manager("Gus Greedy",8000,2003,12,15);
        Manager cfo = new Manager("Sid Sneaky", 60000,2003,12,15);
        Pair<Manager> buddies = new Pair<>(ceo,cfo);
        printBuddies(buddies);

        ceo.setBonus(100000);
        cfo.setBonus(50000);
        Manager[] managers = {ceo,cfo};
        Pair<Employee> result = new Pair<>();
        minmaxBouns(managers,result);
        System.out.println("first" + result.getFirst().getName()+",second:"+result.getSecond().getName());
        maxminBouns(managers,result);
        System.out.println("first" +result.getFirst().getName() + ",second:"+result.getSecond().getName());
    }

    // 只能传入employee的子类,只能读取
    public static void printBuddies(Pair<? extends Employee> p){
        Employee first = p.getFirst();
        Employee second = p.getSecond();
        System.out.println(first.getName()+" and " + second.getName() +" are buddies");
    }
    // 只能传入Manager的父类,可以向泛型对象写入
    public static void minmaxBouns(Manager[] a,Pair<? super Manager> result)
    {
        if(a==null||a.length==0){
            return;
        }
        Manager min = a[0];
        Manager max = a[0];
        for(int i=1;i<a.length;i++){
            if(min.getBonus()>a[i].getBonus()){
                min = a[i];
            }
            if(max.getBonus()<a[i].getBonus()){
                max = a[i];
            }
        }
        result.setFirst(min);
        result.setSecond(max);
    }
    public static void maxminBouns(Manager[] a,Pair<? super Manager> result){
        minmaxBouns(a,result);
        // swapHelper captures wildcard type
        PairAlg.swapHelper(result);
    }
}
