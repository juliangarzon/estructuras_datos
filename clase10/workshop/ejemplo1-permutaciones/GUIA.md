# 🎯 Ejemplo 1: Permutaciones

## 📚 Descripción del Problema

**Input:** Un arreglo de números `[1, 2, 3]`

**Output:** Todas las permutaciones posibles

```
[1, 2, 3]
[1, 3, 2]
[2, 1, 3]
[2, 3, 1]
[3, 1, 2]
[3, 2, 1]
```

**Definición:** Una permutación es un reordenamiento de todos los elementos del arreglo.

---

## 🤔 ¿Por qué es Backtracking?

- **Exploración exhaustiva:** Necesitamos generar TODAS las permutaciones
- **Decisiones secuenciales:** En cada posición, decidimos qué número colocar
- **Restricción:** No podemos repetir números ya usados
- **Backtrack:** Cuando terminamos de explorar una rama, quitamos el número para probar otro

---

## 🌳 Árbol de Decisiones

Visualicemos cómo funciona para `[1, 2, 3]`:

```
                        []
                    /   |   \
                  [1]  [2]  [3]
                 / \   / \   / \
              [1,2][1,3][2,1][2,3][3,1][3,2]
               |    |    |    |    |    |
            [1,2,3][1,3,2][2,1,3][2,3,1][3,1,2][3,2,1]
```

**Explicación:**
1. Empezamos con una lista vacía `[]`
2. **Primer nivel:** Probamos comenzar con 1, 2 o 3
3. **Segundo nivel:** Si elegimos 1, ahora probamos 2 o 3 (no podemos repetir 1)
4. **Tercer nivel:** Solo queda un número por agregar
5. **Backtrack:** Subimos, quitamos el último número, probamos otra opción

---

## 🧩 Aplicando el Patrón de Backtracking

### Paso 1: CASO BASE
**¿Cuándo tenemos una solución completa?**
```java
if (actual.size() == numeros.length) {
    // Ya usamos todos los números
    resultado.add(new ArrayList<>(actual));
    return;
}
```

### Paso 2: GENERAR opciones
**¿Qué opciones tenemos?**
```java
for (int num : numeros) {
    // Probamos con cada número del arreglo
}
```

### Paso 3: Las 4 partes del backtracking

#### 1️⃣ VALIDAR
```java
if (actual.contains(num)) {
    continue; // Ya usé este número, skip
}
```

#### 2️⃣ HACER
```java
actual.add(num); // Agrego el número a la permutación actual
```

#### 3️⃣ EXPLORAR
```java
backtrack(numeros, actual, resultado); // Recursión
```

#### 4️⃣ DESHACER (¡BACKTRACK!)
```java
actual.remove(actual.size() - 1); // Quito el número para probar otra opción
```

---

## 💻 Implementación Completa Comentada

```java
public class Permutaciones {

    public List<List<Integer>> permute(int[] numeros) {
        List<List<Integer>> resultado = new ArrayList<>();
        List<Integer> actual = new ArrayList<>();
        backtrack(numeros, actual, resultado);
        return resultado;
    }

    private void backtrack(int[] numeros, List<Integer> actual, List<List<Integer>> resultado) {
        // CASO BASE: ¿Ya tengo una permutación completa?
        if (actual.size() == numeros.length) {
            // Importante: crear una COPIA de 'actual'
            resultado.add(new ArrayList<>(actual));
            return;
        }

        // GENERAR: Probar con cada número
        for (int num : numeros) {

            // 1️⃣ VALIDAR: ¿Ya usé este número?
            if (actual.contains(num)) {
                continue; // Skip, ya está en la permutación
            }

            // 2️⃣ HACER: Agregar número
            actual.add(num);

            // 3️⃣ EXPLORAR: Continuar recursivamente
            backtrack(numeros, actual, resultado);

            // 4️⃣ DESHACER: Quitar número (BACKTRACK)
            actual.remove(actual.size() - 1);
        }
    }
}
```

---

## 🔍 Traza de Ejecución

Veamos paso a paso qué pasa con `[1, 2]`:

```
Llamada 1: backtrack([1,2], [], resultado)
  actual = []

  Iteración 1: num = 1
    ✅ 1 no está en actual
    actual.add(1) → actual = [1]

    Llamada 2: backtrack([1,2], [1], resultado)
      actual = [1]

      Iteración 1: num = 1
        ❌ 1 ya está en actual → continue

      Iteración 2: num = 2
        ✅ 2 no está en actual
        actual.add(2) → actual = [1, 2]

        Llamada 3: backtrack([1,2], [1,2], resultado)
          actual = [1, 2]
          actual.size() == 2 ✅ CASO BASE
          resultado.add([1, 2]) → resultado = [[1, 2]]
          return

        actual.remove(1) → actual = [1] ⬅️ BACKTRACK

    return

    actual.remove(0) → actual = [] ⬅️ BACKTRACK

  Iteración 2: num = 2
    ✅ 2 no está en actual
    actual.add(2) → actual = [2]

    Llamada 4: backtrack([1,2], [2], resultado)
      ... (similar, genera [2, 1])

    actual.remove(0) → actual = [] ⬅️ BACKTRACK

resultado final = [[1, 2], [2, 1]]
```

---

## 🎯 Puntos Clave para Entender

### 1. ¿Por qué `new ArrayList<>(actual)`?
```java
resultado.add(new ArrayList<>(actual)); // ✅ CORRECTO
```

Si hicieras:
```java
resultado.add(actual); // ❌ INCORRECTO
```

**Problema:** `actual` es una REFERENCIA. Si solo agregas la referencia, cuando hagas backtrack y modifiques `actual`, ¡también se modificarán todas las permutaciones en `resultado`!

### 2. ¿Por qué `remove(actual.size() - 1)`?
Porque estamos quitando el **último elemento** agregado. Es como una pila (stack):
- `add(num)` → push
- `remove(size-1)` → pop

### 3. ¿Qué pasa si no hago el DESHACER?
Sin la línea `actual.remove(actual.size() - 1)`:
- La lista `actual` seguiría creciendo
- Nunca exploraríamos otras ramas
- Solo obtendríamos una permutación

---

## ⏱️ Complejidad

- **Tiempo:** O(n! × n)
  - n! permutaciones posibles
  - n para copiar cada permutación a `resultado`

- **Espacio:** O(n)
  - Profundidad de recursión = n
  - Lista `actual` tiene máximo n elementos

---

## 🧪 Casos de Prueba

| Input | Output |
|-------|--------|
| `[1]` | `[[1]]` |
| `[1, 2]` | `[[1,2], [2,1]]` |
| `[1, 2, 3]` | `[[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]]` |
| `[]` | `[[]]` (una permutación vacía) |

---

## 💡 Variaciones del Problema

### Variación 1: Con elementos duplicados
Input: `[1, 1, 2]`

**Cambio necesario:** Ordenar el arreglo y saltar duplicados consecutivos

### Variación 2: Permutaciones de tamaño k
Input: `[1, 2, 3]`, k = 2
Output: `[[1,2], [1,3], [2,1], [2,3], [3,1], [3,2]]`

**Cambio necesario:** `if (actual.size() == k)` en lugar de `numeros.length`

---

## 🎯 TODOs para la Clase

En el archivo `Permutaciones.java` encontrarás estos TODOs:

1. **TODO 1:** Implementar el caso base
2. **TODO 2:** Implementar la validación (¿ya usé este número?)
3. **TODO 3:** Implementar el HACER (agregar número)
4. **TODO 4:** Implementar el EXPLORAR (llamada recursiva)
5. **TODO 5:** Implementar el DESHACER (backtrack)

---

## 🐛 Debugging Tips

Para visualizar el backtracking, agrega estas líneas:

```java
private void backtrack(int[] numeros, List<Integer> actual, List<List<Integer>> resultado) {
    System.out.println("actual = " + actual); // ← Ver estado actual

    if (actual.size() == numeros.length) {
        System.out.println("✅ Solución encontrada: " + actual);
        resultado.add(new ArrayList<>(actual));
        return;
    }

    for (int num : numeros) {
        if (actual.contains(num)) continue;

        System.out.println("  → Agregando " + num); // ← Ver qué agregamos
        actual.add(num);
        backtrack(numeros, actual, resultado);
        actual.remove(actual.size() - 1);
        System.out.println("  ← Quitando " + num); // ← Ver backtrack
    }
}
```

---

## ✅ Checklist de Implementación

- [ ] El método `permute` inicializa las estructuras correctamente
- [ ] El caso base detecta cuando `actual.size() == numeros.length`
- [ ] Se crea una COPIA de `actual` antes de agregarlo a `resultado`
- [ ] La validación usa `actual.contains(num)` correctamente
- [ ] Se hace backtrack con `actual.remove(actual.size() - 1)`
- [ ] Todos los tests pasan ✅

---

¡Ahora implementa el código siguiendo los TODOs en `Permutaciones.java`!
