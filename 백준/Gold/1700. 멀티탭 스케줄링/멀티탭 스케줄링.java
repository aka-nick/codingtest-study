import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        List<Device> electrics = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            electrics.add(new Device(Integer.parseInt(st.nextToken()), i));
        }
        br.close();

        int count = 0;

        Device[] multitab = new Device[n];
        for (int i = 0; i < electrics.size(); i++) {
            Device device = electrics.get(i);

            // 꽂으려는게 이미 꽂혀있는 경우
            int numberOfPluggedIn = getNumberOfPluggedIn(multitab, device);
            if (numberOfPluggedIn != -1) {
                multitab[numberOfPluggedIn].usedNumber = device.usedNumber;
                continue;
            }

            // 빈탭이 있는 경우
            int emptyTabNumber = getEmptyTabNumber(multitab);
            if (emptyTabNumber != -1) {
                multitab[emptyTabNumber] = device;
                continue;
            }

            // 하나 뽑아야 하는 경우: 금방 써야할 건 늦게 뽑는다, 다시 안 쓸 건 바로 뽑는다. 뽑은 자리에 꼽기.
            int[] queueNumbers = new int[multitab.length];
            Arrays.fill(queueNumbers, -1);
            for (int j = 0; j < queueNumbers.length; j++) {
                int dNumber = multitab[j].deviceNumber;
                setWaitingNumberForQueue(electrics, i, queueNumbers, j, dNumber);
            }
            int toRemove = getNumberToRemove(queueNumbers);
            multitab[toRemove] = device;
            count++;
        }

        System.out.println(count);
    }

    private static int getNumberToRemove(int[] queueNumbers) {
        // 금방 써야할 건 늦게 뽑는다, 다시 안 쓰는 건 바로 뽑는다
        int toRemove = -1; // 제거할 멀티탭 인덱스
        int max = -1;
        for (int i = 0; i < queueNumbers.length; i++) {
            if (queueNumbers[i] == -1) {
                return i;
            }
            if (max < queueNumbers[i]) {
                max = queueNumbers[i];
                toRemove = i;
            }
        }
        return toRemove;
    }

    private static void setWaitingNumberForQueue(
            List<Device> electrics, int i, int[] queueNumbers, int j, int dNumber) {

        for (int l = i + 1; l < electrics.size(); l++) {
            if (dNumber == electrics.get(l).deviceNumber) {
                queueNumbers[j] = electrics.get(l).usedNumber;
                break;
            }
        }
    }

    private static int getEmptyTabNumber(Device[] multitab) {
        for (int i = 0; i < multitab.length; i++) {
            if (multitab[i] == null) {
                return i;
            }
        }
        return -1;
    }

    private static int getNumberOfPluggedIn(Device[] multitab, Device device) {
        for (int i = 0; i < multitab.length; i++) {
            if (multitab[i] != null &&
                    multitab[i].deviceNumber == device.deviceNumber) {
                return i;
            }
        }
        return -1;
    }

    static class Device {
        int deviceNumber;
        int usedNumber;

        public Device(int deviceNumber, int usedNumber) {
            this.deviceNumber = deviceNumber;
            this.usedNumber = usedNumber;
        }
    }

}