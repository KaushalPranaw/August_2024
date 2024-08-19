package Array_String;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        System.out.println(new TextJustification().fullJustify(words, maxWidth));
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        int index = 0;
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                //if adding the next word exceed the maxWidth; break
                if (count + words[last].length() + 1 > maxWidth) {
                    break;
                }
                count += words[last].length() + 1;
                last++;
            }

            StringBuilder sb = new StringBuilder();
            sb.append(words[index]);
            int diff = last - index - 1;

            //if we are on the last line or line has only one word - left-justify
            if (last == words.length || diff == 0) {
                for (int i = index + 1; i < last; i++) {
                    sb.append(" ");
                    sb.append(words[i]);
                }
                for (int i = sb.length(); i < maxWidth; i++) {
                    sb.append(" ");
                }
            } else {
                int spaces = (maxWidth - count) / diff;
                int extraSpaces = (maxWidth - count) % diff;
                for (int i = index + 1; i < last; i++) {
                    for (int s = spaces; s > 0; s--) {
                        sb.append(" ");
                    }
                    if (extraSpaces > 0) {
                        sb.append(" ");
                        extraSpaces--;
                    }
                    sb.append(" ");
                    sb.append(words[i]);
                }
            }
            list.add(sb.toString());
            index = last;
        }
        return list;

    }
}
