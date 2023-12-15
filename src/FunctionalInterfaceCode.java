import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionalInterfaceCode {

    public static void main(String[] args){
        System.out.println("hello world");

        List<Integer> list = Arrays.asList(10,15,8,49,25,98,32,10);
      //  Set<Integer> set = new HashSet<>();
      //  System.out.println(list.stream().count());
     //   System.out.println(list.stream().max((a,b)->Integer.compare(a,b)).get())
        String input = "Java Articles are Awesome";

        Set<Integer> set = new HashSet<>();

       // System.out.println(input.chars().filter(v->!set.add(v)).findFirst().getAsInt());

         Character c =input.chars().mapToObj(s->Character.toLowerCase((char)(s))).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                 .entrySet().stream().filter(entry -> entry.getValue()>1L).map(entry ->entry.getKey()).findFirst().get();
        System.out.println(c);
        int arr[] = { 99, 55, 203, 99, 4, 91 };
        Arrays.sort(arr);

        Arrays.stream(arr).forEach(val-> System.out.println(val));

        List<String> name = Arrays.asList("aa","bb");

        name.stream().map(str ->str.toUpperCase()).forEach(s-> System.out.println(s));

        //Map<String ,String> map = null;
        Optional<Map<String,String>> s = Optional.ofNullable(new HashMap<>());
        if(s.isPresent()){
            System.out.println("yes");
        }else{
            System.out.println("hell");
        }



    }


}
