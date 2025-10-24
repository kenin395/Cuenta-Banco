package banco;

public class Cuenta {
    // ====== Atributos protegidos ======
    protected float saldo;
    protected int numConsignaciones = 0;
    protected int numRetiros = 0;
    protected float tasaAnual;
    protected float comisionMensual = 0;

    // ====== Constructor ======
    public Cuenta(float saldoInicial, float tasaAnual) {
        this.saldo = saldoInicial;
        this.tasaAnual = tasaAnual;
    }

    // ====== Métodos ======
    public void consignar(float cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            numConsignaciones++;
        }
    }

    public void retirar(float cantidad) {
        if (cantidad <= saldo && cantidad > 0) {
            saldo -= cantidad;
            numRetiros++;
        } else {
            System.out.println("Fondos insuficientes para retirar " + cantidad);
        }
    }

    public void calcularInteresMensual() {
        float tasaMensual = tasaAnual / 12;
        float interes = saldo * (tasaMensual / 100);
        saldo += interes;
    }

    public void extractoMensual() {
        saldo -= comisionMensual;
        calcularInteresMensual();
    }

    public void imprimir() {
        System.out.println("Saldo: $" + saldo);
        System.out.println("Número de consignaciones: " + numConsignaciones);
        System.out.println("Número de retiros: " + numRetiros);
        System.out.println("Tasa anual: " + tasaAnual + "%");
        System.out.println("Comisión mensual: $" + comisionMensual);
    }
}

