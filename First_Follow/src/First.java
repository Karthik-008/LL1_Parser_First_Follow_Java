import java.util.*;

public class First {
    public static Map<String, Set<String>> firstSet;

    public First() {
        firstSet = new LinkedHashMap<>();
    }
    
    public void computeFirstSet() {
        for(String nonTerminal : First_Follow.grammar.keySet()) {
            firstSet.put(nonTerminal, new HashSet<>());
        }
        
        for(Map.Entry<String, List<String>> entry : First_Follow.grammar.entrySet()) {
            String nonTerminal = entry.getKey();
            List<String> productions = entry.getValue();
            
            for(String production : productions) {
                computeFirst(nonTerminal, production);
            }
        }
    }

    private void computeFirst(String nonTerminal, String production) {
        String firstSymbol = String.valueOf(production.charAt(0));

        if(Character.isUpperCase(firstSymbol.charAt(0))) {
            List<String> productionOfNT = First_Follow.grammar.get(firstSymbol);
            for(String symbolProduction : productionOfNT) {
                computeFirst(nonTerminal, symbolProduction);
            }

            firstSet.get(nonTerminal).addAll(firstSet.get(firstSymbol));
        }
        else {
            firstSet.get(nonTerminal).add(firstSymbol);
        }
    }

    public void printFirstSet() {
        for(Map.Entry<String, Set<String>> entry : firstSet.entrySet()) {
            System.out.print("First(" + entry.getKey() + ") --> { ");
            for(String first : entry.getValue()) {
                System.out.print(first + " ");
            }
            System.out.println("}");
        }
    }
}
