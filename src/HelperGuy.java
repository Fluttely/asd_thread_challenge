public class HelperGuy implements Runnable {
    private final Bucket bucket;
    private final int workTime;

    public HelperGuy(Bucket bucket, int workTime) {
        this.bucket = bucket;
        this.workTime = workTime;
    }

    public void run() {
        long initialTime = System.currentTimeMillis();

        while (System.currentTimeMillis() - initialTime < workTime) {
            try {
                // enche o balde com 3 litros por vez
                bucket.encher(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Se o balde estiver cheio, aguarda 2 segundos antes de tentar encher novamente
            if (bucket.getActualCapacity() == bucket.getMaxCapacity()) {
                try {
                    System.out.println("O balde está cheio. Aguardando 2 segundos...");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}