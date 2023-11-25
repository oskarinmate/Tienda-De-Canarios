import java.util.concurrent.Semaphore;

class TiendaDeCanarios {
    // semaforo que comtrola el acceso al plato de llos canarios
    private Semaphore semaforoPlato = new Semaphore(3);
    // semaforo que controla el acceso al plato de llos canarios
    private Semaphore semaforoColumpio = new Semaphore(1);

    public void comerDelPlato(int id) throws InterruptedException {
        // pide permiso al semaforo del plato para que pueda comer el pajaro
        semaforoPlato.acquire();
        // mensaje para mostrar que canario se está columpiando
        System.out.println("Canario " + id + " está comiendo del plato.");
        // Simulacion del tiempo que se tarda un canario en comer
        Thread.sleep(1000);
        // suelta el permiso del semaforo para el platito
        semaforoPlato.release();
    }

    public void columpiarPajaros(int id) throws InterruptedException {
        // pide permiso al semaforo del columpio
        semaforoColumpio.acquire();
        // mensaje para mostrar que canario se está columpiando
        System.out.println("Canario " + id + " se está columpiando.");
        // Simulacion del tiempo que se tarda un canario en comer
        Thread.sleep(1000);
        // suelta el permiso del semaforo para el columpio
        semaforoColumpio.release();
    }
}
