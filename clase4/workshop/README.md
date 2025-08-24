# 🔗 Workshop: LinkedList Implementation
## Clase 4 - Estructuras de Datos

Este workshop contiene la implementación completa de una LinkedList desde cero, tal como se desarrolla en la clase práctica.

## 📁 Archivos del Workshop

### 🧩 `Node.java`
**Clase fundamental** que representa un nodo en la lista enlazada.

**Características:**
- Almacena un dato genérico `<T>`
- Referencia al siguiente nodo (`next`)
- Métodos auxiliares para debugging y manipulación

**Métodos principales:**
```java
Node(T data)                    // Constructor básico
Node(T data, Node<T> next)      // Constructor con referencia
toString()                      // Representación simple
toDetailedString()              // Info de debugging
isLast()                        // Verifica si es el último nodo
```

### 🏗️ `MyLinkedList.java`
**Implementación completa** de lista enlazada con iterador.

**Operaciones Básicas - O(1):**
- `addFirst(element)` - Inserción al inicio
- `removeFirst()` - Eliminación del primero
- `getFirst()` - Acceso al primer elemento
- `isEmpty()` - Verificación de lista vacía
- `size()` - Tamaño (con contador interno)

**Operaciones Avanzadas:**
- `add(element)` - Agregar al final [O(n)]
- `add(index, element)` - Insertar en posición [O(n)]
- `get(index)` - Acceso por índice [O(n)]
- `remove(element)` - Eliminar por valor [O(n)]
- `contains(element)` - Búsqueda [O(n)]

**Características Especiales:**
- ✅ **Iterator implementado** - permite enhanced for-loop
- ✅ **Métodos de debugging** - visualizar referencias
- ✅ **Manejo de null** - soporte completo
- ✅ **Validaciones** - índices fuera de rango
- ✅ **Métodos bonus** - `reverse()`, `findMiddle()`

### 🧪 `LinkedListTest.java`
**Suite de pruebas comprehensiva** que demuestra todas las funcionalidades.

**Tests Incluidos:**
1. **Operaciones Básicas** - add, remove, get, contains
2. **Patrón Iterator** - recorridos eficientes vs ineficientes  
3. **Casos Extremos** - lista vacía, índices inválidos, elementos null
4. **Métodos Avanzados** - reverse, findMiddle, toArray
5. **Creación Manual** - ejemplo de nodos conectados manualmente
6. **Caso de Uso Real** - historial de navegación web

### ⚡ `BenchmarkTest.java`
**Análisis de rendimiento** comparando MyLinkedList vs ArrayList vs LinkedList de Java.

**Benchmarks Realizados:**
1. **Inserción al inicio** - donde LinkedList brilla (O(1) vs O(n))
2. **Inserción al final** - donde ArrayList gana (O(1) vs O(n))
3. **Acceso aleatorio** - donde ArrayList domina (O(1) vs O(n))
4. **Iteración completa** - similares con enhanced for-loop
5. **Operaciones de búsqueda** - ambas O(n)

## 🚀 Cómo Ejecutar

### Ejecutar Tests:
```bash
cd workshop/
javac *.java
java LinkedListTest
```

### Ejecutar Benchmarks:
```bash
java BenchmarkTest
```

### Ejemplo Rápido:
```java
// Crear lista
MyLinkedList<String> lista = new MyLinkedList<>();

// Agregar elementos
lista.add("A");
lista.add("B");
lista.addFirst("PRIMERO");  // O(1) - ¡Rápido!

// Iterar eficientemente
for (String elemento : lista) {
    System.out.println(elemento);
}

// Mostrar estructura
lista.display();  // Visual: [PRIMERO → A → B]
```

## 🎯 Conceptos Clave Demostrados

### ✅ Ventajas de LinkedList:
- **O(1) para inserción al inicio** vs ArrayList O(n)
- **Memoria dinámica** - crece según necesidad
- **Sin redimensionamiento** - no hay copias costosas
- **Ideal para Stack/Queue** - operaciones LIFO/FIFO

### ❌ Desventajas de LinkedList:
- **O(n) para acceso por índice** vs ArrayList O(1)
- **Más memoria por elemento** - necesita punteros
- **No localidad espacial** - nodos dispersos en memoria
- **Recorrido secuencial obligatorio** - no hay atajos

### 🔑 Patrones de Uso:

**✅ USAR LinkedList cuando:**
```java
// Historial de navegación
historial.addFirst(nuevaPagina);  // O(1)

// Sistema de deshacer
acciones.addFirst(nuevaAccion);   // O(1)

// Cola de procesamiento
cola.removeFirst();               // O(1)
```

**❌ EVITAR LinkedList cuando:**
```java
// Acceso aleatorio frecuente
for (int i = 0; i < lista.size(); i++) {
    lista.get(i);  // O(n) por cada acceso = O(n²) total!
}

// Búsquedas por posición específica
String elemento = lista.get(500);  // O(n) - muy lento
```

## 🧠 Lecciones Aprendidas

1. **La estructura importa**: Una mala elección puede hacer tu programa 100x más lento
2. **Iterator pattern**: Fundamental para recorridos eficientes
3. **Memoria vs Velocidad**: LinkedList usa más memoria pero es rápida para ciertas operaciones
4. **Casos de uso reales**: No todas las estructuras sirven para todo
5. **Debugging**: Visualizar referencias es clave para entender la estructura

## 🏆 Próximos Pasos

En la **Semana 5** expandiremos a:
- **Listas Doblemente Enlazadas** (prev + next)
- **Listas Circulares** 
- **Comparación con Collections de Java**
- **Implementación del Historial de Préstamos** para el proyecto

---

## 💡 Notas del Profesor

Este workshop representa **2 horas de implementación práctica** donde los estudiantes:

1. **Entienden la diferencia fundamental** entre memoria contigua (arrays) vs dispersa (listas enlazadas)
2. **Experimentan el costo real** de diferentes operaciones
3. **Ven casos de uso reales** donde cada estructura es superior
4. **Aprenden patrones de debugging** para estructuras de referencias

El código está **completamente documentado** y **listo para producción**, sirviendo como referencia para futuras implementaciones.

**🎯 Objetivo cumplido:** Los estudiantes ahora entienden **cuándo, cómo y por qué** usar listas enlazadas vs arrays dinámicos.