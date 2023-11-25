public class main {
    public static void main(String[] args) {
        TiendaDeCanarios tienda = new TiendaDeCanarios();

        // creamos un for para iterar la variable i
        // este for va a crear solo 5 pajaros y pasamos el numero de iteracion como
        // parametro del thread, que esta almacenado en la class Canario
        for (int i = 1; i <= 5; i++) {
            Thread canarioThread = new Thread(new Canarios(tienda, i));
            canarioThread.start();
        }
    }

}
