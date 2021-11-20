import java.util.LinkedList;

public class ScoreBoard {

    public final String[] fields;
    public LinkedList<String[]> results = new LinkedList<>();

    public ScoreBoard(String[] fields){
        this.fields = fields;
    }
    public void addResult(String[] results){
        if(results.length == fields.length){
            this.results.add(results);
        }
        else{
            throw(new IndexOutOfBoundsException());
        }
    }
    public void getResults(int i){
        printline(fields);
        int x=0;
        for(String[] r: results){
            if(x<i){
                printline(r);
                x++;
            }
            else{
                break;
            }
        }
    }
    private void printline(String[] i){
        for(String s : i){
            System.out.printf("%-15s", s);
        }
        System.out.println();
    }
}
