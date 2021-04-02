/**
 * 
 */
package me.learn.personal.mocks;

import java.util.ArrayList;
import java.util.List;

/**
 * Title 68 :
 * 
 * Date : Feb 7, 2021
 * 
 * @author bramanarayan
 *
 */
public class TextJustification {

	// keep appending the characters
	// as sooon as you get max length then  addLine
	public List<String> fullJustify(String[] words, int limit) {
        
        List<String> result = new ArrayList<>();
        int len = -1 , count = -1, start = 0;
        
        for(int i=0;i<words.length;i++){            
            if(len+words[i].length()+1<=limit){
                len += words[i].length()+1;
                count++;                
            }
            else{                 
                addLine(words,start,i-1,len,count,limit,result,false);
                start = i;
                i--;
                len = -1;
                count= -1;
            }
        }
        addLine(words,start,words.length-1,len,count,limit,result,true);
        return result;
    }
    
    public void addLine(String[] words,int start, int end, int len, int count, int maxWidth, List<String> result,boolean isLast){
        
            int spaces = maxWidth-len;
            spaces += count;         
            int same = isLast || (count==0)? 0 : spaces/count;
            int extra = isLast || (count==0)? count : spaces%count;        
            int trail = isLast || (count==0) ? maxWidth-len : 0;
						
            StringBuilder line = new StringBuilder();
                
            while(start<=end){
                line.append(words[start]);                    
                for(int k=0;k<same && start!=end;k++)
                    line.append(' ');
                    
                if(extra>0){
                    line.append(' ');
                    extra--;
                }
                start++;
            }        
            while(trail>0){
                line.append(' ');
                trail--;
            }                
            result.add(line.toString());
    }


}
