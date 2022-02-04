import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.net.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
//import com.google.gson.Gson;


class Twillo {

    /*
     * Complete the 'getArticleTitles' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING author as parameter.
     *
     * URL for cut and paste:
     * https://jsonmock.hackerrank.com/api/articles?author=<authorName>&page=<num>
     *
     */

    public static List<String> getArticleTitles(String author) {
        int currentPage = 0;
        int totalPage = 1;
        Response response = null;
        List<String> output = new ArrayList<>();
        while(currentPage<totalPage){
            String spec = "https://jsonmock.hackerrank.com/api/articles?author="+author+"&page="+currentPage;
            try{
                URL url = new URL(spec);

                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                int responseCode = con.getResponseCode();
                String resp="";
                System.out.println(responseCode);
                if (responseCode == con.HTTP_OK) { // success
                    BufferedReader in = new BufferedReader(new InputStreamReader(
                            con.getInputStream()));
                    String inputLine;
                    StringBuffer responseString = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        responseString.append(inputLine);
                    }
                    in.close();
                    resp=response.toString();
                }
                System.out.println("the output::::"+resp);
              //  Gson obj=new Gson();
                response = null;//obj.fromJson(resp,Response.class);
            } catch(Exception ex){
                System.err.println("getting exception");
            }

            totalPage = response.getTotalPage();
            currentPage++;
            List<Data> dataList= response.getData();
            for(Data dataObject:dataList){
                String title = dataObject.getTitle();
                String storyTitle = dataObject.getStoryTitle();
                if(title!=null){
                    output.add(title);
                } else if(storyTitle!=null){
                    output.add(storyTitle);
                }
            }
        }
        return output;
    }

    public class Response{
        private int page;
        private int per_page;
        private int total;
        private int total_pages;
        private List<Data> data;
        public int getPage(){
            return page;
        }
        public int getPerPage(){
            return per_page;
        }
        public int getTotal(){
            return total;
        }
        public int getTotalPage(){
            return total_pages;
        }
        public List<Data> getData(){
            return data;
        }
    }
    class Data{
        private String title;
        private String url;
        private String author;
        private String num_comments;
        private String story_id;
        private String story_title;
        private String story_url;

        public String getTitle(){
            return title;
        }
        public String getStoryTitle(){
            return story_title;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String author = bufferedReader.readLine();

        List<String> result = null;//Result.getArticleTitles(author);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}


