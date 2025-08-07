import java.io.*;
import java.util.*;

public class Main {

    public static class TrieNode {
        //알파벳의 자식 노드들
        Map<Character, TrieNode> children = new HashMap<>();
        //이 노드까지 도달한 단어들의 입력 순서 인덱스 목록
        List<Integer> indices = new ArrayList<>();
    }

    public static class Result {
        int length = -1;
        int i1, i2 = -1;
    }

    public static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TrieNode root = new TrieNode();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            list.add(word);
            insert(root, list.get(i), i);
        }
        Result res = new Result();
        dfs(root, 0, res);
        System.out.println(list.get(res.i1) + "\n" + list.get(res.i2));
    }

    public static void insert(TrieNode root, String word, int index) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
            node.indices.add(index);
        }
    }

    public static void dfs(TrieNode node, int depth, Result res) {
        if (node.indices.size() >= 2) { //겹치는 단어가 두 개 이상일 경우
            if (depth > res.length || //만약 접두사의 길이가 더 길어질 수 있다면 바로 proceed
                    //접두사의 길이가 같은데 첫 번째 단어의 인덱스가 더 빠르다면
                    (depth == res.length && (node.indices.get(0) < res.i1
                            //접두사의 길이도 같고, 첫 번째 단어의 인덱스도 같은데 두 번째 나오는 단어의 인덱스가 더 빠르다면
                            || (node.indices.get(0) == res.i1 && node.indices.get(1) < res.i2)))) {
                //길이 갱신
                //두 단어 모두 갱신
                res.length = depth;
                //여러 개가 겹친다고 해도 가장 먼저 오는 앞 단어만 필요
                res.i1 = node.indices.get(0);
                res.i2 = node.indices.get(1);
            }
        }

        for (TrieNode child : node.children.values()) {
            dfs(child, depth + 1, res);
        }
    }
}

