# ♟️ Ejemplo 3: N-Reinas

## 📚 Descripción del Problema

**Input:** Un número N (tamaño del tablero)

**Output:** Una forma de colocar N reinas en un tablero NxN sin que se ataquen

**Reglas del ajedrez:**
Una reina puede atacar en:
- ❌ La misma fila
- ❌ La misma columna
- ❌ Las diagonales (ambas)

**Ejemplo con N=4:**
```
. Q . .
. . . Q
Q . . .
. . Q .
```

---

## 🤔 ¿Por qué es Backtracking?

- **Problema de satisfacción de restricciones:** Debemos respetar las reglas del ajedrez
- **Exploración exhaustiva:** Probamos diferentes posiciones hasta encontrar una válida
- **Poda inteligente:** Si una posición es inválida, no seguimos explorando esa rama
- **Backtrack:** Si no podemos colocar una reina, retrocedemos y probamos otra posición

---

## 🎯 Estrategia de Solución

### Observación clave:
En cada **fila**, solo puede haber **UNA** reina.

Por lo tanto:
1. Colocamos reinas fila por fila (empezando en fila 0)
2. En cada fila, probamos colocar la reina en cada columna
3. Solo avanzamos si la posición es segura
4. Si llegamos a la fila N, ¡encontramos una solución!

---

## 🌳 Árbol de Decisiones (N=4)

```
                        Fila 0
                    /   |   |   \
                Col 0  Col 1 Col 2 Col 3
                  |
               Fila 1
           /    |    |    \
        Col 0 Col 1 Col 2 Col 3
         ❌    ❌    ✅     ❌
                     |
                  Fila 2
              /   |   |   \
           ... (continúa explorando)
```

**Explicación:**
- En fila 0, probamos colocar la reina en col 0
- En fila 1, probamos cada columna:
  - Col 0: ❌ Misma columna que la reina en (0,0)
  - Col 1: ❌ En diagonal con (0,0)
  - Col 2: ✅ Seguro, continuamos
  - Col 3: ❌ En diagonal con (0,0)

---

## 🧩 Aplicando el Patrón de Backtracking

### Representación del tablero

En lugar de una matriz 2D, usamos un arreglo 1D:
```java
int[] tablero = new int[N];
```

Donde `tablero[fila] = columna` significa:
> "En la fila `fila`, la reina está en la columna `columna`"

**Ejemplo:**
```
tablero = [1, 3, 0, 2]

Significa:
Fila 0: reina en columna 1 → . Q . .
Fila 1: reina en columna 3 → . . . Q
Fila 2: reina en columna 0 → Q . . .
Fila 3: reina en columna 2 → . . Q .
```

### Las 4 partes del backtracking

#### 1️⃣ VALIDAR - ¿Es seguro colocar la reina aquí?

```java
private boolean esSeguro(int[] tablero, int fila, int col) {
    // Verificar todas las reinas ya colocadas (filas 0 a fila-1)
    for (int i = 0; i < fila; i++) {
        int reinaCol = tablero[i];

        // ❌ Misma columna
        if (reinaCol == col) {
            return false;
        }

        // ❌ Misma diagonal
        // Diagonal: |fila1 - fila2| == |col1 - col2|
        if (Math.abs(i - fila) == Math.abs(reinaCol - col)) {
            return false;
        }
    }

    return true; // ✅ Seguro
}
```

**¿Por qué no validamos fila?**
Porque colocamos **una reina por fila**, nunca habrá dos reinas en la misma fila.

**¿Cómo funciona la validación de diagonal?**
```
Ejemplo: Reina en (0, 0) y queremos poner otra en (1, 1)

|fila1 - fila2| = |0 - 1| = 1
|col1 - col2|   = |0 - 1| = 1

1 == 1 ✅ Están en la misma diagonal ❌
```

#### 2️⃣ HACER - Colocar la reina
```java
tablero[fila] = col;
```

#### 3️⃣ EXPLORAR - Continuar con la siguiente fila
```java
if (colocarReinas(tablero, fila + 1)) {
    return true; // Encontramos solución
}
```

#### 4️⃣ DESHACER - Quitar la reina (backtrack)
```java
tablero[fila] = -1; // -1 = sin reina
```

---

## 💻 Implementación Completa Comentada

