
import javax.swing.JOptionPane;
import java.util.ArrayList;

class Carro {
    private String marca;
    private String modelo;
    private int anio;
    private String color;
    private boolean enMovimiento;

    public Carro(String marca, String modelo, int anio, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.color = color;
        this.enMovimiento = false;
    }

    public void moverAdelante() {
        if (enMovimiento) {
            JOptionPane.showMessageDialog(null, "El carro ya está en movimiento.");
        } else {
            enMovimiento = true;
            JOptionPane.showMessageDialog(null, "El carro está en movimiento hacia adelante.");
        }
    }

    public void moverAtras() {
        if (enMovimiento) {
            enMovimiento = false;
            JOptionPane.showMessageDialog(null, "El carro está en movimiento hacia atrás.");
        } else {
            JOptionPane.showMessageDialog(null, "El carro ya está detenido.");
        }
    }

    public void frenar() {
        if (enMovimiento) {
            enMovimiento = false;
            JOptionPane.showMessageDialog(null, "El carro ha sido frenado.");
        } else {
            JOptionPane.showMessageDialog(null, "El carro ya está detenido.");
        }
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void mostrarDetalles() {
        String detalles = "Marca: " + marca + "\n" +
                          "Modelo: " + modelo + "\n" +
                          "Año: " + anio + "\n" +
                          "Color: " + color;
        JOptionPane.showMessageDialog(null, detalles + "\nDetalles del carro");
    }
}

class MenuCarros {
    private ArrayList<Carro> listaCarros;

    public MenuCarros() {
        listaCarros = new ArrayList<>();
    }

    public void mostrarMenu() {
        int opcion = 0;

        do {
            String menu = "----- MENÚ CARROS -----\n" +
                          "1. Agregar carro\n" +
                          "2. Consultar carro individual\n" +
                          "3. Consultar lista completa de carros\n" +
                          "4. Mover carro hacia adelante\n" +
                          "5. Mover carro hacia atrás\n" +
                          "6. Frenar carro\n" +
                          "7. Salir";
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menu));

            switch (opcion) {
                case 1:
                    agregarCarro();
                    break;
                case 2:
                    consultarCarroIndividual();
                    break;
                case 3:
                    consultarListaCarros();
                    break;
                case 4:
                    moverCarroAdelante();
                    break;
                case 5:
                    moverCarroAtras();
                    break;
                case 6:
                    frenarCarro();
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
                    break;
            }

        } while (opcion != 7);
    }

    private void agregarCarro() {
        String marca = JOptionPane.showInputDialog(null, "Ingrese la marca:");
        String modelo = JOptionPane.showInputDialog(null, "Ingrese el modelo:");
        int anio = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año:"));
        String color = JOptionPane.showInputDialog(null, "Ingrese el color:");

        Carro carro = new Carro(marca, modelo, anio, color);
        listaCarros.add(carro);

        JOptionPane.showMessageDialog(null, "Carro agregado exitosamente.");
    }

    private void consultarCarroIndividual() {
        int indice = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el índice del carro:"));
        
        if (listaCarros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay carros registrados.");
        } else if (indice >= 0 && indice < listaCarros.size()) {
            Carro carro = listaCarros.get(indice);
            carro.mostrarDetalles();
        } else {
            JOptionPane.showMessageDialog(null, "Índice inválido. Error");
        }
    }

    private void consultarListaCarros() {
        if (listaCarros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay carros registrados.");
        } else {
            StringBuilder lista = new StringBuilder();
            lista.append("----- LISTA COMPLETA DE CARROS -----\n");

            for (int i = 0; i < listaCarros.size(); i++) {
                lista.append("----- Carro #").append(i).append(" -----\n");
                Carro carro = listaCarros.get(i);
                lista.append("Marca: ").append(carro.getMarca()).append("\n");
                lista.append("Modelo: ").append(carro.getModelo()).append("\n");
                lista.append("Año: ").append(carro.getAnio()).append("\n");
                lista.append("Color: ").append(carro.getColor()).append("\n\n");
            }

            JOptionPane.showMessageDialog(null, lista.toString() + "Lista de carros");
        }
    }

    private void moverCarroAdelante() {
        int indice = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el índice del carro a mover hacia adelante:"));
        
        if (listaCarros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay carros registrados.");
        } else if (indice >= 0 && indice < listaCarros.size()) {
            Carro carro = listaCarros.get(indice);
            carro.moverAdelante();
        } else {
            JOptionPane.showMessageDialog(null, "Índice inválido. Error");
        }
    }

    private void moverCarroAtras() {
        int indice = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el índice del carro a mover hacia atrás:"));
        
        if (listaCarros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay carros registrados.");
        } else if (indice >= 0 && indice < listaCarros.size()) {
            Carro carro = listaCarros.get(indice);
            carro.moverAtras();
        } else {
            JOptionPane.showMessageDialog(null, "Índice inválido. Error");
        }
    }

    private void frenarCarro() {
        int indice = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el índice del carro a frenar:"));
        
        if (listaCarros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay carros registrados.");
        } else if (indice >= 0 && indice < listaCarros.size()) {
            Carro carro = listaCarros.get(indice);
            carro.frenar();
        } else {
            JOptionPane.showMessageDialog(null, "Índice inválido. Error");
        }
    }
}
 
 /*
  
 encapsula una clase Carro que representa un carro y tiene métodos para acceder y 
 modificar sus atributos, y una clase MenuCarros que muestra un menú de opciones para 
 interactuar con objetos de tipo Carro
 
 */
