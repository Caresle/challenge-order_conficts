public class Main {
    public static void main(String[] args) {
        System.out.println("Reto: Detectar pedidos duplicados o mezclados");

        // Configuración de prueba (reemplazar con rutas de archivos reales)
        String file1Path = "pedidos1.txt";
        String file2Path = "pedidos2.txt";

        OrderProcessorChallenge orderProcessor = new OrderProcessorChallenge();
        orderProcessor.processOrders(file1Path, file2Path);
    }
}

// El desarrollador debe completar esta clase
class OrderProcessorChallenge {

    /**
     * Procesa los pedidos de los archivos dados para detectar duplicados.
     * Un pedido se considera duplicado si tiene el mismo orderId, storeId y customerId.
     *
     * @param file1Path Ruta al primer archivo de pedidos.
     * @param file2Path Ruta al segundo archivo de pedidos.
     */
    public void processOrders(String file1Path, String file2Path) {
        // TODO: Implementar la lógica para leer los archivos, detectar y mostrar los pedidos duplicados.
        // Consideraciones:
        //   - Manejar excepciones de E/S.
        //   - Optimizar para grandes volúmenes de datos.
        //   - Asegurarse de que la comparación de pedidos sea correcta.

        System.out.println("Implementación incompleta. El reto está en completar este método.");
    }
}

// Clase Order (puede ser necesario modificarla)
class Order {
    String orderId;
    String storeId;
    String customerId;

    public Order(String orderId, String storeId, String customerId) {
        this.orderId = orderId;
        this.storeId = storeId;
        this.customerId = customerId;
    }

    // TODO: Implementar equals() y hashCode() correctamente
    @Override
    public boolean equals(Object obj) {
        // Implementación placeholder (¡reemplazar!)
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        // Implementación placeholder (¡reemplazar!)
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", storeId='" + storeId + '\'' +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}