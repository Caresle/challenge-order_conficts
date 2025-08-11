import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        System.out.println("Reto: Detectar pedidos duplicados o mezclados");

        // Configuración de prueba (reemplazar con rutas de archivos reales)
        String file1Path = "pedidos1.csv";
        String file2Path = "pedidos2.csv";
        
        OrderProcessorChallenge orderProcessor = new OrderProcessorChallenge();
        long start = System.nanoTime();
        orderProcessor.processOrders(file1Path, file2Path);
        long end = System.nanoTime();
        double duration = (end - start) / 1_000_000.0;

        System.out.println("Pedidos duplicados: " + orderProcessor.getDuplicates().size());
        System.out.println("Duration: " + duration + " ms");
    }
}

// El desarrollador debe completar esta clase
class OrderProcessorChallenge {
    private HashMap<Order, Integer> orders;
    private HashSet<Order> duplicates;

    public OrderProcessorChallenge() {
        this.orders = new HashMap<>();
        this.duplicates = new HashSet<>();
    }

    public HashSet<Order> getDuplicates() {
        return duplicates;
    }

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
        //   - Optimizar p∫ara grandes volúmenes de datos.
        //   - Asegurarse de que la comparación de pedidos sea correcta.

        // System.out.println("Implementación incompleta. El reto está en completar este método.");

        // if (!file1Path.contains(".txt") || !file2Path.contains(".txt")) {
        //     System.out.println("Error: Los archivos deben ser de tipo .txt");
        //     return;
        // }

        readFileOrders(file1Path);
        readFileOrders(file2Path);
    }

    private void readFileOrders(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                Order order = OrderMapper.fromTxtToOrder(line);
                if (order == null) continue;
                
                if (orders.containsKey(order)) {
                    duplicates.add(order);
                    orders.put(order, orders.get(order) + 1);
                    continue;
                }

                orders.put(order, 1);

            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de pedidos: " + e.getMessage());
        }
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        String id = orderId + storeId + customerId;

        if (obj.getClass() == String.class) {
            return id.equals(obj);
        }

        if (obj == null || getClass() != obj.getClass()) return false;

        Order order = (Order) obj;

        String otherId = order.orderId + order.storeId + order.customerId;

        return Objects.equals(id, otherId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, storeId, customerId);
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

class OrderMapper {
    static Order fromTxtToOrder(String line) {
        String[] values = line.split(",");

        if (values.length < 3) {
            return null;
        }

        String orderId = values[0];
        String storeId = values[1];
        String customerId = values[2];

        return new Order(orderId, storeId, customerId);
        
    }
}