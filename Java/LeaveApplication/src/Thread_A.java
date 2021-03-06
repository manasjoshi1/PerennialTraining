 public class Thread_A implements Runnable {

     private SharedClass sharedObj;
     public Thread_A(SharedClass obj) {
         this.sharedObj = obj;
     }
     @Override
     public void run() {
             int i = 0;


             while (true) {
                 synchronized(sharedObj) {


                     if (sharedObj.isDone()) {

                         try {
                             sharedObj.wait();
                         } catch (InterruptedException e) { // TOO Auto-generated catch block 
                             e.printStackTrace();
                         }
                     }
                     this.sharedObj.setDone(true);

                         try {

                             Thread.sleep(1000);

                             System.out.println("property changed by" +Thread.currentThread().getName()+" Now notifying");

                             sharedObj.notify();
                         }
                     catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
             }
     }
 }