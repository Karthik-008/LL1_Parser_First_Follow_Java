import java.io.*;
import java.util.*;

public class First_Follow {

    public static Map<String, List<String>> grammar;

    public First_Follow() {
        grammar = new LinkedHashMap<>();
    }

    public void printGrammar() {
        for (Map.Entry<String, List<String>> entry : grammar.entrySet()) {
            System.out.print(entry.getKey() + "->");
            for (String prod : entry.getValue()) {
                System.out.print(prod + " ");
            }
            System.out.println(" ");
        }
    }


    public static void main(String[] args) throws Exception {
        int n, i = 0, p;
        First_Follow ff = new First_Follow();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter no.of Non-terminals : ");
        n = Integer.parseInt(br.readLine());

        System.out.println("Enter grammar : ");
        while (i < n) {
            System.out.print("Enter nonTerminal(lhs) : ");
            String nonTerminal = br.readLine();

            System.out.print("Enter no.of productions : ");
            p = Integer.parseInt(br.readLine());

            System.out.println("Enter productions : ");
            String[] prods = new String[p];
            for (int j = 0; j < p; j++) {
                prods[j] = br.readLine();
            }

            List<String> productionList = Arrays.asList(prods);
            grammar.put(nonTerminal, productionList);
            i++;
        }

        ff.printGrammar();

        First fr = new First();
        fr.computeFirstSet();
        fr.printFirstSet();

        Follow fl = new Follow();
        fl.followSet();
        fl.printFollowSet();
    }
}
