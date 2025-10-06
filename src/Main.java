// Importando librerías necesarias
import java.util.Scanner; // Para la entrada de datos
// ==============================================================================================
// Clase main...........................................................................PRINCIPAL
public class Main {
    // Metodo principal
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Padre objetoOperador; 
        
        // --------------------------------------------------------------------------------------
        // 1. Entrada de Números Aritméticos (Enteros).
        // --------------------------------------------------------------------------------------
        System.out.println("--- PRÁCTICA #3: CALCULADORA DE OPERADORES ---");
        System.out.print("1. Ingrese el primer número entero (ej: 10): ");
        int numEntero1 = sc.nextInt(); 
        System.out.print("2. Ingrese el segundo número entero (ej: 3): ");
        int numEntero2 = sc.nextInt();
        // --------------------------------------------------------------------------------------
        // 2. Ejecutar y Mostrar Resultados Aritméticos.
        // --------------------------------------------------------------------------------------
        // PILAR #3: POLIMORFISMO: Creamos la instancia Aritmetica.
        objetoOperador = new Aritmetica();
        objetoOperador.numEntero1 = numEntero1; // Asignamos el primer entero al Padre
        objetoOperador.numEntero2 = numEntero2; // Asignamos el segundo entero al Padre
        System.out.println("\n--- Resultados Aritméticos (4 Operaciones) ---");
        objetoOperador.saludo(); // CLASE ARITMETICA: Muestra los resultados ARITMÉTICOS
        // --------------------------------------------------------------------------------------
        // 3. Entrada de Números Lógicos (Binarios 0 ó 1).
        // --------------------------------------------------------------------------------------
        System.out.println("\n--- Operadores Lógicos (AND/OR) ---");
        System.out.print("3. Ingrese el primer número binario (0 o 1): ");
        int numBinario1 = sc.nextInt();
        System.out.print("4. Ingrese el segundo número binario (0 o 1): ");
        int numBinario2 = sc.nextInt();
    
        // --------------------------------------------------------------------------------------
        // 4. Ejecutar y Mostrar Resultados Lógicos.
        // --------------------------------------------------------------------------------------
        // PILAR #3: POLIMORFISMO: Cambiamos el objeto a Logica y le pasamos los datos binarios.
        objetoOperador = new Logica();
        objetoOperador.numBin1 = numBinario1;
        objetoOperador.numBin2 = numBinario2;
        System.out.println("\n--- Resultados Lógicos (AND/OR) ---");
        objetoOperador.saludo(); // CLASE LOGICA: Muestra los resultados LÓGICOS

        sc.close();
    } // end main
} // end class 0

// ==============================================================================================
// Clase Padre..............................................................................PADRE
// Contiene las variables necesarias para las operaciones.
class Padre {
    
    // PILAR #2: ENCAPSULAMIENTO (Variables protegidas y centralizadas)
    // Variables para Operadores Aritméticos
    protected int numEntero1;
    protected int numEntero2; 
    // Variables para Operadores Lógicos
    protected int numBin1; 
    protected int numBin2; 
    // PILAR #4: ABSTRACCIÓN (Define el contrato 'saludo' que las hijas deben usar)
    public void saludo() {} 
} // end class PADRE

// ==============================================================================================
// Clase 1...............................................................................ARITMETICA
// PILAR #1: HERENCIA (Extiende la clase Padre)
class Aritmetica extends Padre { 
    @Override // PILAR 3: POLIMORFISMO (Sobrescribimos 'saludo' para la Lógica Aritmética)
    public void saludo() {
        // Demostración de Operadores Aritméticos (+, -, *)
        System.out.println(numEntero1 + " + " + numEntero2 + " = " + (numEntero1 + numEntero2));
        System.out.println(numEntero1 + " - " + numEntero2 + " = " + (numEntero1 - numEntero2));
        System.out.println(numEntero1 + " * " + numEntero2 + " = " + (numEntero1 * numEntero2));
        // Demostración de Operador Aritmético (/) y (%)
        if (numEntero2 != 0) {
            System.out.println(numEntero1 + " / " + numEntero2 + " = " + (numEntero1 / numEntero2));
            System.out.println(numEntero1 + " % " + numEntero2 + " = " + (numEntero1 % numEntero2));
        } else {
            System.out.println(numEntero1 + " / " + numEntero2 + " = Error: división por cero.");
        }
    }
} // end class 1

// ==============================================================================================
// Clase 2..................................................................................LOGICA
// PILAR #1: HERENCIA (Extiende la clase Padre)
class Logica extends Padre { 
    @Override // PILAR 3: POLIMORFISMO (Sobrescribimos 'saludo' para la Lógica Booleana)
    public void saludo() {
        // Operador Lógico AND (&&) - Muestra 1 o 0
        int resultAND = (numBin1 == 1 && numBin2 == 1) ? 1 : 0;
        System.out.println(numBin1 + " AND " + numBin2 + " = " + resultAND);
        // Operador Lógico OR (||) - Muestra 1 o 0
        int resultOR = (numBin1 == 1 || numBin2 == 1) ? 1 : 0;
        System.out.println(numBin1 + " OR " + numBin2 + " = " + resultOR);
    }
} // end class 2