```java
public class NReinas {
    private int N;

    public int[] resolverNReinas(int N) {
        this.N = N;
        int[] tablero = new int[N];

        // Inicializar tablero (sin reinas)
        for (int i = 0; i < N; i++) {
            tablero[i] = -1;
        }

        if (colocarReinas(tablero, 0)) {
            return tablero; // Solución encontrada
        }

        return null; // No hay solución
    }

    private boolean colocarReinas(int[] tablero, int fila) {
        // CASO BASE: ¿Ya colocamos todas las reinas?
        if (fila == N) {
            return true; // ¡Éxito!
        }

        // GENERAR: Probar cada columna
        for (int col = 0; col < N; col++) {

            // 1️⃣ VALIDAR: ¿Es seguro colocar reina aquí?
            if (esSeguro(tablero, fila, col)) {

                // 2️⃣ HACER: Colocar reina
                tablero[fila] = col;

                // 3️⃣ EXPLORAR: Continuar con siguiente fila
                if (colocarReinas(tablero, fila + 1)) {
                    return true; // Encontramos solución
                }

                // 4️⃣ DESHACER: Quitar reina (backtrack)
                tablero[fila] = -1;
            }
        }

        return false; // No encontramos solución en esta rama
    }

    private boolean esSeguro(int[] tablero, int fila, int col) {
        for (int i = 0; i < fila; i++) {
            int reinaCol = tablero[i];

            // Misma columna
            if (reinaCol == col) {
                return false;
            }

            // Misma diagonal
            if (Math.abs(i - fila) == Math.abs(reinaCol - col)) {
                return false;
            }
        }

        return true;
    }
}
```

---

## 🔍 Traza de Ejecución (N=4)

```
Llamada 1: colocarReinas([], 0)
  fila = 0

  Probar col = 0:
    ✅ esSeguro([], 0, 0) = true
    tablero = [0]

    Llamada 2: colocarReinas([0], 1)
      fila = 1

      Probar col = 0:
        ❌ esSeguro([0], 1, 0) = false (misma columna)

      Probar col = 1:
        ❌ esSeguro([0], 1, 1) = false (diagonal)

      Probar col = 2:
        ✅ esSeguro([0], 1, 2) = true
        tablero = [0, 2]

        Llamada 3: colocarReinas([0, 2], 2)
          fila = 2

          Probar col = 0:
            ❌ esSeguro([0, 2], 2, 0) = false (misma columna)

          Probar col = 1:
            ❌ esSeguro([0, 2], 2, 1) = false (diagonal con (0,0))

          Probar col = 2:
            ❌ esSeguro([0, 2], 2, 2) = false (misma columna)

          Probar col = 3:
            ❌ esSeguro([0, 2], 2, 3) = false (diagonal con (1,2))

          return false ← No hay solución con [0, 2]

        tablero[1] = -1 ← BACKTRACK
        tablero = [0]

      Probar col = 3:
        ✅ esSeguro([0], 1, 3) = true
        tablero = [0, 3]
        ... (continúa hasta encontrar [1, 3, 0, 2])
```

---

## 🎯 Puntos Clave para Entender

### 1. ¿Por qué solo verificamos `i < fila`?

```java
for (int i = 0; i < fila; i++) {
    // Solo verificamos reinas ya colocadas
}
```

Porque las reinas en `fila` y posteriores **aún no están colocadas**. Solo verificamos conflictos con reinas previas.

### 2. ¿Qué significa `tablero[fila] = -1`?

Es como "borrar" la reina. Volvemos al estado anterior para probar otra columna.

### 3. Diferencia con problemas anteriores

| Permutaciones | Laberinto | N-Reinas |
|---------------|-----------|----------|
| Validación simple (`contains`) | Validación de límites | **Validación compleja (diagonal)** |
| Todas las soluciones | Una solución | Una solución |
| Lista mutable | Lista + matriz boolean | **Arreglo de enteros** |

---

## 📊 Visualización del Tablero

Para visualizar la solución:

```java
public void imprimirTablero(int[] tablero) {
    for (int fila = 0; fila < N; fila++) {
        for (int col = 0; col < N; col++) {
            if (tablero[fila] == col) {
                System.out.print("Q ");
            } else {
                System.out.print(". ");
            }
        }
        System.out.println();
    }
}
```

**Salida para N=4:**
```
. Q . .
. . . Q
Q . . .
. . Q .
```

---

## ⏱️ Complejidad

- **Tiempo:** O(N!) en el peor caso
  - En cada fila tenemos N opciones
  - Pero la poda reduce significativamente el espacio de búsqueda

- **Espacio:** O(N)
  - Arreglo `tablero` de tamaño N
  - Profundidad de recursión = N

---

## 🧪 Casos de Prueba

