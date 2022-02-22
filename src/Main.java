
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    public static void main(String[] args) {
        
        ExecutorService executor = Executors.newFixedThreadPool(2);
        //thread havuzu atamak için newFixedThreadPool kullanıyorum yanda belirtilen sayı en fazla kaç thread aynı anda çalışacaksa onu belirtiyor
        
        for (int i = 1 ;  i <=5 ;i++){
            
            executor.submit(new Worker(String.valueOf(i), i));
            //new Worker yeni thread oluşturuyor
            
        }
        
        executor.shutdown();
        //başka bir iş ataması yaptıktan sonra başka bir iş kabul etmemek için kullanılır.
        System.out.println("Bütün işler teslim edildi...");
        
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
            // programın bitmesi için en fazla beklenecek süreyi belirtiyoruz
          } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }  
         System.out.println("Bütün işler bitti...");   
            
            
            /*
            Birden fazla thread kullanımında kod uzunluğu artıyor
            Thread t1 = new Thread(new Worker("1", 1));
            Thread t2 = new Thread(new Worker("2", 2));
            Thread t3 = new Thread(new Worker("3", 3));
            Thread t4 = new Thread(new Worker("4", 4));
            Thread t5 = new Thread(new Worker("5", 5));
            System.out.println("Bütün işler teslim edildi...");
            t1.start();
            t2.start();
            
            try {
            t1.join();
            t2.join();
            join t1 ve t2 işini bitirmeden diğer threadlerin çalışması bitene kadar main bloğunu blokluyor şeklinde düşünebiliriz
            } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            t3.start();
            t4.start();
            
            try {
            t3.join();
            t4.join();
            } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            t5.start();
            
            try {
            t5.join();
            
            } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Bütün işler tamamlandı...");*/
        
    }
    
}
