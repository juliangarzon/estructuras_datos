# 🗺️ Ejemplo 2: Laberinto

## 📚 Descripción del Problema

**Input:** Un grid (matriz) con:
- `S` = inicio (Start)
- `E` = meta (End)
- `X` = pared/obstáculo
- `.` = camino libre

**Output:** Un camino desde S hasta E (o `null` si no existe)

**Ejemplo:**
```
Grid:
S . .
. X .
. . E

Camino:
(0,0) → (1,0) → (2,0) → (2,1) → (2,2)
```

---

## 🤔 ¿Por qué es Backtracking?

- **Exploración de caminos:** Probamos diferentes direcciones (arriba, abajo, izquierda, derecha)
- **Restricciones:** No podemos atravesar paredes ni revisitar posiciones
- **Backtrack:** Si llegamos a un callejón sin salida, retrocedemos e intentamos otra dirección

---

## 🌳 Árbol de Decisiones

Visualicemos el proceso para el grid de ejemplo:

```
                    (0,0) S
                    /    \
              (1,0) .    (0,1) .
              /             \
         (2,0) .          (0,2) - callejón
         /
    (2,1) .
    /
(2,2) E ✅ ¡META ENCONTRADA!
```

**Nota:** En cada nodo, tenemos hasta 4 opciones (arriba, abajo, izquierda, derecha), pero solo avanzamos por las válidas.

---

## 🧩 Aplicando el Patrón de Backtracking

### Componentes del problema

1. **Estado:** Posición actual (x, y)
2. **Opciones:** 4 direcciones posibles
3. **Validación:** ¿Está dentro del grid? ¿No es pared? ¿No visitada?
4. **Solución:** Llegamos a la meta (E)

### Las 4 partes del backtracking

#### 1️⃣ VALIDAR
```java
// ¿La posición es válida?
if (x < 0 || x >= filas || y < 0 || y >= columnas) {
    return false; // Fuera del grid
}

if (grid[x][y] == 'X') {
    return false; // Es una pared
}

if (visitado[x][y]) {
    return false; // Ya visitamos esta celda
}
```

#### 2️⃣ HACER
```java
visitado[x][y] = true;        // Marcar como visitado
camino.add("(" + x + "," + y + ")"); // Agregar al camino
```

#### 3️⃣ EXPLORAR
```java
// Probar las 4 direcciones
if (encontrarCamino(x + 1, y, ...) ||  // Abajo
    encontrarCamino(x - 1, y, ...) ||  // Arriba
    encontrarCamino(x, y + 1, ...) ||  // Derecha
    encontrarCamino(x, y - 1, ...)) {  // Izquierda
    return true;
}
```

#### 4️⃣ DESHACER (BACKTRACK)
```java
visitado[x][y] = false;              // Desmarcar
camino.remove(camino.size() - 1);    // Quitar del camino
```

---

## 💻 Implementación Completa Comentada

```java
public class LaberintoSolver {
    private char[][] grid;
    private boolean[][] visitado;
    private int filas, columnas;

    public List<String> encontrarCamino(char[][] grid) {
        this.grid = grid;
        this.filas = grid.length;
        this.columnas = grid[0].length;
        this.visitado = new boolean[filas][columnas];

        // Encontrar posición de inicio (S)
        int inicioX = -1, inicioY = -1;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (grid[i][j] == 'S') {
                    inicioX = i;
                    inicioY = j;
                }
            }
        }

        List<String> camino = new ArrayList<>();

        if (backtrack(inicioX, inicioY, camino)) {
            return camino; // Camino encontrado
        }

        return null; // No hay camino
    }

    private boolean backtrack(int x, int y, List<String> camino) {
        // VALIDACIÓN: ¿Es una posición válida?
        if (!esValido(x, y)) {
            return false;
        }

        // CASO BASE: ¿Llegamos a la meta?
        if (grid[x][y] == 'E') {
            camino.add("(" + x + "," + y + ")");
            return true;
        }

        // 2️⃣ HACER: Marcar como visitado y agregar al camino
        visitado[x][y] = true;
        camino.add("(" + x + "," + y + ")");

        // 3️⃣ EXPLORAR: Probar 4 direcciones
        // Abajo
        if (backtrack(x + 1, y, camino)) return true;

        // Derecha
        if (backtrack(x, y + 1, camino)) return true;

        // Arriba
        if (backtrack(x - 1, y, camino)) return true;

        // Izquierda
        if (backtrack(x, y - 1, camino)) return true;

        // 4️⃣ DESHACER: Ninguna dirección funcionó, backtrack
        visitado[x][y] = false;
        camino.remove(camino.size() - 1);

        return false;
    }

    private boolean esValido(int x, int y) {
        // Fuera de límites
        if (x < 0 || x >= filas || y < 0 || y >= columnas) {
            return false;
        }

        // Es una pared
        if (grid[x][y] == 'X') {
            return false;
        }

        // Ya visitado
        if (visitado[x][y]) {
            return false;
        }

        return true;
    }
}
```

