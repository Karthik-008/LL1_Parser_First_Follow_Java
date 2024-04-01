import java.util.*;

public class Follow {
    public static Map<String, Set<String>> followSet;
    public static String start;

    public Follow() {
        followSet = new LinkedHashMap<>();
        for(String lhs : First_Follow.grammar.keySet()){
            followSet.put(lhs, new HashSet<>());
        }
        start = First_Follow.grammar.keySet().iterator().next();
    }

    private Set<String> computeFollowSet(String nonTerminal) {
        Set<String> followTemp = new HashSet<>();

        if(nonTerminal.equals(start)){
            followTemp.add("$");
        }

        for(String lhs : First_Follow.grammar.keySet()){
            for(String production : First_Follow.grammar.get(lhs)){
                for(char c : production.toCharArray()){
                    if(String.valueOf(c).equals(nonTerminal)){
                        String following_nt = production.substring(production.indexOf(c)+1);
                        if(following_nt.isEmpty()){
                            if(!nonTerminal.equals(lhs)){
                                followTemp.addAll(computeFollowSet(lhs));
                            }
                        }
                        else {
                            String following = String.valueOf(following_nt.charAt(0));
                            System.out.println(following);

                            if(!Character.isUpperCase(following_nt.charAt(0))){
                                followTemp.add(following);
                                continue;
                            }
                            Set<String> follow_next = new HashSet<>(First.firstSet.get(following));
                            System.out.println(follow_next);


                            if(!follow_next.isEmpty() &&follow_next.contains("#")){
                                follow_next.remove("#");
                                followTemp.addAll(follow_next);
                                followTemp.addAll(computeFollowSet(lhs));
                            }
                            else {
                                followTemp.addAll(follow_next);
                            }
                        }
                    }
                }
            }
        }
        //followTemp.removeAll(First_Follow.grammar.keySet());
        return followTemp;
    }


    public void followSet() {
        for (String lhs : First_Follow.grammar.keySet()){
            followSet.get(lhs).addAll(computeFollowSet(lhs));
        }
    }


    public void printFollowSet() {
        for (Map.Entry<String, Set<String>> entry : followSet.entrySet()) {
            System.out.print("Follow(" + entry.getKey() + ") --> {");
            for (String terminal : entry.getValue()) {
                System.out.print(terminal + " ");
            }
            System.out.println("}");

        }
    }
}
