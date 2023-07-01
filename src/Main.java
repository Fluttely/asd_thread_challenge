public class Main {
    public static void main(String[] args) {
        Bucket bucket = new Bucket();
        int workTime = 120000; // 2 minutos em milissegundos

        HelperGuy helperGuy1 = new HelperGuy(bucket, workTime);
        HelperGuy helperGuy2 = new HelperGuy(bucket, workTime);
        HelperGuy helperGuy3 = new HelperGuy(bucket, workTime);

        WasherGuy washer = new WasherGuy(bucket, workTime);

        Thread threadHelperGuy1 = new Thread(helperGuy1);
        Thread threadHelperGuy2 = new Thread(helperGuy2);
        Thread threadHelperGuy3 = new Thread(helperGuy3);
        Thread threadWasherGuy = new Thread(washer);

        threadWasherGuy.start();
        threadHelperGuy1.start();
        threadHelperGuy2.start();
        threadHelperGuy3.start();

        try {
            // espera o lavador terminar de trabalhar
            threadWasherGuy.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

