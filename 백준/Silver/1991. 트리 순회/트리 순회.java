import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static StringBuilder result;
    private static Map<Character, Character[]> myTreeMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        myTreeMap = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Character root = st.nextToken().toCharArray()[0];
            Character left = st.nextToken().toCharArray()[0];
            left = left == '.' ? null : left;
            Character right = st.nextToken().toCharArray()[0];
            right = right == '.' ? null : right;
            myTreeMap.put(root, new Character[]{left, right});
        }
        br.close();

        result = new StringBuilder();
        preorder();
        inorder();
        postorder();
        System.out.println(result);
    }

    private static void preorder() {
        preorder('A');
        result.append(System.lineSeparator());
    }
    private static void inorder() {
        inorder('A');
        result.append(System.lineSeparator());
    }
    private static void postorder() {
        postorder('A');
        result.append(System.lineSeparator());
    }
    private static void preorder(Character nodeData) {
        if (myTreeMap.get(nodeData) == null) return;
        result.append(nodeData);
        preorder(myTreeMap.get(nodeData)[0]);
        preorder(myTreeMap.get(nodeData)[1]);
    }
    private static void inorder(Character nodeData) {
        if (myTreeMap.get(nodeData) == null) return;
        inorder(myTreeMap.get(nodeData)[0]);
        result.append(nodeData);
        inorder(myTreeMap.get(nodeData)[1]);
    }
    private static void postorder(Character nodeData) {
        if(myTreeMap.get(nodeData) == null) return;
        postorder(myTreeMap.get(nodeData)[0]);
        postorder(myTreeMap.get(nodeData)[1]);
        result.append(nodeData);
    }

}