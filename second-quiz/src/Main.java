import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String value = "BCE";

        List<Character> characters = new ArrayList<Character>();
        for(char c : value.toCharArray()){
            characters.add(c);
        }

        characters.add(2, 'D');
        characters.add(0,'A');
        characters.remove(2);
        characters.add(4,'F');
        System.out.println(characters);

        StringBuilder sb = new StringBuilder();
        for(char c : characters){
            sb.append(c);
        }

        System.out.println(sb.toString());
     }
}
