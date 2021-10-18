import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int length = musicinfos.length;
        int[] time = new int[length];
        String[] title = new String[length];
        String[] music = new String[length];

        for (int i = 0; i < length; i++) {
            time[i] = Integer.parseInt(musicinfos[i].split(",")[1].split(":")[0])*60
                      + Integer.parseInt(musicinfos[i].split(",")[1].split(":")[1])
                      - Integer.parseInt(musicinfos[i].split(",")[0].split(":")[0])*60
                      - Integer.parseInt(musicinfos[i].split(",")[0].split(":")[1]);
            title[i] = musicinfos[i].split(",")[2];
            music[i] = convert(musicinfos[i].split(",")[3]);
        }

        int t = 0;
        for (int i = 0; i < length; i++) {
            if(t < time[i]) {
                StringBuilder s = new StringBuilder();
                for (int j = 0; j < time[i]; j++) {
                	s.append(music[i].charAt(j % music[i].length()));
                }
                if (s.toString().contains(convert(m))) {
                	answer = title[i];
                	t = time[i];
                }
            }
        }
      
        return answer;
    }
	
    public static String convert(String s) {
    	for (int j = 0; j < s.length(); j++) {
        	if(s.charAt(j) == '#') {
            	s = s.substring(0, j - 1) + s.substring(j - 1, j).toLowerCase() + s.substring(j + 1);
          	}
      	}
      	return s;
    }

}