| N | ¿Tiene solución? | Ejemplo de solución |
|---|------------------|---------------------|
| 1 | ✅ Sí | `[0]` |
| 2 | ❌ No | - |
| 3 | ❌ No | - |
| 4 | ✅ Sí | `[1, 3, 0, 2]` |
| 5 | ✅ Sí | `[0, 2, 4, 1, 3]` |
| 8 | ✅ Sí | `[0, 4, 7, 5, 2, 6, 1, 3]` |

**Nota:** N=2 y N=3 no tienen solución.

---

## 💡 Variaciones del Problema

### Variación 1: Contar TODAS las soluciones

```java
private int contarSoluciones(int[] tablero, int fila) {
    if (fila == N) {
        return 1; // Encontramos una solución
    }

    int total = 0;
    for (int col = 0; col < N; col++) {
        if (esSeguro(tablero, fila, col)) {
            tablero[fila] = col;
            total += contarSoluciones(tablero, fila + 1);
            tablero[fila] = -1;
        }
    }

    return total;
}
```

**Para N=8:** ¡Hay 92 soluciones diferentes!

### Variación 2: Encontrar TODAS las soluciones

```java
private void encontrarTodasLasSoluciones(int[] tablero, int fila, List<int[]> soluciones) {
    if (fila == N) {
        soluciones.add(tablero.clone()); // Guardar copia
        return;
    }

    for (int col = 0; col < N; col++) {
        if (esSeguro(tablero, fila, col)) {
            tablero[fila] = col;
            encontrarTodasLasSoluciones(tablero, fila + 1, soluciones);
            tablero[fila] = -1;
        }
    }
}
```

---

## 🐛 Debugging Tips

Para visualizar el proceso:

```java
private boolean colocarReinas(int[] tablero, int fila) {
    System.out.println("  ".repeat(fila) + "→ Fila " + fila);

    if (fila == N) {
        System.out.println("  ".repeat(fila) + "✅ Solución encontrada!");
        return true;
    }

    for (int col = 0; col < N; col++) {
        if (esSeguro(tablero, fila, col)) {
            System.out.println("  ".repeat(fila) + "  Probando col " + col);
            tablero[fila] = col;

            if (colocarReinas(tablero, fila + 1)) {
                return true;
            }

            System.out.println("  ".repeat(fila) + "  ↩ Backtrack col " + col);
            tablero[fila] = -1;
        } else {
            System.out.println("  ".repeat(fila) + "  ✗ Col " + col + " no segura");
        }
    }

    return false;
}
```

---

## 🎨 Visualización en el Pizarrón

Dibuja un tablero 4x4 y muestra paso a paso:
1. ✅ Colocar reina en (0, 1)
2. ❌ Intentar (1, 0) - diagonal
3. ❌ Intentar (1, 1) - misma columna
4. ❌ Intentar (1, 2) - diagonal
5. ✅ Colocar reina en (1, 3)
6. ... (continúa)

Marca con X las posiciones que la reina ataca.

---

## 🔑 Fórmula de Diagonales

**Pregunta:** ¿Cómo saber si dos posiciones están en la misma diagonal?

**Respuesta:**
```
Posición 1: (fila1, col1)
Posición 2: (fila2, col2)

Misma diagonal si:
|fila1 - fila2| == |col1 - col2|
```

**Ejemplos:**
- (0,0) y (1,1): |0-1| = 1, |0-1| = 1 → 1 == 1 ✅ Diagonal
- (0,0) y (2,2): |0-2| = 2, |0-2| = 2 → 2 == 2 ✅ Diagonal
- (0,0) y (1,2): |0-1| = 1, |0-2| = 2 → 1 ≠ 2 ❌ No diagonal

---

## ✅ Checklist de Implementación

- [ ] El tablero se representa como `int[] tablero`
- [ ] Se inicializa con `-1` (sin reinas)
- [ ] El caso base detecta cuando `fila == N`
- [ ] Se prueba cada columna en cada fila
- [ ] La validación verifica columna y diagonales
- [ ] **NO** se valida fila (ya garantizado por diseño)
- [ ] Se coloca reina con `tablero[fila] = col`
- [ ] Se hace backtrack con `tablero[fila] = -1`
- [ ] Retorna `true` al encontrar solución
- [ ] Maneja correctamente N=1, N=2, N=3, N=4
- [ ] Todos los tests pasan ✅

---

## 🎓 ¿Qué aprendimos?

1. **Optimización del espacio de búsqueda:** Usar 1D en lugar de 2D
2. **Restricciones complejas:** Validar diagonales con matemáticas
3. **Diseño inteligente:** Una reina por fila elimina una validación
4. **Backtracking clásico:** El ejemplo perfecto del patrón

---

¡Ahora implementa el código siguiendo los TODOs en `NReinas.java`!