---

## 🔍 Traza de Ejecución

Grid:
```
S . .
. X .
. . E
```

**Paso a paso:**

```
Llamada 1: backtrack(0, 0, [])
  grid[0][0] = 'S'
  ✅ esValido(0, 0) = true
  visitado[0][0] = true
  camino = ["(0,0)"]

  Explorar ABAJO (1, 0):
    Llamada 2: backtrack(1, 0, ["(0,0)"])
      grid[1][0] = '.'
      ✅ esValido(1, 0) = true
      visitado[1][0] = true
      camino = ["(0,0)", "(1,0)"]

      Explorar ABAJO (2, 0):
        Llamada 3: backtrack(2, 0, ["(0,0)", "(1,0)"])
          grid[2][0] = '.'
          ✅ esValido(2, 0) = true
          visitado[2][0] = true
          camino = ["(0,0)", "(1,0)", "(2,0)"]

          Explorar ABAJO (3, 0):
            ❌ esValido(3, 0) = false (fuera de límites)

          Explorar DERECHA (2, 1):
            Llamada 4: backtrack(2, 1, ["(0,0)", "(1,0)", "(2,0)"])
              grid[2][1] = '.'
              ✅ esValido(2, 1) = true
              visitado[2][1] = true
              camino = ["(0,0)", "(1,0)", "(2,0)", "(2,1)"]

              Explorar DERECHA (2, 2):
                Llamada 5: backtrack(2, 2, [...])
                  grid[2][2] = 'E' 🎯 ¡META!
                  camino = ["(0,0)", "(1,0)", "(2,0)", "(2,1)", "(2,2)"]
                  return true ✅

              return true ✅
          return true ✅
      return true ✅
  return true ✅

Camino final: ["(0,0)", "(1,0)", "(2,0)", "(2,1)", "(2,2)"]
```

---

## 🎯 Puntos Clave para Entender

### 1. ¿Por qué necesitamos la matriz `visitado`?

Sin `visitado`, podríamos caer en un **ciclo infinito**:

```
. . .
. S .
. . .
```

Sin marcar visitados:
- Voy de S a derecha
- De derecha vuelvo a S
- De S voy a derecha
- ... ¡Infinito! ❌

### 2. ¿Por qué desmarcamos en el backtrack?

Imagina este grid:
```
S X E
. . .
```

Si no desmarcamos:
1. Desde S intento ir a la derecha (X = pared) ❌
2. Voy abajo y marco (1,0) como visitado
3. Backtrack, pero (1,0) sigue marcado
4. Nunca podré pasar por (1,0) en otro camino ❌

**Solución:** Desmarcar permite explorar (1,0) en futuros intentos.

### 3. ¿Por qué retornamos `true` inmediatamente?

```java
if (backtrack(x + 1, y, camino)) return true; // ← Aquí
```

Porque solo necesitamos **UN** camino. En cuanto lo encontramos, no necesitamos seguir buscando.

Si quisiéramos **TODOS** los caminos, no retornaríamos `true` inmediatamente.

### 4. Diferencia con Permutaciones

