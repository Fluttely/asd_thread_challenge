public class WasherGuy implements Runnable {
    private final Bucket bucket;
    private final int workTime;

    public WasherGuy(Bucket bucket, int workTime) {
        this.bucket = bucket;
        this.workTime = workTime;
    }

    public void run() {
        long initialTime = System.currentTimeMillis();
        boolean emptyBucket = false;

        while (!emptyBucket && System.currentTimeMillis() - initialTime < workTime) {
            try {
                // esvazia o balde com 10 litros por vez
                bucket.empty();

                // verifica se o balde está vazio
                if (bucket.getActualCapacity() == 0) {
                    emptyBucket = true;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("O lavador esvaziou o balde " + bucket.getTimesWasherWentToTheBucket() + " vezes.");
    }
}
