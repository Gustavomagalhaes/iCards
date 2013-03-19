package xCards;

import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 *
 * @author Gustavo
 */
public class Data {
    public static void main(String[] args) {
        Calendar data = Calendar.getInstance();
        SimpleDateFormat now = new SimpleDateFormat("dd/MM/yyyy");
        String today = now.format(data.getTime());
        
        System.out.println(today); // Variável com a data 
        
    }
}
