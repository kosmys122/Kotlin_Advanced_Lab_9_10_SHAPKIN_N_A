# Лабораторная работа №9–10: Продвинутое ООП на Kotlin

# # Описание
Лабораторная работа направлена на освоение продвинутых концепций объектно-ориентированного программирования в языке Kotlin.

# # Структура проекта
Проект включает примеры реализации расширенных механизмов ООП, а также пояснения к основным концепциям.

# # Инструкция по запуску

Клонируйте репозиторий:

bash
git clone <URL_репозитория>
Откройте проект в IntelliJ IDEA.

Запустите любой пример через контекстное меню или напрямую из функции main.

# # Автор
[Шапкин Н.А.]

# # Лицензия
Проект создан в учебных целях.
## 1. Геттеры и сеттеры (Getters & Setters)

В Kotlin свойства по умолчанию имеют автоматически генерируемые геттеры и сеттеры.

### Пример:
```kotlin
class Person {
    var name: String = ""
        get() = field.uppercase()
        set(value) {
            field = value.trim()
        }
    
    var age: Int = 0
        set(value) {
            if (value >= 0) field = value
        }
}
```
fun main() {
    val person = Person()
    person.name = "  Анна  "
    println(person.name) // Выведет: "АННА"
}
## 2. Инкапсуляция (Encapsulation)
Инкапсуляция — это сокрытие внутренней реализации и предоставление контролируемого доступа через публичные методы.

Пример:
kotlin```
class BankAccount {
    private var balance: Double = 0.0

    fun deposit(amount: Double) {
        if (amount > 0) balance += amount
    }

    fun withdraw(amount: Double): Boolean {
        if (amount <= balance) {
            balance -= amount
            return true
        }
        return false
    }

    fun getBalance(): Double = balance
}

fun main() {
    val account = BankAccount()
    account.deposit(1000.0)
    println(account.getBalance()) // 1000.0
}
## 3. Data-классы (Data Classes)
Используются для хранения данных. Автоматически генерируют toString(), equals(), hashCode(), copy().

Пример:
kotlin
data class User(
    val id: Int,
    val name: String,
    val email: String
)

fun main() {
    val user1 = User(1, "Иван", "ivan@mail.com")
    val user2 = user1.copy(email = "ivan.new@mail.com")
    println(user2) // User(id=1, name=Иван, email=ivan.new@mail.com)
}
## 4. Абстрактные классы (Abstract Classes)
Не могут быть созданы напрямую, содержат абстрактные методы (без реализации) и могут содержать реализованные методы.

Пример:
kotlin
abstract class Shape {
    abstract fun area(): Double
    
    fun description() {
        println("Это геометрическая фигура")
    }
}

class Circle(val radius: Double) : Shape() {
    override fun area(): Double = Math.PI * radius * radius
}

fun main() {
    val circle = Circle(5.0)
    println(circle.area()) // ~78.54
    circle.description() // Это геометрическая фигура
}
## 5. Интерфейсы (Interfaces)
Определяют контракт поведения. Могут содержать:

Функции без реализации

Функции с реализацией по умолчанию (default)

Свойства без состояния (только декларации)

Пример:
kotlin
// Определяем интерфейс видео-плеера:
interface VideoPlayable {
    fun play()
}

// Определяем интерфейс аудио-плеера:
interface AudioPlayable {
    fun play()
}

// Класс реализует оба интерфейса
class MediaPlayer : VideoPlayable, AudioPlayable {
    // Одна реализация для обоих интерфейсов
    override fun play() {
        println("Воспроизводится аудио и видео")
    }
}

// Пример с разными методами в интерфейсах:
interface Clickable {
    fun click()
    fun show() = println("Элемент кликабелен")
}

interface Dragable {
    fun drag()
    fun show() = println("Элемент перемещаем")
}

class Button : Clickable, Dragable {
    override fun click() {
        println("Кнопка нажата")
    }
    
    override fun drag() {
        println("Кнопка перемещена")
    }
    
    // Явное указание, какой метод show использовать при конфликте
    override fun show() {
        super<Clickable>.show()
        super<Dragable>.show()
    }
}

fun main() {
    val player = MediaPlayer()
    player.play() // Воспроизводится аудио и видео

    val button = Button()
    button.click() // Кнопка нажата
    button.drag()  // Кнопка перемещена
    button.show()  // Выведет оба сообщения из интерфейсов
}





## Sealed-классы

**Sealed-классы** используются для представления ограниченного набора состояний или результатов, которые известны на этапе компиляции. Они позволяют:

- гарантировать обработку всех возможных вариантов;
- безопасно использовать конструкцию `when` без `else`;
- удобно описывать состояния, события и результаты действий.

### Пример: результат работы модуля

```kotlin
sealed class ModuleResult {
    data class Success(val message: String) : ModuleResult()
    data class ResourceProduced(val resourceName: String, val amount: Int) : ModuleResult()
    data class NotEnoughResources(
        val resourceName: String,
        val required: Int,
        val available: Int
    ) : ModuleResult()
    data class Error(val reason: String) : ModuleResult()
}
```
## Использование sealed-классов:
```kotlin
fun handleResult(result: ModuleResult) {
    when (result) {
        is ModuleResult.Success -> println(result.message)
        is ModuleResult.ResourceProduced -> println("Произведено: ${result.amount} ${result.resourceName}")
        is ModuleResult.NotEnoughResources -> println("Не хватает ${result.resourceName}")
        is ModuleResult.Error -> println("Ошибка: ${result.reason}")
    }
}
```
Object в Kotlin
object — это специальная конструкция Kotlin, которая создаёт единственный экземпляр класса (Singleton). Особенности:

создаётся при первом обращении;

существует в одном экземпляре;

не имеет конструктора.

Пример: глобальный логгер
```kotlin
object Logger {
    private var counter = 0

