package c08.dataStructure;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeMap;

public class Test1 {
public static void main(String[] args) {
final long REPS = 100000000;
long t1 = System.currentTimeMillis();
System.out.print("Hashtable");
for(long i = 0; i < REPS; i++)
new Hashtable();
long t2 = System.currentTimeMillis();
System.out.println(": " + (t2 - t1));
t1 = System.currentTimeMillis();
System.out.print("TreeMap");
for(long i = 0; i < REPS; i++)
new TreeMap();
t2 = System.currentTimeMillis();
System.out.println(": " + (t2 - t1));
t1 = System.currentTimeMillis();
System.out.print("HashMap");
for(long i = 0; i < REPS; i++)
new HashMap();
t2 = System.currentTimeMillis();
System.out.println(": " + (t2 - t1));

}
}
