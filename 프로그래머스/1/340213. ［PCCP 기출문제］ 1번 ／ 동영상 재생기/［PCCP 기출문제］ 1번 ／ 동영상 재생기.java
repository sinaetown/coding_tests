class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int videoSeconds = toSeconds(video_len);
        int posSeconds = toSeconds(pos);
        int startSeconds = toSeconds(op_start);
        int endSeconds = toSeconds(op_end);
        if ((startSeconds <= posSeconds) && (posSeconds <= endSeconds)) posSeconds = endSeconds;
        for (int c = 0; c < commands.length; c++) {
            if (commands[c].equals("next")) {
                posSeconds += 10;
            } else if (commands[c].equals("prev")) {
                posSeconds -= 10;
            }
            if (posSeconds < 10) posSeconds = 0;
            if (videoSeconds - posSeconds < 10) posSeconds = videoSeconds;
            if ((startSeconds <= posSeconds) && (posSeconds <= endSeconds)) posSeconds = endSeconds;
        }
        String min = (Integer.toString(posSeconds / 60).length() == 1) ? "0" + Integer.toString(posSeconds / 60) : Integer.toString(posSeconds / 60);
        String sec = (Integer.toString(posSeconds % 60).length() == 1) ? "0" + Integer.toString(posSeconds % 60) : Integer.toString(posSeconds % 60);
        answer = min + ":" + sec;
        return answer;
    }

    public int toSeconds(String s) {
        String[] arr = s.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
}