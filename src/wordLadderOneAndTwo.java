
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


class Node {

    ArrayList<String> list;
    int level;

    Node(ArrayList<String> list, int level) {
        this.list = list;
        this.level = level;
    }
}
class Node1{

    String val;
    int level;

    Node1(String val, int level){
        this.val=val;
        this.level=level;
    }
}

class levelInfo {

    String str;
    int level;

    levelInfo(String str, int level) {
        this.str = str;
        this.level = level;
    }
}


public class wordLadderOneAndTwo {

    static List<List<String>> resultList = new ArrayList<>();
    public static boolean isDiffOne(String s1, String s2) {
        boolean res = false;

        int count = 0;
        int i = 0;
        while (i < s1.length()) {
            if (s1.charAt(i) != s2.charAt(i))
                count++;
            if (count > 1) {
                res = false;
                break;
            }
            i++;
        }
        if (count == 1)
            res = true;

        return res;
    }
    /*
word ladder 1
127. Word Ladder
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 */
    public static int ladderLengthforWordLadderOne(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> s = new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            s.add(wordList.get(i));
        }

        Queue<Node1> q = new LinkedList<>();

        q.add(new Node1(beginWord,1));

        int res=0;

        while(!q.isEmpty()){

            Node1 temp = q.poll();
            if(temp.val.equals(endWord)){

                res=temp.level;
                break;
            }

            if(s.contains(temp.val)){
                s.remove(temp.val);
            }
            if(!s.isEmpty()){


                for(int i=0;i<temp.val.length();i++){
                    StringBuilder sb = new StringBuilder(temp.val);
                    for(int j=0;j<26;j++){
                        sb.setCharAt(i,(char)('a'+j));
                        if(s.contains(sb.toString())){

                            q.add(new Node1(sb.toString(),temp.level+1));

                            s.remove(sb.toString());
                        }
                    }
                }


            }
        }

