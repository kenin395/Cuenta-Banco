package banco;

public class CuentaAhorros extends Cuenta {
    private boolean activa;

    public CuentaAhorros(float saldoInicial, float tasaAnual) {
        super(saldoInicial, tasaAnual);
        this.activa = saldoInicial >= 10;
    }

    @Override
    public void consignar(float cantidad) {
        if (activa) {
            super.consignar(cantidad);
        } else {
            System.out.println("Cuenta inactiva. No se puede consignar.");
        }
    }

    @Override
    public void retirar(float cantidad) {
        if (activa) {
            super.retirar(cantidad);
        } else {
            System.out.println("Cuenta inactiva. No se puede retirar.");
        }
    }

    @Override
    public void extractoMensual() {
        // Comisión si hay más de 4 retiros
        if (numRetiros > 4) {
            comisionMensual += (numRetiros - 4);
        }
        super.extractoMensual();
        activa = saldo >= 10; // Actualiza el estado
    }

    @Override
    public void imprimir() {
        System.out.println("=== CUENTA DE AHORROS ===");
        super.imprimir();
        System.out.println("Cuenta activa: " + activa);
        System.out.println("Total transacciones: " + (numConsignaciones + numRetiros));
        System.out.println("==========================\n");
    }
}
