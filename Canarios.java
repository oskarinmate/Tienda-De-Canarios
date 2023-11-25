class Canarios implements Runnable {

    // se pone final para que el valor del parametro no sea alterado en el futuro
    private final TiendaDeCanarios tienda;
    private final int id;

    // constructor de la clase canario
    public Canarios(TiendaDeCanarios tienda, int id) {
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

}