        return res;
    }

    /*
    {Not Optimised}
    A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].
     */
    public static List<List<String>> ladderListwordProblem2firstway(String beginWord, String endWord, List<String> wordList) {

        Queue<Node> q = new LinkedList<>();
        ArrayList<String> list = new ArrayList<>();
        list.add(beginWord);
        q.add(new Node(list, 1));
        int prevLevel = 1;
        Set<levelInfo> removeE = new HashSet<>();
        removeE.add(new levelInfo(beginWord, 1));
        Set<String> wl = new HashSet<>();
        for (String s : wordList)
            wl.add(s);

        List<List<String>> result = new ArrayList<>();
        while (!q.isEmpty()) {

            Node node = q.poll();

            if (node.list.get(node.list.size() - 1).equals(endWord)) {
                result.add(new ArrayList<>(node.list));

                if (wl.contains(endWord))
                    wl.remove(endWord);
                continue;
            }
            if (prevLevel != node.level) {
                for (levelInfo s : removeE) {
                    if (s.level <= node.level && wl.contains(s.str))
                        wl.remove(s.str);
                }
                prevLevel = node.level;
                // removeE.add();
            }

            if (!wl.isEmpty()) {
                // ConcurrentHa
                StringBuilder sb = new StringBuilder(node.list.get(node.list.size() - 1));
                for (String s : wl) {

                    if (!s.equals(sb.toString()) && isDiffOne(sb.toString(), s)) {
                        ArrayList<String> l = new ArrayList<>(node.list);
                        l.add(s);

                        q.add(new Node(l, node.level + 1));

                        removeE.add(new levelInfo(s, node.level + 1));
                    }
                }

            }
        }

        return result;
    }

    /*
    flow will go from endword to beginword that is backtarcking way
     */
    public static void backTrack(HashMap<String, Integer> hashMap, int maxLevel, String word, String beginWord, List<String> list) {
        if (word.equals(beginWord)) {
            ArrayList<String> res = new ArrayList<>(list);
            Collections.reverse(res);
            resultList.add(res);
            return;
        }
        for (String str : hashMap.keySet()) {
            if (hashMap.get(word) == (hashMap.get(str) + 1) && isDiffOne(word, str)) {
                list.add(str);
                backTrack(hashMap, maxLevel, str, beginWord, list);
                list.remove(list.size() - 1);
            }
        }
    }

    /*
    flow will go from beginword to lastword
     */
    public static void dfs(HashMap<String, Integer> hashMap, int maxLevel, String word, String endWord, List<String> list) {

        if (word.equals(endWord)) {
            resultList.add(new ArrayList<>(list));
            return;
        } else if (hashMap.get(word) == maxLevel && !word.equals(endWord)) {
            return;
        }

        for (String str : hashMap.keySet()) {

            if ((hashMap.get(word) + 1) == hashMap.get(str) && isDiffOne(word, str)) {
                list.add(str);

                dfs(hashMap, maxLevel, str, endWord, list);
                list.remove(list.size() - 1);
            }
        }
    }

    /*
    {Optimised}
    A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].
     */
    public static List<List<String>> ladderListwordProblem2Secondway(String beginWord, String endWord, List<String> wordList) {

        Queue<String> q = new LinkedList<>();

        HashMap<String, Integer> hashMap = new HashMap<>();
        q.add(beginWord);

        ConcurrentHashMap<String, Integer> wl = new ConcurrentHashMap<>();

        for (String s : wordList)
            wl.put(s, wl.getOrDefault(s, 0) + 1);

        hashMap.put(beginWord, 1);
        if (wl.containsKey(beginWord))
            wl.remove(beginWord);


        int maxLevel = 0;
        while (!q.isEmpty()) {
            String s = q.poll();
            if (s.equals(endWord) && hashMap.containsKey(endWord)) {
                break;
            }

            if (!wl.isEmpty()) {
                for (String var : wl.keySet()) {
                    if (!var.equals(s) && isDiffOne(s, var)) {
                        hashMap.put(var, hashMap.get(s) + 1);
                        maxLevel = Math.max(maxLevel, hashMap.get(s) + 1);
                        q.add(var);
                        wl.remove(var);
                    }
                }
            }

        }

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(endWord);
        if (hashMap.containsKey(endWord))
            backTrack(hashMap, maxLevel, endWord, beginWord, arrayList);

        return resultList;
    }



    public static void main(String[] args) {

        /*

        word ladder 1
         */
        ArrayList<String> list = new ArrayList<>(
                Arrays.asList("hot","dot","dog","lot","log","cog")
        );
        System.out.println(ladderLengthforWordLadderOne("hit","cog",list));




        /*

        word ladder 2 using queue method only bfs

         */
        ArrayList<String> list2 = new ArrayList<>(
                Arrays.asList("hot","dot","dog","lot","log","cog")
        );
        ladderListwordProblem2firstway("hit","cog",list2).forEach(var->{
            System.out.println("ans is "+var);
        });

        /*

        word ladder 2 using bfs and dfs
        Two step:
        1> We are calculating the level of the word from beginWord to endWord in hashMao
        2>we are doing backtrack from lastword to beginword to compute the result.

         */
        ArrayList<String> list1 = new ArrayList<>(
                Arrays.asList("aaaaa", "caaaa", "cbaaa", "daaaa", "dbaaa", "eaaaa", "ebaaa", "faaaa", "fbaaa", "gaaaa", "gbaaa", "haaaa", "hbaaa", "iaaaa", "ibaaa", "jaaaa", "jbaaa", "kaaaa", "kbaaa", "laaaa", "lbaaa", "maaaa", "mbaaa", "naaaa", "nbaaa", "oaaaa", "obaaa", "paaaa", "pbaaa", "bbaaa", "bbcaa", "bbcba", "bbdaa", "bbdba", "bbeaa", "bbeba", "bbfaa", "bbfba", "bbgaa", "bbgba", "bbhaa", "bbhba", "bbiaa", "bbiba", "bbjaa", "bbjba", "bbkaa", "bbkba", "bblaa", "bblba", "bbmaa", "bbmba", "bbnaa", "bbnba", "bboaa", "bboba", "bbpaa", "bbpba", "bbbba", "abbba", "acbba", "dbbba", "dcbba", "ebbba", "ecbba", "fbbba", "fcbba", "gbbba", "gcbba", "hbbba", "hcbba", "ibbba", "icbba", "jbbba", "jcbba", "kbbba", "kcbba", "lbbba", "lcbba", "mbbba", "mcbba", "nbbba", "ncbba", "obbba", "ocbba", "pbbba", "pcbba", "ccbba", "ccaba", "ccaca", "ccdba", "ccdca", "cceba", "cceca", "ccfba", "ccfca", "ccgba", "ccgca", "cchba", "cchca", "cciba", "ccica", "ccjba", "ccjca", "cckba", "cckca", "cclba", "cclca", "ccmba", "ccmca", "ccnba", "ccnca", "ccoba", "ccoca", "ccpba", "ccpca", "cccca", "accca", "adcca", "bccca", "bdcca", "eccca", "edcca", "fccca", "fdcca", "gccca", "gdcca", "hccca", "hdcca", "iccca", "idcca", "jccca", "jdcca", "kccca", "kdcca", "lccca", "ldcca", "mccca", "mdcca", "nccca", "ndcca", "occca", "odcca", "pccca", "pdcca", "ddcca", "ddaca", "ddada", "ddbca", "ddbda", "ddeca", "ddeda", "ddfca", "ddfda", "ddgca", "ddgda", "ddhca", "ddhda", "ddica", "ddida", "ddjca", "ddjda", "ddkca", "ddkda", "ddlca", "ddlda", "ddmca", "ddmda", "ddnca", "ddnda", "ddoca", "ddoda", "ddpca", "ddpda", "dddda", "addda", "aedda", "bddda", "bedda", "cddda", "cedda", "fddda", "fedda", "gddda", "gedda", "hddda", "hedda", "iddda", "iedda", "jddda", "jedda", "kddda", "kedda", "lddda", "ledda", "mddda", "medda", "nddda", "nedda", "oddda", "oedda", "pddda", "pedda", "eedda", "eeada", "eeaea", "eebda", "eebea", "eecda", "eecea", "eefda", "eefea", "eegda", "eegea", "eehda", "eehea", "eeida", "eeiea", "eejda", "eejea", "eekda", "eekea", "eelda", "eelea", "eemda", "eemea", "eenda", "eenea", "eeoda", "eeoea", "eepda", "eepea", "eeeea", "ggggg", "agggg", "ahggg", "bgggg", "bhggg", "cgggg", "chggg", "dgggg", "dhggg", "egggg", "ehggg", "fgggg", "fhggg", "igggg", "ihggg", "jgggg", "jhggg", "kgggg", "khggg", "lgggg", "lhggg", "mgggg", "mhggg", "ngggg", "nhggg", "ogggg", "ohggg", "pgggg", "phggg", "hhggg", "hhagg", "hhahg", "hhbgg", "hhbhg", "hhcgg", "hhchg", "hhdgg", "hhdhg", "hhegg", "hhehg", "hhfgg", "hhfhg", "hhigg", "hhihg", "hhjgg", "hhjhg", "hhkgg", "hhkhg", "hhlgg", "hhlhg", "hhmgg", "hhmhg", "hhngg", "hhnhg", "hhogg", "hhohg", "hhpgg", "hhphg", "hhhhg", "ahhhg", "aihhg", "bhhhg", "bihhg", "chhhg", "cihhg", "dhhhg", "dihhg", "ehhhg", "eihhg", "fhhhg", "fihhg", "ghhhg", "gihhg", "jhhhg", "jihhg", "khhhg", "kihhg", "lhhhg", "lihhg", "mhhhg", "mihhg", "nhhhg", "nihhg", "ohhhg", "oihhg", "phhhg", "pihhg", "iihhg", "iiahg", "iiaig", "iibhg", "iibig", "iichg", "iicig", "iidhg", "iidig", "iiehg", "iieig", "iifhg", "iifig", "iighg", "iigig", "iijhg", "iijig", "iikhg", "iikig", "iilhg", "iilig", "iimhg", "iimig", "iinhg", "iinig", "iiohg", "iioig", "iiphg", "iipig", "iiiig", "aiiig", "ajiig", "biiig", "bjiig", "ciiig", "cjiig", "diiig", "djiig", "eiiig", "ejiig", "fiiig", "fjiig", "giiig", "gjiig", "hiiig", "hjiig", "kiiig", "kjiig", "liiig", "ljiig", "miiig", "mjiig", "niiig", "njiig", "oiiig", "ojiig", "piiig", "pjiig", "jjiig", "jjaig", "jjajg", "jjbig", "jjbjg", "jjcig", "jjcjg", "jjdig", "jjdjg", "jjeig", "jjejg", "jjfig", "jjfjg", "jjgig", "jjgjg", "jjhig", "jjhjg", "jjkig", "jjkjg", "jjlig", "jjljg", "jjmig", "jjmjg", "jjnig", "jjnjg", "jjoig", "jjojg", "jjpig", "jjpjg", "jjjjg", "ajjjg", "akjjg", "bjjjg", "bkjjg", "cjjjg", "ckjjg", "djjjg", "dkjjg", "ejjjg", "ekjjg", "fjjjg", "fkjjg", "gjjjg", "gkjjg", "hjjjg", "hkjjg", "ijjjg", "ikjjg", "ljjjg", "lkjjg", "mjjjg", "mkjjg", "njjjg", "nkjjg", "ojjjg", "okjjg", "pjjjg", "pkjjg", "kkjjg", "kkajg", "kkakg", "kkbjg", "kkbkg", "kkcjg", "kkckg", "kkdjg", "kkdkg", "kkejg", "kkekg", "kkfjg", "kkfkg", "kkgjg", "kkgkg", "kkhjg", "kkhkg", "kkijg", "kkikg", "kkljg", "kklkg", "kkmjg", "kkmkg", "kknjg", "kknkg", "kkojg", "kkokg", "kkpjg", "kkpkg", "kkkkg", "ggggx", "gggxx", "ggxxx", "gxxxx", "xxxxx", "xxxxy", "xxxyy", "xxyyy", "xyyyy", "yyyyy", "yyyyw", "yyyww", "yywww", "ywwww", "wwwww", "wwvww", "wvvww", "vvvww", "vvvwz", "avvwz", "aavwz", "aaawz", "aaaaz")
        );
        ladderListwordProblem2Secondway("aaaaa","ggggg",list1).forEach(var->{
            System.out.println("ans is "+var);
        });
    }
}