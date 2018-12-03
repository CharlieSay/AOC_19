package DAY1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    private static List<String> getInput(){
        List<String> listString = new ArrayList<>();
        try{
            File file = new File(Solution.class.getResource("/DAY1/DAY1_INPUT.txt").toURI());
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null){
                listString.add(st);
            }
        }catch(Exception e){ }
        return listString;
    }

    public static int part1(List<Integer> streamableList) {
        return streamableList.stream().reduce(0, Integer::sum);
    }

    public static int part2(List<Integer> integerList) {
        Set<Integer> findUnique = new HashSet<>();
        int frequency = 0;
        while(true) {
            for(int integer : integerList) {
                frequency += integer;
                if(!findUnique.add(frequency)) {
                    return frequency;
                }
            }
        }
    }


    public static void main(String[] args) {
        List<Integer> numbersAsList = getInput().stream().map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(part1(numbersAsList));
        System.out.println(part2(numbersAsList));
    }
}
