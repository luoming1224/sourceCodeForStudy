package problems;

class TrieNode {
    public static final int ALPHABET_SIZE = 26;

    private int branch;

    private boolean isEnd;

    private char ch;

    public TrieNode[] child;

    public void incrBranch() {
        branch++;
    }

    public int getBranch() {
        return branch;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean getEnd() {
        return isEnd;
    }

    public void setCh(char c) {
        ch = c;
    }

    public char getCh() {
        return ch;
    }

    public TrieNode[] getChild() {
        return child;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    private void insertTrie(TrieNode root, String str) {
        if (str.length() == 0) {
            root.setEnd();
            return;
        }

        int i = 0, idx;
        TrieNode p = root;
        while (i < str.length()) {
            idx = str.charAt(i) - 'a';
            if (p.child == null) {
                p.child = new TrieNode[TrieNode.ALPHABET_SIZE];
                p.child[idx] = new TrieNode();
                p.incrBranch();
            } else if (p.child[idx] == null) {
                p.child[idx] = new TrieNode();
                p.incrBranch();
            }
            p = p.child[idx];
            p.setCh(str.charAt(i));
            i++;
        }
        p.setEnd();
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 0)
            return "";
        for (int i = 0; i < strs.length; ++i) {
            insertTrie(root, strs[i]);
        }

        int i = 0;
        StringBuilder builder = new StringBuilder();
        TrieNode p = root;
        while (p.getBranch() == 1 && !p.getEnd()) {
            p = p.child[strs[0].charAt(i) - 'a'];
            builder.append(p.getCh());
            i++;
        }
        return builder.toString();
    }
}

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 0)
            return "";

        int j = 0;
        while (true) {
            if (j == strs[0].length())
                return strs[0];
            char c = strs[0].charAt(j);
            for (int i = 1; i < strs.length; ++i) {
                if (j == strs[i].length())
                    return strs[i];
                if (strs[i].charAt(j) != c)
                    return strs[i].substring(0, j);
            }
            ++j;
        }

    }

    public static void main(String[] args) {
        String[] strs = {};
//        System.out.println(longestCommonPrefix(strs));

        Trie trie = new Trie();
        System.out.println(trie.longestCommonPrefix(strs));
    }
}
