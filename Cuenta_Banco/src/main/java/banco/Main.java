package banco;

public class Main {
    public static void main(String[] args) {
        // Crear una cuenta de ahorros
        CuentaAhorros ahorro = new CuentaAhorros(50f, 12f);

        ahorro.consignar(20f);
        ahorro.retirar(10f);
        ahorro.retirar(5f);
        ahorro.retirar(3f);
        ahorro.retirar(2f);
        ahorro.retirar(1f); // este genera comisión adicional
        ahorro.extractoMensual();
        ahorro.imprimir();

        // Crear una cuenta corriente
        CuentaCorriente corriente = new CuentaCorriente(100f, 10f);
        corriente.retirar(120f); // genera sobregiro
        corriente.consignar(50f); // reduce el sobregiro
        corriente.extractoMensual();
        corriente.imprimir();
    }
}