| Permutaciones | Laberinto |
|---------------|-----------|
| Generamos TODAS las soluciones | Solo necesitamos UNA solución |
| `void backtrack(...)` | `boolean backtrack(...)` |
| No hay retorno temprano | Retornamos `true` al encontrar solución |

---

## ⏱️ Complejidad

- **Tiempo:** O(4^(n×m)) en el peor caso
  - n × m = tamaño del grid
  - 4 = direcciones posibles por celda
  - En la práctica, es mucho mejor gracias a la poda (paredes, visitados)

- **Espacio:** O(n × m)
  - Matriz `visitado`
  - Profundidad de recursión máxima = n × m

---

## 🧪 Casos de Prueba

### Caso 1: Camino directo
```
S . . E
```
Camino: `[(0,0), (0,1), (0,2), (0,3)]`

### Caso 2: Con obstáculos
```
S . .
. X .
. . E
```
Camino: `[(0,0), (1,0), (2,0), (2,1), (2,2)]`

### Caso 3: Sin solución
```
S X E
```
Resultado: `null`

### Caso 4: Laberinto complejo
```
S . X .
X . . .
. X . E
```
Camino: `[(0,0), (0,1), (1,1), (1,2), (1,3), (2,3)]`

---

## 🎨 Visualización (para el pizarrón)

Dibuja el grid y marca con flechas:
1. ✅ Celdas visitadas exitosamente (en verde)
2. ❌ Celdas donde hicimos backtrack (en rojo)
3. 🎯 Camino final (en azul)

---

## 💡 Variaciones del Problema

### Variación 1: Contar TODOS los caminos
```java
private int backtrack(int x, int y) {
    if (grid[x][y] == 'E') return 1;

    visitado[x][y] = true;

    int total = 0;
    total += backtrack(x + 1, y);
    total += backtrack(x, y + 1);
    total += backtrack(x - 1, y);
    total += backtrack(x, y - 1);

    visitado[x][y] = false; // ← Importante deshacer
    return total;
}
```

### Variación 2: Camino más corto
Usar BFS (Breadth-First Search) en lugar de backtracking. El primer camino encontrado es el más corto.

### Variación 3: Con costos
Si cada celda tiene un costo, usar Dijkstra o A* en lugar de backtracking.

---

## 🐛 Debugging Tips

Para visualizar el backtracking, agrega prints:

```java
private boolean backtrack(int x, int y, List<String> camino) {
    System.out.println("  ".repeat(camino.size()) + "→ Visitando (" + x + "," + y + ")");

    if (!esValido(x, y)) {
        System.out.println("  ".repeat(camino.size()) + "✗ Inválido");
        return false;
    }

    if (grid[x][y] == 'E') {
        System.out.println("  ".repeat(camino.size()) + "🎯 ¡META!");
        camino.add("(" + x + "," + y + ")");
        return true;
    }

    visitado[x][y] = true;
    camino.add("(" + x + "," + y + ")");

    if (backtrack(x + 1, y, camino)) return true;
    if (backtrack(x, y + 1, camino)) return true;
    if (backtrack(x - 1, y, camino)) return true;
    if (backtrack(x, y - 1, camino)) return true;

    System.out.println("  ".repeat(camino.size()) + "↩ Backtrack desde (" + x + "," + y + ")");
    visitado[x][y] = false;
    camino.remove(camino.size() - 1);

    return false;
}
```

---

## ✅ Checklist de Implementación

- [ ] La validación verifica límites del grid
- [ ] La validación detecta paredes (`'X'`)
- [ ] La validación detecta celdas visitadas
- [ ] El caso base detecta cuando llegamos a `'E'`
- [ ] Se marca `visitado[x][y] = true` antes de explorar
- [ ] Se prueba las 4 direcciones (abajo, derecha, arriba, izquierda)
- [ ] Se desmarca `visitado[x][y] = false` al hacer backtrack
- [ ] Se quita la posición del camino al hacer backtrack
- [ ] Retorna `true` al encontrar la meta
- [ ] Todos los tests pasan ✅

---

¡Ahora implementa el código siguiendo los TODOs en `LaberintoSolver.java`!
