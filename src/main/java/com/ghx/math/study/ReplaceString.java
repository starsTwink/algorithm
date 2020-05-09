package com.ghx.math.study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author：ghx
 * @date：2020/5/2 23:14
 * @describe：替换空格
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceString {

    public static Logger logger = LoggerFactory.getLogger(ReplaceString.class);

//    public String replaceSpace(StringBuffer str) {
//        String replace = str.toString().replace(" ", "%20");
//           return replace;
//    }

    public String replaceSpace(StringBuffer str) {
        int spacenum = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                spacenum++;
            }
        }

        int oldLength = str.length();
        int oldIndex = oldLength - 1;
        int newLength = oldLength + spacenum*2;
        str.setLength(newLength);
        int newIndex = newLength - 1;
        for(; oldIndex >= 0 && oldLength < newLength; oldIndex--){
            if(str.charAt(oldIndex) == ' '){
                str.setCharAt(newIndex--, '0');
                str.setCharAt(newIndex--, '2');
                str.setCharAt(newIndex--, '%');
            }else{
                str.setCharAt(newIndex--, str.charAt(oldIndex));
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("apple   d");
        String replace = str.toString().replace(" ", "%20");
        logger.info(""+replace);
    }
}