    fun log(message: String) {
        counter++
        println("[$counter] $message")
    }
}
```
Использование:
kotlin
Logger.log("Инициализация системы")
Logger.log("Модуль запущен")
object удобно использовать для:

логгеров;

конфигураций;

состояний без данных в sealed-классах;

утилитарных классов.

Дополнительный пример: конфигурация приложения
```kotlin
object AppConfig {
    const val APP_NAME = "Galaxy Outpost Manager"
    const val VERSION = "1.0.0"
    var debugMode = true

    fun getApiUrl(): String {
        return if (debugMode) "http://localhost:8080" else "https://api.galaxy.outpost"
    }
}
```
```kotlin
println(AppConfig.APP_NAME)  // Galaxy Outpost Manager
println(AppConfig.getApiUrl()) // http://localhost:8080
```

## Делегирование свойств
Делегирование свойств позволяет передать логику хранения и обработки значения другому объекту. В Kotlin это реализуется с помощью ключевого слова by.

Преимущества:

Уменьшение дублирования кода

Централизованная логика проверки и обработки данных

Более чистый и читаемый код

Примеры применения:
```kotlin
kotlin
import kotlin.properties.Delegates

// Пример 1: Валидация значений с помощью делегирования
class Spaceship {
var health: Int by Delegates.vetoable(100) { _, _, newValue ->
newValue in 0..100 // Разрешаем только значения от 0 до 100
}

    var shield: Int by Delegates.observable(0) { property, oldValue, newValue ->
        println("${property.name} изменился: $oldValue ? $newValue")
    }
}

// Пример 2: Делегирование с пользовательским классом
class RangeDelegate(
private var value: Int,
private val min: Int,
private val max: Int
) {
operator fun getValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>): Int {
return value
}

    operator fun setValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>, newValue: Int) {
        value = newValue.coerceIn(min, max)
        println("Установлено значение $value в диапазоне [$min, $max]")
    }
}

class ResourceStorage {
var energy: Int by RangeDelegate(100, 0, 1000)
var fuel: Int by RangeDelegate(50, 0, 500)
}
```
## Lazy (ленивая инициализация)
lazy позволяет инициализировать объект только при первом обращении к нему.

Когда использовать:

Объект создаётся не всегда

Его создание ресурсоёмкое

Нужно отложить инициализацию

Примеры применения:
```kotlin
kotlin
// Пример 1: Базовое использование
class GalaxyMap {
val starSystems by lazy {
println("Загрузка карты галактики...")
loadStarSystemsFromDatabase() // Тяжёлая операция
}

    private fun loadStarSystemsFromDatabase(): List<StarSystem> {
        // Симуляция загрузки данных
        Thread.sleep(2000)
        return listOf(StarSystem("Солнечная"), StarSystem("Альфа Центавра"))
    }
}

// Пример 2: Lazy с потокобезопасностью
class ResourceManager {
// Потокобезопасная инициализация
val expensiveResource by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
ExpensiveResource()
}

    // Непотокобезопасная, но более быстрая инициализация
    val cachedConfig by lazy(LazyThreadSafetyMode.NONE) {
        loadConfiguration()
    }
    
    // Публикация через LazyThreadSafetyMode.PUBLICATION
    val sharedResource by lazy(LazyThreadSafetyMode.PUBLICATION) {
        SharedResource()
    }
}

