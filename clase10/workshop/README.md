# 🔄 Workshop: Backtracking - Semana 10

## 📚 Descripción General

Este workshop contiene 3 ejemplos progresivos de **Backtracking**, desde lo más simple hasta lo más complejo. Cada ejemplo incluye:

- 📖 **Guía teórica** explicando el algoritmo paso a paso
- 💻 **Template de código** con TODOs para completar en clase
- ✅ **Tests automatizados** para validar la implementación

---

## 🎯 Patrón de Backtracking (REPASA ESTO PRIMERO)

Todos los problemas de backtracking siguen el mismo patrón de 4 pasos:

```java
boolean backtrack(Estado actual, Solucion parcial) {
    // CASO BASE: ¿Llegué a una solución completa?
    if (esSolucionCompleta(parcial)) {
        procesarSolucion(parcial);
        return true;
    }

    // GENERAR todas las opciones disponibles
    for (Opcion opcion : obtenerOpciones(actual)) {

        // 1️⃣ VALIDAR: ¿Esta opción es válida?
        if (esValida(opcion, parcial)) {

            // 2️⃣ HACER: Agregar opción
            parcial.agregar(opcion);

            // 3️⃣ EXPLORAR: Continuar recursivamente
            if (backtrack(nuevoEstado, parcial)) {
                return true; // ¡Encontré solución!
            }

            // 4️⃣ DESHACER: Quitar opción (BACKTRACK)
            parcial.remover(opcion);
        }
    }

    return false; // No hay solución por aquí
}
```

**⚠️ PUNTO CLAVE:** El paso 4 (DESHACER) es lo que lo hace "backtracking". Sin esa línea, sería solo recursión normal.

---

## 📋 Ejemplos del Workshop

### 🟢 Ejemplo 1: Permutaciones (Básico)
**Carpeta:** `ejemplo1-permutaciones/`

**Problema:** Generar todas las permutaciones de un arreglo `[1, 2, 3]`

**Por qué empezamos aquí:**
- Es el ejemplo más simple de backtracking
- Solo necesitas entender: agregar y quitar elementos
- No hay validaciones complicadas

**Archivos:**
- 📖 `GUIA.md` - Explicación detallada del algoritmo
- 💻 `Permutaciones.java` - Template para implementar
- ✅ `PermutacionesTest.java` - Tests automatizados

**Salida esperada:**
```
[1, 2, 3]
[1, 3, 2]
[2, 1, 3]
[2, 3, 1]
[3, 1, 2]
[3, 2, 1]
```

---

### 🟡 Ejemplo 2: Laberinto (Intermedio)
**Carpeta:** `ejemplo2-laberinto/`

**Problema:** Encontrar un camino desde (0,0) hasta (2,2) en un grid 3x3 con obstáculos

**Por qué es el segundo:**
- Introduce el concepto de "validación de restricciones"
- Trabajas con coordenadas (x, y)
- Necesitas marcar visitados y desmarcar (backtrack)

**Archivos:**
- 📖 `GUIA.md` - Explicación detallada del algoritmo
- 💻 `LaberintoSolver.java` - Template para implementar
- ✅ `LaberintoSolverTest.java` - Tests automatizados

**Grid de ejemplo:**
```
S . .
. X .
. . E

S = inicio (0,0)
E = meta (2,2)
X = pared
. = libre
```

---

### 🔴 Ejemplo 3: N-Reinas (Avanzado)
**Carpeta:** `ejemplo3-nreinas/`

**Problema:** Colocar N reinas en un tablero NxN sin que se ataquen

**Por qué es el último:**
- Validación más compleja (fila, columna, diagonales)
- Optimización del espacio de búsqueda
- Problema clásico de backtracking

**Archivos:**
- 📖 `GUIA.md` - Explicación detallada del algoritmo
- 💻 `NReinas.java` - Template para implementar
- ✅ `NReinasTest.java` - Tests automatizados

**Solución para N=4:**
```
. Q . .
. . . Q
Q . . .
. . Q .
```

---

## 🚀 Cómo usar este workshop

### Paso 1: Lee la teoría
Antes de programar, lee el archivo `GUIA.md` de cada ejemplo para entender:
- ¿Qué problema resuelve?
- ¿Cómo aplicamos el patrón de backtracking?
- ¿Cuáles son las 4 partes (Validar, Hacer, Explorar, Deshacer)?

### Paso 2: Completa el template
Cada archivo `.java` tiene TODOs marcados con:
```java
// TODO: [Descripción de lo que debes implementar]
```

### Paso 3: Ejecuta los tests
Compila y ejecuta los tests para verificar tu implementación:

```bash
# Compilar
javac ejemplo1-permutaciones/*.java

# Ejecutar tests
java ejemplo1-permutaciones.PermutacionesTest
```

Si todos los tests pasan ✅, ¡tu implementación es correcta!

---

## 📊 Orden recomendado

1. **Ejemplo 1 (Permutaciones)** - 30 minutos
   - Entiende el patrón básico
   - Practica agregar/quitar elementos

2. **Ejemplo 2 (Laberinto)** - 25 minutos
   - Aprende a validar restricciones
   - Trabaja con matriz 2D

3. **Ejemplo 3 (N-Reinas)** - 20 minutos
   - Aplica todo lo aprendido
   - Validación compleja

**Total:** ~75 minutos de live coding

---

## 🎯 Objetivos de Aprendizaje

Al completar este workshop, deberías poder:

✅ Identificar cuándo un problema requiere backtracking
✅ Aplicar el patrón de 4 pasos (Validar, Hacer, Explorar, Deshacer)
✅ Escribir funciones recursivas con backtracking
✅ Entender la diferencia entre recursión simple y backtracking
✅ Optimizar búsquedas podando ramas inválidas

---

## 💡 Tips para la clase

- **Usa el debugger:** Coloca breakpoints para ver cómo se construye y deshace la solución
- **Dibuja el árbol:** En el pizarrón, dibuja el árbol de decisiones para visualizar el backtracking
- **Imprime el estado:** Agrega `System.out.println()` para ver cada paso del algoritmo
- **No te saltes pasos:** Asegúrate de implementar TODAS las 4 partes del patrón

---

## 📚 Recursos Adicionales

- **Diapositivas:** `../semana10-slides.html`
- **Visualización:** Usa el pizarrón para dibujar el árbol de recursión
- **Debugging:** Ejecuta paso a paso para entender el flujo

---

## ❓ Preguntas Frecuentes

**P: ¿Por qué necesito "deshacer" cambios?**
R: Porque estamos explorando TODAS las soluciones posibles. Si no deshacemos, los cambios de una rama afectarán las otras.

**P: ¿Cuándo retorno `true` vs `false`?**
R: `true` = encontré solución completa. `false` = esta rama no lleva a solución.

**P: ¿Qué diferencia hay con recursión normal?**
R: Backtracking = Recursión + modificar/deshacer estado. La recursión normal no modifica estado compartido.

---

¡Buena suerte! 🚀
