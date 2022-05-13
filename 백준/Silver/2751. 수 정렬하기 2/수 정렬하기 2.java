import java.util.*;

public class Main {
    /*
    * 생각 정리:
    * # 각종 sorting을 연습해보기 좋은 기회인 것 같다.
    * # 그럼 일단 버블소트부터?
    * 2. 삽입정렬
    * 3. 선택정렬
    * 4. 머지소트
    * 5. 힙소트....하려다가 다음 기회에..^^.. 걍 컬렉션 이용해서 해결해둔다..^^..
    * */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }
//        sc.close();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(sc.nextInt());
        sc.close();

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for(int value : list) {
            sb.append(value).append('\n');
        }
        System.out.println(sb);
//        SortingAlgorithms sa = new SortingAlgorithms();
////        sa.bubbleSort(arr);
////        sa.insertionSort(arr);
////        sa.selectionSort(arr);
////        System.out.println(Arrays.toString(arr))
//
//        for (int i : sa.mergeSort(arr)) System.out.println(i);
    }
}
class SortingAlgorithms {

    /*
     * 버블소트:
     * 1) 가장 왼쪽의 두 수부터 비교해서
     * 2) 그 중 큰 수를 오른쪽으로 한 칸씩 밀며 비교해나간다.
     * 3) 끝에 도달한 수들은 다시 비교하지 않는다.
     * 1 ~ 3을 더 이상 비교할 수가 없을 때까지 반복한다.
     *
     * =================================================
     * 시간복잡도: 평균 O(n^2) / 최선 O(n) / 최악 O(n^2)
     * 공간복잡도: O(1)
     * stability: stable
     *
     * * =================================================
     * O(n^2)의 느린 정렬 알고리즘.
     *
     * */
    void bubbleSort(int[] arr) {
        int forSwap; //swap용 변수

        /*  i: 정리된(정리할) arr의 요소 위치. [0]부터 [len-1]까지의 요소가 모두 정리될 수 있도록.  */
        for (int loop = 0; loop < arr.length; loop++) {
            /*
                idx: 비교주체(idx)와 비교대상(idx + 1)을 설정할 인덱스.
                조건식 'arr.length - loop - 1' :
                    '- loop'하는 이유: 'i의 횟수'마다 맨 끝에 '정리된 숫자의 개수'가 생겨있을 것인데, (loop == 정리된 숫자개수)
                                   정리된 숫자는 다시 정리하지 않도록 loop 만큼 빼준다.
                    '- 1'하는 이유: 비교대상의 위치가 [idx + 1]이므로 OutOfIndex가 생기지 않도록 - 1해준다.
            */
            for (int compareIdx = 0; compareIdx < arr.length - loop - 1; compareIdx++) {

                if (arr[compareIdx] > arr[compareIdx + 1]) { // 비교 실행: 비교주체가 비교대상보다 크면 스왑
                    forSwap = arr[compareIdx];
                    arr[compareIdx] = arr[compareIdx + 1];
                    arr[compareIdx + 1] = forSwap;
                }
            }
        }

        // 주어진 메모리 영역 안에서 해결했기 때문에 따로 리턴할 필요는 없다(in-place).
    }

    /*
     * 삽입정렬:
     * 1) 가장 왼쪽에서 두번째 요소부터 삽입 요소로 삼는다.
     * 2) 삽입 요소보다 왼쪽에 있는 요소들은 비교대상이 된다.
     * 3) 비교대상을 훑으며 삽입요소가 들어가기 적당한 위치를 찾고
     * 4) 삽입하면 다음 삽입 요소로 넘어간다.
     * 1 ~ 4의 과정을 더이상 진행할 수 없을 때까지 반복한다.
     *
     * =================================================
     * 시간복잡도: 평균 O(n^2) / 최선 O(n) / 최악 O(n^2)
     * 공간복잡도: O(1)
     * stability: stable
     *
     * * =================================================
     * O(n^2)의 느린 정렬 알고리즘.
     *
     * */
    void insertionSort(int[] arr) {
        int forSwap;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    for (int x = j; x < i; x++) {
                        forSwap = arr[x];
                        arr[x] = arr[i];
                        arr[i] = forSwap;
                    }
                }
            }
        }

        // 역시 주어진 메모리 안에서 해결했으므로 리턴할 필요 없다.
        // O(n^2)임이 코드에 드러나도록 깔끔히 짜는 방법이 있을 것 같은데 아쉽다.
    }


    /*
     * 선택정렬:
     * 1) 비교대상 중 가장 왼쪽 요소를 스왑위치로 잡는다.
     * 2) 비교대상부터 오른쪽으로 훑으면서 그중 가장 작은 값의 요소를 기억한다.
     * 3) 스왑위치와 가장 작은 요소의 위치를 스왑한다.
     * 4) 스왑위치를 한칸 옆으로 옮기고 1~3을 반복실행한다.
     * 5) 스왑위치가 배열을 벗어나면 종료.
     *
     * =================================================
     * 시간복잡도: 평균 O(n^2) / 최선 O(n^2) / 최악 O(n^2)
     * 공간복잡도: O(1)
     * stability: unstable
     *
     * * =================================================
     * O(n^2)의 느린 정렬 알고리즘.
     *
     * */
    public void selectionSort(int[] arr) {
        int tmpval, tmpidx;
        for (int i = 0; i < arr.length; i++) {
            tmpidx = i;
            tmpval = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (tmpval > arr[j]) {
                    tmpval = arr[j];
                    tmpidx = j;
                }
            }
            tmpval = arr[tmpidx];
            arr[tmpidx] = arr[i];
            arr[i] = tmpval;
        }
    }


    /*
     * 머지소트:
     * 1) 배열의 중간을 기준으로 잘라 왼쪽 배열 오른쪽 배열을 생성한다. 더 나눌 수 없을 때까지(하나의 원소만 남을때까지) 재귀적으로 나눈다.
     * 2) 합치며 더 작은 숫자가 배열 앞쪽에 위치하도록 스왑한다. 더 합칠 수 없을 때까지(배열이 하나만 남을때까지) 재귀적으로 합친다.
     * 3) 재귀가 끝나며 종료.
     *
     * =================================================
     * 시간복잡도: 평균 O(nlogn) / 최선 O(nlogn) / 최악 O(nlogn)
     * 공간복잡도: O(n)
     * stability: stable
     *
     * * =================================================
     * 그 이름도 유명한 폰 노이만이 고안한 알고리즘.
     *
     * */
    public int[] mergeSort(int[] arr) {
        /* 메모리고 나발이고 모르겠다... */
        if (arr.length < 2) return arr;

        int mid = arr.length / 2;
        int[] lowArr = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] highArr = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        int[] mergedArr = new int[arr.length];
        int l = 0, m = 0, h = 0;
        while (l < lowArr.length && h < highArr.length)
            if (lowArr[l] < highArr[h]) mergedArr[m++] = lowArr[l++];
            else mergedArr[m++] = highArr[h++];
        while (l < lowArr.length) mergedArr[m++] = lowArr[l++];
        while (h < highArr.length) mergedArr[m++] = highArr[h++];

        return mergedArr;
    }
}
