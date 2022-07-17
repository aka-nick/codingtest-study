class Solution {
    public String solution(String m, String[] musicinfos) {
        String result = "(None)";
        int longestRunningTime = 0;
        m = sharpToLower(m);

        for (int i = 0; i < musicinfos.length; i++) {
            String[] info = musicinfos[i].split(",");

            int runningTime  = getRunningTime(info[0], info[1]);
            String title     = info[2];
            String notes     = sharpToLower(info[3]);
            int songTime     = notes.length();
            String playNotes = getPlayNotes(notes, runningTime, songTime);

            if (playNotes.contains(m)) {
                if ("(None)".equals(result)) {
                    result = title;
                    longestRunningTime = runningTime;
                }
                else {
                    if (longestRunningTime < runningTime) {
                        result = title;
                        longestRunningTime = runningTime;
                    }
                }
            }
        }

        return result;
    }

    String sharpToLower(String str) {
        str = str.replace("C#", "c");
        str = str.replace("D#", "d");
        str = str.replace("F#", "f");
        str = str.replace("G#", "g");
        str = str.replace("A#", "a");
        return str;
    }

    int getRunningTime(String time1, String time2) {
        String[] t1 = time1.split(":");
        String[] t2 = time2.split(":");
        int startTime = (Integer.parseInt(t1[0]) * 60) + Integer.parseInt(t1[1]);
        int endTime = (Integer.parseInt(t2[0]) * 60) + Integer.parseInt(t2[1]);
        return endTime - startTime;
    }

    String getPlayNotes(String notes, int runningTime, int songTime) {
        int playCount = runningTime / songTime;
        int remainNotesCount = runningTime % songTime;

        String tmp = "";
        for (int i = 0; i < playCount; i++) {
            tmp += notes;
        }
        tmp += notes.substring(0, remainNotesCount);

        return tmp;
    }
}