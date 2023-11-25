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

// Runnable para los hilos que se van a crear
class Canario implements Runnable {

    // se pone final para que el valor del parametro no sea alterado en el futuro
    private final TiendaDeCanarios tienda;
    private final int id;

    // constructor de la clase canario
    public Canario(TiendaDeCanarios tienda, int id) {
        this.tienda = tienda;
        this.id = id;
    }

    @Override
    public void run() {
        try {

            // creamos un for para que tenga un fin

            for (int i = 0; i < 5; i++) {
                tienda.comerDelPlato(id);
                tienda.columpiarPajaros(id);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // main parar correr el programa
    public static void main(String[] args) {
        TiendaDeCanarios tienda = new TiendaDeCanarios();

        // creamos un for para iterar la variable i
        // este for va a crear solo 5 pajaros y pasamos el numero de iteracion como
        // parametro del thread, que esta almacenado en la class Canario
        for (int i = 1; i <= 5; i++) {
            Thread canarioThread = new Thread(new Canario(tienda, i));
            canarioThread.start();
        }
    }
}
