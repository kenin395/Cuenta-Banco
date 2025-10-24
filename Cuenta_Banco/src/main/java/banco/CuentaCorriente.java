package banco;

public class CuentaCorriente extends Cuenta {
    private float sobregiro = 0;

    public CuentaCorriente(float saldoInicial, float tasaAnual) {
        super(saldoInicial, tasaAnual);
    }

    @Override
    public void retirar(float cantidad) {
        if (cantidad <= saldo) {
            super.retirar(cantidad);
        } else {
            float faltante = cantidad - saldo;
            saldo = 0;
            sobregiro += faltante;
            numRetiros++;
            System.out.println("Saldo insuficiente. Se generó sobregiro de $" + faltante);
        }
    }

    @Override
    public void consignar(float cantidad) {
        if (sobregiro > 0) {
            if (cantidad > sobregiro) {
                cantidad -= sobregiro;
                sobregiro = 0;
                saldo += cantidad;
            } else {
                sobregiro -= cantidad;
            }
        } else {
            super.consignar(cantidad);
        }
        numConsignaciones++;
    }

    @Override
    public void extractoMensual() {
        super.extractoMensual();
    }

    @Override
    public void imprimir() {
        System.out.println("=== CUENTA CORRIENTE ===");
        super.imprimir();
        System.out.println("Sobregiro: $" + sobregiro);
        System.out.println("Total transacciones: " + (numConsignaciones + numRetiros));
        System.out.println("=========================\n");
    }
}