// Пример 3: Ленивая инициализация с параметрами
class SpaceStation {
private val stationName: String = "Альфа"

    val dockingBay by lazy { 
        DockingBay(stationName, capacity = 10)
    }
    
    val energyGrid by lazy {
        EnergyGrid(maxCapacity = 10000)
    }
}
```
## Observer-паттерн (наблюдатель)
Observer-паттерн позволяет объектам реактировать на изменения состояния другого объекта.

Применение в проекте:

Реагирование на изменение ресурсов

Логирование событий

Уведомление пользователя

Примеры реализации:
```kotlin
kotlin
import kotlin.properties.Delegates

// Пример 1: Использование Delegates.observable
class ResourceManager {
var minerals: Int by Delegates.observable(0) { _, old, new ->
onResourceChanged("minerals", old, new)
}

    var energy: Int by Delegates.observable(100) { _, old, new ->
        onResourceChanged("energy", old, new)
    }
    
    private val observers = mutableListOf<ResourceObserver>()
    
    fun addObserver(observer: ResourceObserver) {
        observers.add(observer)
    }
    
    private fun onResourceChanged(resource: String, oldValue: Int, newValue: Int) {
        observers.forEach { it.onResourceChanged(resource, oldValue, newValue) }
    }
}

interface ResourceObserver {
fun onResourceChanged(resource: String, oldValue: Int, newValue: Int)
}

// Пример 2: Кастомная реализация Observer
class ObservableProperty<T>(
initialValue: T,
private val onChange: (oldValue: T, newValue: T) -> Unit
) {
private var value: T = initialValue

    fun get(): T = value
    
    fun set(newValue: T) {
        val oldValue = value
        value = newValue
        onChange(oldValue, newValue)
    }
}

class Spacecraft {
private val _health = ObservableProperty(100) { old, new ->
println("Здоровье изменилось: $old ? $new")
if (new < 30) {
println("Внимание: низкий уровень здоровья!")
}
}

    val health: Int get() = _health.get()
    fun setHealth(value: Int) = _health.set(value)
}

// Пример 3: Расширенный Observer с поддержкой нескольких типов событий
class GameEventManager {
private val eventListeners = mutableMapOf<String, MutableList<(Any) -> Unit>>()

    fun addListener(eventType: String, listener: (Any) -> Unit) {
        eventListeners.getOrPut(eventType) { mutableListOf() }.add(listener)
    }
    
    fun notify(eventType: String, data: Any) {
        eventListeners[eventType]?.forEach { listener ->
            listener(data)
        }
    }
}

class GameUI {
init {
val eventManager = GameEventManager()

        eventManager.addListener("RESOURCE_CHANGE") { data ->
            println("Изменены ресурсы: $data")
        }
        
        eventManager.addListener("ALERT") { data ->
            println("ТРЕВОГА: $data")
        }
    }
}
```
## Сохранение состояния
Для сохранения состояния проекта используется сериализация в JSON.

Преимущества:

Сохранение данных между запусками программы

Хранение состояния в человекочитаемом формате

Легко перенести логику в Android-приложение

Пример реализации:
```kotlin
kotlin
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import java.io.File

@Serializable
data class GameState(
val playerName: String,
val resources: Map<String, Int>,
val discoveredSystems: List<String>,
val currentStation: String,
val timestamp: Long = System.currentTimeMillis()
)

class SaveManager {
private val json = Json { prettyPrint = true }

    fun saveGame(state: GameState, filename: String = "savegame.json") {
        val jsonString = json.encodeToString(state)
        File(filename).writeText(jsonString)
        println("Игра сохранена в $filename")
    }
    
    fun loadGame(filename: String = "savegame.json"): GameState? {
        return try {
            val jsonString = File(filename).readText()
            json.decodeFromString<GameState>(jsonString)
        } catch (e: Exception) {
            println("Ошибка загрузки: ${e.message}")
            null
        }
    }
}

// Пример использования
fun main() {
val saveManager = SaveManager()

    // Сохранение
    val gameState = GameState(
        playerName = "Командир Шепард",
        resources = mapOf("minerals" to 1500, "energy" to 750, "fuel" to 300),
        discoveredSystems = listOf("Солнечная система", "Альфа Центавра"),
        currentStation = "Цитадель"
    )
    
    saveManager.saveGame(gameState)
    
    // Загрузка
    val loadedState = saveManager.loadGame()
    loadedState?.let {
        println("Загружен игрок: ${it.playerName}")
        println("Ресурсы: ${it.resources}")
    }
}
```