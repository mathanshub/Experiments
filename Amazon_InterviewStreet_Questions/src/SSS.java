import java.util.*;
 
public class SSS {
 
 public static int k;
 public static int str_arr[];
 public static String str_arr1[];
 public static HashMap<String,Integer> t;
 public static HashMap<Integer,Integer> t1;
 public static int num_words;
 public static List<String> ll;
 public static int res_words;
 public static int start;
 public static int end;
 public static int min_start;
 public static int min_end;
  
 public static void main(String[] args) 
 {
  Scanner in = new Scanner(System.in);
  String str = in.nextLine();
   
  str = str.replaceAll("[,|.|!|@|#|$|%|^|&|*|(|)|{|}|<|>|/|-|_|~|`|\\d]", "");
  k = in.nextInt();
  t = new HashMap<String,Integer> ();
  t1 = new HashMap<Integer,Integer> ();  
  in.nextLine();  
  str_arr1 = str.split(" ");
  str_arr = new int[str_arr1.length];
   
  ll = new LinkedList<String>();
   
  for(int i=0;i<k;i++)
  {
   String s = in.nextLine().toLowerCase();
                        int tmp = 0;
   boolean flag = false;
   try
   {
    tmp = t.get(s);
    flag = true;
   }
   catch(Exception ex){}
    
   if(flag == false)
   {
    ll.add(s);
    t.put(s, i);
   }
  }
   
  for(int i=0;i<str_arr1.length;i++)
  {
   try
   {
    int tmp = t.get(str_arr1[i].toLowerCase());
    str_arr[i] = tmp;
   }
   catch(Exception ex)
   {
    str_arr[i] = -1;
   }
  }
   
  start = end = 0;
  min_start = min_end = 0;
  boolean found = false;
  res_words = Integer.MAX_VALUE;
   
  for(int i=0;i<str_arr.length;i++)
  {
   if(str_arr[i] != -1)
   {
    start = i;
    check(i);
    t1 = new HashMap<Integer,Integer> ();
    if(end != -1)
    {
     if(res_words > num_words)
     {
                                            found = true;
                                            res_words = num_words;
                                            min_start = start;
                                            min_end = end;
     } 
    }
                                else
                                {
                                    break;
                                }
     
    if( (i + num_words) >= str_arr.length-1 || (i + ll.size()) > str_arr.length-1)
    {
     break;
    } 
   }
  }
  if(found == true)
  {
   for(int i=min_start;i<min_end;i++)
   {
    System.out.print(str_arr1[i] + " ");
   }
   System.out.print(str_arr1[min_end]);
  }
  else
  {
      System.out.println("NO SUBSEGMENT FOUND");
  } 
 }
     
 public static void check(int i)
 {
  num_words = 0;
 
                for(int j=i;j<str_arr1.length;j++)
  {
   if(str_arr[j] != -1)
   {
    int tmp = 0;
    try
    {
     tmp = t1.get(str_arr[j]);
    }
    catch(Exception ex)
    {
     t1.put(str_arr[j], 1);
    }
     
    end = j;
    if(num_words >= ll.size()-1)
    {
     if(t1.size() == ll.size())
     {
      return;
     }
    }
   }
   else
   {
    end = j;
   }
   num_words++;
   if(num_words > res_words)
   {
    end = -1;
    return;
   }
  }
  end = -1;
  return;
 }
  
  
}